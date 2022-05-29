package com.daud.gameleven;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.daud.gameleven.Fragment.FragAccount;
import com.daud.gameleven.Fragment.FragCart;
import com.daud.gameleven.Fragment.FragCategory;
import com.daud.gameleven.Fragment.FragHome;
import com.daud.gameleven.Fragment.FragSignIn;
import com.daud.gameleven.Fragment.FragWishlist;
import com.daud.gameleven.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            if (btmNav.getSelectedItemId() != R.id.home) {
                fabOnClickHandler();
            }
        });

        btmNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() != btmNav.getSelectedItemId()) {
                    btmNavItemSelectHandler(item);
                }
                return true;
            }
        });
    }

    private void fabOnClickHandler() {
        getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .replace(R.id.mainFrame, new FragHome()).commit();
    }

    private void btmNavItemSelectHandler(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.category:
                getSupportFragmentManager().beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .replace(R.id.mainFrame, new FragCategory()).commit();
                break;

            case R.id.wishlist:
                getSupportFragmentManager().beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .replace(R.id.mainFrame, new FragWishlist()).commit();
                break;

            case R.id.cart:
                getSupportFragmentManager().beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .replace(R.id.mainFrame, new FragCart()).commit();
                break;

            case R.id.account:
                if (getPreferences.getInt("SIGNIN", 0) == 1) {
                    getSupportFragmentManager().beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .replace(R.id.mainFrame, new FragAccount()).commit();
                } else {
                    getSupportFragmentManager().beginTransaction()
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .replace(R.id.mainFrame, new FragSignIn()).commit();
                }
                break;

            default:
                break;
        }
    }

    private void initial() {
        btmCard = findViewById(R.id.btmCard);
        btmNav = findViewById(R.id.btmNav);
        fab = findViewById(R.id.fab);
        btmNav.getMenu().getItem(2).setEnabled(false);
        btmNav.setSelectedItemId(R.id.home);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new FragHome()).commit();
        getPreferences = getSharedPreferences("MySp", MODE_PRIVATE);
        editor = getPreferences.edit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0 && btmNav.getSelectedItemId() != R.id.home) {
            fabOnClickHandler();
        } else if (getSupportFragmentManager().getBackStackEntryCount() == 0 && btmNav.getSelectedItemId() == R.id.home) {
            Toast.makeText(this, "NO TASK", Toast.LENGTH_SHORT).show();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    public static int getRandomColor() {
        List<Integer> colorcode = new ArrayList<>();
        colorcode.add(Color.parseColor("#D81D4C"));
        colorcode.add(Color.parseColor("#68C037"));
        colorcode.add(Color.parseColor("#094D82"));
        colorcode.add(Color.parseColor("#2B2B2B"));

        Random random = new Random();
        int number = random.nextInt(colorcode.size());
        return colorcode.get(number);
    }
}