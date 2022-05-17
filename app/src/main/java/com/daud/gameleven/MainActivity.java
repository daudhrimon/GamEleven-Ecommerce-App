package com.daud.gameleven;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    private BottomNavigationView btmNav;

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
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new HomeFrag()).commit();
        btmNav.setSelectedItemId(R.id.home);
    }

    private void btmNavItemSelectHandler(MenuItem item) {
        switch (item.getItemId()){
            case R.id.category:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new CategoryFrag()).commit();
                break;
            case R.id.wishlist:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new WishlistFrag()).commit();
                break;
            case R.id.cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new CartFrag()).commit();
                break;
            case R.id.account:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new AccountFrag()).commit();
                break;
            default:break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new HomeFrag()).commit();
    }

    private void initial() {
        fab = findViewById(R.id.fab);
        btmNav = findViewById(R.id.btmNav);
        btmNav.getMenu().getItem(2).setEnabled(false);
        btmNav.setSelectedItemId(R.id.home);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new HomeFrag()).commit();
    }
}