package com.daud.gameleven.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

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

        accountBack.setOnClickListener(view1 -> {
            backPressedHandler();
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

        cngLanFab.setOnClickListener(view1 -> {
            cngLanFabClickHandler();
        });

        return view;
    }

    private void cngLanFabClickHandler() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.alertdialog_language,null,false);
        TextView cancelBtn = view.findViewById(R.id.cancelBtn);
        builder.setView(view);
        final Dialog dialog = builder.create();
        dialog.show();

        cancelBtn.setOnClickListener(view1 -> {
            dialog.dismiss();
        });
    }

    private void ordersFabClickHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragOrderList())
                .addToBackStack(null).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
    }

    private void profileFabClickHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragProfile())
                .addToBackStack(null).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
    }

    private void addressFabClickHandler() {
        BottomSheetDialog btmDialog = new BottomSheetDialog(getContext(),R.style.AppBottomSheetDialogTheme);
        btmDialog.setContentView(R.layout.btmsheet_address_full);

        btmDialog.show();
    }

    private void backPressedHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
        MainActivity.btmNav.setSelectedItemId(R.id.home);
    }

    private void initial(View view) {
        MainActivity.btmCard.setVisibility(View.VISIBLE);
        MainActivity.fab.setVisibility(View.VISIBLE);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        //////////////////////////////////////////////////
        accountBack = view.findViewById(R.id.accountBack);
        ordersFab = view.findViewById(R.id.ordersFab);
        profileFab = view.findViewById(R.id.profileFab);
        addressFab = view.findViewById(R.id.addressFab);
        cngLanFab = view.findViewById(R.id.cngLanFab);
        logoutFab = view.findViewById(R.id.logoutFab);
    }
}