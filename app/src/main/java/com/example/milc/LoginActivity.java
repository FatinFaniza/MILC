package com.example.milc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button btnlogin;
    TextView signup_dietitian,signup_supplier,signup_user,forgotTv;

    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnlogin = findViewById(R.id.btn_login);
        signup_dietitian = findViewById(R.id.signup_dietitian);
        signup_supplier = findViewById(R.id.signup_supplier);
        signup_user = findViewById(R.id.signup_user);
        forgotTv = findViewById(R.id.forgotTv);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        signup_dietitian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterDietitianActivity.class);
                startActivity(i);
                finish();
            }
        });

        signup_supplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterSupplierActivity.class);
                startActivity(i);
                finish();
            }
        });

        signup_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterUserActivity.class);
                startActivity(i);
                finish();
            }
        });

        forgotTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(i);
                finish();
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if(TextUtils.isEmpty(mail)){
                    email.setError("Email is required.");
                    Toast.makeText(LoginActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    email.requestFocus();
                    return;
                }else if(TextUtils.isEmpty(pass)){
                    password.setError("Password is required.");
                    Toast.makeText(LoginActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    password.requestFocus();
                    return;
                }else if (password.length() <6){
                    password.setError("Password must be 6 characters");
                    return;
                }else
                    progressDialog.setMessage("Logging in ...");
                    progressDialog.show();

                firebaseAuth.signInWithEmailAndPassword(mail,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        makeMeOnline();
                    }

                }) 
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                
                            }
                        });

//                    firebaseAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                String uid = task.getResult().getUser().getUid();
//                                FirebaseDatabase firebaseDatabase =  FirebaseDatabase.getInstance();
//                                firebaseDatabase.getReference("Users Info").child(uid).child("role").addListenerForSingleValueEvent(new ValueEventListener() {
//                                    @Override
//                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                        String Role = snapshot.getValue(String.class);
//                                        if (Role.equals("Supplier")) {
//                                            Toast.makeText(LoginActivity.this, "Registration complete", Toast.LENGTH_SHORT).show();
//                                            Intent i = new Intent(LoginActivity.this, Dietitian_Home.class);
//                                            startActivity(i);
//                                        }
//                                        if (Role.equals("Patient")) {
//                                            Toast.makeText(LoginActivity.this, "Registration complete", Toast.LENGTH_SHORT).show();
//                                            Intent i = new Intent(LoginActivity.this, User_Home.class);
//                                            startActivity(i);
//                                        }
//                                        if (Role.equals("Dietitian")) {
//                                            Toast.makeText(LoginActivity.this, "Registration complete", Toast.LENGTH_SHORT).show();
//                                            Intent i = new Intent(LoginActivity.this, Dietitian_Home.class);
//                                            startActivity(i);
//                                        }
//                                    }
//
//                                    @Override
//                                    public void onCancelled(@NonNull DatabaseError error) {
//
//                                    }
//                                });
////                            Toast.makeText(Login.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
////                            startActivity(new Intent(getApplicationContext(), Dietitian_Homepage.class));
//                            } else {
//                                Toast.makeText(LoginActivity.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
            }
        });

    }

    private void makeMeOnline() {
        //after log in, make user online
        progressDialog.setMessage("Checking user ...");

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("online", "true");

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users Info");
        databaseReference.child(firebaseAuth.getUid()).updateChildren(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        //update successful
                        //check user type
                        //if user is dietitian, start dietitian homepage
                        //if user is dietitian, start dietitian homepage
                        //if user is dietitian, start dietitian homepage

                        databaseReference.orderByChild("uid").equalTo(firebaseAuth.getUid())
                                .addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        for(DataSnapshot ds:snapshot.getChildren()){
                                            String role = ""+ds.child("role").getValue();
                                            if(role.equals("Dietitian")){
                                                progressDialog.dismiss();
                                                startActivity(new Intent(getApplicationContext(), Dietitian_Home.class));
                                                finish();
                                            }
                                            else if (role.equals("Supplier")){
                                                progressDialog.dismiss();
                                                startActivity(new Intent(getApplicationContext(), Supplier_Home.class));
                                                finish();
                                            }
                                            else if (role.equals("Product User")){
                                                progressDialog.dismiss();
                                                startActivity(new Intent(getApplicationContext(), User_Home.class));
                                                finish();
                                            }
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //update fail
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(LoginActivity.this, MainActivity2.class);
        startActivity(i);
        finish();
    }
}


