package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.daud.gameleven.MainActivity;
import com.daud.gameleven.Adapter.WishlistAd;
import com.daud.gameleven.Model.ProductModel;
import com.daud.gameleven.R;
import com.daud.gameleven.Util.Data;

import java.util.ArrayList;
import java.util.List;

public class FragWishlist extends Fragment {
    private ImageButton wishBack;
    private RecyclerView wishRecycler;
    private List<ProductModel> wList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_wishlist, container, false);

        initial(view);

        onBackPressed(view);

        wishBack.setOnClickListener(view1 -> {
            backPressedHandler();
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        showWishlistDemo();
    }

    private void showWishlistDemo() {
        Data data = new Data();
        wishRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        wishRecycler.setAdapter(new WishlistAd(getContext(),data.getWishlist()));
    }

    private void backPressedHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
        MainActivity.btmNav.setSelectedItemId(R.id.home);
    }

    private void initial(View view) {
        wishBack = view.findViewById(R.id.wishBack);
        wishRecycler = view.findViewById(R.id.wishRecycler);
        wList = new ArrayList<>();
    }

    private void onBackPressed(View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i==KeyEvent.KEYCODE_BACK){
                    backPressedHandler();
                    return true;
                }
                return false;
            }
        });
    }
}