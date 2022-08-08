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

public class Dietitian_Techno extends AppCompatActivity {

    ImageView back, imageView;
    TextView productName, companyName, description, indication, ingredient, availability, retailPrice;
    DatabaseReference databaseReference;

    TextView Sodium,Calcium,Iron;
    TextView Energy,Protein,Fat,Carbohydrate;
    TextView VitaminA,VitaminC;
    TextView Isoleucine,Leucine,Lysine,Methionine,Phenylalanine,Threonine,Tryptophan,Valine,Histidine,Alanine,Arginine,Asparticacid,Cysteine,Glutamicacid,Glycine,Proline,Serine,Tyrosine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietitian_techno);

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

        VitaminA = findViewById(R.id.VitaminA);
        VitaminC = findViewById(R.id.VitaminC);
        Sodium = findViewById(R.id.Sodium);
        Calcium = findViewById(R.id.Calcium);
        Iron = findViewById(R.id.Iron);

        Isoleucine = findViewById(R.id.Isoleucine);
        Leucine = findViewById(R.id.Leucine);
        Lysine = findViewById(R.id.Lysine);
        Methionine = findViewById(R.id.Methionine);
        Phenylalanine = findViewById(R.id.Phenylalanine);
        Threonine = findViewById(R.id.Threonine);
        Tryptophan = findViewById(R.id.Tryptophan);
        Valine = findViewById(R.id.Valine);
        Histidine = findViewById(R.id.Histidine);
        Alanine = findViewById(R.id.Alanine);
        Arginine = findViewById(R.id.Arginine);
        Asparticacid = findViewById(R.id.Asparticacid);
        Cysteine = findViewById(R.id.Cysteine);
        Glutamicacid = findViewById(R.id.Glutamicacid);
        Glycine = findViewById(R.id.Glycine);
        Proline = findViewById(R.id.Proline);
        Serine = findViewById(R.id.Serine);
        Tyrosine = findViewById(R.id.Tyrosine);


        back = findViewById(R.id.back);
        imageView = findViewById(R.id.imageView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dietitian_Techno.this, Dietitian_Modular.class);
                startActivity(i);
                finish();
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Products Info").child("t5aTq32ZMaP33c16tCaOrFvaKyt2").child("1649973045700");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String image = snapshot.child("product Icon").getValue().toString();
                String name = snapshot.child("product NameFull").getValue().toString();
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

                VitaminA.setText(snapshot.child("product VitaminAUnit").getValue().toString());
                VitaminC.setText(snapshot.child("product VitaminCUnit").getValue().toString());

                Sodium .setText(snapshot.child("product SodiumUnit").getValue().toString());
                Calcium .setText(snapshot.child("product CalciumUnit").getValue().toString());
                Iron .setText(snapshot.child("product IronUnit").getValue().toString());

                Isoleucine.setText(snapshot.child("product IsoleucineUnit").getValue().toString());
                Leucine.setText(snapshot.child("product LeucineUnit").getValue().toString());
                Lysine.setText(snapshot.child("product LysineUnit").getValue().toString());
                Methionine.setText(snapshot.child("product MethionineUnit").getValue().toString());
                Phenylalanine.setText(snapshot.child("product PhenylalanineUnit").getValue().toString());
                Threonine.setText(snapshot.child("product ThreonineUnit").getValue().toString());
                Tryptophan.setText(snapshot.child("product TryptophanUnit").getValue().toString());
                Valine.setText(snapshot.child("product ValineUnit").getValue().toString());
                Histidine.setText(snapshot.child("product HistidineUnit").getValue().toString());
                Alanine.setText(snapshot.child("product AlanineUnit").getValue().toString());
                Arginine.setText(snapshot.child("product ArginineUnit").getValue().toString());
                Asparticacid.setText(snapshot.child("product AsparticAcidUnit").getValue().toString());
                Cysteine.setText(snapshot.child("product CysteineUnit").getValue().toString());
                Glutamicacid.setText(snapshot.child("product GlutamicAcidUnit").getValue().toString());
                Glycine.setText(snapshot.child("product GlycineUnit").getValue().toString());
                Proline.setText(snapshot.child("product ProlineUnit").getValue().toString());
                Serine.setText(snapshot.child("product SerineUnit").getValue().toString());
                Tyrosine.setText(snapshot.child("product TyrosineUnit").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Dietitian_Techno.this, Dietitian_Modular.class);
        startActivity(i);
        finish();
    }
}