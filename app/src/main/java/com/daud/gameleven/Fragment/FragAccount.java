package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.daud.gameleven.MainActivity;
import com.daud.gameleven.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FragAccount extends Fragment {
    private ImageButton accountBack;
    private FloatingActionButton ordersFab,profileFab,addressFab,cngLanFab,logoutFab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_account, container, false);

        initial(view);

        accountBack.setOnClickListener(view1 -> {
            onBackPressedHandler();
        });

        ordersFab.setOnClickListener(view1 -> {
            ordersFabClickHandler();
        });

        profileFab.setOnClickListener(view1 -> {
            profileFabClickHandler();
        });

        addressFab.setOnClickListener(view1 -> {
            addressFabClickHandler();
        });

        return view;
    }

    private void ordersFabClickHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragOrderList()).addToBackStack("A2P").commit();
        MainActivity.fab.setVisibility(View.GONE);
        MainActivity.btmCard.setVisibility(View.GONE);
    }

    private void profileFabClickHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragProfile()).addToBackStack("A2O").commit();
        MainActivity.fab.setVisibility(View.GONE);
        MainActivity.btmNav.setVisibility(View.GONE);
    }

    private void addressFabClickHandler() {
        BottomSheetDialog btmDialog = new BottomSheetDialog(getContext(),R.style.AppBottomSheetDialogTheme);
        btmDialog.setContentView(R.layout.btmsheet_address_full);

        btmDialog.show();
    }

    private void onBackPressedHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome()).commit();
        MainActivity.btmNav.setSelectedItemId(R.id.home);
    }

    private void initial(View view) {
        accountBack = view.findViewById(R.id.accountBack);
        ordersFab = view.findViewById(R.id.ordersFab);
        profileFab = view.findViewById(R.id.profileFab);
        addressFab = view.findViewById(R.id.addressFab);
        cngLanFab = view.findViewById(R.id.cngLanFab);
        logoutFab = view.findViewById(R.id.logoutFab);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onBackPressedHandler();
    }
}