package com.example.milc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterUserActivity extends AppCompatActivity {

    EditText username, password, email;
    RadioButton radio_dietitian,radio_supplier,radio_user;
    Button btnregister;
    TextView signin;

    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    String Role = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        radio_dietitian = findViewById(R.id.radio_dietitian);
        radio_supplier = findViewById(R.id.radio_supplier);
        radio_user = findViewById(R.id.radio_user);
        btnregister = findViewById(R.id.btn_register);
        signin = findViewById(R.id.signin);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterUserActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //input data
                String Username = username.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();

                //validate data
                if(TextUtils.isEmpty(Username)){
                    username.setError("Username is required.");
                    Toast.makeText(RegisterUserActivity.this, "Please enter username", Toast.LENGTH_SHORT).show();
                    username.requestFocus();
                    return;
                }else if(TextUtils.isEmpty(Email)){
                    email.setError("Email is required.");
                    Toast.makeText(RegisterUserActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    email.requestFocus();
                    return;
                }else if(TextUtils.isEmpty(Password)){
                    password.setError("Password is required.");
                    Toast.makeText(RegisterUserActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    password.requestFocus();
                    return;
                }else if (password.length() <6){
                    password.setError("Password must be at least 6 characters");
                    return;
                }
                else {

                    progressDialog.setMessage("Creating account");
                    progressDialog.show();

                    firebaseAuth.createUserWithEmailAndPassword(Email,Password)
                            .addOnCompleteListener(RegisterUserActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //account created
                                    if (task.isSuccessful()) {
                                        String uid = task.getResult().getUser().getUid();
//                                        user information = new user(Username, Email, Password, Role, uid );
                                        progressDialog.setMessage("Saving account info...");
                                        String timestamp = ""+System.currentTimeMillis();

                                        //setup data to save (replace cara kat user class)
                                        HashMap<String,Object> hashMap = new HashMap<>();
                                        hashMap.put("uid", "" + firebaseAuth.getUid());
//                                        hashMap.put("uid", "" + uid);
                                        hashMap.put("userName", "" + Username);
                                        hashMap.put("email", "" + Email);
                                        hashMap.put("password", "" + Password);
                                        hashMap.put("role", "" + "Product User");
                                        hashMap.put("online", "true");
                                        hashMap.put("timestamp", "" + timestamp);

                                        //save to db
                                        firebaseDatabase.getInstance().getReference("Users Info").child(uid).setValue(hashMap);
                                        progressDialog.dismiss();
                                        Toast.makeText(RegisterUserActivity.this, "Registration complete", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), User_Home.class));
                                        finish();

                                    }else {
                                        //failed uploading to db
                                        progressDialog.dismiss();
                                        Toast.makeText(RegisterUserActivity.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                }
                            });
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(RegisterUserActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}