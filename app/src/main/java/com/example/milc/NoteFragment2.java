package com.example.milc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.firebase.ui.firestore.SnapshotParser;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class NoteFragment2 extends Fragment {

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseFirestore firebaseFirestore;
    FloatingActionButton floatBtnAddNote;

    FirebaseFirestore db;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    FirestoreRecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note2, container, false);

        floatBtnAddNote = view.findViewById(R.id.notes_addBtnNote);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        floatBtnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), NoteEditor2.class);
                startActivity(i);
            }
        });

        db = FirebaseFirestore.getInstance();
        recyclerView = view.findViewById(R.id.recyclerView);

        //query
        Query query = db.collection("Notes").document(firebaseAuth.getUid()).collection("Supplier").orderBy("title",Query.Direction.ASCENDING);

        //RecyclerOption
        FirestoreRecyclerOptions<Note> options = new FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query, new SnapshotParser<Note>() {
                    @NonNull
                    @Override
                    public Note parseSnapshot(@NonNull DocumentSnapshot snapshot) {
                        Note note = snapshot.toObject(Note.class);
                        String itemId = snapshot.getId();
                        note.setItemId(itemId);

                        return note;
                    }
                })
                .build();

        adapter = new FirestoreRecyclerAdapter<Note, NoteFragment2.NoteViewHolder>(options) {
            @NonNull
            @Override
            public NoteFragment2.NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_layout, parent, false);

                return new NoteFragment2.NoteViewHolder(v);
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            protected void onBindViewHolder(@NonNull NoteFragment2.NoteViewHolder holder, int position, @NonNull Note model) {

                ImageView menupopupbutton = holder.itemView.findViewById(R.id.menupopupbutton);
//                int colorCode = getRandomColor();
//                holder.note.setBackgroundColor(holder.itemView.getResources().getColor(colorCode,null));

                holder.notetitle.setText(model.getTitle());
                holder.notecontent.setText(model.getDescription() + " ");
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(v.getContext(),NoteView2.class);
                        intent.putExtra("title",model.getTitle());
                        intent.putExtra("description",model.getDescription());
                        intent.putExtra("noteId",model.getItemId());

                        v.getContext().startActivity(intent);
                    }
                });

                menupopupbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        PopupMenu popupMenu = new PopupMenu(v.getContext(),v);
                        popupMenu.getMenu().add("Edit").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {

                                Intent intent = new Intent(v.getContext(),NoteView2.class);
                                intent.putExtra("title",model.getTitle());
                                intent.putExtra("description",model.getDescription());
                                intent.putExtra("noteId",model.getItemId());

                                v.getContext().startActivity(intent);
                                return false;
                            }
                        });

                        popupMenu.getMenu().add("Delete").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {

                                DocumentReference documentReference = firebaseFirestore.collection("Notes")
                                        .document(firebaseAuth.getUid()).collection("Supplier").document(model.getItemId());

                                documentReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(getContext(), "Note is deleted successfully", Toast.LENGTH_SHORT).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getContext(), "Failed To Delete Note", Toast.LENGTH_SHORT).show();

                                    }
                                });

                                return false;
                            }
                        });

                        popupMenu.show();

                    }
                });
            }
        };

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;

    }

    private class NoteViewHolder extends RecyclerView.ViewHolder {

        TextView notetitle,notecontent;
        LinearLayout note;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            notetitle = itemView.findViewById(R.id.notetitle);
            notecontent = itemView.findViewById(R.id.notecontent);
            note = itemView.findViewById(R.id.note);
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }
}

