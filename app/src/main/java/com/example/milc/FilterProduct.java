package com.example.milc;

import android.widget.Filter;

import java.util.ArrayList;

public class FilterProduct extends Filter {

    private AdapterProduct adapter;
    private ArrayList<ModelProduct> filterList;

    public FilterProduct(AdapterProduct adapter, ArrayList<ModelProduct> filterList ) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

        FilterResults results = new FilterResults();

        //validate data for search query
        if(constraint !=null && constraint.length() >0){

            //search filled not empty, searching something, perform search
            //change to uppercase, to make case insensitive
            constraint = constraint.toString().toUpperCase();
            //store our filtered list
            ArrayList<ModelProduct> filteredModels = new ArrayList<>();

            //check, search by title and sub  category
            for (int i=0; i<filterList.size(); i++){
                if(filterList.get(i).getProductName().toUpperCase().contains(constraint) ||
                        filterList.get(i).getProductSubCategory().toUpperCase().contains(constraint)){

                    //add filtered data to list
                    filteredModels.add(filterList.get(i));
                }
            }
            results.count = filteredModels.size();
            results.values = filteredModels;
        }
        else{
            //search filled empty, not searching, return original/all/complete list

            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.productList = (ArrayList<ModelProduct>)  results.values;

        //refresh adapter
        adapter.notifyDataSetChanged();
    }
}
