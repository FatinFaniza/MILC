package com.example.milc;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class User_Home extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    BottomNavigationView bottomNavigationView;

    HomeFragment3 homeFragment3 = new HomeFragment3();
    ProfileFragment3 profileFragment3 = new ProfileFragment3();
    NoteFragment3 noteFragment3 = new NoteFragment3();
    NotificationFragment notificationFragment = new NotificationFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        bottomNavigationView  = findViewById(R.id.bottomNavigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment3).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment3).commit();
                        return true;
                    case R.id.notes:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,noteFragment3).commit();
                        return true;
                    case R.id.notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,notificationFragment).commit();
                        return true;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment3).commit();
                        return true;
                }

                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}