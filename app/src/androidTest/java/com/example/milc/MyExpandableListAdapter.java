package com.example.milc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public abstract class MyExpandableListAdapter implements ExpandableListAdapter {

    private Context context;
    private HashMap<String,List<String>> listHashMap;
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expand_list_group_category,parent,false);

        TextView textView = convertView.findViewById(R.id.textview);
        textView.setText(String.valueOf(getGroup(groupPosition)));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expand_list_item_category,parent,false);

        TextView textView = convertView.findViewById(R.id.textview);
        textView.setText(String.valueOf(getChild(groupPosition, childPosition)));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }}
