package com.example.milc;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AdapterNotification extends RecyclerView.Adapter<AdapterNotification.HolderNotification> {

    private Context context;
    private ArrayList<ModelNotification> notificationsList;
    FirebaseAuth firebaseAuth;

    public AdapterNotification(Context context, ArrayList<ModelNotification> notificationsList) {
        this.context = context;
        this.notificationsList = notificationsList;

        firebaseAuth = FirebaseAuth.getInstance();

    }

    @NonNull
    @Override
    public HolderNotification onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate view row_notification
        View view = LayoutInflater.from(context).inflate(R.layout.row_notification,parent,false);
        return new HolderNotification(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderNotification holder, int position) {

        ImageView menupopupbutton = holder.itemView.findViewById(R.id.menupopupbutton);
        int x = position;

        //get and set data to views
        //get data
        ModelNotification modelNotification = notificationsList.get(position);
        String productName = modelNotification.getProductName();
        String timeStamp = modelNotification.getTimestamp();
        String uid = modelNotification.getUid();
        String notification = modelNotification.getNotification();
        String companyName = modelNotification.getProductCompany();

        //convert timestamp to dd/mm/yy hh:mm am/pm
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(Long.parseLong(timeStamp));
        String time = DateFormat.format("dd//MM/yyyy hh:mm aa",calendar).toString();

        //set data
        holder.notificationTv.setText(notification);
        holder.companyNameTv.setText(companyName + " " + notification + " " + productName + " " + "product");
        holder.timeTv.setText(time);

        menupopupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(v.getContext(),v);

                popupMenu.getMenu().add("Delete").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        notificationsList.remove(x);
//                        notifyItemRemoved(x);
                        notifyItemChanged(x);
                        notifyDataSetChanged();
                        return false;
                    }

                });
                popupMenu.show();
            }
        });

    }



    @Override
    public int getItemCount() {
        return notificationsList.size();
    }

    //1
    //holds view of recyclerview
    //holder class for views of row_notification
    class HolderNotification extends RecyclerView.ViewHolder{

        //declare views
        private TextView companyNameTv,notificationTv,timeTv;

        //create constructor
        public HolderNotification (@NonNull View itemView) {
            super(itemView);

            //init views
            companyNameTv =itemView.findViewById(R.id.companyNameTv);
            notificationTv =itemView.findViewById(R.id.notificationTv);
            timeTv =itemView.findViewById(R.id.timeTv);

        }
    }
}
