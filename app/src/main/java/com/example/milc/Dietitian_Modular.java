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

public class Dietitian_Modular extends AppCompatActivity {


    ImageView back;
    ExpandableListView expandableListView;
    List<String> childItem;
    Map<String,List<String>> listHashMap;

    List<String> ParentList = new ArrayList<>();
    {
        ParentList.add("Carbohydrate");
        ParentList.add("Protein");
        ParentList.add("Fat");
        ParentList.add("Fiber");
    }

    String [] carbohydrate = {
            "Carborie",
    };

    String [] protein = {
            "Ceprolac",
            "Protegen",
            "Techno Nutri",
    };

    String [] fat = {
            "MCT oil"
    };

    String [] fiber = {
            "Gucil",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietitian_modular);

        back = findViewById(R.id.back);
        expandableListView = findViewById(R.id.expandableListView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dietitian_Modular.this, Dietitian_View.class);
                startActivity(i);
                finish();
            }
        });

        listHashMap = new LinkedHashMap<>();
        for (String HoldItem:ParentList){
            if (HoldItem.equals("Carbohydrate")){
                loadChild(carbohydrate);
            }
            else if (HoldItem.equals("Protein")){
                loadChild(protein);
            }
            else if (HoldItem.equals("Fat")){
                loadChild(fat);
            }
            else if (HoldItem.equals("Fiber")){
                loadChild(fiber);
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
                        Intent intent = new Intent (Dietitian_Modular.this, Dietitian_Carborie.class);
                        startActivity(intent);
                        finish();
                    }
                }

                else if(groupPosition==1){
                    if(childPosition==0){
                        Intent intent = new Intent (Dietitian_Modular.this, Dietitian_Ceprolac.class);
                        startActivity(intent);
                        finish();
                    }
                    else if(childPosition==1){
                        Intent intent = new Intent (Dietitian_Modular.this, Dietitian_Protegen.class);
                        startActivity(intent);
                        finish();
                    }
                    if(childPosition==2){
                        Intent intent = new Intent (Dietitian_Modular.this, Dietitian_Techno.class);
                        startActivity(intent);
                        finish();
                    }
                }

                else if(groupPosition==2){
                    if(childPosition==0){
                        Intent intent = new Intent (Dietitian_Modular.this, Dietitian_MCToil.class);
                        startActivity(intent);
                        finish();
                    }
                }
                else if(groupPosition==3){
                    if(childPosition==0){
                        Intent intent = new Intent (Dietitian_Modular.this, Dietitian_Gucil.class);
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
        Intent i = new Intent(Dietitian_Modular.this, Dietitian_View.class);
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