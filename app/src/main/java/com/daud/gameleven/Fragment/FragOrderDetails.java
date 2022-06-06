package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.daud.gameleven.Activity.MainActivity;
import com.daud.gameleven.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class FragOrderDetails extends Fragment {
    private ImageButton backBtn;
    private LinearLayout unpaidBtn, odDemo1,odDemo2; // demos have to remove //

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_orderdetails, container, false);

        initial(view);

        backBtn.setOnClickListener(view1 -> {
            backPressed();
        });

        unpaidBtn.setOnClickListener(view1 -> {
            unpaidBtnClickHandler();
        });

        odDemo1.setOnClickListener(view1 -> {
            demoClick();
        });

        odDemo2.setOnClickListener(view1 -> {
            demoClick();
        });

        return view;
    }

    private void unpaidBtnClickHandler() {
        BottomSheetDialog btmSheet = new BottomSheetDialog(getContext(),R.style.AppBottomSheetDialogTheme);
        btmSheet.setContentView(R.layout.btmsheet_payment);
        LinearLayout paymentBtn = btmSheet.findViewById(R.id.paymentBtn);
        btmSheet.show();

        paymentBtn.setOnClickListener(view -> {
            btmSheet.dismiss();
        });
    }

    private void backPressed(){
        getParentFragmentManager().popBackStack();
    }

    private void initial(View view) {
        MainActivity.fab.setVisibility(View.GONE);
        MainActivity.btmCard.setVisibility(View.GONE);
        backBtn = view.findViewById(R.id.odBack);
        unpaidBtn = view.findViewById(R.id.unpaidBtn);
        odDemo1 = view.findViewById(R.id.odDemo1);
        odDemo2 = view.findViewById(R.id.odDemo2);
    }

    public void demoClick() {
        getParentFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.mainFrame, new FragProDetails()).addToBackStack(null).commit();
    }
}