package com.daud.gameleven;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WishlistFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_wishlist, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new HomeFrag()).commit();
    }
}