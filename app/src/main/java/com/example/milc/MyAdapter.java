package com.example.milc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    ArrayList<Note> noteArrayList;

    public MyAdapter(Context context, ArrayList<Note> noteArrayList) {
        this.context = context;
        this.noteArrayList = noteArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.notes_layout, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        Note note = noteArrayList.get(position);

        holder.notetitle.setText(note.title);
        holder.notecontent.setText(note.description);

    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView notetitle,notecontent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            notetitle = itemView.findViewById(R.id.notetitle);
            notecontent = itemView.findViewById(R.id.notecontent);
        }
    }
}









//    public MyAdapter(Context context, ArrayList<Note> noteArrayList) {
//        this.context = context;
//        this.noteArrayList = noteArrayList;
//    }
//
//    @NonNull
//    @Override
//    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View view = LayoutInflater.from(context).inflate(R.layout.notes_layout, parent, false);
//        return new MyViewHolder(view);
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
//
//        Note note = noteArrayList.get(position);
//
//        holder.notetitle.setText(note.title);
//        holder.notecontent.setText(note.description);

//    }
//
//    @Override
//    public int getItemCount() {
//        return noteArrayList.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//
//        TextView notetitle,notecontent;
//
//        public MyViewHolder(View view) {
//            super(view);
//            notetitle = itemView.findViewById(R.id.notetitle);
//            notecontent = itemView.findViewById(R.id.notecontent);        }
//    }

