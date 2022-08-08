package com.example.milc;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        LinearLayout btn_view,btn_search,btn_compare,btn_analyse,btn_note;
        TextView usernameView,positionName,hospitalName;
        ImageButton btnLogOut;
        RecyclerView productsRv;

        FirebaseAuth firebaseAuth;
        ProgressDialog progressDialog;

        btnLogOut = view.findViewById(R.id.btnLogout);
        btn_view = view.findViewById(R.id.view);
        btn_search = view.findViewById(R.id.search);
        btn_analyse = view.findViewById(R.id.analyse);
        btn_compare = view.findViewById(R.id.compare);
        usernameView = view.findViewById(R.id.username);
        positionName = view.findViewById(R.id.positionName);
        hospitalName = view.findViewById(R.id.hospitalName);
//        productsRv  = view.findViewById(R.id.productsRv);

        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference("Users Info");

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);


        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeMeOffline();
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                displayDialog();
                showDialog();
            }
        });

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Dietitian_View.class);
                startActivity(i);
            }
        });

        btn_compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Dietitian_Compare.class);
                startActivity(i);
            }
        });

        btn_analyse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Dietitian_Analyse.class);
                startActivity(i);
            }
        });

        reference.orderByChild("uid").equalTo(firebaseAuth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    String name = ""+ds.child("userName").getValue();
                    String hospital = ""+ds.child("hospitalName").getValue();
                    String position = ""+ds.child("position").getValue();
                    usernameView.setText("Welcome" + " " + name + "!" );
                    hospitalName.setText(hospital);
                    positionName.setText(position);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return view;
    }

    private void showDialog() {
         //1. create dialog builder
            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());

            //2. set the properties of dialog builder
            dialog.setTitle("Quick Search");
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View reg_layout = inflater.inflate(R.layout.quick_search,null);

            Spinner product = reg_layout.findViewById(R.id.product);
            Spinner search = reg_layout.findViewById(R.id.search);
            Button btn_result = reg_layout.findViewById(R.id.btn_result);
            TextView amountView = reg_layout.findViewById(R.id.amountView);
            TextView resultView = reg_layout.findViewById(R.id.resultView);
            dialog.setView(reg_layout);

            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();

            String[] nutrientEnsure = {"Energy","Protein","Fat","MUFA","PUFA","Linoleic Acid (Omega 3)","α-linolenicAcid","SFA","Trans Fatty Acids","Cholesterol","Carbohydrate","FOS","Choline","Taurine","L-Carnitine",
                    "Vitamin A Palmitate","Vitamin A B-carotene","Vitamin D3","Vitamin E","Vitamin K1","Vitamin C","Vitamin B1","Vitamin B2","Vitamin B6","Vitamin B12","Niacin","Folic Acid","Biotin",
                    "Pantothenic Acid", "Sodium","Potassium","Chloride","Calcium","Phosphorus","Magnesium","Iron","Zinc","Manganese","Copper","Iodine","Selenium","Chromium","Molybdenum","CaHMB","HMB"};

            String[] nutrientCalco = {"Energy", "Protein", "Fat", "MUFA", "PUFA", "Linoleic Acid (Omega 3)","α-linolenicAcid","SFA","Trans Fatty Acids", "Cholesterol", "Carbohydrate", "Choline",
                    "Vitamin A", "Vitamin D3", "Vitamin E", "Vitamin K1", "Vitamin C", "Vitamin B1", "Vitamin B2", "Vitamin B6", "Vitamin B12", "Niacin", "Folic Acid", "Biotin", "Inositol", "Pantothenic Acid",
                    "Sodium", "Potassium", "Chloride", "Calcium", "Phosphorus", "Magnesium", "Iron", "Zinc", "Manganese", "Copper", "Iodine", "Selenium", "Chromium", "Molybdenum"};

            String[] nutrientGlucerna = {"Energy", "Protein", "Fat", "MUFA", "PUFA", "Linoleic Acid (Omega 3)","α-linolenicAcid","SFA","Trans Fatty Acids", "Cholesterol",
                    "Carbohydrate", "Lactose", "Polyols", "Fiber", "FOS", "Choline", "Inositol", "Taurine", "Carnitine",
                    "Vitamin A", "Vitamin D3", "Vitamin E", "Vitamin K1", "Vitamin C", "Vitamin B1", "Vitamin B2", "VitaminB6", "VitaminB12", "Niacin", "Folic Acid", "Biotin", "PantothenicAcid",
                    "Sodium", "Potassium", "Chloride", "Calcium", "Phosphorus", "Magnesium", "Iron", "Zinc", "Manganese", "Copper", "Iodine", "Selenium", "Chromium", "Molybdenum"};

            String[] nutrientDiabetasol ={"Energy", "Protein", "Fat", "Carbohydrate", "Fiber", "Inulin", "Vitamin A", "Vitamin D3", "Vitamin E", "Vitamin C", "Vitamin B1", "Vitamin B2", "Vitamin B6", "Vitamin B12",
                    "Niacin", "Folic Acid", "Biotin", "Pantothenic Acid", "Sodium", "Potassium", "Chloride", "Calcium", "Phosphorus", "Magnesium", "Iron", "Zinc", "Iodine"};

            String[] nutrientNeproHP = {"Energy", "Protein", "Fat", "MUFA", "PUFA",  "Linoleic Acid (Omega 3)","α-linolenicAcid","SFA","Trans Fatty Acids",
                    "Carbohydrate", "Polyols", "Total sugar", "Fiber", "Dietary fiber", "FOS", "Choline", "Taurine", "Carnitine",
                    "Vitamin A Palmitate", "Vitamin D3", "Vitamin E", "Vitamin K1", "Vitamin C", "Vitamin B1", "Vitamin B2", "Vitamin B6", "Vitamin B12", "Niacin", "Folic Acid", "Biotin", "Pantothenic Acid",
                    "Sodium", "Potassium", "Chloride", "Calcium", "Phosphorus", "Magnesium", "Iron", "Zinc", "Manganese", "Copper", "Iodine", "Selenium", "Chromium", "Molybdenum","Water"};

            String[] nutrientPeptamen = {"Energy", "Protein", "Fat", "MUFA", "PUFA", "Linoleic Acid (Omega 3)", "α-linolenicAcid", "SFA", "MCT oil", "Trans Fatty Acids", "Carbohydrate", "Lactose",
                    "Fiber", "Choline", "Taurine", "L-Carnitine",
                    "Vitamin A", "Vitamin D", "Vitamin E", "Vitamin K", "Vitamin C", "Vitamin B1", "Vitamin B2", "Vitamin B6", "Vitamin B12", "Niacin", "Niacin Equivalent", "Folic Acid", "Biotin", "Pantothenic Acid",
                    "Sodium", "Potassium", "Chloride", "Calcium", "Phosphorus", "Magnesium", "Iron", "Zinc", "Manganese", "Copper", "Iodine", "Selenium", "Chromium", "Molybdenum", "Salt" };

            String[] nutrientResource ={"Energy", "Protein", "Fat", "Carbohydrate", "Fiber", "Total sugar", "Vitamin A", "Vitamin D", "Vitamin E", "Vitamin K", "Vitamin C", "Vitamin B1", "Vitamin B2", "Vitamin B6", "Vitamin B12", "Niacin",
                    "Folic Acid", "Biotin", "Pantothenic Acid","Sodium", "Potassium", "Calcium", "Phosphorus", "Magnesium", "Iodine"};

            String[] nutrientProsure = {"Energy", "Protein", "Fat", "MUFA", "PUFA", "Linoleic Acid (Omega 3)", "α-linolenicAcid", "EPA", "DHA", "SFA", "Trans Fatty Acids", "Carbohydrate", "Fiber",
                    "Dietary fiber", "FOS", "Choline", "Taurine", "Carnitine",
                    "Vitamin A", "Vitamin A B-carotene", "Vitamin D3", "Vitamin E", "Vitamin K1", "Vitamin C", "Vitamin B1", "Vitamin B2", "Vitamin B6", "Vitamin B12", "Niacin", "Folic Acid", "Biotin", "Pantothenic Acid",
                    "Sodium", "Potassium", "Chloride", "Calcium", "Phosphorus", "Magnesium", "Iron", "Zinc", "Manganese", "Copper", "Iodine", "Selenium", "Chromium", "Molybdenum"};

            String[] nutrientCarborie = {"Energy", "Protein", "Fat", "Carbohydrate", "Sodium", "Potassium", "Chloride", "Calcium", "Phosphorus", "Iron"} ;

            String[] nutrientCeprolac ={"Energy", "Protein", "Fat", "Carbohydrate", "Lactose","Essential Amino Acid","Branched Amino Acid","α-Lactalbumin","β-Lactoglobulin","Glycomacropeptide","Immunoglobulin G (IgG)","Bovine Serum Albumin","Protease Peptone 5",
                    "Sodium", "Potassium", "Calcium", "Phosphorus", "Magnesium","Isoleucine","Leucine", "Lysine", "Methionine", "Phenylalanine", "Threonine", "Tryptophan", "Valine",
                    "Histidine", "Alanine", "Arginine", "Asparticacid", "Cysteine", "Glutamic Acid", "Glycine", "Proline", "Serine", "Tyrosine"};

            String[] nutrientProtegen = {"Energy", "Protein", "Fat", "Carbohydrate", "Sodium", "Potassium", "Calcium", "Phosphorus", "Chloride",
                    "Isoleucine", "Leucine", "Lysine", "Methionine", "Phenylalanine", "Threonine", "Valine",
                    "Histidine", "Alanine", "Arginine", "Aspartic Acid","Glutamic Acid", "Glycine", "Proline", "Serine", "Tyrosine",
                    "Hydroxy-Lysine","Hydroxy-Proline"};

            String[] nutrientTechno = {"Energy", "Protein", "Fat", "Carbohydrate", "Vitamin A", "Vitamin C", "Sodium", "Calcium", "Iron",
                    "Isoleucine", "Leucine", "Lysine", "Methionine", "Phenylalanine", "Threonine", "Tryptophan", "Valine",
                    "Histidine", "Alanine", "Arginine", "Aspartic Acid", "Cysteine", "Glutamic Acid", "Glycine", "Proline", "Serine", "Tyrosine"};

            String[] nutrientMCT ={"Energy", "Protein", "Fat", "MUFA", "PUFA", "SFA", "Trans Fatty Acids", "Cholesterol", "Carbohydrate"};

            String[] nutrientGucil ={"Energy" ,"Protein" ,"Fat" ,"Carbohydrate" ,"Total sugar", "Dietary fiber" ,"Sodium" ,"Soluble fiber"};

//        final String[] Product = {"Ensure Gold","Calco","Glucerna Vanilla","Diabetasol Milk","Nepro HP","Peptamen","Resource"};
//        ArrayAdapter<String> AdapterProduct = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,Product);
//        product.setAdapter(AdapterProduct);

            ArrayAdapter<String> AdapterEnsure = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientEnsure);
            ArrayAdapter<String> AdapterCalco = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientCalco);
            ArrayAdapter<String> AdapterGlucerna = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientGlucerna);
            ArrayAdapter<String> AdapterDiabetasol = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientDiabetasol);
            ArrayAdapter<String> AdapterNeproHP = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientNeproHP);
            ArrayAdapter<String> AdapterPeptamen = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientPeptamen);
            ArrayAdapter<String> AdapterResource = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientResource);
            ArrayAdapter<String> AdapterProsure = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientProsure);
            ArrayAdapter<String> AdapterCarborie = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientCarborie);
            ArrayAdapter<String> AdapterCeprolac = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientCeprolac);
            ArrayAdapter<String> AdapterProtegen = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientProtegen);
            ArrayAdapter<String> AdapterTechno = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientTechno);
            ArrayAdapter<String> AdapterMCT = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientMCT);
            ArrayAdapter<String> AdapterGucil = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientGucil);

            //nnti da siap isi suma info.. tukar ke reference 'product'
            databaseReference.child("Products Info").child("t5aTq32ZMaP33c16tCaOrFvaKyt2").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    arrayList.clear();
                    for(DataSnapshot item : snapshot.getChildren()){
                        arrayList.add(item.child("product Name").getValue(String.class));
                    }
                    ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,arrayList);
                    product.setAdapter(arrayAdapter1);
                }
                @Override
                public void onCancelled(DatabaseError error) {

                }
            });

            product.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    if(position == 0){
                        search.setAdapter(AdapterEnsure);
                    }
                    if(position == 1){
                        search.setAdapter(AdapterCalco);
                    }
                    if(position == 2){
                        search.setAdapter(AdapterGlucerna);
                    }
                    if(position == 3){
                        search.setAdapter(AdapterDiabetasol);
                    }
                    if(position == 4){
                        search.setAdapter(AdapterNeproHP);
                    }
                    if(position == 5){
                        search.setAdapter(AdapterPeptamen);
                    }
                    if(position == 6){
                        search.setAdapter(AdapterResource);
                    }
                    if(position == 7){
                        search.setAdapter(AdapterProsure);
                    }
                    if(position == 8){
                        search.setAdapter(AdapterCarborie);
                    }
                    if(position == 9){
                        search.setAdapter(AdapterCeprolac);
                    }
                    if(position == 10){
                        search.setAdapter(AdapterProtegen);
                    }
                    if(position == 11){
                        search.setAdapter(AdapterTechno);
                    }
                    if(position == 12){
                        search.setAdapter(AdapterMCT);
                    }
                    if(position == 13){
                        search.setAdapter(AdapterGucil);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            btn_result.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //create string variable to get from spinner
                    String productName = product.getSelectedItem().toString();
                    String nutrientList = search.getSelectedItem().toString();

                    DatabaseReference nutrient = FirebaseDatabase.getInstance().getReference("Products Info");
                    nutrient.child("t5aTq32ZMaP33c16tCaOrFvaKyt2").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {

                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////Ensure Gold
                            if (productName.equals("Ensure Gold")) {
                                String amount = snapshot.child("1649956682127").child("product AmountType").getValue(String.class);
                                amountView.setText(productName + " in 1 " + amount + " . ");

                                //Energy
                                if (nutrientList.equals("Energy")) {
                                    String energy = snapshot.child("1649956682127").child("product EnergyUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Protein")) {
                                    String energy = snapshot.child("1649956682127").child("product ProteinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fat")) {
                                    String energy = snapshot.child("1649956682127").child("product FatUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("MUFA")) {
                                    String energy = snapshot.child("1649956682127").child("product MUFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("PUFA")) {
                                    String energy = snapshot.child("1649956682127").child("product PUFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Linoleic Acid (Omega 3)")) {
                                    String energy = snapshot.child("1649956682127").child("product LinoleicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("α-linolenicAcid")) {
                                    String energy = snapshot.child("1649956682127").child("product αlinolenicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("SFA")) {
                                    String energy = snapshot.child("1649956682127").child("product SFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Trans Fatty Acids")) {
                                    String energy = snapshot.child("1649956682127").child("product TransfattyAcidsUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Cholesterol")) {
                                    String energy = snapshot.child("1649956682127").child("product CholesterolUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carbohydrate")) {
                                    String energy = snapshot.child("1649956682127").child("product CarbohydrateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("FOS")) {
                                    String energy = snapshot.child("1649956682127").child("product FOSUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Choline")) {
                                    String energy = snapshot.child("1649956682127").child("product CholineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Taurine")) {
                                    String energy = snapshot.child("1649956682127").child("product TaurineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("L-Carnitine")) {
                                    String energy = snapshot.child("1649956682127").child("product LcarnitineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin A Palmitate")) {
                                    String energy = snapshot.child("1649956682127").child("product VitaminAPalmitateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin A B-carotene")) {
                                    String energy = snapshot.child("1649956682127").child("product VitaminABcaroteneUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin D3")) {
                                    String energy = snapshot.child("1649956682127").child("product VitaminD3Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin E")) {
                                    String energy = snapshot.child("1649956682127").child("product VitaminEUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin K1")) {
                                    String energy = snapshot.child("1649956682127").child("product VitaminK1Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin C")) {
                                    String energy = snapshot.child("1649956682127").child("product VitaminCUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B1")) {
                                    String energy = snapshot.child("1649956682127").child("product VitaminB1Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B2")) {
                                    String energy = snapshot.child("1649956682127").child("product VitaminB2Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B6")) {
                                    String energy = snapshot.child("1649956682127").child("product VitaminB6Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B12")) {
                                    String energy = snapshot.child("1649956682127").child("product VitaminB12Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Niacin")) {
                                    String energy = snapshot.child("1649956682127").child("product NiacinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Folic Acid")) {
                                    String energy = snapshot.child("1649956682127").child("product FolicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Biotin")) {
                                    String energy = snapshot.child("1649956682127").child("product BiotinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Pantothenic Acid")) {
                                    String energy = snapshot.child("1649956682127").child("product PantothenicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Sodium")) {
                                    String energy = snapshot.child("1649956682127").child("product SodiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Potassium")) {
                                    String energy = snapshot.child("1649956682127").child("product PotassiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Chloride")) {
                                    String energy = snapshot.child("1649956682127").child("product ChlorideUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Calcium")) {
                                    String energy = snapshot.child("1649956682127").child("product CalciumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Phosphorus")) {
                                    String energy = snapshot.child("1649956682127").child("product PhosphorusUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Magnesium")) {
                                    String energy = snapshot.child("1649956682127").child("product MagnesiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iron")) {
                                    String energy = snapshot.child("1649956682127").child("product IronUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Zinc")) {
                                    String energy = snapshot.child("1649956682127").child("product ZincUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Manganese")) {
                                    String energy = snapshot.child("1649956682127").child("product ManganeseUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Copper")) {
                                    String energy = snapshot.child("1649956682127").child("product CopperUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iodine")) {
                                    String energy = snapshot.child("1649956682127").child("product IodineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Selenium")) {
                                    String energy = snapshot.child("1649956682127").child("product SeleniumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Chromium")) {
                                    String energy = snapshot.child("1649956682127").child("product ChromiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Molybdenum")) {
                                    String energy = snapshot.child("1649956682127").child("product MolybdenumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("CaHMB")) {
                                    String energy = snapshot.child("1649956682127").child("product caHMBUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("HMB")) {
                                    String energy = snapshot.child("1649956682127").child("product HMBUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////Calco
                            if (productName.equals("Calco")) {
                                String amount = snapshot.child("1649957698787").child("product AmountType").getValue(String.class);
                                amountView.setText(productName + " in 1 " + amount + " . ");

                                //Energy
                                if (nutrientList.equals("Energy")) {
                                    String energy = snapshot.child("1649957698787").child("product EnergyUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Protein")) {
                                    String energy = snapshot.child("1649957698787").child("product ProteinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fat")) {
                                    String energy = snapshot.child("1649957698787").child("product FatUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("MUFA")) {
                                    String energy = snapshot.child("1649956682127").child("product MUFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("PUFA")) {
                                    String energy = snapshot.child("1649957698787").child("product PUFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Linoleic Acid (Omega 3)")) {
                                    String energy = snapshot.child("1649957698787").child("product LinoleicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("α-linolenicAcid")) {
                                    String energy = snapshot.child("1649957698787").child("product αlinolenicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("SFA")) {
                                    String energy = snapshot.child("1649957698787").child("product SFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Trans Fatty Acids")) {
                                    String energy = snapshot.child("1649957698787").child("product TransfattyAcidsUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Cholesterol")) {
                                    String energy = snapshot.child("1649957698787").child("product CholesterolUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carbohydrate")) {
                                    String energy = snapshot.child("1649957698787").child("product CarbohydrateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Choline")) {
                                    String energy = snapshot.child("1649957698787").child("product CholineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin A")) {
                                    String energy = snapshot.child("1649957698787").child("product VitaminAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin D3")) {
                                    String energy = snapshot.child("1649957698787").child("product VitaminD3Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin E")) {
                                    String energy = snapshot.child("1649957698787").child("product VitaminEUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin K1")) {
                                    String energy = snapshot.child("1649957698787").child("product VitaminK1Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin C")) {
                                    String energy = snapshot.child("1649957698787").child("product VitaminCUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B1")) {
                                    String energy = snapshot.child("1649957698787").child("product VitaminB1Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B2")) {
                                    String energy = snapshot.child("1649957698787").child("product VitaminB2Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B6")) {
                                    String energy = snapshot.child("1649957698787").child("product VitaminB6Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B12")) {
                                    String energy = snapshot.child("1649957698787").child("product VitaminB12Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Niacin")) {
                                    String energy = snapshot.child("1649957698787").child("product NiacinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Folic Acid")) {
                                    String energy = snapshot.child("1649957698787").child("product FolicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Biotin")) {
                                    String energy = snapshot.child("1649957698787").child("product BiotinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Inositol")) {
                                    String energy = snapshot.child("1649957698787").child("product InositolUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Pantothenic Acid")) {
                                    String energy = snapshot.child("1649957698787").child("product PantothenicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Sodium")) {
                                    String energy = snapshot.child("1649957698787").child("product SodiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Potassium")) {
                                    String energy = snapshot.child("1649957698787").child("product PotassiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Chloride")) {
                                    String energy = snapshot.child("1649957698787").child("product ChlorideUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Calcium")) {
                                    String energy = snapshot.child("1649957698787").child("product CalciumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Phosphorus")) {
                                    String energy = snapshot.child("1649957698787").child("product PhosphorusUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Magnesium")) {
                                    String energy = snapshot.child("1649957698787").child("product MagnesiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iron")) {
                                    String energy = snapshot.child("1649957698787").child("product IronUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Zinc")) {
                                    String energy = snapshot.child("1649957698787").child("product ZincUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Manganese")) {
                                    String energy = snapshot.child("1649957698787").child("product ManganeseUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Copper")) {
                                    String energy = snapshot.child("1649957698787").child("product CopperUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iodine")) {
                                    String energy = snapshot.child("1649957698787").child("product IodineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Selenium")) {
                                    String energy = snapshot.child("1649957698787").child("product SeleniumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Chromium")) {
                                    String energy = snapshot.child("1649957698787").child("product ChromiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Molybdenum")) {
                                    String energy = snapshot.child("1649957698787").child("product MolybdenumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////Glucerna Vanilla
                            if (productName.equals("Glucerna Vanilla")) {
                                String amount = snapshot.child("1649958774561").child("product AmountType").getValue(String.class);
                                amountView.setText(productName + " in 1 " + amount + " . ");

                                //Energy
                                if (nutrientList.equals("Energy")) {
                                    String energy = snapshot.child("1649958774561").child("product EnergyUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Protein")) {
                                    String energy = snapshot.child("1649958774561").child("product ProteinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fat")) {
                                    String energy = snapshot.child("1649958774561").child("product FatUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("MUFA")) {
                                    String energy = snapshot.child("1649958774561").child("product MUFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("PUFA")) {
                                    String energy = snapshot.child("1649958774561").child("product PUFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Linoleic Acid (Omega 3)")) {
                                    String energy = snapshot.child("1649958774561").child("product LinoleicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("α-linolenicAcid")) {
                                    String energy = snapshot.child("1649958774561").child("product αlinolenicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("SFA")) {
                                    String energy = snapshot.child("1649958774561").child("product SFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Trans Fatty Acids")) {
                                    String energy = snapshot.child("1649958774561").child("product TransfattyAcidsUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Cholesterol")) {
                                    String energy = snapshot.child("1649958774561").child("product CholesterolUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carbohydrate")) {
                                    String energy = snapshot.child("1649958774561").child("product CarbohydrateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Lactose")) {
                                    String energy = snapshot.child("1649958774561").child("product LactoseUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Polyols")) {
                                    String energy = snapshot.child("1649958774561").child("product PolyolsUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fiber")) {
                                    String energy = snapshot.child("1649958774561").child("product FiberUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("FOS")) {
                                    String energy = snapshot.child("1649958774561").child("product FOSUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Choline")) {
                                    String energy = snapshot.child("1649958774561").child("product CholineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Taurine")) {
                                    String energy = snapshot.child("1649958774561").child("product TaurineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Inositol")) {
                                    String energy = snapshot.child("1649958774561").child("product InositolUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carnitine")) {
                                    String energy = snapshot.child("1649958774561").child("product CarnitineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin A")) {
                                    String energy = snapshot.child("1649958774561").child("product VitaminAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin D3")) {
                                    String energy = snapshot.child("1649958774561").child("product VitaminD3Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin E")) {
                                    String energy = snapshot.child("1649958774561").child("product VitaminEUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin K1")) {
                                    String energy = snapshot.child("1649958774561").child("product VitaminK1Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin C")) {
                                    String energy = snapshot.child("1649958774561").child("product VitaminCUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B1")) {
                                    String energy = snapshot.child("1649958774561").child("product VitaminB1Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B2")) {
                                    String energy = snapshot.child("1649958774561").child("product VitaminB2Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B6")) {
                                    String energy = snapshot.child("1649958774561").child("product VitaminB6Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B12")) {
                                    String energy = snapshot.child("1649958774561").child("product VitaminB12Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Niacin")) {
                                    String energy = snapshot.child("1649958774561").child("product NiacinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Folic Acid")) {
                                    String energy = snapshot.child("1649958774561").child("product FolicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Biotin")) {
                                    String energy = snapshot.child("1649958774561").child("product BiotinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Pantothenic Acid")) {
                                    String energy = snapshot.child("1649958774561").child("product PantothenicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Sodium")) {
                                    String energy = snapshot.child("1649958774561").child("product SodiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Potassium")) {
                                    String energy = snapshot.child("1649958774561").child("product PotassiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Chloride")) {
                                    String energy = snapshot.child("1649958774561").child("product ChlorideUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Calcium")) {
                                    String energy = snapshot.child("1649958774561").child("product CalciumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Phosphorus")) {
                                    String energy = snapshot.child("1649958774561").child("product PhosphorusUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Magnesium")) {
                                    String energy = snapshot.child("1649958774561").child("product MagnesiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iron")) {
                                    String energy = snapshot.child("1649958774561").child("product IronUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Zinc")) {
                                    String energy = snapshot.child("1649958774561").child("product ZincUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Manganese")) {
                                    String energy = snapshot.child("1649958774561").child("product ManganeseUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Copper")) {
                                    String energy = snapshot.child("1649958774561").child("product CopperUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iodine")) {
                                    String energy = snapshot.child("1649958774561").child("product IodineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Selenium")) {
                                    String energy = snapshot.child("1649958774561").child("product SeleniumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Chromium")) {
                                    String energy = snapshot.child("1649958774561").child("product ChromiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Molybdenum")) {
                                    String energy = snapshot.child("1649958774561").child("product MolybdenumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////Diabetasol
                            if (productName.equals("Diabetasol Milk")) {
                                String amount = snapshot.child("1649959666026").child("product AmountType").getValue(String.class);
                                amountView.setText(productName + " in 1 " + amount + " . ");

                                //Energy
                                if (nutrientList.equals("Energy")) {
                                    String energy = snapshot.child("1649959666026").child("product EnergyUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Protein")) {
                                    String energy = snapshot.child("1649959666026").child("product ProteinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fat")) {
                                    String energy = snapshot.child("1649959666026").child("product FatUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carbohydrate")) {
                                    String energy = snapshot.child("1649959666026").child("product CarbohydrateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fiber")) {
                                    String energy = snapshot.child("1649959666026").child("product FiberUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Inulin")) {
                                    String energy = snapshot.child("1649959666026").child("product InulinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin A")) {
                                    String energy = snapshot.child("1649959666026").child("product VitaminAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin D3")) {
                                    String energy = snapshot.child("1649959666026").child("product VitaminD3Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin E")) {
                                    String energy = snapshot.child("1649959666026").child("product VitaminEUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin C")) {
                                    String energy = snapshot.child("1649959666026").child("product VitaminCUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B1")) {
                                    String energy = snapshot.child("1649959666026").child("product VitaminB1Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B2")) {
                                    String energy = snapshot.child("1649959666026").child("product VitaminB2Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B6")) {
                                    String energy = snapshot.child("1649959666026").child("product VitaminB6Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B12")) {
                                    String energy = snapshot.child("1649959666026").child("product VitaminB12Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Niacin")) {
                                    String energy = snapshot.child("1649959666026").child("product NiacinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Folic Acid")) {
                                    String energy = snapshot.child("1649959666026").child("product FolicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Biotin")) {
                                    String energy = snapshot.child("1649959666026").child("product BiotinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Pantothenic Acid")) {
                                    String energy = snapshot.child("1649959666026").child("product PantothenicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Sodium")) {
                                    String energy = snapshot.child("1649959666026").child("product SodiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Potassium")) {
                                    String energy = snapshot.child("1649959666026").child("product PotassiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Chloride")) {
                                    String energy = snapshot.child("1649959666026").child("product ChlorideUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Calcium")) {
                                    String energy = snapshot.child("1649959666026").child("product CalciumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Phosphorus")) {
                                    String energy = snapshot.child("1649959666026").child("product PhosphorusUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Magnesium")) {
                                    String energy = snapshot.child("1649959666026").child("product MagnesiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iron")) {
                                    String energy = snapshot.child("1649959666026").child("product IronUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Zinc")) {
                                    String energy = snapshot.child("1649959666026").child("product ZincUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iodine")) {
                                    String energy = snapshot.child("1649959666026").child("product IodineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////NeproHP
                            if (productName.equals("Nepro HP")) {
                                String amount = snapshot.child("1649960954263").child("product AmountType").getValue(String.class);
                                amountView.setText(productName + " in 1 " + amount + " . ");

                                //Energy
                                if (nutrientList.equals("Energy")) {
                                    String energy = snapshot.child("1649960954263").child("product EnergyUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Protein")) {
                                    String energy = snapshot.child("1649960954263").child("product ProteinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fat")) {
                                    String energy = snapshot.child("1649960954263").child("product FatUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("MUFA")) {
                                    String energy = snapshot.child("1649960954263").child("product MUFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("PUFA")) {
                                    String energy = snapshot.child("1649960954263").child("product PUFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Linoleic Acid (Omega 3)")) {
                                    String energy = snapshot.child("1649960954263").child("product LinoleicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("α-linolenicAcid")) {
                                    String energy = snapshot.child("1649960954263").child("product αlinolenicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("SFA")) {
                                    String energy = snapshot.child("1649960954263").child("product SFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Trans Fatty Acids")) {
                                    String energy = snapshot.child("1649960954263").child("product TransfattyAcidsUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carbohydrate")) {
                                    String energy = snapshot.child("1649960954263").child("product CarbohydrateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Polyols")) {
                                    String energy = snapshot.child("1649960954263").child("product PolyolsUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Total sugar")) {
                                    String energy = snapshot.child("1649960954263").child("product TotalsugarUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fiber")) {
                                    String energy = snapshot.child("1649960954263").child("product FiberUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Dietary fiber")) {
                                    String energy = snapshot.child("1649960954263").child("product DietaryfiberUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("FOS")) {
                                    String energy = snapshot.child("1649960954263").child("product FOSUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Choline")) {
                                    String energy = snapshot.child("1649960954263").child("product CholineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Taurine")) {
                                    String energy = snapshot.child("1649960954263").child("product TaurineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carnitine")) {
                                    String energy = snapshot.child("1649960954263").child("product CarnitineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin A Palmitate")) {
                                    String energy = snapshot.child("1649960954263").child("product VitaminAPalmitateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin D3")) {
                                    String energy = snapshot.child("1649960954263").child("product VitaminD3Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin E")) {
                                    String energy = snapshot.child("1649960954263").child("product VitaminEUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin K1")) {
                                    String energy = snapshot.child("1649960954263").child("product VitaminK1Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin C")) {
                                    String energy = snapshot.child("1649960954263").child("product VitaminCUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B1")) {
                                    String energy = snapshot.child("1649960954263").child("product VitaminB1Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B2")) {
                                    String energy = snapshot.child("1649960954263").child("product VitaminB2Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B6")) {
                                    String energy = snapshot.child("1649960954263").child("product VitaminB6Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B12")) {
                                    String energy = snapshot.child("1649960954263").child("product VitaminB12Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Niacin")) {
                                    String energy = snapshot.child("1649960954263").child("product NiacinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Folic Acid")) {
                                    String energy = snapshot.child("1649960954263").child("product FolicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Biotin")) {
                                    String energy = snapshot.child("1649960954263").child("product BiotinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Pantothenic Acid")) {
                                    String energy = snapshot.child("1649960954263").child("product PantothenicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Sodium")) {
                                    String energy = snapshot.child("1649960954263").child("product SodiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Potassium")) {
                                    String energy = snapshot.child("1649960954263").child("product PotassiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Chloride")) {
                                    String energy = snapshot.child("1649960954263").child("product ChlorideUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Calcium")) {
                                    String energy = snapshot.child("1649960954263").child("product CalciumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Phosphorus")) {
                                    String energy = snapshot.child("1649960954263").child("product PhosphorusUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Magnesium")) {
                                    String energy = snapshot.child("1649960954263").child("product MagnesiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iron")) {
                                    String energy = snapshot.child("1649960954263").child("product IronUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Zinc")) {
                                    String energy = snapshot.child("1649960954263").child("product ZincUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Manganese")) {
                                    String energy = snapshot.child("1649960954263").child("product ManganeseUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Copper")) {
                                    String energy = snapshot.child("1649960954263").child("product CopperUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iodine")) {
                                    String energy = snapshot.child("1649960954263").child("product IodineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Selenium")) {
                                    String energy = snapshot.child("1649960954263").child("product SeleniumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Chromium")) {
                                    String energy = snapshot.child("1649960954263").child("product ChromiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Molybdenum")) {
                                    String energy = snapshot.child("1649960954263").child("product MolybdenumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Water")) {
                                    String energy = snapshot.child("1649960954263").child("product WaterUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////Peptamen
                            if (productName.equals("Peptamen")) {
                                String amount = snapshot.child("1649972715423").child("product AmountType").getValue(String.class);
                                amountView.setText(productName + " in 1 " + amount + " . ");

                                //Energy
                                if (nutrientList.equals("Energy")) {
                                    String energy = snapshot.child("1649972715423").child("product EnergyUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Protein")) {
                                    String energy = snapshot.child("1649972715423").child("product ProteinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fat")) {
                                    String energy = snapshot.child("1649972715423").child("product FatUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("MUFA")) {
                                    String energy = snapshot.child("1649972715423").child("product MUFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("PUFA")) {
                                    String energy = snapshot.child("1649972715423").child("product PUFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Linoleic Acid (Omega 3)")) {
                                    String energy = snapshot.child("1649972715423").child("product LinoleicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("α-linolenicAcid")) {
                                    String energy = snapshot.child("1649972715423").child("product αlinolenicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("SFA")) {
                                    String energy = snapshot.child("1649972715423").child("product SFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Trans Fatty Acids")) {
                                    String energy = snapshot.child("1649972715423").child("product TransfattyAcidsUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("MCT oil")) {
                                    String energy = snapshot.child("1649972715423").child("product MCToilUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carbohydrate")) {
                                    String energy = snapshot.child("1649972715423").child("product CarbohydrateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Lactose")) {
                                    String energy = snapshot.child("1649972715423").child("product LactoseUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fiber")) {
                                    String energy = snapshot.child("1649972715423").child("product FiberUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Choline")) {
                                    String energy = snapshot.child("1649972715423").child("product CholineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Taurine")) {
                                    String energy = snapshot.child("1649972715423").child("product TaurineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("L-Carnitine")) {
                                    String energy = snapshot.child("1649972715423").child("product LcarnitineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin A")) {
                                    String energy = snapshot.child("1649972715423").child("product VitaminAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin D")) {
                                    String energy = snapshot.child("1649972715423").child("product VitaminDUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin E")) {
                                    String energy = snapshot.child("1649972715423").child("product VitaminEUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin K1")) {
                                    String energy = snapshot.child("1649972715423").child("product VitaminK1Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin C")) {
                                    String energy = snapshot.child("1649972715423").child("product VitaminCUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B1")) {
                                    String energy = snapshot.child("1649972715423").child("product VitaminB1Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B2")) {
                                    String energy = snapshot.child("1649972715423").child("product VitaminB2Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B6")) {
                                    String energy = snapshot.child("1649972715423").child("product VitaminB6Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B12")) {
                                    String energy = snapshot.child("1649972715423").child("product VitaminB12Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Niacin Equivalent")) {
                                    String energy = snapshot.child("1649972715423").child("product NiacinEquivalentUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Niacin")) {
                                    String energy = snapshot.child("1649972715423").child("product NiacinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Folic Acid")) {
                                    String energy = snapshot.child("1649972715423").child("product FolicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Biotin")) {
                                    String energy = snapshot.child("1649972715423").child("product BiotinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Pantothenic Acid")) {
                                    String energy = snapshot.child("1649972715423").child("product PantothenicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Sodium")) {
                                    String energy = snapshot.child("1649972715423").child("product SodiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Potassium")) {
                                    String energy = snapshot.child("1649972715423").child("product PotassiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Chloride")) {
                                    String energy = snapshot.child("1649972715423").child("product ChlorideUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Calcium")) {
                                    String energy = snapshot.child("1649972715423").child("product CalciumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Phosphorus")) {
                                    String energy = snapshot.child("1649972715423").child("product PhosphorusUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Magnesium")) {
                                    String energy = snapshot.child("1649972715423").child("product MagnesiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iron")) {
                                    String energy = snapshot.child("1649972715423").child("product IronUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Zinc")) {
                                    String energy = snapshot.child("1649972715423").child("product ZincUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Manganese")) {
                                    String energy = snapshot.child("1649972715423").child("product ManganeseUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Copper")) {
                                    String energy = snapshot.child("1649972715423").child("product CopperUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iodine")) {
                                    String energy = snapshot.child("1649972715423").child("product IodineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Selenium")) {
                                    String energy = snapshot.child("1649972715423").child("product SeleniumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Chromium")) {
                                    String energy = snapshot.child("1649972715423").child("product ChromiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Molybdenum")) {
                                    String energy = snapshot.child("1649972715423").child("product MolybdenumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Salt")) {
                                    String energy = snapshot.child("1649972715423").child("product SaltUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////Resource
                            if (productName.equals("Resource")) {
                                String amount = snapshot.child("1649972764821").child("product AmountType").getValue(String.class);
                                amountView.setText(productName + " in 1 " + amount + " . ");

                                //Energy
                                if (nutrientList.equals("Energy")) {
                                    String energy = snapshot.child("1649972764821").child("product EnergyUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Protein")) {
                                    String energy = snapshot.child("1649972764821").child("product ProteinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fat")) {
                                    String energy = snapshot.child("1649972764821").child("product FatUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + "  .");
                                }
                                if (nutrientList.equals("Carbohydrate")) {
                                    String energy = snapshot.child("1649972764821").child("product CarbohydrateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fiber")) {
                                    String energy = snapshot.child("1649972764821").child("product FiberUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Total sugar")) {
                                    String energy = snapshot.child("1649972764821").child("product TotalsugarUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin A")) {
                                    String energy = snapshot.child("1649972764821").child("product VitaminAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin D")) {
                                    String energy = snapshot.child("1649972764821").child("product VitaminDUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin E")) {
                                    String energy = snapshot.child("1649972764821").child("product VitaminEUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin K")) {
                                    String energy = snapshot.child("1649972764821").child("product VitaminKUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin C")) {
                                    String energy = snapshot.child("1649972764821").child("product VitaminCUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B1")) {
                                    String energy = snapshot.child("1649972764821").child("product VitaminB1Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B2")) {
                                    String energy = snapshot.child("1649972764821").child("product VitaminB2Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B6")) {
                                    String energy = snapshot.child("1649972764821").child("product VitaminB6Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B12")) {
                                    String energy = snapshot.child("1649972764821").child("product VitaminB12Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Niacin")) {
                                    String energy = snapshot.child("1649972764821").child("product NiacinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Folic Acid")) {
                                    String energy = snapshot.child("1649972764821").child("product FolicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Biotin")) {
                                    String energy = snapshot.child("1649972764821").child("product BiotinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Pantothenic Acid")) {
                                    String energy = snapshot.child("1649972764821").child("product PantothenicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Sodium")) {
                                    String energy = snapshot.child("1649972764821").child("product SodiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Potassium")) {
                                    String energy = snapshot.child("1649972764821").child("product PotassiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Calcium")) {
                                    String energy = snapshot.child("1649972764821").child("product CalciumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Phosphorus")) {
                                    String energy = snapshot.child("1649972764821").child("product PhosphorusUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Magnesium")) {
                                    String energy = snapshot.child("1649972764821").child("product MagnesiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iodine")) {
                                    String energy = snapshot.child("1649972764821").child("product IodineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////Prosure
                            if (productName.equals("Prosure")) {
                                String amount = snapshot.child("1649972806785").child("product AmountType").getValue(String.class);
                                amountView.setText(productName + " in 1 " + amount + " . ");

                                //Energy
                                if (nutrientList.equals("Energy")) {
                                    String energy = snapshot.child("1649972806785").child("product EnergyUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Protein")) {
                                    String energy = snapshot.child("1649972806785").child("product ProteinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fat")) {
                                    String energy = snapshot.child("1649972806785").child("product FatUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("MUFA")) {
                                    String energy = snapshot.child("1649972806785").child("product MUFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("PUFA")) {
                                    String energy = snapshot.child("1649972806785").child("product PUFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Linoleic Acid (Omega 3)")) {
                                    String energy = snapshot.child("1649972806785").child("product LinoleicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("α-linolenicAcid")) {
                                    String energy = snapshot.child("1649972806785").child("product αlinolenicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("EPA")) {
                                    String energy = snapshot.child("1649972806785").child("product EPAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("DHA")) {
                                    String energy = snapshot.child("1649972806785").child("product DHAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("SFA")) {
                                    String energy = snapshot.child("1649972806785").child("product SFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Trans Fatty Acids")) {
                                    String energy = snapshot.child("1649972806785").child("product TransfattyAcidsUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Cholesterol")) {
                                    String energy = snapshot.child("1649972806785").child("product CholesterolUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carbohydrate")) {
                                    String energy = snapshot.child("1649972806785").child("product CarbohydrateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fiber")) {
                                    String energy = snapshot.child("1649972806785").child("product FiberUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Dietary fiber")) {
                                    String energy = snapshot.child("1649972806785").child("product DietaryfiberUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("FOS")) {
                                    String energy = snapshot.child("1649972806785").child("product FOSUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Choline")) {
                                    String energy = snapshot.child("1649972806785").child("product CholineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Taurine")) {
                                    String energy = snapshot.child("1649972806785").child("product TaurineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carnitine")) {
                                    String energy = snapshot.child("1649972806785").child("product CarnitineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin A")) {
                                    String energy = snapshot.child("1649972806785").child("product VitaminAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin D3")) {
                                    String energy = snapshot.child("1649972806785").child("product VitaminD3Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin E")) {
                                    String energy = snapshot.child("1649972806785").child("product VitaminEUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin K1")) {
                                    String energy = snapshot.child("1649972806785").child("product VitaminK1Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin C")) {
                                    String energy = snapshot.child("1649972806785").child("product VitaminCUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B1")) {
                                    String energy = snapshot.child("1649972806785").child("product VitaminB1Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B2")) {
                                    String energy = snapshot.child("1649972806785").child("product VitaminB2Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B6")) {
                                    String energy = snapshot.child("1649972806785").child("product VitaminB6Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin B12")) {
                                    String energy = snapshot.child("1649972806785").child("product VitaminB12Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Niacin")) {
                                    String energy = snapshot.child("1649972806785").child("product NiacinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Folic Acid")) {
                                    String energy = snapshot.child("1649972806785").child("product FolicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Biotin")) {
                                    String energy = snapshot.child("1649972806785").child("product BiotinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Pantothenic Acid")) {
                                    String energy = snapshot.child("1649972806785").child("product PantothenicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Sodium")) {
                                    String energy = snapshot.child("1649972806785").child("product SodiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Potassium")) {
                                    String energy = snapshot.child("1649972806785").child("product PotassiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Chloride")) {
                                    String energy = snapshot.child("1649972806785").child("product ChlorideUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Calcium")) {
                                    String energy = snapshot.child("1649972806785").child("product CalciumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Phosphorus")) {
                                    String energy = snapshot.child("1649972806785").child("product PhosphorusUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Magnesium")) {
                                    String energy = snapshot.child("1649972806785").child("product MagnesiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iron")) {
                                    String energy = snapshot.child("1649972806785").child("product IronUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Zinc")) {
                                    String energy = snapshot.child("1649972806785").child("product ZincUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Manganese")) {
                                    String energy = snapshot.child("1649972806785").child("product ManganeseUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Copper")) {
                                    String energy = snapshot.child("1649972806785").child("product CopperUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iodine")) {
                                    String energy = snapshot.child("1649972806785").child("product IodineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Selenium")) {
                                    String energy = snapshot.child("1649972806785").child("product SeleniumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Chromium")) {
                                    String energy = snapshot.child("1649972806785").child("product ChromiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Molybdenum")) {
                                    String energy = snapshot.child("1649972806785").child("product MolybdenumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////Carborie
                            if (productName.equals("Carborie")) {
                                String amount = snapshot.child("1649972859145").child("product AmountType").getValue(String.class);
                                amountView.setText(productName + " in 1 " + amount + " . ");

                                //Energy
                                if (nutrientList.equals("Energy")) {
                                    String energy = snapshot.child("1649972859145").child("product EnergyUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Protein")) {
                                    String energy = snapshot.child("1649972859145").child("product ProteinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fat")) {
                                    String energy = snapshot.child("1649972859145").child("product FatUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carbohydrate")) {
                                    String energy = snapshot.child("1649972859145").child("product CarbohydrateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Sodium")) {
                                    String energy = snapshot.child("1649972859145").child("product SodiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Potassium")) {
                                    String energy = snapshot.child("1649972859145").child("product PotassiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Chloride")) {
                                    String energy = snapshot.child("1649972859145").child("product ChlorideUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Calcium")) {
                                    String energy = snapshot.child("1649972859145").child("product CalciumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Phosphorus")) {
                                    String energy = snapshot.child("1649972859145").child("product PhosphorusUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iron")) {
                                    String energy = snapshot.child("1649972859145").child("product IronUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////Ceprolac
                            if (productName.equals("Ceprolac")) {
                                String amount = snapshot.child("1649972919466").child("product AmountType").getValue(String.class);
                                amountView.setText(productName + " in 1 " + amount + " . ");

                                //Energy
                                if (nutrientList.equals("Energy")) {
                                    String energy = snapshot.child("1649972919466").child("product EnergyUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Protein")) {
                                    String energy = snapshot.child("1649972919466").child("product ProteinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fat")) {
                                    String energy = snapshot.child("1649972919466").child("product FatUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carbohydrate")) {
                                    String energy = snapshot.child("1649972919466").child("product CarbohydrateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Lactose")) {
                                    String energy = snapshot.child("1649972919466").child("product LactoseUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Essential Amino Acid")) {
                                    String energy = snapshot.child("1649972919466").child("product EssentialAminoAcidsUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Branched Amino Acid")) {
                                    String energy = snapshot.child("1649972919466").child("product BranchedChainAminoAcidsUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("α-Lactalbumin")) {
                                    String energy = snapshot.child("1649972919466").child("product α-LactalbuminUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("β-Lactoglobulin")) {
                                    String energy = snapshot.child("1649972919466").child("product β-LactoglobulinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Glycomacropeptide")) {
                                    String energy = snapshot.child("1649972919466").child("product GlycomacropeptideUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Immunoglobulin G (IgG)")) {
                                    String energy = snapshot.child("1649972919466").child("product ImmunoglobulinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Bovine Serum Albumin")) {
                                    String energy = snapshot.child("1649972919466").child("product BovineSerumAlbuminUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Protease Peptone 5")) {
                                    String energy = snapshot.child("1649972919466").child("product ProteasePeptone5Unit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Sodium")) {
                                    String energy = snapshot.child("1649972919466").child("product SodiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Potassium")) {
                                    String energy = snapshot.child("1649972919466").child("product PotassiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Calcium")) {
                                    String energy = snapshot.child("1649972919466").child("product CalciumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Phosphorus")) {
                                    String energy = snapshot.child("1649972919466").child("product PhosphorusUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Magnesium")) {
                                    String energy = snapshot.child("1649972919466").child("product MagnesiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Isoleucine")) {
                                    String energy = snapshot.child("1649972919466").child("product IsoleucineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Leucine")) {
                                    String energy = snapshot.child("1649972919466").child("product LeucineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Lysine")) {
                                    String energy = snapshot.child("1649972919466").child("product LysineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Methionine")) {
                                    String energy = snapshot.child("1649972919466").child("product MethionineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Phenylalanine")) {
                                    String energy = snapshot.child("1649972919466").child("product PhenylalanineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Threonine")) {
                                    String energy = snapshot.child("1649972919466").child("product ThreonineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Tryptophan")) {
                                    String energy = snapshot.child("1649972919466").child("product TryptophanUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Valine")) {
                                    String energy = snapshot.child("1649972919466").child("product ValineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Histidine")) {
                                    String energy = snapshot.child("1649972919466").child("product HistidineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Alanine")) {
                                    String energy = snapshot.child("1649972919466").child("product AlanineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Arginine")) {
                                    String energy = snapshot.child("1649972919466").child("product ArginineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Aspartic Acid")) {
                                    String energy = snapshot.child("1649972919466").child("product AsparticAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Cysteine")) {
                                    String energy = snapshot.child("1649972919466").child("product CysteineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Glutamic Acid")) {
                                    String energy = snapshot.child("1649972919466").child("product GlutamicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Glycine")) {
                                    String energy = snapshot.child("1649972919466").child("product GlycineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Proline")) {
                                    String energy = snapshot.child("1649972919466").child("product ProlineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Serine")) {
                                    String energy = snapshot.child("1649972919466").child("product SerineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Tyrosine")) {
                                    String energy = snapshot.child("1649972919466").child("product TyrosineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////Protegen
                            if (productName.equals("Protegen")) {
                                String amount = snapshot.child("1649972962901").child("product AmountType").getValue(String.class);
                                amountView.setText(productName + " in 1 " + amount + " . ");

                                //Energy
                                if (nutrientList.equals("Energy")) {
                                    String energy = snapshot.child("1649972962901").child("product EnergyUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Protein")) {
                                    String energy = snapshot.child("1649972962901").child("product ProteinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fat")) {
                                    String energy = snapshot.child("1649972962901").child("product FatUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carbohydrate")) {
                                    String energy = snapshot.child("1649972962901").child("product CarbohydrateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Sodium")) {
                                    String energy = snapshot.child("1649972962901").child("product SodiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Potassium")) {
                                    String energy = snapshot.child("1649972962901").child("product PotassiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Chloride")) {
                                    String energy = snapshot.child("1649972962901").child("product ChlorideUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Calcium")) {
                                    String energy = snapshot.child("1649972962901").child("product CalciumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Phosphorus")) {
                                    String energy = snapshot.child("1649972962901").child("product PhosphorusUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Isoleucine")) {
                                    String energy = snapshot.child("1649972962901").child("product IsoleucineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Leucine")) {
                                    String energy = snapshot.child("1649972962901").child("product LeucineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Lysine")) {
                                    String energy = snapshot.child("1649972962901").child("product LysineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Methionine")) {
                                    String energy = snapshot.child("1649972962901").child("product MethionineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Phenylalanine")) {
                                    String energy = snapshot.child("1649972962901").child("product PhenylalanineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Threonine")) {
                                    String energy = snapshot.child("1649972962901").child("product ThreonineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Valine")) {
                                    String energy = snapshot.child("1649972962901").child("product ValineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Histidine")) {
                                    String energy = snapshot.child("1649972962901").child("product HistidineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Alanine")) {
                                    String energy = snapshot.child("1649972962901").child("product AlanineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Arginine")) {
                                    String energy = snapshot.child("1649972962901").child("product ArginineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Aspartic Acid")) {
                                    String energy = snapshot.child("1649972962901").child("product AsparticAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Glutamic Acid")) {
                                    String energy = snapshot.child("1649972962901").child("product GlutamicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Glycine")) {
                                    String energy = snapshot.child("1649972962901").child("product GlycineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Proline")) {
                                    String energy = snapshot.child("1649972962901").child("product ProlineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Serine")) {
                                    String energy = snapshot.child("1649972962901").child("product SerineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Tyrosine")) {
                                    String energy = snapshot.child("1649972962901").child("product TyrosineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Hydroxy-Lysine")) {
                                    String energy = snapshot.child("1649972962901").child("product HydroxyLysineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Hydroxy-Proline")) {
                                    String energy = snapshot.child("1649972962901").child("product HydroxyProlineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////Techno Nutri
                            if (productName.equals("Techno Nutri")) {
                                String amount = snapshot.child("1649973045700").child("product AmountType").getValue(String.class);
                                amountView.setText(productName + " in 1 " + amount + " . ");

                                //Energy
                                if (nutrientList.equals("Energy")) {
                                    String energy = snapshot.child("1649973045700").child("product EnergyUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Protein")) {
                                    String energy = snapshot.child("1649973045700").child("product ProteinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fat")) {
                                    String energy = snapshot.child("1649973045700").child("product FatUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carbohydrate")) {
                                    String energy = snapshot.child("1649973045700").child("product CarbohydrateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin C")) {
                                    String energy = snapshot.child("1649973045700").child("product VitaminCUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Vitamin A")) {
                                    String energy = snapshot.child("1649973045700").child("product VitaminAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Sodium")) {
                                    String energy = snapshot.child("1649973045700").child("product SodiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Calcium")) {
                                    String energy = snapshot.child("1649973045700").child("product CalciumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Iron")) {
                                    String energy = snapshot.child("1649973045700").child("product IronUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Isoleucine")) {
                                    String energy = snapshot.child("1649973045700").child("product IsoleucineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Leucine")) {
                                    String energy = snapshot.child("1649973045700").child("product LeucineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Lysine")) {
                                    String energy = snapshot.child("1649973045700").child("product LysineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Methionine")) {
                                    String energy = snapshot.child("1649973045700").child("product MethionineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Phenylalanine")) {
                                    String energy = snapshot.child("1649973045700").child("product PhenylalanineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Threonine")) {
                                    String energy = snapshot.child("1649973045700").child("product ThreonineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Tryptophan")) {
                                    String energy = snapshot.child("1649973045700").child("product TryptophanUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Valine")) {
                                    String energy = snapshot.child("1649973045700").child("product ValineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Histidine")) {
                                    String energy = snapshot.child("1649973045700").child("product HistidineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Alanine")) {
                                    String energy = snapshot.child("1649973045700").child("product AlanineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Arginine")) {
                                    String energy = snapshot.child("1649973045700").child("product ArginineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Aspartic Acid")) {
                                    String energy = snapshot.child("1649973045700").child("product AsparticAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Cysteine")) {
                                    String energy = snapshot.child("1649973045700").child("product CysteineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Glutamic Acid")) {
                                    String energy = snapshot.child("1649973045700").child("product GlutamicAcidUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Glycine")) {
                                    String energy = snapshot.child("1649973045700").child("product GlycineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Proline")) {
                                    String energy = snapshot.child("1649973045700").child("product ProlineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Serine")) {
                                    String energy = snapshot.child("1649973045700").child("product SerineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Tyrosine")) {
                                    String energy = snapshot.child("1649973045700").child("product TyrosineUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }

                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////MCT Oil (Ezical)
                            if (productName.equals("MCT Oil (Ezical)")) {
                                String amount = snapshot.child("1649973116976").child("product AmountType").getValue(String.class);
                                amountView.setText(productName + " in 1 " + amount + " . ");

                                //Energy
                                if (nutrientList.equals("Energy")) {
                                    String energy = snapshot.child("1649973116976").child("product EnergyUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Protein")) {
                                    String energy = snapshot.child("1649973116976").child("product ProteinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fat")) {
                                    String energy = snapshot.child("1649973116976").child("product FatUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("MUFA")) {
                                    String energy = snapshot.child("1649973116976").child("product MUFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("PUFA")) {
                                    String energy = snapshot.child("1649973116976").child("product PUFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("SFA")) {
                                    String energy = snapshot.child("1649973116976").child("product SFAUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Trans Fatty Acids")) {
                                    String energy = snapshot.child("1649973116976").child("product TransfattyAcidsUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Cholesterol")) {
                                    String energy = snapshot.child("1649973116976").child("product CholesterolUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carbohydrate")) {
                                    String energy = snapshot.child("1649973116976").child("product CarbohydrateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                            }
                            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////Gucil
                            if (productName.equals("Gucil")) {
                                String amount = snapshot.child("1649973173366").child("product AmountType").getValue(String.class);
                                amountView.setText(productName + " in 1 " + amount + " . ");

                                if (nutrientList.equals("Energy")) {
                                    String energy = snapshot.child("1649973173366").child("product EnergyUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Protein")) {
                                    String energy = snapshot.child("1649973173366").child("product ProteinUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Fat")) {
                                    String energy = snapshot.child("1649973173366").child("product FatUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Carbohydrate")) {
                                    String energy = snapshot.child("1649973173366").child("product CarbohydrateUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Total sugar")) {
                                    String energy = snapshot.child("1649973173366").child("product TotalsugarUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Dietary fiber")) {
                                    String energy = snapshot.child("1649973173366").child("product DietaryfiberUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Sodium")) {
                                    String energy = snapshot.child("1649973173366").child("product SodiumUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }
                                if (nutrientList.equals("Soluble fiber")) {
                                    String energy = snapshot.child("1649973173366").child("product SolubleFiberUnit").getValue(String.class);
                                    resultView.setText(nutrientList + " of " + productName + " is " + energy + " . ");
                                }

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {

                        }
                    });
                }
            });


            dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            //4. create builder and display
            AlertDialog alert = dialog.create();
            alert.show();
//      atau ditulis spt -  mydialog.show();

    }

//    private void displayDialog() {
//        //1. create dialog builder
//        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
//
//        //2. set the properties of dialog builder
//        dialog.setTitle("Quick Search");
//        LayoutInflater inflater = LayoutInflater.from(getActivity());
//        View reg_layout = inflater.inflate(R.layout.quick_search,null);
//
//        Spinner product = reg_layout.findViewById(R.id.product);
//        Spinner search = reg_layout.findViewById(R.id.search);
//        Button btn_result = reg_layout.findViewById(R.id.btn_result);
//        dialog.setView(reg_layout);
//        ArrayList<String> productList = new ArrayList<>();
//        ArrayList<String> nutrientList = new ArrayList<>();
//
//        //*****************************************
//        RecyclerView recyclerView;
//        AdapterSearch adapterSearch;
//        List<ModelProduct> searchList;
//
//        recyclerView = reg_layout.findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        searchList = new ArrayList<>();
//        adapterSearch = new AdapterSearch(getActivity(),searchList);
//        recyclerView.setAdapter(adapterSearch);
//        //*****************************************
//
//        DatabaseReference Product = FirebaseDatabase.getInstance().getReference();
//        Product.child("Products").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                productList.clear();
//                for(DataSnapshot item : snapshot.getChildren()){
//                    productList.add(item.child("productName").getValue(String.class));
//                }
//                ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,productList);
//                product.setAdapter(arrayAdapter1);
//            }
//            @Override
//            public void onCancelled(DatabaseError error) {
//
//            }
//        });
//
//        String[] nutrientMCT ={"Energy", "Protein", "Fat", "MUFA", "PUFA", "SFA", "Trans Fatty Acids", "Cholesterol", "Carbohydrate"};
//        ArrayAdapter<String> AdapterMCT = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientMCT);
//
//        product.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                //we will get list nutrient from productName
////                DatabaseReference Search = FirebaseDatabase.getInstance().getReference("Products");
////                Search.addValueEventListener(new ValueEventListener() {
////                    @Override
////                    public void onDataChange(@NonNull DataSnapshot snapshot) {
////                        nutrientList.clear();
////                        for(DataSnapshot item : snapshot.getChildren()){
////                            ModelProduct modelProduct = item.getValue(ModelProduct.class);
////                            nutrientList.add(item.child("productName").getValue(String.class));
////                        }
////                        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(getActivity(),R.layout.style_spinner,nutrientList);
////                        search.setAdapter(arrayAdapter2);
////                    }
////
////                    @Override
////                    public void onCancelled(@NonNull DatabaseError error) {
////
////                    }
////                });
//
//                search.setAdapter(AdapterMCT);
//
//                btn_result.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        //we will get type of amount of product from productName
//                        Query Product = FirebaseDatabase.getInstance().getReference("Products");
//                        Product.orderByChild("productName").equalTo(productList.get(position)).addListenerForSingleValueEvent(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                searchList.clear();
//                                if(snapshot.exists()){
//                                    for(DataSnapshot item : snapshot.getChildren()){
//                                        ModelProduct modelProduct = item.getValue(ModelProduct.class);
//                                        searchList.add(modelProduct);
//                                    }
//                                    adapterSearch.notifyDataSetChanged();
//                                }
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError error) {
//
//                            }
//                        });
//
//                    }
//                });
//
//
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//
//        dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//            }
//        });
//
//        //4. create builder and display
//        AlertDialog alert = dialog.create();
//        alert.show();
////      atau ditulis spt -  mydialog.show();
//    };




    private void makeMeOffline() {

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        //after log in, make user online
        progressDialog.setMessage("Logging Out User ...");

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("online", "false");

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users Info");
        databaseReference.child(firebaseAuth.getUid()).updateChildren(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        firebaseAuth.signOut();
                        Intent i = new Intent(getActivity(), LoginActivity.class);
                        startActivity(i);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //update fail
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}