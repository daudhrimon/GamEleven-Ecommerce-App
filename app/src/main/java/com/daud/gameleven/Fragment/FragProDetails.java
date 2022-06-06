package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daud.gameleven.Adapter.ProductAdsAd;
import com.daud.gameleven.Activity.MainActivity;
import com.daud.gameleven.R;
import com.daud.gameleven.Util.Data;
import com.denzcoskun.imageslider.ImageSlider;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class FragProDetails extends Fragment {
    private ImageSlider imageSliderPd;
    private ImageButton backBtn;
    private LinearLayout buyBtn, desBtn, specBtn;
    private TextView desTv, specTv;
    private RecyclerView relatedPR;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_prodetails, container, false);

        initial(view);

        backBtn.setOnClickListener(view1 -> {
            backPressedHandler();
        });

        desBtn.setOnClickListener(view1 -> {
            setBtnColor(desBtn, desTv, specBtn, specTv);
        });

        specBtn.setOnClickListener(view1 -> {
            setBtnColor(specBtn, specTv, desBtn, desTv);
        });

        buyBtn.setOnClickListener(view1 -> {
            buyBtnClickHandler();
        });

        return view;
    }

    private void buyBtnClickHandler() {
        BottomSheetDialog btmSheet = new BottomSheetDialog(getContext(), R.style.AppBottomSheetDialogTheme);
        btmSheet.setContentView(R.layout.btmsheet_single_product);
        LinearLayout spCOut = btmSheet.findViewById(R.id.spCOut);
        btmSheet.show();

        spCOut.setOnClickListener(view -> {
            getParentFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.mainFrame, new FragCkOutInfo()).addToBackStack(null).commit();
            btmSheet.dismiss();
        });
    }

    private void setBtnColor(LinearLayout firstLay, TextView firstTv, LinearLayout secLay, TextView secTv) {
        firstLay.setBackgroundColor(getResources().getColor(R.color.selector_clr));
        firstTv.setTextColor(getResources().getColor(R.color.white));
        secLay.setBackgroundColor(getResources().getColor(R.color.white));
        secTv.setTextColor(getResources().getColor(R.color.pd_btn_clr));
    }

    @Override
    public void onStart() {
        super.onStart();

        imageSliderHandler();

        setRelatedProductDemo();
    }

    private void setRelatedProductDemo() {
        Data data = new Data();
        relatedPR.setLayoutManager(new GridLayoutManager(getContext(), 2));
        relatedPR.setAdapter(new ProductAdsAd(getContext(), data.getAllProduct()));
    }


    private void imageSliderHandler() {
        imageSliderPd.setImageList(new Data().proDetSlider());
    }

    private void backPressedHandler() {
        getParentFragmentManager().popBackStack();
    }

    private void initial(View view) {
        MainActivity.fab.setVisibility(View.GONE);
        MainActivity.btmCard.setVisibility(View.GONE);
        //////////////////////////////////////////////////////
        imageSliderPd = view.findViewById(R.id.imageSliderPd);
        backBtn = view.findViewById(R.id.proDetailsBack);
        buyBtn = view.findViewById(R.id.buyBtn);
        desBtn = view.findViewById(R.id.desBtn);
        desTv = view.findViewById(R.id.desTv);
        specBtn = view.findViewById(R.id.specBtn);
        specTv = view.findViewById(R.id.specTv);
        relatedPR = view.findViewById(R.id.relatedPR);
    }
}