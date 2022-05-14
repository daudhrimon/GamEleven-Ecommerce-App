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
            btmNav.setSelectedItemId(R.id.home);
            Toast.makeText(this,"Home Selected",Toast.LENGTH_SHORT).show();
        });

        btmNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                btmNavItemSelectHandler(item);
                return true;
            }
        });
    }

    private void btmNavItemSelectHandler(MenuItem item) {
        switch (item.getItemId()){
            case R.id.category:
                Toast.makeText(this,"Category Selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.wishlist:
                Toast.makeText(this,"WishList Selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cart:
                Toast.makeText(this,"Cart Selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.account:
                Toast.makeText(this,"Account Selected",Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
    }

    private void initial() {
        fab = findViewById(R.id.fab);
        btmNav = findViewById(R.id.btmNav);
        btmNav.getMenu().getItem(2).setEnabled(false);
        btmNav.setSelectedItemId(R.id.home);
    }
}