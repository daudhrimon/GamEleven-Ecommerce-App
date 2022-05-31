package com.daud.gameleven.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daud.gameleven.MainActivity;
import com.daud.gameleven.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class FragAccount extends Fragment {
    private ImageButton accountBack;
    private RelativeLayout ordersLay, profileLay, addressLay, cngLanLay, logoutLay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_account, container, false);

        initial(view);

        accountBack.setOnClickListener(view1 -> {
            backPressedHandler();
        });

        ordersLay.setOnClickListener(view1 -> {
            ordersFabClickHandler();
        });

        profileLay.setOnClickListener(view1 -> {
            profileFabClickHandler();
        });

        addressLay.setOnClickListener(view1 -> {
            addressNullBtmSheet();
        });

        cngLanLay.setOnClickListener(view1 -> {
            cngLanFabClickHandler();
        });

        return view;
    }

    private void cngLanFabClickHandler() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.alertdialog_language, null, false);
        TextView cancelBtn = view.findViewById(R.id.cancelBtn);
        builder.setView(view);
        final Dialog dialog = builder.create();
        dialog.show();

        cancelBtn.setOnClickListener(view1 -> {
            dialog.dismiss();
        });
    }

    private void ordersFabClickHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame, new FragOrderList())
                .addToBackStack(null).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
    }

    private void profileFabClickHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame, new FragProfile())
                .addToBackStack(null).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
    }

    private void addressNullBtmSheet(){
        BottomSheetDialog btmSheet = new BottomSheetDialog(getContext(), R.style.AppBottomSheetDialogTheme);
        btmSheet.setContentView(R.layout.btmsheet_no_address);
        ImageButton backBtn = btmSheet.findViewById(R.id.addressBack);
        ImageButton plusBtn = btmSheet.findViewById(R.id.addressPlus);
        btmSheet.show();

        backBtn.setOnClickListener(view -> {
            btmSheet.dismiss();
        });

        plusBtn.setOnClickListener(view -> {
            addressAddingBtmSheet();
            btmSheet.dismiss();
        });
    }

    private void addressAddingBtmSheet() {
        BottomSheetDialog btmDialog = new BottomSheetDialog(getContext(), R.style.AppBottomSheetDialogTheme);
        btmDialog.setContentView(R.layout.btmsheet_address_full);

        btmDialog.show();
    }

    private void backPressedHandler() {
        getParentFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .replace(R.id.mainFrame, new FragHome()).commit();
    }

    private void initial(View view) {
        MainActivity.btmCard.setVisibility(View.VISIBLE);
        MainActivity.fab.setVisibility(View.VISIBLE);
        //////////////////////////////////////////////////
        accountBack = view.findViewById(R.id.accountBack);
        ordersLay = view.findViewById(R.id.ordersLay);
        profileLay = view.findViewById(R.id.profileLay);
        addressLay = view.findViewById(R.id.addressLay);
        cngLanLay = view.findViewById(R.id.cngLanLay);
        logoutLay = view.findViewById(R.id.logoutLay);
    }
}