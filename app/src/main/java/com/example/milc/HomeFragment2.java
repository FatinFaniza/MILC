package com.example.milc;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragment2 extends Fragment {

    private EditText searchProductEt;
    private ImageButton filterProductBtn;
    private TextView filteredProductsTv;
    private RecyclerView productsRv;

    ArrayList<ModelProduct> productList;
    AdapterProduct adapterProduct;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home2, container, false);

        ImageButton btnLogOut;
        TextView usernameView,positionName,companyName;
        FloatingActionButton floatBtnAdd;

        FirebaseAuth firebaseAuth;
        ProgressDialog progressDialog;

        btnLogOut = view.findViewById(R.id.btnLogout);
        usernameView = view.findViewById(R.id.username);
        positionName = view.findViewById(R.id.positionName);
        companyName = view.findViewById(R.id.companyName);
        floatBtnAdd = view.findViewById(R.id.floatBtnAdd);

        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference("Users Info");

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);


        floatBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AddProductActivity.class);
                startActivity(i);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeMeOffline();
            }
        });

        reference.orderByChild("uid").equalTo(firebaseAuth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    String name = ""+ds.child("userName").getValue();
                    String company = ""+ds.child("companyName").getValue();
                    String position = ""+ds.child("position").getValue();
                    usernameView.setText(name);
                    companyName.setText(company);
                    positionName.setText(position);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        searchProductEt = view.findViewById(R.id.searchProductEt);
        filterProductBtn = view.findViewById(R.id.filterProductBtn);
        filteredProductsTv = view.findViewById(R.id.filteredProductsTv);
        productsRv = view.findViewById(R.id.productsRv);

        loadAllProducts();

        searchProductEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try{
                    adapterProduct.getFilter().filter(s);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        filterProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(" Choose Category: ")
                        .setItems(Subcategory1.AllCategories, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                //get selected item
                                String selected = Subcategory1.AllCategories[which];
                                filteredProductsTv.setText(selected);

                                if(selected.equals("All")){
                                    loadAllProducts();
                                }
                                else {
                                    loadFilteredProducts(selected);
                                }
                            }
                        })
                        .show();
            }
        });

        return view;
    }

    private void loadFilteredProducts(String selected) {
        productList = new ArrayList<>();

        String timestamp = ""+System.currentTimeMillis();

        //get all products

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Products");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                //before getting reset list
                for (DataSnapshot ds:snapshot.getChildren()){

                    String productSubCategory = ""+ds.child("productSubCategory").getValue();

                    //if selected category matches product category then add in
                    if(selected.equals(productSubCategory)) {

                        ModelProduct modelProduct = ds.getValue(ModelProduct.class);
                        productList.add(modelProduct);
                    }
                }
                //setup adapter
                adapterProduct = new AdapterProduct(getActivity(),productList);
                productsRv.setAdapter(adapterProduct);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void loadAllProducts() {

        String timestamp = ""+System.currentTimeMillis();

        productList = new ArrayList<>();

        //get all products
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Products");
//        reference.child(firebaseAuth.getUid()).addValueEventListener(new ValueEventListener() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Products");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                //before getting reset list
                productList.clear();
                for(DataSnapshot ds:snapshot.getChildren()){

                    ModelProduct modelProduct = ds.getValue(ModelProduct.class);
                    productList.add(modelProduct);

                }

                //setup adapter
                adapterProduct = new AdapterProduct(getActivity(),productList);

                //set adapter
                productsRv.setAdapter(adapterProduct);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void makeMeOffline() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        //after log in, make user online
        progressDialog.setMessage("Logging Out User ...");

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("online", "false");

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users Info");
        databaseReference.child(firebaseAuth.getUid()).updateChildren(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        firebaseAuth.signOut();
                        Intent i = new Intent(getActivity(), LoginActivity.class);
                        startActivity(i);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //update fail
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

