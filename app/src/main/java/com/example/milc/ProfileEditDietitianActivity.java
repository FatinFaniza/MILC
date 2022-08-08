package com.example.milc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ProfileEditDietitianActivity extends AppCompatActivity {

    EditText username, email, hospital, position;
    Button updateBtn;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit_dietitian);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        hospital = findViewById(R.id.hospital);
        position = findViewById(R.id.position);
        updateBtn = findViewById(R.id.btn_update);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

//        updateBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ProfileEditDietitianActivity.this, "Update data complete", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(getApplicationContext(), Dietitian_Home.class));
//            }
//        });


        checkUser();

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //begin profile update
                inputData();
            }
        });

    }


    private void inputData() {

        String UserName,Email,HospitalName,Position;
        UserName = username.getText().toString().trim();
        Email = email.getText().toString().trim();
        HospitalName = hospital.getText().toString().trim();
        Position = position.getText().toString().trim();

        progressDialog.setMessage("Updating Profile ...");
        progressDialog.show();

        //setup data to update
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("userName", "" + UserName);
        hashMap.put("email", "" + Email);
        hashMap.put("hospitalName", "" + HospitalName);
        hashMap.put("position", "" + Position);

        //update to db
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users Info");
        databaseReference.child(firebaseAuth.getUid()).updateChildren(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        //update successfully
                        progressDialog.dismiss();
                        Toast.makeText(ProfileEditDietitianActivity.this, "Profile updated", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //update failed
                        progressDialog.dismiss();
                        Toast.makeText(ProfileEditDietitianActivity.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private void checkUser() {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user==null){
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }
        else {
            loadMyInfo();
        }
    }

    private void loadMyInfo() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users Info");
        databaseReference.orderByChild("uid").equalTo(firebaseAuth.getUid())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for(DataSnapshot ds:snapshot.getChildren()){
                            String UserName = ""+ds.child("userName").getValue();
                            String Email = ""+ds.child("email").getValue();
                            String HospitalName = ""+ds.child("hospitalName").getValue();
                            String Position = ""+ds.child("position").getValue();

                            username.setText(UserName);
                            email.setText(Email);
                            hospital.setText(HospitalName);
                            position.setText(Position);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

    }

}