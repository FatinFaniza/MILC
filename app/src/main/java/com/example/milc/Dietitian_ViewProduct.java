package com.example.milc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class Dietitian_ViewProduct extends AppCompatActivity implements RecyclerAdapter.OnItemClickListener {

    ImageView back;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private ProgressBar mProgressBar;
    private FirebaseStorage mStorage;
    private DatabaseReference mDatabaseRef;
    private ValueEventListener mDBListener;
    private List<ModelProduct> mProducts;
    FirebaseAuth firebaseAuth;


    private void openDetailActivity(String[] data){
        Intent intent = new Intent(this, Dietitian_ViewProductDetail.class);
        intent.putExtra("NAME_KEY",data[0]);
        intent.putExtra("DESCRIPTION_KEY",data[1]);
        intent.putExtra("IMAGE_KEY",data[2]);
        intent.putExtra("COMPANY_KEY",data[3]);
        intent.putExtra("INDICATION_KEY",data[4]);
        intent.putExtra("INGREDIENT_KEY",data[5]);
        intent.putExtra("AVAILABILITY_KEY",data[6]);
        intent.putExtra("PRICE_KEY",data[7]);
        intent.putExtra("SPECIAL_KEY",data[8]);

        intent.putExtra("STORAGE_KEY",data[9]);
        intent.putExtra("CALORIE_KEY",data[10]);
        intent.putExtra("OTHER_KEY",data[11]);
        intent.putExtra("SERVING_KEY",data[12]);
        intent.putExtra("SIZE_KEY",data[13]);

        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietitian_view_product);

        back = findViewById(R.id.back);
        firebaseAuth = FirebaseAuth.getInstance();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dietitian_ViewProduct.this, Dietitian_Home.class);
                startActivity(i);
                finish();
            }
        });

        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mProgressBar = findViewById(R.id.myDataLoaderProgressBar);
        mProgressBar.setVisibility(View.VISIBLE);

        mProducts = new ArrayList<>();
        mAdapter = new RecyclerAdapter (Dietitian_ViewProduct.this, mProducts);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(Dietitian_ViewProduct.this);

        mStorage = FirebaseStorage.getInstance();
        String timestamp = ""+System.currentTimeMillis();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Products");
//        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Users Info").child(firebaseAuth.getUid()).child("Products");

        mDBListener = mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mProducts.clear();

                for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {
                    ModelProduct upload = productSnapshot.getValue(ModelProduct.class);
                    upload.setKey(productSnapshot.getKey());
                    mProducts.add(upload);
                }
                mAdapter.notifyDataSetChanged();
                mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Dietitian_ViewProduct.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Dietitian_ViewProduct.this, Dietitian_Home.class);
        startActivity(i);
        finish();
    }

    public void onItemClick(int position) {
        ModelProduct clickedProduct=mProducts.get(position);
        String[] productData={  clickedProduct.getProductName(),clickedProduct.getProductDescription(),clickedProduct.getProductIcon(),clickedProduct.getProductCompany(),
                                clickedProduct.getProductIndication(),clickedProduct.getProductIngredient(),clickedProduct.getProductAvailability(),clickedProduct.getProductRetailPrice(),
                                clickedProduct.getProductSpecialFeatures(),clickedProduct.getProductStorage(),clickedProduct.getProductCalorie(),clickedProduct.getProductOtherInfo(),
                                clickedProduct.getProductServingSize(),clickedProduct.getProductPackSize()};
        openDetailActivity(productData);
    }

    public void onShowItemClick(int position) {
        ModelProduct clickedProduct=mProducts.get(position);
        String[] productData={    clickedProduct.getProductName(),clickedProduct.getProductDescription(),clickedProduct.getProductIcon(),clickedProduct.getProductCompany(),
                clickedProduct.getProductIndication(),clickedProduct.getProductIngredient(),clickedProduct.getProductAvailability(),clickedProduct.getProductRetailPrice(),
                clickedProduct.getProductSpecialFeatures(),clickedProduct.getProductStorage(),clickedProduct.getProductCalorie(),clickedProduct.getProductOtherInfo(),
                clickedProduct.getProductServingSize(),clickedProduct.getProductPackSize()};

        openDetailActivity(productData);
    }

    public void onDeleteItemClick(int position) {
        ModelProduct selectedItem = mProducts.get(position);
        final String selectedKey = selectedItem.getKey();

        StorageReference imageRef = mStorage.getReferenceFromUrl(selectedItem.getProductIcon());
        imageRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                mDatabaseRef.child(selectedKey).removeValue();
                Toast.makeText(Dietitian_ViewProduct.this, "Item deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void onDestroy() {
        super.onDestroy();
        mDatabaseRef.removeEventListener(mDBListener);
    }

}