package com.example.milc;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Company_ViewProduct extends AppCompatActivity {

    private EditText searchProductEt;
    private ImageButton filterProductBtn;
    private TextView filteredProductsTv;
    private RecyclerView productsRv;

    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    ArrayList<ModelProduct> productList;
    AdapterProduct adapterProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_view_product);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        searchProductEt = findViewById(R.id.searchProductEt);
        filterProductBtn = findViewById(R.id.filterProductBtn);
        filteredProductsTv = findViewById(R.id.filteredProductsTv);
        productsRv = findViewById(R.id.productsRv);

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

                AlertDialog.Builder builder = new AlertDialog.Builder(Company_ViewProduct.this);
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

    }

    private void loadFilteredProducts(String selected) {
        productList = new ArrayList<>();

        String timestamp = ""+System.currentTimeMillis();

        //get all products

//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Products");
//        reference.child(firebaseAuth.getUid()).addValueEventListener(new ValueEventListener() {
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
                adapterProduct = new AdapterProduct(Company_ViewProduct.this,productList);
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
                adapterProduct = new AdapterProduct(Company_ViewProduct.this,productList);

                //set adapter
                productsRv.setAdapter(adapterProduct);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}