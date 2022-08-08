package com.example.milc;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {

    ListView notesListView;
    static List<String> notes;
    ArrayAdapter adapter;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

//        sharedPreferences = this.getSharedPreferences("com.example.firebasedemo.Dietitian", Context.MODE_PRIVATE);
//
//        notesListView = findViewById(R.id.notes_listview);

//        notes = new ArrayList<>();
//        HashSet<String> noteSet = (HashSet<String>) sharedPreferences.getStringSet("notes", null);
//
//        adapter = new ArrayAdapter(getApplicationContext(),R.layout.custom_notes_row,R.id.notesTV,notes);
//        notesListView.setAdapter(adapter);
//

//        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent i = new Intent(getApplicationContext(), NoteEditorActivity.class);
//                i.putExtra("noteId",position);
//                startActivity(i);
//            }
//        });

//        notesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//
//                int itemToDelete = position;
//                AlertDialog show = new AlertDialog.Builder(NoteListActivity.this)
//                        .setTitle("Are you sure?")
//                        .setMessage("Do you want to delete this note?")
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                notes.remove(itemToDelete);
//                                adapter.notifyDataSetChanged();
//
//                                HashSet<String> noteSet = new HashSet<>(notes);
//                                sharedPreferences.edit().putStringSet("notes", noteSet).apply();
//                            }
//                        }).setNegativeButton("No", null).show();
//
//                return true;
//            }
//        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.add_note_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        if(item.getItemId() == R.id.add){
//            Intent i = new Intent(getApplicationContext(), NoteEditorActivity.class);
//            startActivity(i);
//            return true;
//        }
//        return false;
//    }


}