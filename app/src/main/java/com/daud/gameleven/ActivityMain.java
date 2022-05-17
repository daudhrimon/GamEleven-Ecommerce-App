package com.daud.gameleven;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class ActivityMain extends AppCompatActivity {
    private FloatingActionButton fab;
    public static BottomNavigationView btmNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initial();

        fab.setOnClickListener(view -> {
            fabOnClickHandler();
        });

        btmNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                btmNavItemSelectHandler(item);
                return true;
            }
        });
    }

    private void fabOnClickHandler() {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome()).commit();
        btmNav.setSelectedItemId(R.id.home);
    }

    private void btmNavItemSelectHandler(MenuItem item) {
        switch (item.getItemId()){
            case R.id.category:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragCategory()).commit();
                break;
            case R.id.wishlist:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragWishlist()).commit();
                break;
            case R.id.cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragCart()).commit();
                break;
            case R.id.account:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragAccount()).commit();
                break;
            default:break;
        }
    }

    @Override
    public void onBackPressed() {
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome()).commit();
    }

    private void initial() {
        fab = findViewById(R.id.fab);
        btmNav = findViewById(R.id.btmNav);
        btmNav.getMenu().getItem(2).setEnabled(false);
        btmNav.setSelectedItemId(R.id.home);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome()).commit();
    }
}