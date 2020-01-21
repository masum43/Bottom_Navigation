package com.example.vrushabh.bottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        defaultFragment(new HomeFragment());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.home:
                fragment = new HomeFragment();
                Toast toast = Toast.makeText(getApplicationContext(), "Welcome to HOME",Toast.LENGTH_SHORT);
                toast.show();
                break;

            case R.id.drop:
                fragment = new DropFragment();
                Toast toast2 = Toast.makeText(getApplicationContext(), "Welcome to DROP",Toast.LENGTH_SHORT);
                toast2.show();
                break;

            case R.id.heart:
                fragment = new HeartFragment();
                Toast toast3 = Toast.makeText(getApplicationContext(), "Welcome to HEART",Toast.LENGTH_SHORT);
                toast3.show();
                break;

            case R.id.android:
                fragment = new AndroidFragment();
                Toast toast4 = Toast.makeText(getApplicationContext(), "Welcome to ANDROID",Toast.LENGTH_SHORT);
                toast4.show();
                break;

        }

        return defaultFragment (fragment);
    }

    private boolean defaultFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
