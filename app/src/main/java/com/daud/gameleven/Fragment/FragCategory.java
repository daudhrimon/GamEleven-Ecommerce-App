package com.daud.gameleven.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daud.gameleven.Activity.MainActivity;
import com.daud.gameleven.Adapter.AdapterTextItems;
import com.daud.gameleven.R;

public class FragCategory extends Fragment {
    private ImageButton catBack;
    private LinearLayout oneBtn,twoBtn,threeBtn,fourBtn,fiveBtn,sixBtn;
    private RecyclerView itemsSuperRecycler;
    private TextView catName;
    private LinearLayout catNameLay;

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

    @Override
    public void onStart() {
        super.onStart();

        oneBtnClickHandler();
    }

    private void oneBtnClickHandler() {
        setButtonsColor(oneBtn);
        catNameLay.setVisibility(View.VISIBLE);
        catName.setText("Electronic Device");
        String[] textList = {"Merchandise","Retro Gaming Consoles","Pre Owned (Badel)","Xbox","PlayStation 4","Gaming Setup","Tv & Audio"};
        itemsSuperRecycler.setAdapter(new AdapterTextItems(getContext(),textList,2));
    }

    private void twoBtnClickHandler() {
        setButtonsColor(twoBtn);
        catNameLay.setVisibility(View.VISIBLE);
        catName.setText("Furniture Device");
        String[] textList = {"Xbox","PlayStation 4","Gaming Setup","Tv & Audio","Merchandise","Retro Gaming Consoles","Pre Owned (Badel)"};
        itemsSuperRecycler.setAdapter(new AdapterTextItems(getContext(),textList,2));
    }

    private void threeBtnClickHandler() {
        setButtonsColor(threeBtn);
        catNameLay.setVisibility(View.VISIBLE);
        catName.setText("Casual Bag");
        String[] textList = {"Merchandise","Retro Gaming Consoles","Pre Owned (Badel)","Xbox","PlayStation 4","Gaming Setup","Tv & Audio"};
        itemsSuperRecycler.setAdapter(new AdapterTextItems(getContext(),textList,2));
    }

    private void fourBtnClickHandler() {
        setButtonsColor(fourBtn);
        catNameLay.setVisibility(View.VISIBLE);
        catName.setText("Electronic Device");
        String[] textList = {"Xbox","PlayStation 4","Gaming Setup","Tv & Audio","Merchandise","Retro Gaming Consoles","Pre Owned (Badel)"};
        itemsSuperRecycler.setAdapter(new AdapterTextItems(getContext(),textList,2));
    }

    private void fiveBtnClickHandler() {
        setButtonsColor(fiveBtn);
        catNameLay.setVisibility(View.VISIBLE);
        catName.setText("Electronic Device");
        String[] textList = {"Merchandise","Retro Gaming Consoles","Pre Owned (Badel)","Xbox","PlayStation 4","Gaming Setup","Tv & Audio"};
        itemsSuperRecycler.setAdapter(new AdapterTextItems(getContext(),textList,2));
    }

    private void sixBtnClickHandler() {
        setButtonsColor(sixBtn);
        catNameLay.setVisibility(View.VISIBLE);
        catName.setText("Electronic Device");
        String[] textList = {"Xbox","PlayStation 4","Gaming Setup","Tv & Audio","Merchandise","Retro Gaming Consoles","Pre Owned (Badel)"};
        itemsSuperRecycler.setAdapter(new AdapterTextItems(getContext(),textList,2));
    }

    private void catBackClickHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome()).commit();
        MainActivity.btmNav.setSelectedItemId(R.id.home);
    }

    private void setButtonsColor(LinearLayout Lay){
        oneBtn.setBackgroundColor(Color.parseColor("#F0F0F0"));
        twoBtn.setBackgroundColor(Color.parseColor("#F0F0F0"));
        threeBtn.setBackgroundColor(Color.parseColor("#F0F0F0"));
        fourBtn.setBackgroundColor(Color.parseColor("#F0F0F0"));
        fiveBtn.setBackgroundColor(Color.parseColor("#F0F0F0"));
        sixBtn.setBackgroundColor(Color.parseColor("#F0F0F0"));
        Lay.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }

    private void initial(View view) {
        catBack = view.findViewById(R.id.catBack);
        oneBtn = view.findViewById(R.id.oneBtn);
        twoBtn = view.findViewById(R.id.twoBtn);
        threeBtn = view.findViewById(R.id.threeBtn);
        fourBtn = view.findViewById(R.id.fourBtn);
        fiveBtn = view.findViewById(R.id.fiveBtn);
        sixBtn = view.findViewById(R.id.sixBtn);
        itemsSuperRecycler = view.findViewById(R.id.itemsSuperRecycler);
        itemsSuperRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        catName = view.findViewById(R.id.catName);
        catNameLay = view.findViewById(R.id.catNameLay);
    }
}