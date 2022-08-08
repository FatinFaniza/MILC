package com.example.milc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private  static  int SPLASH_SCREEN =2500;

    ImageView imageView;
    TextView textView1, textView2;
    Animation top, bottom;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        top = AnimationUtils.loadAnimation(this, R.anim.top);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom);
        imageView.setAnimation(top);
        textView1.setAnimation(bottom);
        textView2.setAnimation(bottom);

        firebaseAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run() {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user==null){
                    //user not logged in, go to login activity
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    //user logged in, check user type
                    //if user is dietitian, start dietitian homepage
                    //if user is dietitian, start dietitian homepage
                    //if user is dietitian, start dietitian homepage

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users Info");
                    databaseReference.orderByChild("uid").equalTo(firebaseAuth.getUid())
                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for(DataSnapshot ds:snapshot.getChildren()){
                                        String role = ""+ds.child("role").getValue();
                                        if(role.equals("Dietitian")){
                                            startActivity(new Intent(getApplicationContext(), Dietitian_Home.class));
                                            finish();
                                        }
                                            else if (role.equals("Supplier")){
                                            startActivity(new Intent(getApplicationContext(), Supplier_Home.class));
                                            finish();
                                            }
//                                            else if (accountType.equals("User")){
//
//                                            }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

                }


            }
        },3000);



    }


}
