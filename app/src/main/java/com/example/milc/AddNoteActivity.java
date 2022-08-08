package com.example.milc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;


public class AddNoteActivity extends AppCompatActivity {

    FirebaseFirestore firebaseFirestore;
    EditText mTitle,mDesc;
    String uTitle, uDesc , uId;
    Button mSaveBtn,mShowBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        mTitle = findViewById(R.id.edit_title);
        mDesc = findViewById(R.id.edit_desc);
        mSaveBtn = findViewById(R.id.save_btn);
        mShowBtn = findViewById(R.id.showall_btn);

        firebaseFirestore = FirebaseFirestore.getInstance();

//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null){
//            mSaveBtn.setText("Update");
//            uTitle = bundle.getString("uTitle");
//            uId = bundle.getString("uId");
//            uDesc = bundle.getString("uDesc");
//            mTitle.setText(uTitle);
//            mDesc.setText(uDesc);
//        }else{
//            mSaveBtn.setText("Save");
//        }

        mShowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddNoteActivity.this , Dietitian_Home.class));
            }
        });


        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.save_btn) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new NoteFragment()).commit();
                }
            }
        });
        }
    }



//        mSaveBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                startActivity(new Intent(AddNoteActivity.this , Dietitian_Home.class));

//                String title = mTitle.getText().toString();
//                String desc = mDesc.getText().toString();
//
//                Bundle bundle1 = getIntent().getExtras();
//                if (bundle1 !=null){
//                    String id = uId;
//                    updateToFireStore(id , title, desc);
//                }else{
//                    String id = UUID.randomUUID().toString();
//                    saveToFireStore(id , title , desc);
//                }

//            }
//        });





//        mSaveBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String title = mcreatetitleofnote.getText().toString();
//                String desc = mcreatecontentofnote.getText().toString();
//
//                Bundle bundle1 = getIntent().getExtras();
//                if (bundle1 !=null){
//                    String id = uId;
//                    updateToFireStore(id , title, desc);
//                }else{
//                    String id = UUID.randomUUID().toString();
//                    saveToFireStore(id , title , desc);
//                }



//                String title = mcreatetitleofnote.getText().toString();
//                String content = mcreatecontentofnote.getText().toString();
//                String id = UUID.randomUUID().toString();
//
//                HashMap<String, Object> note = new HashMap<>();
//                note.put("id",id);
//                note.put("title",title);
//                note.put("content",content);
//
//                if(title.isEmpty() || content.isEmpty()){
//                    Toast.makeText(getApplicationContext(),"Both field are required", Toast.LENGTH_SHORT).show();
//                } else {
//                    firebaseFirestore.collection("Notes").document(id).set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if(task.isSuccessful()){
//                                Toast.makeText(getApplicationContext(),"Data saved", Toast.LENGTH_SHORT).show();
//                                Intent i = new Intent(AddNoteActivity.this, Dietitian_Home.class);
//                                startActivity(i);
//
//                            }
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(getApplicationContext(),"Failed", Toast.LENGTH_SHORT).show();
//
//                        }
//                    });
//
//                }
//            }

//            private void updateToFireStore(String id, String title, String desc) {
//            }
//
//            private void saveToFireStore(String id , String title , String desc) {
//
//                if (!title.isEmpty() && !desc.isEmpty()){
//                    HashMap<String , Object> map = new HashMap<>();
//                    map.put("id" , id);
//                    map.put("title" , title);
//                    map.put("desc" , desc);
//
//                    firebaseFirestore.collection("Documents").document(id).set(map)
//                            .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if (task.isSuccessful()){
//                                        Toast.makeText(AddNoteActivity.this, "Data Saved !!", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(AddNoteActivity.this, "Failed !!", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//                }
//            }
//        });


//    private void saveToFireStore(String id, String title, String desc) {
//
//        if (!title.isEmpty() && !desc.isEmpty()){
//            HashMap<String , Object> map = new HashMap<>();
//            map.put("id" , id);
//            map.put("title" , title);
//            map.put("desc" , desc);
//
//            firebaseFirestore.collection("Documents").document(id).set(map)
//                    .addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if (task.isSuccessful()){
//                                Toast.makeText(AddNoteActivity.this, "Data Saved !!", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(AddNoteActivity.this, "Failed !!", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//        }else
//            Toast.makeText(this, "Empty Fields not Allowed", Toast.LENGTH_SHORT).show();
//    }


//    @Override
//    public void onClick(View v) {
//        if(v.getId()==R.id.save_btn){
//            getSupportFragmentManager().beginTransaction().replace(R.id.container,new NoteFragment()).commit();
//
//        }
//    }


//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        return super.onOptionsItemSelected(item);
//    }
