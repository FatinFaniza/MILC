package com.example.milc;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Supplier_Home extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    BottomNavigationView bottomNavigationView;

    HomeFragment2 homeFragment2 = new HomeFragment2();
    ProfileFragment2 profileFragment2 = new ProfileFragment2();
    NoteFragment2 noteFragment2 = new NoteFragment2();
    NotificationFragment notificationFragment = new NotificationFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_home);

        bottomNavigationView  = findViewById(R.id.bottomNavigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment2).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment2).commit();
                        return true;
                    case R.id.notes:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,noteFragment2).commit();
                        return true;
                    case R.id.notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,notificationFragment).commit();
                        return true;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment2).commit();
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