package com.example.milc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Dietitian_Paediatric extends AppCompatActivity {

    ImageView back;
    ExpandableListView expandableListView;
    List<String> childItem;
    Map<String,List<String>> listHashMap;

    List<String> ParentList = new ArrayList<>();
    {
        ParentList.add("Standard Nutrition");
        ParentList.add("Diabetes Nutrition");
        ParentList.add("Renal Nutrition");
        ParentList.add("Complete nutrition with Fiber");
        ParentList.add("Semi elemental");
        ParentList.add("Clear nutrition");
        ParentList.add("Cancer nutrition");
    }

    String [] standard = {
            "Ensure Gold",
            "Calco"
    };

    String [] diabetes = {
            "Glucerna",
            "Nutren Diabetic Plus",
            "Diabetasol choc"
    };

    String [] renal = {
            "Nepro"
    };

    String [] complete = {
            "Nutren Fibre",
            "Jevity"
    };

    String [] semi = {
            "Peptamen"
    };

    String [] clear = {
            "Resource"
    };

    String [] cancer = {
            "Prosure"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietitian_paediatric);


        back = findViewById(R.id.back);
        expandableListView = findViewById(R.id.expandableListView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dietitian_Paediatric.this, Dietitian_View.class);
                startActivity(i);
                finish();
            }
        });


        listHashMap = new LinkedHashMap<>();
        for (String HoldItem:ParentList){
            if (HoldItem.equals("Standard Nutrition")){
                loadChild(standard);
            }
            else if (HoldItem.equals("Diabetes Nutrition")){
                loadChild(diabetes);
            }
            else if (HoldItem.equals("Renal Nutrition")){
                loadChild(renal);
            }
            else if (HoldItem.equals("Complete nutrition with Fiber")){
                loadChild(complete);
            }
            else if (HoldItem.equals("Semi elemental")){
                loadChild(semi);
            }
            else if (HoldItem.equals("Clear nutrition")){
                loadChild(clear);
            }
            else if (HoldItem.equals("Cancer nutrition")){
                loadChild(cancer);
            }

            listHashMap.put(HoldItem,childItem);
        }

        ExpandableListAdapter adapter = new MyExpandableListAdapter(this, (HashMap<String, List<String>>) listHashMap, ParentList);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if(groupPosition==0){
                    if(childPosition==0){
                        Intent intent = new Intent (Dietitian_Paediatric.this, Dietitian_Home.class);
                        startActivity(intent);
                        finish();
                    }
//                    else if(childPosition==1){
//                        Intent intent = new Intent (Company_AFproduct.this, MainActivity.class);
//                        startActivity(intent);
//                        finish();
//                    }
                }

                else if(groupPosition==2){
                    if(childPosition==0){
                        Intent intent = new Intent (Dietitian_Paediatric.this, Dietitian_Home.class);
                        startActivity(intent);
                        finish();
                    }
                }

                else if(groupPosition==4){
                    if(childPosition==0){
                        Intent intent = new Intent (Dietitian_Paediatric.this, Dietitian_Home.class);
                        startActivity(intent);
                        finish();
                    }
                }

                return false;
            }
        });
    }

    private void loadChild(String[] parentElementName){
        childItem = new ArrayList<>();
        Collections.addAll(childItem, parentElementName);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Dietitian_Paediatric.this, Dietitian_View.class);
        startActivity(i);
        finish();
    }

    private class MyExpandableListAdapter extends BaseExpandableListAdapter {

        private Context context;
        private HashMap<String, List<String>> listHashMap;
        private List<String> listDataHeader;

        public MyExpandableListAdapter(Context context, HashMap<String, List<String>> listHashMap, List<String> listDataHeader) {
            this.context = context;
            this.listHashMap = listHashMap;
            this.listDataHeader = listDataHeader;
        }

        @Override
        public int getGroupCount() {
            return listDataHeader.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return listHashMap.get(listDataHeader.get(groupPosition)).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return listDataHeader.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return listHashMap.get(listDataHeader.get(groupPosition)).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expand_list_group_category, parent, false);

            TextView textView = convertView.findViewById(R.id.textview);
            textView.setText(String.valueOf(getGroup(groupPosition)));
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expand_list_item_category, parent, false);

            TextView textView = convertView.findViewById(R.id.textview);
            textView.setText(String.valueOf(getChild(groupPosition, childPosition)));
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
    }


}