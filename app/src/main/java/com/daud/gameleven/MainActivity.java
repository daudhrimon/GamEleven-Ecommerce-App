package com.daud.gameleven;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    public static CardView btmCard;
    public static BottomNavigationView btmNav;
    public static FloatingActionButton fab;
    public static SharedPreferences getPreferences;
    public static SharedPreferences.Editor editor;

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
                if (getPreferences.getInt("SIGNIN",0)==1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragAccount()).commit();
                    break;
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragSignIn()).commit();
                    fab.setVisibility(View.GONE);
                    btmCard.setVisibility(View.GONE);
                    break;
                }

            default:break;
        }
    }

    @Override
    public void onBackPressed() {
        btmCard.setVisibility(View.VISIBLE);
        fab.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome()).commit();
        btmNav.setSelectedItemId(R.id.home);
    }

    private void initial() {
        btmCard = findViewById(R.id.btmCard);
        btmNav = findViewById(R.id.btmNav);
        fab = findViewById(R.id.fab);
        btmNav.getMenu().getItem(2).setEnabled(false);
        btmNav.setSelectedItemId(R.id.home);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome()).commit();
        getPreferences = getSharedPreferences("MySp",MODE_PRIVATE);
        editor = getPreferences.edit();
    }
}