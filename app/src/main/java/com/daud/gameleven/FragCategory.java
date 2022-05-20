package com.daud.gameleven;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class FragCategory extends Fragment {
    private ImageButton catBack;
    private LinearLayout oneBtn,twoBtn,threeBtn,fourBtn,fiveBtn,sixBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_category, container, false);

        initial(view);

        catBack.setOnClickListener(view1 -> {
            catBackClickHandler();
        });
        
        oneBtn.setOnClickListener(view1 -> {
            oneBtnClickHandler();
        });
        
        twoBtn.setOnClickListener(view1 -> {
            twoBtnClickHandler();
        });
        
        threeBtn.setOnClickListener(view1 -> {
            threeBtnClickHandler();
        });
        
        fourBtn.setOnClickListener(view1 -> {
            fourBtnClickHandler();
        });
        
        fiveBtn.setOnClickListener(view1 -> {
            fiveBtnClickHandler();
        });

        sixBtn.setOnClickListener(view1 -> {
            sixBtnClickHandler();
        });
        
        return view;
    }

    private void oneBtnClickHandler() {
    }

    private void twoBtnClickHandler() {
    }

    private void threeBtnClickHandler() {
    }

    private void fourBtnClickHandler() {
    }

    private void fiveBtnClickHandler() {
    }

    private void sixBtnClickHandler() {
    }

    private void catBackClickHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome()).commit();
        MainActivity.btmNav.setSelectedItemId(R.id.home);
    }

    private void initial(View view) {
        catBack = view.findViewById(R.id.catBack);
        oneBtn = view.findViewById(R.id.oneBtn);
        twoBtn = view.findViewById(R.id.twoBtn);
        threeBtn = view.findViewById(R.id.threeBtn);
        fourBtn = view.findViewById(R.id.fourBtn);
        fiveBtn = view.findViewById(R.id.fiveBtn);
        sixBtn = view.findViewById(R.id.sixBtn);
    }
}