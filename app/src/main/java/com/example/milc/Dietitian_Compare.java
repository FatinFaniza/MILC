package com.example.milc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Dietitian_Compare extends AppCompatActivity {

    ImageView back;
    TextView value,valueNutrient;
    int count = 1;
    int countNutrient = 1;
    Button decrement,increment,decrementNutrient,incrementNutrient;
//    Button buttonAdd,buttonAdd2;
//    EditText et,et2;
//    TextView tv;
    DecimalFormat decimalpoint = new DecimalFormat("####.##");

    LinearLayout spinnerA,spinnerB,spinnerC,spinner1,spinner2,spinner3,result1,result2;
    Spinner product1A,product2A,product2B,product3A,product3B,product3C;
    Spinner nutrient1A,nutrient2A,nutrient2B,nutrient3A,nutrient3B,nutrient3C;

//    Spinner nutrient1a,nutrient2a,nutrient2b,nutrient3a,nutrient3b,nutrient3c;
//
    Button btn_resultcompare;
    EditText compareRef;
//    TextView pAnA,pAnB,pBnA,pBnB,compareInKcal;
    TextView p1n1,p1n2,p1n3,p2n1,p2n2,p2n3,p3n1,p3n2,p3n3, compareInKcal;
    TextView resultNutrient1, resultNutrient2, resultNutrient3;
    TextView resultProduct1, resultProduct2, resultProduct3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietitian_compare);

        back = findViewById(R.id.back);
        value  = findViewById(R.id.value);
        valueNutrient  = findViewById(R.id.valueNutrient);
        increment  = findViewById(R.id.increment);
        decrement  = findViewById(R.id.decrement);
        decrementNutrient  = findViewById(R.id.decrementNutrient);;
        incrementNutrient  = findViewById(R.id.incrementNutrient);

        spinnerA = findViewById(R.id.spinnerA);
        spinnerB = findViewById(R.id.spinnerB);
        spinnerC = findViewById(R.id.spinnerC);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
//        result1 = findViewById(R.id.result1);
//        result2 = findViewById(R.id.result2);
//        buttonAdd = findViewById(R.id.button_add);
////        buttonAdd2 = findViewById(R.id.button_addNutrient);
//        et  = findViewById(R.id.edittext);
////        et2  = findViewById(R.id.edittextNutrient);
        product1A = findViewById(R.id.product1A);
        product2A = findViewById(R.id.product2A);
        product2B = findViewById(R.id.product2B);
        product3A = findViewById(R.id.product3A);
        product3B = findViewById(R.id.product3B);
        product3C = findViewById(R.id.product3C);

        nutrient1A = findViewById(R.id.nutrient1A);
        nutrient2A = findViewById(R.id.nutrient2A);
        nutrient2B = findViewById(R.id.nutrient2B);
        nutrient3A = findViewById(R.id.nutrient3A);
        nutrient3B = findViewById(R.id.nutrient3B);
        nutrient3C = findViewById(R.id.nutrient3C);

        compareRef = findViewById(R.id.compareRef);
        btn_resultcompare = findViewById(R.id.btn_resultcompare);

        btn_resultcompare = findViewById(R.id.btn_resultcompare);
        resultProduct1 = findViewById(R.id.resultProduct1);
        resultProduct2 = findViewById(R.id.resultProduct2);
        resultProduct3 = findViewById(R.id.resultProduct3);
        resultNutrient1 = findViewById(R.id.resultNutrient1);
        resultNutrient2 = findViewById(R.id.resultNutrient2);
        resultNutrient3 = findViewById(R.id.resultNutrient3);

        compareInKcal  = findViewById(R.id.compareInKcal);
        p1n1 = findViewById(R.id.p1n1);
        p1n2 = findViewById(R.id.p1n2);
        p1n3 = findViewById(R.id.p1n3);
        p2n1 = findViewById(R.id.p2n1);
        p2n2 = findViewById(R.id.p2n2);
        p2n3 = findViewById(R.id.p2n3);
        p3n1 = findViewById(R.id.p3n1);
        p3n2 = findViewById(R.id.p3n2);
        p3n3 = findViewById(R.id.p3n3);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        ArrayList<String> arrayList = new ArrayList<>();

//        databaseReference.child("Products Info").child("t5aTq32ZMaP33c16tCaOrFvaKyt2").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                arrayList.clear();
//                for(DataSnapshot item : snapshot.getChildren()){
//                    arrayList.add(item.child("product Name").getValue(String.class));
//                }
//                ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(Dietitian_Compare.this,R.layout.style_spinner,arrayList);
//                product1A.setAdapter(arrayAdapter1);
//                product2A.setAdapter(arrayAdapter1);
//                product2B.setAdapter(arrayAdapter1);
//                product3A.setAdapter(arrayAdapter1);
//                product3B.setAdapter(arrayAdapter1);
//                product3C.setAdapter(arrayAdapter1);
//            }
//            @Override
//            public void onCancelled(DatabaseError error) {
//
//            }
//        });

        String[] nutrientEnsure = {"Energy","Protein","Fat","MUFA","PUFA","LinoleicAcid","αlinolenicAcid","SFA","Trans Fatty Acids","Cholesterol","Carbohydrate","FOS","Choline","Taurine","LCarnitine",
                "Vitamin A Palmitate","Vitamin A Bcarotene","VitaminD3","VitaminE","VitaminK1","VitaminC","VitaminB1","VitaminB2","VitaminB6","VitaminB12","Niacin","Folic Acid","Biotin",
                "PantothenicAcid", "Sodium","Potassium","Chloride","Calcium","Phosphorus","Magnesium","Iron","Zinc","Manganese","Copper","Iodine","Selenium","Chromium","Molybdenum","CaHMB","HMB"};

        String[] nutrientCalco = {"Energy", "Protein", "Fat", "MUFA", "PUFA", "LinoleicAcid","αlinolenicAcid","SFA","Trans Fatty Acids", "Cholesterol", "Carbohydrate", "Choline",
                "Vitamin A Palmitate", "VitaminD3", "VitaminE", "VitaminK1", "VitaminC", "VitaminB1", "VitaminB2", "VitaminB6", "VitaminB12", "Niacin", "Folic", "Biotin", "PantothenicAcid",
                "Sodium", "Potassium", "Chloride", "Calcium", "Phosphorus", "Magnesium", "Iron", "Zinc", "Manganese", "Copper", "Iodine", "Selenium", "Chromium", "Molybdenum"};

        String[] nutrientGlucerna = {"Energy", "Protein", "Fat", "MUFA", "PUFA", "LinoleicAcid","αlinolenicAcid","SFA","Trans Fatty Acids", "Cholesterol",
                "Carbohydrate", "Lactose", "Polyols", "Fibre", "FOS", "Choline", "Taurine", "Carnitine",
                "Vitamin A Palmitate", "VitaminD3", "VitaminE", "VitaminK1", "VitaminC", "VitaminB1", "VitaminB2", "VitaminB6", "VitaminB12", "Niacin", "Folic", "Biotin", "PantothenicAcid",
                "Sodium", "Potassium", "Chloride", "Calcium", "Phosphorus", "Magnesium", "Iron", "Zinc", "Manganese", "Copper", "Iodine", "Selenium", "Chromium", "Molybdenum"};

        String[] nutrientDiabetasol ={"Energy", "Protein", "Fat", "Carbohydrate", "Fibre", "Vitamin A Palmitate", "VitaminD3", "VitaminE", "VitaminC", "VitaminB1", "VitaminB2", "VitaminB6", "VitaminB12",
                "Niacin", "Folic", "Biotin", "PantothenicAcid", "Sodium", "Potassium", "Chloride", "Calcium", "Phosphorus", "Magnesium", "Iron", "Zinc", "Iodine"};

        String[] nutrientNeproHP = {"Energy", "Protein", "Fat", "MUFA", "PUFA",  "LinoleicAcid","αlinolenicAcid","SFA","Trans Fatty Acids",
                "Carbohydrate", "Polyols", "Totalsugar", "Fiber", "Dietaryfiber", "FOS", "Choline", "Taurine", "Carnitine",
                "Vitamin A Palmitate", "VitaminD3", "VitaminE", "VitaminK1", "VitaminC", "VitaminB1", "VitaminB2", "VitaminB6", "VitaminB12", "Niacin", "Folic", "Biotin", "PantothenicAcid",
                "Sodium", "Potassium", "Chloride", "Calcium", "Phosphorus", "Magnesium", "Iron", "Zinc", "Manganese", "Copper", "Iodine", "Selenium", "Chromium", "Molybdenum","Water"};

        String[] nutrientPeptamen = {"Energy", "Protein", "Fat", "MUFA", "PUFA", "LinoleicAcid", "αlinolenicAcid", "SFA", "MCToil", "Trans Fatty Acids", "Carbohydrate", "Lactose",
                "Fiber", "Choline", "Taurine", "LCarnitine",
                "VitaminA", "VitaminD", "VitaminE", "VitaminK", "VitaminC", "VitaminB1", "VitaminB2", "VitaminB6", "VitaminB12", "Niacin", "NiacinEquivalent", "Folic", "Biotin", "PantothenicAcid",
                "Sodium", "Potassium", "Chloride", "Calcium", "Phosphorus", "Magnesium", "Iron", "Zinc", "Manganese", "Copper", "Iodine", "Selenium", "Chromium", "Molybdenum", "Salt" };

        String[] nutrientResource ={"Energy", "Protein", "Fat", "Carbohydrate", "Fiber", "Totalsugar", "VitaminA", "VitaminD", "VitaminE", "VitaminK", "VitaminC", "VitaminB1", "VitaminB2", "VitaminB6", "VitaminB12", "Niacin",
                "Folic", "Biotin", "PantothenicAcid","Sodium", "Potassium", "Calcium", "Phosphorus", "Magnesium", "Iodine"};

        String[] nutrientProsure = {"Energy", "Protein", "Fat", "MUFA", "PUFA", "LinoleicAcid", "αlinolenicAcid", "EPA", "DHA", "SFA", "Trans Fatty Acids", "Carbohydrate", "Fiber",
                "Dietaryfiber", "FOS", "Choline", "Taurine", "Carnitine",
                "VitaminA", "Vitamin A Bcarotene", "VitaminD3", "VitaminE", "VitaminK1", "VitaminC", "VitaminB1", "VitaminB2", "VitaminB6", "VitaminB12", "Niacin", "Folic", "Biotin", "PantothenicAcid",
                "Sodium", "Potassium", "Chloride", "Calcium", "Phosphorus", "Magnesium", "Iron", "Zinc", "Manganese", "Copper", "Iodine", "Selenium", "Chromium", "Molybdenum"};

        String[] nutrientCarborie = {"Energy", "Protein", "Fat", "Carbohydrate", "Sodium", "Potassium", "Chloride", "Calcium", "Phosphorus", "Iron"} ;

        String[] nutrientCeprolac ={"Energy", "Protein", "Fat", "Carbohydrate", "Lactose","αLactalbumin","βLactoglobulin","Glycomacropeptide","Immunoglobulin","BovineSerumAlbumin","ProteasePeptone5",
                "Sodium", "Potassium", "Calcium", "Phosphorus", "Magnesium","Isoleucine","Leucin", "Lysine", "Methionine", "Phenylalanine", "Threonine", "Tryptophan", "Valine",
                "Histidine", "Alanine", "Arginine", "Asparticacid", "Cysteine", "Glutamicacid", "Glycine", "Proline", "Serine", "Tyrosine","HydroxyLysine","HydroxyProline"};

        String[] nutrientProtegen = {"Energy", "Protein", "Fat", "Carbohydrate", "Sodium", "Potassium", "Calcium", "Phosphorus", "Chloride",
                "Isoleucine", "Leucin", "Lysine", "Methionine", "Phenylalanine", "Threonine", "Tryptophan", "Valine",
                "Histidine", "Alanine", "Arginine", "Asparticacid", "Cysteine", "Glutamicacid", "Glycine", "Proline", "Serine", "Tyrosine",
                "HydroxyLysine","HydroxyProline"};

        String[] nutrientTechno = {"Energy", "Protein", "Fat", "Carbohydrate", "VitaminA", "VitaminC", "Sodium", "Calcium", "Iron",
                "Isoleucine", "Leucin", "Lysine", "Methionine", "Phenylalanine", "Threonine", "Tryptophan", "Valine",
                "Histidine", "Alanine", "Arginine", "Asparticacid", "Cysteine", "Glutamicacid", "Glycine", "Proline", "Serine", "Tyrosine"};

        String[] nutrientMCT ={"Energy", "Protein", "Fat", "MUFA", "PUFA", "SFA", "Trans Fatty Acids", "Cholesterol", "Carbohydrate"};

        String[] nutrientGucil ={"Energy" ,"Protein" ,"Fat" ,"Carbohydrate" ,"Totalsugar", "Dietaryfiber" ,"Sodium" ,"Solublefiber"};

        final String[] product = {"Ensure Gold","Peptamen","Nepro HP","Techno Nutri","MCT Oil (Ezical)","Carborie"};
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this,R.layout.style_spinner,product);
        product1A.setAdapter(arrayAdapter1);
        product2A.setAdapter(arrayAdapter1);
        product2B.setAdapter(arrayAdapter1);
        product3A.setAdapter(arrayAdapter1);
        product3B.setAdapter(arrayAdapter1);
        product3C.setAdapter(arrayAdapter1);

        String[] nutrient ={"Protein" ,"Fat" ,"Carbohydrate","Potassium","Sodium","Phosphorus"};
        ArrayAdapter<String> adapterNutrient = new ArrayAdapter<>(this,R.layout.style_spinner,nutrient);

//        ArrayAdapter<String> adapterEnsure = new ArrayAdapter<>(this,R.layout.style_spinner,nutrientEnsure);
//        ArrayAdapter<String> adapterCalco = new ArrayAdapter<>(this,R.layout.style_spinner,nutrientCalco);
//        ArrayAdapter<String> adapterGlucerna = new ArrayAdapter<>(this,R.layout.style_spinner,nutrientGlucerna);
//        ArrayAdapter<String> adapterDiabetasol = new ArrayAdapter<>(this,R.layout.style_spinner,nutrientDiabetasol);
//        ArrayAdapter<String> adapterNeproHP = new ArrayAdapter<>(this,R.layout.style_spinner,nutrientNeproHP);
//        ArrayAdapter<String> adapterPeptamen = new ArrayAdapter<>(this,R.layout.style_spinner,nutrientPeptamen);
//        ArrayAdapter<String> adapterResource = new ArrayAdapter<>(this,R.layout.style_spinner,nutrientResource);
//        ArrayAdapter<String> adapterProsure = new ArrayAdapter<>(this,R.layout.style_spinner,nutrientProsure);
//        ArrayAdapter<String> adapterCarborie = new ArrayAdapter<>(this,R.layout.style_spinner,nutrientCarborie);
//        ArrayAdapter<String> adapterCeprolac = new ArrayAdapter<>(this,R.layout.style_spinner,nutrientCeprolac);
//        ArrayAdapter<String> adapterProtegen = new ArrayAdapter<>(this,R.layout.style_spinner,nutrientProtegen);
//        ArrayAdapter<String> adapterTechno = new ArrayAdapter<>(this,R.layout.style_spinner,nutrientTechno);
//        ArrayAdapter<String> adapterMCT = new ArrayAdapter<>(this,R.layout.style_spinner,nutrientMCT);
//        ArrayAdapter<String> adapterGucil = new ArrayAdapter<>(this,R.layout.style_spinner,nutrientGucil);

        nutrient1A.setAdapter(adapterNutrient);
        nutrient2A.setAdapter(adapterNutrient);
        nutrient2B.setAdapter(adapterNutrient);
        nutrient3A.setAdapter(adapterNutrient);
        nutrient3B.setAdapter(adapterNutrient);
        nutrient3C.setAdapter(adapterNutrient);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dietitian_Compare.this, Dietitian_Home.class);
                startActivity(i);
                finish();
            }
        });

        btn_resultcompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //PRODUCT
                String p1 = product1A.getSelectedItem().toString();
                String p2A = product2A.getSelectedItem().toString();
                String p2B = product2B.getSelectedItem().toString();
                String p3A = product3A.getSelectedItem().toString();
                String p3B = product3B.getSelectedItem().toString();
                String p3C = product3C.getSelectedItem().toString();

                //NUTRIENT
                String n1 = nutrient1A.getSelectedItem().toString();
                String n2A = nutrient2A.getSelectedItem().toString();
                String n2B = nutrient2B.getSelectedItem().toString();
                String n3A = nutrient3A.getSelectedItem().toString();
                String n3B = nutrient3B.getSelectedItem().toString();
                String n3C = nutrient3C.getSelectedItem().toString();

                double G = Double.parseDouble(compareRef.getText().toString());
                compareInKcal.setText("Comparison in " + G + " kcal");

                if(TextUtils.isEmpty(compareRef.getText())){
                    compareRef.setError("Value is required.");
                    compareRef.requestFocus();
                    return;
                }

                //count 1 for all products
                databaseReference.child("Products Info").child("t5aTq32ZMaP33c16tCaOrFvaKyt2").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if(count ==1) {
                            //*********************************************************************************************************** PRODUCT 1 NUTRIENT 1**********************
                            if (p1.equals("Ensure Gold")) {
                                String Energy = snapshot.child("1649956682127").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);

                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p1.equals("Nepro HP")) {
                                String Energy = snapshot.child("1649960954263").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p1.equals("Peptamen")) {
                                String Energy = snapshot.child("1649972715423").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p1.equals("Carborie")) {
                                String Energy = snapshot.child("1649972859145").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p1.equals("Techno Nutri")) {
                                String Energy = snapshot.child("1649973045700").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p1.equals("MCT Oil (Ezical)")) {
                                String Energy = snapshot.child("1649973116976").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                });

                //count 2 for all products
                databaseReference.child("Products Info").child("t5aTq32ZMaP33c16tCaOrFvaKyt2").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if(count ==2) {
                            //*********************************************************************************************************** PRODUCT 2a ********************** display p1n1 delete p1n1.setText
                            if (p2A.equals("Ensure Gold")) {
                                String Energy = snapshot.child("1649956682127").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p2A.equals("Nepro HP")) {
                                String Energy = snapshot.child("1649960954263").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p2A.equals("Peptamen")) {
                                String Energy = snapshot.child("1649972715423").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p2A.equals("Carborie")) {
                                String Energy = snapshot.child("1649972859145").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p2A.equals("Techno Nutri")) {
                                String Energy = snapshot.child("1649973045700").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p2A.equals("MCT Oil (Ezical)")) {
                                String Energy = snapshot.child("1649973116976").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }

                            //*********************************************************************************************************** PRODUCT 2b ********************** display p2n1, delete p2n1.setText
                            if (p2B.equals("Ensure Gold")) {
                                String Energy = snapshot.child("1649956682127").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p2B.equals("Nepro HP")) {
                                String Energy = snapshot.child("1649960954263").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p2B.equals("Peptamen")) {
                                String Energy = snapshot.child("1649972715423").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p2B.equals("Carborie")) {
                                String Energy = snapshot.child("1649972859145").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p2B.equals("Techno Nutri")) {
                                String Energy = snapshot.child("1649973045700").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p2B.equals("MCT Oil (Ezical)")) {
                                String Energy = snapshot.child("1649973116976").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                });

                //count 3 for all products
                databaseReference.child("Products Info").child("t5aTq32ZMaP33c16tCaOrFvaKyt2").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if(count ==3) {
                            //*********************************************************************************************************** PRODUCT 2 **********************
                            if (p3A.equals("Ensure Gold")) {
                                String Energy = snapshot.child("1649956682127").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p3A.equals("Nepro HP")) {
                                String Energy = snapshot.child("1649960954263").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p3A.equals("Peptamen")) {
                                String Energy = snapshot.child("1649972715423").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p3A.equals("Carborie")) {
                                String Energy = snapshot.child("1649972859145").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p3A.equals("Techno Nutri")) {
                                String Energy = snapshot.child("1649973045700").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p3A.equals("MCT Oil (Ezical)")) {
                                String Energy = snapshot.child("1649973116976").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {

                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p1n3.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p2n1.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                });

                //count 3 for all products
                databaseReference.child("Products Info").child("t5aTq32ZMaP33c16tCaOrFvaKyt2").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if(count ==3) {
                            //*********************************************************************************************************** PRODUCT 2 **********************
                            if (p3B.equals("Ensure Gold")) {
                                String Energy = snapshot.child("1649956682127").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);

                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p3B.equals("Nepro HP")) {
                                String Energy = snapshot.child("1649960954263").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p3B.equals("Peptamen")) {
                                String Energy = snapshot.child("1649972715423").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p3B.equals("Carborie")) {
                                String Energy = snapshot.child("1649972859145").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p3B.equals("Techno Nutri")) {
                                String Energy = snapshot.child("1649973045700").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                            if (p3B.equals("MCT Oil (Ezical)")) {
                                String Energy = snapshot.child("1649973116976").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p2n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p3n1.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                });

                //count 3 for all products
                databaseReference.child("Products Info").child("t5aTq32ZMaP33c16tCaOrFvaKyt2").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if(count ==3) {

                            //*********************************************************************************************************** PRODUCT 2 **********************
                            if (p3C.equals("Ensure Gold")) {
                                String Energy = snapshot.child("1649956682127").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649956682127").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                }
                            }
                            if (p3C.equals("Nepro HP")) {
                                String Energy = snapshot.child("1649960954263").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n2p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n2p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649960954263").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                }
                            }
                            if (p3C.equals("Peptamen")) {
                                String Energy = snapshot.child("1649972715423").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972715423").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                }
                            }
                            if (p3C.equals("Carborie")) {
                                String Energy = snapshot.child("1649972859145").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649972859145").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                }
                            }
                            if (p3C.equals("Techno Nutri")) {
                                String Energy = snapshot.child("1649973045700").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973045700").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                }
                            }
                            if (p3C.equals("MCT Oil (Ezical)")) {
                                String Energy = snapshot.child("1649973116976").child("product Energy").getValue(String.class);
                                double energy_pA = Double.parseDouble(Energy);
                                if(countNutrient ==1) {
                                    if (n1.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n1.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n1.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    p1n2.setText("");
                                    p1n3.setText("");
                                    p2n2.setText("");
                                    p2n3.setText("");
                                    p3n2.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==2) {
                                    if (n2A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n2B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n2B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n2B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    p1n3.setText("");
                                    p2n3.setText("");
                                    p3n3.setText("");
                                }
                                if(countNutrient ==3) {
                                    if (n3A.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3A.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3A.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n1.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3B.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3B.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3B.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n2.setText(decimalpoint.format(rslt) + " mg");
                                    }

                                    if (n3C.equals("Protein")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Protein").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Fat")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Fat").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Carbohydrate")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Carbohydrate").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " g");
                                    }
                                    if (n3C.equals("Potassium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Potassium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Sodium")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Sodium").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                    if (n3C.equals("Phosphorus")) {
                                        String nutrient1 = snapshot.child("1649973116976").child("product Phosphorus").getValue(String.class);
                                        double n1p1 = Double.parseDouble(nutrient1);
                                        double rslt = ((G/energy_pA) * n1p1);
                                        p3n3.setText(decimalpoint.format(rslt) + " mg");
                                    }
                                }
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                });

                //count 2 for all products
//                databaseReference.child("Products Info").child("t5aTq32ZMaP33c16tCaOrFvaKyt2").addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot snapshot) {
//
//                        if(count ==2) {
//                            //*********************************************************************************************************** PRODUCT 1 NUTRIENT 1**********************
//                            if (p1.equals("Ensure Gold")) {
//                                String Energy = snapshot.child("1649956682127").child("product Energy").getValue(String.class);
//                                double energy_pA = Double.parseDouble(Energy);
//
//                                //Protein
//                                if (n2A.equals("Protein")) {
//                                    String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
//                                    double n1p1 = Double.parseDouble(nutrient1);
//                                    double rslt = ((G/energy_pA) * n1p1);
//                                    p1n1.setText(decimalpoint.format(rslt) + " g");
//                                }
//                                //Fat
//                                if (n2A.equals("Fat")) {
//                                    String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
//                                    double n1p1 = Double.parseDouble(nutrient1);
//                                    double rslt = ((G/energy_pA) * n1p1);
//                                    p1n1.setText(decimalpoint.format(rslt) + " g");
//                                }
//
//                                //Carbohydrate
//                                if (n2A.equals("Carbohydrate")) {
//                                    String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
//                                    double n1p1 = Double.parseDouble(nutrient1);
//                                    double rslt = ((G/energy_pA) * n1p1);
//                                    p1n1.setText(decimalpoint.format(rslt) + " g");
//                                }
//
//                                //Protein
//                                if (n2B.equals("Protein")) {
//                                    String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
//                                    double n1p1 = Double.parseDouble(nutrient1);
//                                    double rslt = ((G/energy_pA) * n1p1);
//                                    p1n2.setText(decimalpoint.format(rslt) + " g");
//                                }
//                                //Fat
//                                if (n2B.equals("Fat")) {
//                                    String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
//                                    double n1p1 = Double.parseDouble(nutrient1);
//                                    double rslt = ((G/energy_pA) * n1p1);
//                                    p1n2.setText(decimalpoint.format(rslt) + " g");
//                                }
//
//                                //Carbohydrate
//                                if (n2B.equals("Carbohydrate")) {
//                                    String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
//                                    double n1p1 = Double.parseDouble(nutrient1);
//                                    double rslt = ((G/energy_pA) * n1p1);
//                                    p1n2.setText(decimalpoint.format(rslt) + " g");
//                                }
//
//                            }
////                            if (p1.equals("Calco")) {
////                                String Energy = snapshot.child("1649957698787").child("product Energy").getValue(String.class);
////                                double energy_pA = Double.parseDouble(Energy);
////                            }
////                            if (p1.equals("Glucerna Vanilla")) {
////                                String Energy = snapshot.child("1649958774561").child("product Energy").getValue(String.class);
////                                double energy_pA = Double.parseDouble(Energy);
////                            }
////                            if (p1.equals("Diabetasol Milk")) {
////                                String Energy = snapshot.child("1649959666026").child("product Energy").getValue(String.class);
////                                double energy_pA = Double.parseDouble(Energy);
////                            }
////                            if (p1.equals("Nepro HP")) {
////                                String Energy = snapshot.child("1649960954263").child("product Energy").getValue(String.class);
////                                double energy_pA = Double.parseDouble(Energy);
////                            }
////                            if (p1.equals("Peptamen")) {
////                                String Energy = snapshot.child("1649972715423").child("product Energy").getValue(String.class);
////                                double energy_pA = Double.parseDouble(Energy);
////                            }
////                            if (p1.equals("Resource")) {
////                                String Energy = snapshot.child("1649972764821").child("product Energy").getValue(String.class);
////                                double energy_pA = Double.parseDouble(Energy);
////                            }
////                            if (p1.equals("Prosure")) {
////                                String Energy = snapshot.child("1649972806785").child("product Energy").getValue(String.class);
////                                double energy_pA = Double.parseDouble(Energy);
////                            }
////                            if (p1.equals("Carborie")) {
////                                String Energy = snapshot.child("1649972859145").child("product Energy").getValue(String.class);
////                                double energy_pA = Double.parseDouble(Energy);
////                            }
////                            if (p1.equals("Ceprolac")) {
////                                String Energy = snapshot.child("1649972919466").child("product Energy").getValue(String.class);
////                                double energy_pA = Double.parseDouble(Energy);
////                            }
////                            if (p1.equals("Protegen")) {
////                                String Energy = snapshot.child("1649972962901").child("product Energy").getValue(String.class);
////                                double energy_pA = Double.parseDouble(Energy);
////                            }
////                            if (p1.equals("Techno Nutri")) {
////                                String Energy = snapshot.child("1649973045700").child("product Energy").getValue(String.class);
////                                double energy_pA = Double.parseDouble(Energy);
////                            }
////                            if (p1.equals("MCT Oil (Ezical)")) {
////                                String Energy = snapshot.child("1649973116976").child("product Energy").getValue(String.class);
////                                double energy_pA = Double.parseDouble(Energy);
////                            }
////                            if (p1.equals("Gucil")) {
////                                String Energy = snapshot.child("1649973173366").child("product Energy").getValue(String.class);
////                                double energy_pA = Double.parseDouble(Energy);
////                            }
//                        }
//
//                    }
//                    @Override
//                    public void onCancelled(DatabaseError error) {
//
//                    }
//                });
//
//                //count 3 for all products
//                databaseReference.child("Products Info").child("t5aTq32ZMaP33c16tCaOrFvaKyt2").addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot snapshot) {
//
//                        if(count ==3) {
//                            if (p1.equals("Ensure Gold")) {
//                                String Energy = snapshot.child("1649956682127").child("product Energy").getValue(String.class);
//                                double energy_pA = Double.parseDouble(Energy);
//
//                            //Protein
//                            if (n3A.equals("Protein")) {
//                                String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
//                                double n1p1 = Double.parseDouble(nutrient1);
//                                double rslt = ((G/energy_pA) * n1p1);
//                                p1n1.setText(decimalpoint.format(rslt) + " g");
//                            }
//                            //Fat
//                            if (n3A.equals("Fat")) {
//                                String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
//                                double n1p1 = Double.parseDouble(nutrient1);
//                                double rslt = ((G/energy_pA) * n1p1);
//                                p1n1.setText(decimalpoint.format(rslt) + " g");
//                            }
//
//                            //Carbohydrate
//                            if (n3A.equals("Carbohydrate")) {
//                                String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
//                                double n1p1 = Double.parseDouble(nutrient1);
//                                double rslt = ((G/energy_pA) * n1p1);
//                                p1n1.setText(decimalpoint.format(rslt) + " g");
//                            }
//                            //Protein
//                            if (n3B.equals("Protein")) {
//                                String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
//                                double n1p1 = Double.parseDouble(nutrient1);
//                                double rslt = ((G/energy_pA) * n1p1);
//                                p1n2.setText(decimalpoint.format(rslt) + " g");
//                            }
//                            //Fat
//                            if (n3B.equals("Fat")) {
//                                String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
//                                double n1p1 = Double.parseDouble(nutrient1);
//                                double rslt = ((G/energy_pA) * n1p1);
//                                p1n2.setText(decimalpoint.format(rslt) + " g");
//                            }
//
//                            //Carbohydrate
//                            if (n3B.equals("Carbohydrate")) {
//                                String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
//                                double n1p1 = Double.parseDouble(nutrient1);
//                                double rslt = ((G/energy_pA) * n1p1);
//                                p1n2.setText(decimalpoint.format(rslt) + " g");
//                            }
//                            //Protein
//                            if (n3C.equals("Protein")) {
//                                String nutrient1 = snapshot.child("1649956682127").child("product Protein").getValue(String.class);
//                                double n1p1 = Double.parseDouble(nutrient1);
//                                double rslt = ((G/energy_pA) * n1p1);
//                                p1n3.setText(decimalpoint.format(rslt) + " g");
//                            }
//                            //Fat
//                            if (n3C.equals("Fat")) {
//                                String nutrient1 = snapshot.child("1649956682127").child("product Fat").getValue(String.class);
//                                double n1p1 = Double.parseDouble(nutrient1);
//                                double rslt = ((G/energy_pA) * n1p1);
//                                p1n3.setText(decimalpoint.format(rslt) + " g");
//                            }
//
//                            //Carbohydrate
//                            if (n3C.equals("Carbohydrate")) {
//                                String nutrient1 = snapshot.child("1649956682127").child("product Carbohydrate").getValue(String.class);
//                                double n1p1 = Double.parseDouble(nutrient1);
//                                double rslt = ((G/energy_pA) * n1p1);
//                                p1n3.setText(decimalpoint.format(rslt) + " g");
//                            }
//                            }
//
//
//                        }
//
//                    }
//                    @Override
//                    public void onCancelled(DatabaseError error) {
//
//                    }
//                });

//                p1n1.setText(decimalpoint.format(G) + " g");
//                p1n2.setText(decimalpoint.format(G) + " g");
//                p1n3.setText(decimalpoint.format(G) + " g");
//                p2n1.setText(decimalpoint.format(G) + " g");
//                p2n2.setText(decimalpoint.format(G) + " g");
//                p2n3.setText(decimalpoint.format(G) + " g");
//                p3n1.setText(decimalpoint.format(G) + " g");
//                p3n2.setText(decimalpoint.format(G) + " g");
//                p3n3.setText(decimalpoint.format(G) + " g");

                if(count ==1){
                    resultProduct1.setText(p1);
                    resultProduct2.setText("");
                    resultProduct3.setText("");
                }
                if(count ==2){
                    resultProduct1.setText(p2A);
                    resultProduct2.setText(p2B);
                    resultProduct3.setText("");
                }
                if(count ==3){
                    resultProduct1.setText(p3A);
                    resultProduct2.setText(p3B);
                    resultProduct3.setText(p3C);
                }

                if(countNutrient ==1){
                    resultNutrient1.setText(n1);
                    resultNutrient2.setText("");
                    resultNutrient3.setText("");
                }
                if(countNutrient ==2){
                    resultNutrient1.setText(n2A);
                    resultNutrient2.setText(n2B);
                    resultNutrient3.setText("");
                }
                if(countNutrient ==3){
                    resultNutrient1.setText(n3A);
                    resultNutrient2.setText(n3B);
                    resultNutrient3.setText(n3C);
                }
            }


        });

    }

    private void CountProduct1() {
    }


    public void increment(View v){
        if(count >=3) count =3;
        else count++;
        value.setText("" + count);

        if(count ==1){
            spinnerA.setVisibility(View.VISIBLE);
            spinnerB.setVisibility(View.GONE);
            spinnerC.setVisibility(View.GONE);
        }
        if(count ==2){
            spinnerA.setVisibility(View.GONE);
            spinnerB.setVisibility(View.VISIBLE);
            spinnerC.setVisibility(View.GONE);

            increment.setVisibility(View.VISIBLE);
            decrement.setVisibility(View.VISIBLE);
        }
        if(count ==3){
            spinnerA.setVisibility(View.GONE);
            spinnerB.setVisibility(View.GONE);
            spinnerC.setVisibility(View.VISIBLE);

            increment.setVisibility(View.GONE);
            decrement.setVisibility(View.VISIBLE);
        }
    }

    public void decrement(View v){
        if(count <=1) count =1;
        else count--;
        value.setText("" + count);

        if(count ==1){
            spinnerA.setVisibility(View.VISIBLE);
            spinnerB.setVisibility(View.GONE);
            spinnerC.setVisibility(View.GONE);

            decrement.setVisibility(View.GONE);
            increment.setVisibility(View.VISIBLE);
        }
        if(count ==2){
            spinnerA.setVisibility(View.GONE);
            spinnerB.setVisibility(View.VISIBLE);
            spinnerC.setVisibility(View.GONE);

            increment.setVisibility(View.VISIBLE);
            decrement.setVisibility(View.VISIBLE);
        }
        if(count ==3){
            spinnerA.setVisibility(View.GONE);
            spinnerB.setVisibility(View.GONE);
            spinnerC.setVisibility(View.VISIBLE);
        }
    }

    public void incrementNutrient(View v){
        if(countNutrient >=3) countNutrient =3;
        else countNutrient++;
        valueNutrient.setText("" + countNutrient);

        if(countNutrient ==1){
            spinner1.setVisibility(View.VISIBLE);
            spinner2.setVisibility(View.GONE);
            spinner3.setVisibility(View.GONE);
        }
        if(countNutrient ==2){
            spinner1.setVisibility(View.GONE);
            spinner2.setVisibility(View.VISIBLE);
            spinner3.setVisibility(View.GONE);

            incrementNutrient.setVisibility(View.VISIBLE);
            decrementNutrient.setVisibility(View.VISIBLE);
        }
        if(countNutrient ==3){
            spinner1.setVisibility(View.GONE);
            spinner2.setVisibility(View.GONE);
            spinner3.setVisibility(View.VISIBLE);

            incrementNutrient.setVisibility(View.GONE);
            decrementNutrient.setVisibility(View.VISIBLE);
        }
    }

    public void decrementNutrient(View v){
        if(countNutrient <=1) countNutrient =1;
        else countNutrient--;
        valueNutrient.setText("" + countNutrient);

        if(countNutrient ==1){
            spinner1.setVisibility(View.VISIBLE);
            spinner2.setVisibility(View.GONE);
            spinner3.setVisibility(View.GONE);

            decrementNutrient.setVisibility(View.GONE);
            incrementNutrient.setVisibility(View.VISIBLE);
        }
        if(countNutrient ==2){
            spinner1.setVisibility(View.GONE);
            spinner2.setVisibility(View.VISIBLE);
            spinner3.setVisibility(View.GONE);

            incrementNutrient.setVisibility(View.VISIBLE);
            decrementNutrient.setVisibility(View.VISIBLE);
        }
        if(countNutrient ==3){
            spinner1.setVisibility(View.GONE);
            spinner2.setVisibility(View.GONE);
            spinner3.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Dietitian_Compare.this, Dietitian_Home.class);
        startActivity(i);
        finish();
    }
}

//        if (p1.equals("Ensure Gold")) {
//         String Amount = snapshot.child("1649956682127").child("product AmountType").getValue(String.class);
//        regimeA.setText(p1  + " = " + " ( " + p1amt  + " " +  Amount + " , " + p1frq  + "x/day) ");
//        }
//        if (p1.equals("Calco")) {
//        String Amount = snapshot.child("1649957698787").child("product AmountType").getValue(String.class);
//        regimeA.setText(p1  + " = " + " ( " + p1amt  + " " +  Amount + " , " + p1frq  + "x/day) ");
//
//        }
//        if (p1.equals("Glucerna Vanilla")) {
//        String Amount = snapshot.child("1649958774561").child("product AmountType").getValue(String.class);
//        regimeA.setText(p1  + " = " + " ( " + p1amt  + " " +  Amount + " , " + p1frq  + "x/day) ");
//
//        }
//        if (p1.equals("Diabetasol Milk")) {
//        String Amount = snapshot.child("1649959666026").child("product AmountType").getValue(String.class);
//        regimeA.setText(p1  + " = " + " ( " + p1amt  + " " +  Amount + " , " + p1frq  + "x/day) ");
//
//        }
//        if (p1.equals("Nepro HP")) {
//        String Amount = snapshot.child("1649960954263").child("product AmountType").getValue(String.class);
//        regimeA.setText(p1  + " = " + " ( " + p1amt  + " " +  Amount + " , " + p1frq  + "x/day) ");
//
//        }
//        if (p1.equals("Peptamen")) {
//        String Amount = snapshot.child("1649972715423").child("product AmountType").getValue(String.class);
//        regimeA.setText(p1  + " = " + " ( " + p1amt  + " " +  Amount + " , " + p1frq  + "x/day) ");
//
//        }
//        if (p1.equals("Resource")) {
//        String Amount = snapshot.child("1649972764821").child("product AmountType").getValue(String.class);
//        regimeA.setText(p1  + " = " + " ( " + p1amt  + " " +  Amount + " , " + p1frq  + "x/day) ");
//
//        }
//        if (p1.equals("Prosure")) {
//        String Amount = snapshot.child("1649972806785").child("product AmountType").getValue(String.class);
//        regimeA.setText(p1  + " = " + " ( " + p1amt  + " " +  Amount + " , " + p1frq  + "x/day) ");
//
//        }
//        if (p1.equals("Carborie")) {
//        String Amount = snapshot.child("1649972859145").child("product AmountType").getValue(String.class);
//        regimeA.setText(p1  + " = " + " ( " + p1amt  + " " +  Amount + " , " + p1frq  + "x/day) ");
//
//        }
//        if (p1.equals("Ceprolac")) {
//        String Amount = snapshot.child("1649972919466").child("product AmountType").getValue(String.class);
//        regimeA.setText(p1  + " = " + " ( " + p1amt  + " " +  Amount + " , " + p1frq  + "x/day) ");
//
//        }
//        if (p1.equals("Protegen")) {
//        String Amount = snapshot.child("1649972962901").child("product AmountType").getValue(String.class);
//        regimeA.setText(p1  + " = " + " ( " + p1amt  + " " +  Amount + " , " + p1frq  + "x/day) ");
//
//        }
//        if (p1.equals("Techno Nutri")) {
//        String Amount = snapshot.child("1649973045700").child("product AmountType").getValue(String.class);
//        regimeA.setText(p1  + " = " + " ( " + p1amt  + " " +  Amount + " , " + p1frq  + "x/day) ");
//
//        }
//        if (p1.equals("MCT Oil (Ezical)")) {
//        String Amount = snapshot.child("1649973116976").child("product AmountType").getValue(String.class);
//        regimeA.setText(p1  + " = " + " ( " + p1amt  + " " +  Amount + " , " + p1frq  + "x/day) ");
//
//        }
//        if (p1.equals("Gucil")) {
//        String Amount = snapshot.child("1649973173366").child("product AmountType").getValue(String.class);
//        regimeA.setText(p1  + " = " + " ( " + p1amt  + " " +  Amount + " , " + p1frq  + "x/day) ");
//        }