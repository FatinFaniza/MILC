package com.example.milc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Dietitian_EnsureGold extends AppCompatActivity {

    ImageView back, imageView;
    TextView productName, companyName, description, indication, ingredient, availability, retailPrice;
    DatabaseReference databaseReference;

    TextView Sodium,Potassium,Chloride,Calcium,Phosphorus,Magnesium,Iron,Zinc,Manganese,Copper,Iodine,Selenium,Chromium,Molybdenum,CaHMB,HMB;
    TextView Energy,Protein,Fat,MUFA,PUFA,Linoleic,LinoAcid,SFA,Trans,Cholesterol,Carbohydrate,FOS,Choline,Taurine,LCarnitine;
    TextView VitaminA1,VitaminA2,VitaminD3,VitaminE,VitaminK1,VitaminC,VitaminB1,VitaminB2,VitaminB6,VitaminB12,Niacin,Folic,Biotin,Pantothenic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietitian_ensure_gold);

        productName = findViewById(R.id.productName);
        companyName = findViewById(R.id.companyName);
        description = findViewById(R.id.description);
        indication = findViewById(R.id.indication);
        ingredient = findViewById(R.id.ingredient);
        availability = findViewById(R.id.availability);
        retailPrice = findViewById(R.id.retailPrice);

        Energy = findViewById(R.id.Energy);
        Protein = findViewById(R.id.Protein);
        Fat = findViewById(R.id.Fat);
        MUFA = findViewById(R.id.MUFA);
        PUFA = findViewById(R.id.PUFA);
        Linoleic = findViewById(R.id.Linoleic);
        LinoAcid = findViewById(R.id.LinoAcid);
        SFA = findViewById(R.id.SFA);
        Trans = findViewById(R.id.Trans);
        Cholesterol = findViewById(R.id.Cholesterol);
        Carbohydrate = findViewById(R.id.Carbohydrate);
        FOS = findViewById(R.id.FOS);
        Choline = findViewById(R.id.Choline);
        Taurine = findViewById(R.id.Taurine);
        LCarnitine = findViewById(R.id.LCarnitine);

        VitaminA1 = findViewById(R.id.VitaminA1);
        VitaminA2 = findViewById(R.id.VitaminA2);
        VitaminD3 = findViewById(R.id.VitaminD3);
        VitaminE = findViewById(R.id.VitaminE);
        VitaminK1 = findViewById(R.id.VitaminK1);
        VitaminC = findViewById(R.id.VitaminC);
        VitaminB1 = findViewById(R.id.VitaminB1);
        VitaminB2 = findViewById(R.id.VitaminB2);
        VitaminB6 = findViewById(R.id.VitaminB6);
        VitaminB12 = findViewById(R.id.VitaminB12);
        Niacin = findViewById(R.id.Niacin);
        Folic = findViewById(R.id.Folic);
        Biotin = findViewById(R.id.Biotin);
        Pantothenic = findViewById(R.id.Pantothenic);

        Sodium = findViewById(R.id.Sodium);
        Potassium = findViewById(R.id.Potassium);
        Chloride = findViewById(R.id.Chloride);
        Calcium = findViewById(R.id.Calcium);
        Phosphorus = findViewById(R.id.Phosphorus);
        Magnesium = findViewById(R.id.Magnesium);
        Iron = findViewById(R.id.Iron);
        Zinc = findViewById(R.id.Zinc);
        Manganese = findViewById(R.id.Manganese);
        Copper = findViewById(R.id.Copper);
        Iodine = findViewById(R.id.Iodine);
        Selenium = findViewById(R.id.Selenium);
        Chromium = findViewById(R.id.Chromium);
        Molybdenum = findViewById(R.id.Molybdenum);

        CaHMB = findViewById(R.id.CaHMB);
        HMB = findViewById(R.id.HMB);


        back = findViewById(R.id.back);
        imageView = findViewById(R.id.imageView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dietitian_EnsureGold.this, Dietitian_AdultFormula.class);
                startActivity(i);
                finish();
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Products Info").child("t5aTq32ZMaP33c16tCaOrFvaKyt2").child("1649956682127");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String image = snapshot.child("product Icon").getValue().toString();
                String name = snapshot.child("product Name").getValue().toString();
                String company = snapshot.child("product Company").getValue().toString();
                String desc = snapshot.child("product Description").getValue().toString();
                String ind = snapshot.child("product Indications").getValue().toString();
                String ing = snapshot.child("product Ingredients").getValue().toString();
                String avail = snapshot.child("product Availability").getValue().toString();
                String retail = snapshot.child("product Retail Price").getValue().toString();

                Picasso.get().load(image).into(imageView);
                productName.setText(name);
                companyName.setText(company);
                description.setText(desc);
                indication.setText(ind);
                ingredient.setText(ing);
                availability.setText(avail);
                retailPrice.setText(retail);

                Energy.setText(snapshot.child("product EnergyUnit").getValue().toString());
                Protein.setText(snapshot.child("product ProteinUnit").getValue().toString());
                Fat.setText(snapshot.child("product FatUnit").getValue().toString());
                MUFA.setText(snapshot.child("product MUFAUnit").getValue().toString());
                PUFA.setText(snapshot.child("product PUFAUnit").getValue().toString());
                Linoleic.setText(snapshot.child("product LinoleicAcidUnit").getValue().toString());
                LinoAcid.setText(snapshot.child("product αlinolenicAcidUnit").getValue().toString());
                SFA.setText(snapshot.child("product SFAUnit").getValue().toString());
                Trans.setText(snapshot.child("product TransfattyAcidsUnit").getValue().toString());
                Cholesterol.setText(snapshot.child("product CholesterolUnit").getValue().toString());
                Carbohydrate.setText(snapshot.child("product CarbohydrateUnit").getValue().toString());

                FOS.setText(snapshot.child("product FOSUnit").getValue().toString());
                Choline.setText(snapshot.child("product CholineUnit").getValue().toString());
                Taurine.setText(snapshot.child("product TaurineUnit").getValue().toString());
                LCarnitine.setText(snapshot.child("product LcarnitineUnit").getValue().toString());
                VitaminA1.setText(snapshot.child("product VitaminAPalmitateUnit").getValue().toString());
                VitaminA2.setText(snapshot.child("product VitaminABcaroteneUnit").getValue().toString());

                VitaminD3.setText(snapshot.child("product VitaminD3Unit").getValue().toString());
                VitaminE.setText(snapshot.child("product VitaminEUnit").getValue().toString());
                VitaminK1.setText(snapshot.child("product VitaminK1Unit").getValue().toString());
                VitaminC.setText(snapshot.child("product VitaminCUnit").getValue().toString());
                VitaminB1 .setText(snapshot.child("product VitaminB1Unit").getValue().toString());
                VitaminB2 .setText(snapshot.child("product VitaminB2Unit").getValue().toString());
                VitaminB6.setText(snapshot.child("product VitaminB6Unit").getValue().toString());
                VitaminB12.setText(snapshot.child("product VitaminB12Unit").getValue().toString());
                Niacin.setText(snapshot.child("product NiacinUnit").getValue().toString());
                Folic.setText(snapshot.child("product FolicAcidUnit").getValue().toString());
                Biotin.setText(snapshot.child("product BiotinUnit").getValue().toString());
                Pantothenic.setText(snapshot.child("product PantothenicAcidUnit").getValue().toString());

                Sodium .setText(snapshot.child("product SodiumUnit").getValue().toString());
                Potassium .setText(snapshot.child("product PotassiumUnit").getValue().toString());
                Chloride .setText(snapshot.child("product ChlorideUnit").getValue().toString());
                Calcium .setText(snapshot.child("product CalciumUnit").getValue().toString());
                Phosphorus .setText(snapshot.child("product PhosphorusUnit").getValue().toString());
                Magnesium .setText(snapshot.child("product MagnesiumUnit").getValue().toString());
                Iron .setText(snapshot.child("product IronUnit").getValue().toString());
                Zinc.setText(snapshot.child("product ZincUnit").getValue().toString());

                Manganese .setText(snapshot.child("product ManganeseUnit").getValue().toString());
                Copper.setText(snapshot.child("product CopperUnit").getValue().toString());
                Iodine .setText(snapshot.child("product IodineUnit").getValue().toString());
                Selenium.setText(snapshot.child("product SeleniumUnit").getValue().toString());
                Chromium .setText(snapshot.child("product ChromiumUnit").getValue().toString());
                Molybdenum .setText(snapshot.child("product MolybdenumUnit").getValue().toString());

                CaHMB.setText(snapshot.child("product caHMBUnit").getValue().toString());
                HMB.setText(snapshot.child("product HMBUnit").getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Dietitian_EnsureGold.this, Dietitian_AdultFormula.class);
        startActivity(i);
        finish();
    }
}
//
//    TextView Sodium,Potassium,Chloride,Calcium,Phosphorus,Magnesium,Iron,Zinc,Manganese,Copper,Iodine,Selenium,Chromium,Molybdenum,CaHMB,HMB,Salt;
//    TextView Energy,Protein,Fat,MUFA,PUFA,Linoleic,LinoAcid,SFA,MCToil,Trans,Cholesterol,Carbohydrate,Lactose,FOS,Choline,Taurine,LCarnitine,Carnitine,Polyols,Totalsugar,Fiber,Dietaryfiber,Water;
//    TextView VitaminA,VitaminA1,VitaminA2,VitaminD3,VitaminE,VitaminK1,VitaminC,VitaminB1,VitaminB2,VitaminB6,VitaminB12,VitaminK,VitaminD,Niacin,Folic,Biotin,Pantothenic;
//    TextView Isoleucine,Leucine,Lysine,Methionine,Phenylalanine,Threonine,Tryptophan,Valine,Histidine,Alanine,Arginine,Asparticacid,Cysteine,Glutamicacid,Glycine,Proline,Serine,Tyrosine;
//


//                Energy.setText(snapshot.child("product Energy").getValue().toString());
//                        Protein.setText(snapshot.child("product Protein").getValue().toString());
//                        Fat.setText(snapshot.child("product Fat").getValue().toString());
//                        MUFA.setText(snapshot.child("product MUFA").getValue().toString());
//                        PUFA.setText(snapshot.child("product PUFA").getValue().toString());
//                        Linoleic.setText(snapshot.child("product LinoleicAcid").getValue().toString());
//                        LinoAcid.setText(snapshot.child("product αlinolenicAcid").getValue().toString());
//                        SFA.setText(snapshot.child("product SFA").getValue().toString());
//                        MCToil.setText(snapshot.child("product MCToil").getValue().toString());
//                        Trans.setText(snapshot.child("product TransfattyAcids").getValue().toString());
//                        Cholesterol.setText(snapshot.child("product Cholesterol").getValue().toString());
//                        Carbohydrate.setText(snapshot.child("product Carbohydrate").getValue().toString());
//                        Lactose.setText(snapshot.child("product Lactose").getValue().toString());
//
//                        Polyols.setText(snapshot.child("product Polyols").getValue().toString());
//                        Totalsugar.setText(snapshot.child("product Totalsugar").getValue().toString());
//                        Fiber.setText(snapshot.child("product Fiber").getValue().toString());
//                        Dietaryfiber.setText(snapshot.child("product Dietaryfiber").getValue().toString());
//                        FOS.setText(snapshot.child("product FOS").getValue().toString());
//                        Choline.setText(snapshot.child("product Choline").getValue().toString());
//                        Taurine.setText(snapshot.child("product Taurine").getValue().toString());
//                        LCarnitine.setText(snapshot.child("product Lcarnitine").getValue().toString());
//                        Carnitine.setText(snapshot.child("product Carnitine").getValue().toString());
//                        VitaminA.setText(snapshot.child("product VitaminA").getValue().toString());
//                        VitaminA1.setText(snapshot.child("product VitaminAPalmitate").getValue().toString());
//                        VitaminA2.setText(snapshot.child("product VitaminABcarotene").getValue().toString());
//
//                        VitaminD.setText(snapshot.child("product VitaminD").getValue().toString());
//                        VitaminD3.setText(snapshot.child("product VitaminD3").getValue().toString());
//                        VitaminE.setText(snapshot.child("product VitaminE").getValue().toString());
//                        VitaminK.setText(snapshot.child("product VitaminK").getValue().toString());
//                        VitaminK1.setText(snapshot.child("product VitaminK1").getValue().toString());
//                        VitaminC.setText(snapshot.child("product VitaminC").getValue().toString());
//                        VitaminB1 .setText(snapshot.child("product VitaminB1").getValue().toString());
//                        VitaminB2 .setText(snapshot.child("product VitaminB2").getValue().toString());
//                        VitaminB6.setText(snapshot.child("product VitaminB6").getValue().toString());
//                        VitaminB12.setText(snapshot.child("product VitaminB12").getValue().toString());
//                        Niacin.setText(snapshot.child("product Niacin").getValue().toString());
//                        Folic.setText(snapshot.child("product FolicAcid").getValue().toString());
//                        Biotin.setText(snapshot.child("product Biotin").getValue().toString());
//                        Pantothenic.setText(snapshot.child("product PantothenicAcid").getValue().toString());
//
//                        Sodium .setText(snapshot.child("product Sodium").getValue().toString());
//                        Potassium .setText(snapshot.child("product Potassium").getValue().toString());
//                        Chloride .setText(snapshot.child("product Chloride").getValue().toString());
//                        Calcium .setText(snapshot.child("product Calcium").getValue().toString());
//                        Phosphorus .setText(snapshot.child("product Phosphorus").getValue().toString());
//                        Magnesium .setText(snapshot.child("product Magnesium").getValue().toString());
//                        Iron .setText(snapshot.child("product Iron").getValue().toString());
//                        Zinc.setText(snapshot.child("product Zinc").getValue().toString());
//
//
//                        Manganese .setText(snapshot.child("product Manganese").getValue().toString());
//                        Copper.setText(snapshot.child("product Copper").getValue().toString());
//                        Iodine .setText(snapshot.child("product Iodine").getValue().toString());
//                        Selenium.setText(snapshot.child("product Selenium").getValue().toString());
//                        Chromium .setText(snapshot.child("product Chromium").getValue().toString());
//                        Molybdenum .setText(snapshot.child("product Molybdenum").getValue().toString());
//                        Water.setText(snapshot.child("product Water").getValue().toString());
//                        Salt.setText(snapshot.child("product Salt").getValue().toString());
//
//                        Isoleucine.setText(snapshot.child("product Isoleucine").getValue().toString());
//                        Leucine.setText(snapshot.child("product Leucine").getValue().toString());
//                        Lysine.setText(snapshot.child("product Lysine").getValue().toString());
//                        Methionine.setText(snapshot.child("product Methionine").getValue().toString());
//                        Phenylalanine.setText(snapshot.child("product Phenylalanine").getValue().toString());
//                        Threonine.setText(snapshot.child("product Threonine").getValue().toString());
//                        Tryptophan.setText(snapshot.child("product Tryptophan").getValue().toString());
//                        Valine.setText(snapshot.child("product Valine").getValue().toString());
//                        Histidine.setText(snapshot.child("product Histidine").getValue().toString());
//                        Alanine.setText(snapshot.child("product Alanine").getValue().toString());
//                        Arginine.setText(snapshot.child("product Arginine").getValue().toString());
//                        Asparticacid.setText(snapshot.child("product AsparticAcid").getValue().toString());
//                        Cysteine.setText(snapshot.child("product Cysteine").getValue().toString());
//                        Glutamicacid.setText(snapshot.child("product GlutamicAcid").getValue().toString());
//                        Glycine.setText(snapshot.child("product Glycine").getValue().toString());
//                        Proline.setText(snapshot.child("product Proline").getValue().toString());
//                        Serine.setText(snapshot.child("product Serine").getValue().toString());
//                        Tyrosine.setText(snapshot.child("product Tyrosine").getValue().toString());
//                        CaHMB.setText(snapshot.child("product caHMB").getValue().toString());
//                        HMB.setText(snapshot.child("product HMB").getValue().toString());

//
//    String[] nutrientCeprolac ={"Energy", "Protein", "Fat", "Carbohydrate", "Lactose","Essential Amino Acid","Branched Amino Acid","α-Lactalbumin","β-Lactoglobulin","Glycomacropeptide","Immunoglobulin G (IgG)","Bovine Serum Albumin","Protease Peptone 5",
//            "Sodium", "Potassium", "Calcium", "Phosphorus", "Magnesium","Isoleucine","Leucine", "Lysine", "Methionine", "Phenylalanine", "Threonine", "Tryptophan", "Valine",
//            "Histidine", "Alanine", "Arginine", "Asparticacid", "Cysteine", "Glutamic Acid", "Glycine", "Proline", "Serine", "Tyrosine"};
//
//    String[] nutrientProtegen = {"Energy", "Protein", "Fat", "Carbohydrate", "Sodium", "Potassium", "Calcium", "Phosphorus", "Chloride",
//            "Isoleucine", "Leucine", "Lysine", "Methionine", "Phenylalanine", "Threonine", "Valine",
//            "Histidine", "Alanine", "Arginine", "Aspartic Acid", "Glutamic Acid", "Glycine", "Proline", "Serine", "Tyrosine",
//            "Hydroxy-Lysine","Hydroxy-Proline"};
//
//    String[] nutrientTechno = {"Energy", "Protein", "Fat", "Carbohydrate", "Vitamin A", "Vitamin C", "Sodium", "Calcium", "Iron",
//            "Isoleucine", "Leucine", "Lysine", "Methionine", "Phenylalanine", "Threonine", "Tryptophan", "Valine",
//            "Histidine", "Alanine", "Arginine", "Aspartic Acid", "Cysteine", "Glutamic Acid", "Glycine", "Proline", "Serine", "Tyrosine"};
