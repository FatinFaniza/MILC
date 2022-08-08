package com.example.milc;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.List;

public class Dietitian_View extends AppCompatActivity {

    ImageView back;
//    ExpandableListView expandableListView;
//    List<String> childItem;
//    Map<String, List<String>> listHashMap;

//    EditText searchProductEt;
//    ImageButton filterProductBtn;
//    TextView filteredProductsTv;
//    RecyclerView productsRv;

    TextView adultFormula,modularFormula;

    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

//    List<String> ParentList = new ArrayList<>();
//
//    {
//        ParentList.add("Product Category");
//    }
//
//    String[] productCategory = {
//            "Adult Formula",
//            "Modular Formula",
//            "Paediatric Formula"
//    };
//
//    ArrayList<ModelProduct> productList;
//    AdapterProduct adapterProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietitian_view);

        back = findViewById(R.id.back);
//        searchProductEt = findViewById(R.id.searchProductEt);
//        filterProductBtn = findViewById(R.id.filterProductBtn);
//        filteredProductsTv = findViewById(R.id.filteredProductsTv);
//        productsRv  = findViewById(R.id.productsRv);
        modularFormula = findViewById(R.id.modularFormula);
        adultFormula = findViewById(R.id.adultFormula);



        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

//        loadAllProducts();

//        expandableListView = findViewById(R.id.expandableListView);

        adultFormula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dietitian_View.this, Dietitian_AdultFormula.class);
                startActivity(i);
                finish();
            }
        });

        modularFormula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dietitian_View.this, Dietitian_Modular.class);
                startActivity(i);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dietitian_View.this, Dietitian_Home.class);
                startActivity(i);
                finish();
            }
        });

//        listHashMap = new LinkedHashMap<>();
//        for (String HoldItem : ParentList) {
//            if (HoldItem.equals("Product Category")) {
//                loadChild(productCategory);
//            }
////            else if (HoldItem.equals("Product Category")){
////                loadChild(productCategory);
////            }
//
//            listHashMap.put(HoldItem, childItem);
//        }

//        ExpandableListAdapter adapter = new MyExpandableListAdapter(this, (HashMap<String, List<String>>) listHashMap, ParentList);
//        expandableListView.setAdapter(adapter);
//
//        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//
//                if (groupPosition == 0) {
//                    if (childPosition == 0) {
//                        Intent intent = new Intent(Dietitian_View.this, Dietitian_AdultFormula.class);
//                        startActivity(intent);
//                    }
//                    if (childPosition == 1) {
//                        Intent intent = new Intent(Dietitian_View.this, Dietitian_Modular.class);
//                        startActivity(intent);
//                    }
//                    if (childPosition == 2) {
//                        Intent intent = new Intent(Dietitian_View.this, Dietitian_Paediatric.class);
//                        startActivity(intent);
//                    }
//                }
//                return false;
//            }
//        });

//        searchProductEt.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                try {
//                    adapterProduct.getFilter().filter(s);
//                }
//                catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//        filterProductBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(Dietitian_View.this);
//                builder.setTitle(" Choose Category: ")
//                        .setItems(Subcategory1.AllCategories, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                                //get selected item
//                                String selected = Subcategory1.AllCategories[which];
//                                filteredProductsTv.setText(selected);
//
//                                if(selected.equals("All")){
//                                    loadAllProducts();
//                                }
//                                else {
//                                    loadFilteredProducts(selected);
//                                }
//                            }
//                        })
//                .show();
//            }
//        });
    }

//    private void loadFilteredProducts(String selected) {
//        productList = new ArrayList<>();
//
//        //get all products
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users Info");
//        reference.child(firebaseAuth.getUid()).child("Products").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                //before getting reset list
//                for (DataSnapshot ds:snapshot.getChildren()){
//
//                    String productSubCategory = ""+ds.child("product SubCategory").getValue();
//
//                    //if selected category matches product category then add in
//                    if(selected.equals(productSubCategory)) {
//
//                        ModelProduct modelProduct = ds.getValue(ModelProduct.class);
//                        productList.add(modelProduct);
//                    }
//                }
//                //setup adapter
//                adapterProduct = new AdapterProduct(Dietitian_View.this,productList);
//                productsRv.setAdapter(adapterProduct);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }

//    private void loadAllProducts() {
//
//        productList = new ArrayList<>();
//
//        //get all products
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users Info");
//        reference.child(firebaseAuth.getUid()).child("Products").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                //before getting reset list
//                productList.clear();
//                for (DataSnapshot ds:snapshot.getChildren()){
//                    ModelProduct modelProduct = ds.getValue(ModelProduct.class);
//                    productList.add(modelProduct);
//                }
//
//                //setup adapter
//                adapterProduct = new AdapterProduct(Dietitian_View.this,productList);
//                productsRv.setAdapter(adapterProduct);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }

//    private void loadChild(String[] parentElementName) {
//        childItem = new ArrayList<>();
//        Collections.addAll(childItem, parentElementName);
//    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Dietitian_View.this, Dietitian_Home.class);
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

