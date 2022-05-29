package com.daud.gameleven.Fragment;

import android.graphics.Color;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daud.gameleven.MainActivity;
import com.daud.gameleven.Adapter.CateItemAd;
import com.daud.gameleven.R;

public class FragCategory extends Fragment {
    private ImageButton catBack;
    private LinearLayout oneBtn,twoBtn,threeBtn,fourBtn,fiveBtn,sixBtn;
    private RecyclerView itemsSuperRecycler;
    private TextView catName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity.btmCard.setVisibility(View.VISIBLE);
        MainActivity.fab.setVisibility(View.VISIBLE);
        View view = inflater.inflate(R.layout.frag_category, container, false);

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

        catBack.setOnClickListener(view1 -> {
            backPressedHandler();
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
        catName.setText("Electronic Device");
        String[] textList = {"Merchandise","Retro Gaming Consoles","Pre Owned (Badel)","Xbox","PlayStation 4","Gaming Setup","Tv & Audio"};
        itemsSuperRecycler.setAdapter(new CateItemAd(getContext(),textList));
    }

    private void twoBtnClickHandler() {
        setButtonsColor(twoBtn);
        catName.setText("Furniture Device");
        String[] textList = {"Xbox","PlayStation 4","Gaming Setup","Tv & Audio","Merchandise","Retro Gaming Consoles","Pre Owned (Badel)"};
        itemsSuperRecycler.setAdapter(new CateItemAd(getContext(),textList));
    }

    private void threeBtnClickHandler() {
        setButtonsColor(threeBtn);
        catName.setText("Casual Bag");
        String[] textList = {"Merchandise","Retro Gaming Consoles","Pre Owned (Badel)","Xbox","PlayStation 4","Gaming Setup","Tv & Audio"};
        itemsSuperRecycler.setAdapter(new CateItemAd(getContext(),textList));
    }

    private void fourBtnClickHandler() {
        setButtonsColor(fourBtn);
        catName.setText("Electronic Device");
        String[] textList = {"Xbox","PlayStation 4","Gaming Setup","Tv & Audio","Merchandise","Retro Gaming Consoles","Pre Owned (Badel)"};
        itemsSuperRecycler.setAdapter(new CateItemAd(getContext(),textList));
    }

    private void fiveBtnClickHandler() {
        setButtonsColor(fiveBtn);
        catName.setText("Electronic Device");
        String[] textList = {"Merchandise","Retro Gaming Consoles","Pre Owned (Badel)","Xbox","PlayStation 4","Gaming Setup","Tv & Audio"};
        itemsSuperRecycler.setAdapter(new CateItemAd(getContext(),textList));
    }

    private void sixBtnClickHandler() {
        setButtonsColor(sixBtn);
        catName.setText("Electronic Device");
        String[] textList = {"Xbox","PlayStation 4","Gaming Setup","Tv & Audio","Merchandise","Retro Gaming Consoles","Pre Owned (Badel)"};
        itemsSuperRecycler.setAdapter(new CateItemAd(getContext(),textList));
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

    private void backPressedHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
        MainActivity.btmNav.setSelectedItemId(R.id.home);
    }

    private void initial(View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        /////////////////////////////////////////////////
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
    }
}