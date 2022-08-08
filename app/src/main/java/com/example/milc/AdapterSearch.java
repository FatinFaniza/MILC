package com.example.milc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.HolderSearch>{

    private Context context;
    private List<ModelProduct> searchList,nutrientList;

    public AdapterSearch(Context context, List<ModelProduct> searchList) {
        this.context = context;
        this.searchList = searchList;
    }

    @NonNull
    @Override
    public HolderSearch onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate view row_notification
        View view = LayoutInflater.from(context).inflate(R.layout.row_quick_search,parent,false);
        return new HolderSearch(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderSearch holder, int position) {
        //get data
        ModelProduct modelProduct = searchList.get(position);
        String productEnergyUnit = modelProduct.getProductEnergyUnit();
        String productHydroxyLysineUnit = modelProduct.getProductHydroxyLysineUnit();

        //set data
        holder.amountView.setText(modelProduct.getProductName() + " in 1 " + modelProduct.getProductAmountType() + " . ");
        holder.resultView.setText("Energy" + " of " + modelProduct.getProductName() + " is " + modelProduct.getProductHydroxyLysineUnit() + " . ");

        if(productEnergyUnit.equals(" ")){
            holder.resultView.setVisibility(View.GONE);
        } else{
            holder.resultView.setVisibility(View.VISIBLE);
        }

        if(productHydroxyLysineUnit.equals(" ")){
            holder.resultView.setVisibility(View.GONE);
        } else{
            holder.resultView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }


    public class HolderSearch extends RecyclerView.ViewHolder {

        //declare views
        private TextView amountView,resultView;

        public HolderSearch(@NonNull View itemView) {
            super(itemView);

            //init views
            amountView =itemView.findViewById(R.id.amountView);
            resultView =itemView.findViewById(R.id.resultView);
        }
    }
}
