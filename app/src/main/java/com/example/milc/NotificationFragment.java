package com.example.milc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {

    FirebaseAuth firebaseAuth;
    RecyclerView notificationRv;
    ArrayList<ModelNotification> notificationsList;
    AdapterNotification adapterNotification;
    public NotificationFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        notificationRv = view.findViewById(R.id.notificationRv);
        firebaseAuth = FirebaseAuth.getInstance();
        getAllNotifications();

        return view;

    }

    private void getAllNotifications() {

        notificationsList = new ArrayList<>();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Notifications");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                notificationsList.clear();
                for(DataSnapshot ds:snapshot.getChildren()){

                    //get data
                    ModelNotification model = ds.getValue(ModelNotification.class);

                    //add to list
                    notificationsList.add(model);
                }

                //adapter
                adapterNotification = new AdapterNotification(getActivity(),notificationsList);

                //set to recycler view
                notificationRv.setAdapter(adapterNotification);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}