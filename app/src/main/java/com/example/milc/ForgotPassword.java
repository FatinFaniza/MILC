package com.example.milc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    EditText email;
    Button btnRecover;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.email);
        btnRecover = findViewById(R.id.btnRecover);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        btnRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = email.getText().toString().trim();

                if(TextUtils.isEmpty(mail)){
                    email.setError("Email is required.");
                    Toast.makeText(ForgotPassword.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    email.requestFocus();
                    return;
                }

                progressDialog.setMessage("Sending instructions to reset password");
                progressDialog.show();

                firebaseAuth.sendPasswordResetEmail(mail)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                //instruction sent
                                progressDialog.dismiss();
                                Toast.makeText(ForgotPassword.this, "Password reset instructions sent to your email", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //failed sending instruction
                                progressDialog.dismiss();
                                Toast.makeText(ForgotPassword.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();


                            }
                        });
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(ForgotPassword.this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}