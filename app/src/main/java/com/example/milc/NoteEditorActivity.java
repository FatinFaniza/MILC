package com.example.milc;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NoteEditorActivity extends AppCompatActivity {

    EditText notes_edittext;
    int noteId;
    SharedPreferences sharedPreferences;
    Button notes_saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

//        ActionBar actionBar = getSupportActionBar();
//        sharedPreferences = this.getSharedPreferences("com.example.firebasedemo.Dietitian", Context.MODE_PRIVATE);
//        notes_edittext = findViewById(R.id.notes_edittext);
//        notes_saveBtn  = findViewById(R.id.notes_saveBtn);

//        Intent i = getIntent();
//        noteId = i.getIntExtra("noteId", -1);
//
//        if(noteId != -1){
//            notes_edittext.setText(NoteListActivity.notes.get(noteId));
////            actionBar.setTitle("Edit Note");
//        }else{
//            NoteListActivity.notes.add("");
//            noteId = NoteListActivity.notes.size() -1;
////            actionBar.setTitle("Add Note");
//        }

//        notes_edittext.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                NoteListActivity.notes.set(noteId, String.valueOf(s));
//                NoteListActivity.adapter.notifyDataSetChanged();
//
//                HashSet<String> noteSet = new HashSet<>(NoteListActivity.notes);
//                sharedPreferences.edit().putStringSet("notes", noteSet).apply();
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//
//        notes_saveBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(NoteEditorActivity.this, NoteListActivity.class);
//                startActivity(i);
//                finish();
//            }
//        });
    }


}