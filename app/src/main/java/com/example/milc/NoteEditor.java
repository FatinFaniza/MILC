package com.example.milc;

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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class NoteEditor extends AppCompatActivity {

    EditText notes_titleEt,notes_descEt;
    Button notes_saveBtn;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_note_editor);

        notes_titleEt = findViewById(R.id.notes_titleEt);
        notes_descEt = findViewById(R.id.notes_descEt);
        notes_saveBtn = findViewById(R.id.notes_saveBtn);

        //initialize
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();

        notes_saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = notes_titleEt.getText().toString();
                String description = notes_descEt.getText().toString();

                if(title.isEmpty() || description.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Both field are required to fill", Toast.LENGTH_SHORT).show();
                }
                else {

                    DocumentReference documentReference = firebaseFirestore.collection("Notes")
                            .document(firebaseAuth.getUid()).collection("Dietitian").document();

                    Map<String,Object> note = new HashMap<>();
                    note.put("title",title);
                    note.put("description",description);

                    documentReference.set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(), "Note Created Successfully", Toast.LENGTH_SHORT).show();
                            notes_titleEt.setText("");
                            notes_descEt.setText("");
                            onBackPressed();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Failed To Create Note", Toast.LENGTH_SHORT).show();
                            onBackPressed();
                        }
                    });

                }
            }
        });

    }
}