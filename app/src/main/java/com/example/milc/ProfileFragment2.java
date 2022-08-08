package com.example.milc;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ProfileFragment2 extends Fragment {

    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    EditText etUsername,etEmail,etCompany,etPosition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile2, container, false);

        TextView tvUsername,tvEmail,tvCompany,tvPosition;
        Button updateProfileBtn;


        updateProfileBtn = view.findViewById(R.id.updateProfile);
        tvUsername  = view.findViewById(R.id.tvUsername);
        tvEmail  = view.findViewById(R.id.tvEmail);
        tvCompany  = view.findViewById(R.id.tvCompany);
        tvPosition  = view.findViewById(R.id.tvPosition);

        etUsername = view.findViewById(R.id.username);
        etEmail = view.findViewById(R.id.email);
        etCompany = view.findViewById(R.id.company);
        etPosition = view.findViewById(R.id.position);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference("Users Info");

        reference.orderByChild("uid").equalTo(firebaseAuth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    String name = ""+ds.child("userName").getValue();
                    String email = ""+ds.child("email").getValue();
                    String company = ""+ds.child("companyName").getValue();
                    String position = ""+ds.child("position").getValue();
                    tvUsername.setText(name);
                    tvEmail.setText(email);
                    tvCompany.setText(company);
                    tvPosition.setText(position);

                    etUsername.setText(name);
                    etEmail.setText(email);
                    etCompany.setText(company);
                    etPosition.setText(position);

                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        updateProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //begin profile update
                inputData();
            }
        });

        return view;
    }

    private void inputData() {

        String UserName,Email,CompanyName,Position;
        UserName = etUsername.getText().toString().trim();
        Email = etEmail.getText().toString().trim();
        CompanyName = etCompany.getText().toString().trim();
        Position = etPosition.getText().toString().trim();

        progressDialog.setMessage("Updating Profile ...");
        progressDialog.show();

        //setup data to update
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("userName", "" + UserName);
        hashMap.put("email", "" + Email);
        hashMap.put("companyName", "" + CompanyName);
        hashMap.put("position", "" + Position);

        //update to db
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users Info");
        databaseReference.child(firebaseAuth.getUid()).updateChildren(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        //update successfully
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Profile updated", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //update failed
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
    }

}