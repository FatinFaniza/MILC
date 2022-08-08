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

public class Dietitian_Diabetasol extends AppCompatActivity {

    ImageView back, imageView;
    TextView productName, companyName, description, indication, ingredient, availability, retailPrice;
    DatabaseReference databaseReference;

    TextView Sodium,Potassium,Chloride,Calcium,Phosphorus,Magnesium,Iron,Zinc,Iodine;
    TextView VitaminA,VitaminD3,VitaminE,VitaminC,VitaminB1,VitaminB2,VitaminB6,VitaminB12,Niacin,Folic,Biotin,Pantothenic;
    TextView Energy,Protein,Fat,Carbohydrate,Fibre,Inulin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietitian_diabetasol);

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
        Carbohydrate = findViewById(R.id.Carbohydrate);
        Fibre = findViewById(R.id.Fiber);
        Inulin = findViewById(R.id.Inulin);

        VitaminA = findViewById(R.id.VitaminA);
        VitaminD3 = findViewById(R.id.VitaminD3);
        VitaminE = findViewById(R.id.VitaminE);
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
        Iodine = findViewById(R.id.Iodine);

        back = findViewById(R.id.back);
        imageView = findViewById(R.id.imageView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dietitian_Diabetasol.this, Dietitian_AdultFormula.class);
                startActivity(i);
                finish();
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Products Info").child("t5aTq32ZMaP33c16tCaOrFvaKyt2").child("1649959666026");
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
                Carbohydrate.setText(snapshot.child("product CarbohydrateUnit").getValue().toString());
                Fibre.setText(snapshot.child("product FiberUnit").getValue().toString());
                Inulin.setText(snapshot.child("product InulinUnit").getValue().toString());

                VitaminA.setText(snapshot.child("product VitaminAUnit").getValue().toString());
                VitaminD3.setText(snapshot.child("product VitaminD3Unit").getValue().toString());
                VitaminE.setText(snapshot.child("product VitaminEUnit").getValue().toString());
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
                Iodine .setText(snapshot.child("product IodineUnit").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(Dietitian_Diabetasol.this, Dietitian_AdultFormula.class);
        startActivity(i);
        finish();
    }

}