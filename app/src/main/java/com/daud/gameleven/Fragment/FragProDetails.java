package com.daud.gameleven.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daud.gameleven.Adapter.ProductAdsAd;
import com.daud.gameleven.MainActivity;
import com.daud.gameleven.Model.ProductModel;
import com.daud.gameleven.R;
import com.daud.gameleven.Util.Data;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class FragProDetails extends Fragment {
    private ImageSlider imageSliderPd;
    private ImageButton backBtn;
    private LinearLayout buyBtn,desBtn,specBtn;
    private TextView desTv,specTv;
    private RecyclerView relatedPR;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_prodetails, container, false);

        initial(view);

        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i==keyEvent.KEYCODE_BACK){
                    backPressedHandler();
                    return true;
                }
                return false;
            }
        });

        backBtn.setOnClickListener(view1 -> {
            backPressedHandler();
        });

        buyBtn.setOnClickListener(view1 -> {
            buyBtnClickHandler();
        });

        desBtn.setOnClickListener(view1 -> {
            setBtnColor(desBtn,desTv,specBtn,specTv);
        });

        specBtn.setOnClickListener(view1 -> {
            setBtnColor(specBtn,specTv,desBtn,desTv);
        });

        return view;
    }

    private void buyBtnClickHandler() {
        BottomSheetDialog btmSheet = new BottomSheetDialog(getContext(),R.style.AppBottomSheetDialogTheme);
        btmSheet.setContentView(R.layout.btmsheet_single_product);
        btmSheet.show();
    }

    private void setBtnColor(LinearLayout firstLay, TextView firstTv,LinearLayout secLay,TextView secTv){
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
        relatedPR.setLayoutManager(new GridLayoutManager(getContext(),2));
        relatedPR.setAdapter(new ProductAdsAd(getContext(),data.getAllProduct()));
    }


    private void imageSliderHandler() {
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.four, ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel(R.drawable.two, ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel(R.drawable.one, ScaleTypes.CENTER_INSIDE));
        imageSliderPd.setImageList(imageList);
    }

    private void backPressedHandler(){
        getParentFragmentManager().popBackStack();
    }

    private void initial(View view) {
        MainActivity. fab.setVisibility(View.GONE);
        MainActivity.btmCard.setVisibility(View.GONE);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
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