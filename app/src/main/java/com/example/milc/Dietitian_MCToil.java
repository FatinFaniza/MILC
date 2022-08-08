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

public class Dietitian_MCToil extends AppCompatActivity {

    ImageView back, imageView;
    TextView productName, companyName, description, indication, ingredient, availability, retailPrice;
    DatabaseReference databaseReference;

    TextView Energy,Protein,Fat,MUFA,PUFA,SFA,Trans,Cholesterol,Carbohydrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietitian_mctoil);

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
        SFA = findViewById(R.id.SFA);
        Trans = findViewById(R.id.Trans);
        Cholesterol = findViewById(R.id.Cholesterol);
        Carbohydrate = findViewById(R.id.Carbohydrate);

        back = findViewById(R.id.back);
        imageView = findViewById(R.id.imageView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dietitian_MCToil.this, Dietitian_Modular.class);
                startActivity(i);
                finish();
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Products Info").child("t5aTq32ZMaP33c16tCaOrFvaKyt2").child("1649973116976");
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
                MUFA.setText(snapshot.child("product MUFAUnit").getValue().toString());
                PUFA.setText(snapshot.child("product PUFAUnit").getValue().toString());
                SFA.setText(snapshot.child("product SFAUnit").getValue().toString());
                Trans.setText(snapshot.child("product TransfattyAcidsUnit").getValue().toString());
                Cholesterol.setText(snapshot.child("product CholesterolUnit").getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Dietitian_MCToil.this, Dietitian_Modular.class);
        startActivity(i);
        finish();
    }
}