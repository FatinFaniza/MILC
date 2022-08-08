package com.example.milc;

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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class NoteView2 extends AppCompatActivity {

    EditText notes_titleEt,notes_descEt;
    Button notes_updateBtn;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_note_view2);

        notes_titleEt = findViewById(R.id.notes_titleEt);
        notes_descEt = findViewById(R.id.notes_descEt);
        notes_updateBtn = findViewById(R.id.notes_updateBtn);

        //initialize
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();

        Intent data = getIntent();

        String title = data.getStringExtra("title");
        String description = data.getStringExtra("description");
        notes_titleEt.setText(title);
        notes_descEt.setText(description);

        notes_updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTitle = notes_titleEt.getText().toString();
                String newDescription = notes_descEt.getText().toString();

                if(newTitle.isEmpty() || newDescription.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Both field are required to fill", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {

                    DocumentReference documentReference = firebaseFirestore.collection("Notes")
                            .document(firebaseAuth.getUid()).collection("Supplier").document(data.getStringExtra("noteId"));

                    Map<String,Object> note = new HashMap<>();
                    note.put("title",newTitle);
                    note.put("description",newDescription);

                    documentReference.set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(), "Note is updated", Toast.LENGTH_SHORT).show();
                            onBackPressed();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Failed To Create Update Note", Toast.LENGTH_SHORT).show();
                            onBackPressed();

                        }
                    });

                }
            }
        });


    }
}