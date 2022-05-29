package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.daud.gameleven.MainActivity;
import com.daud.gameleven.Adapter.ProductAdsAd;
import com.daud.gameleven.Adapter.TextListAd;
import com.daud.gameleven.Adapter.BrandsAd;
import com.daud.gameleven.Adapter.DailyFeaturesAd;
import com.daud.gameleven.Adapter.FlashDealsAd;
import com.daud.gameleven.Adapter.HotCateAd;
import com.daud.gameleven.Model.ProductModel;
import com.daud.gameleven.R;
import com.daud.gameleven.Util.Data;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;


import java.util.ArrayList;
import java.util.List;

public class FragHome extends Fragment {
    private ImageButton menuBtn;
    private RecyclerView textRecycler, flashDeals, dailyFeatures, hotCategories, brands, bestSale;
    private ImageSlider imageSlider;
    private ImageView couponBtn, giftCBtn, slashBtn, pcbBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);

        initial(view);

        menuBtn.setOnClickListener(view1 -> {
            menuBtnOnClick();
        });

        ///////////////////////////////////////
        couponBtn.setOnClickListener(view1 -> {
            demoClick();
        });
        giftCBtn.setOnClickListener(view1 -> {
            demoClick();
        });
        slashBtn.setOnClickListener(view1 -> {
            demoClick();
        });
        pcbBtn.setOnClickListener(view1 -> {
            demoClick();
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        topTextSliderHandler();

        imageSliderHandler();

        setRecyclersDemo();
    }

    private void demoClick() {
        getParentFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.mainFrame, new FragProduct()).addToBackStack(null).commit();
    }

    private void topTextSliderHandler() {
        String[] textList = {"Hot", "Computer & Office", "Phone Accessories", "Gaming PC", "Toys"};
        textRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        textRecycler.setAdapter(new TextListAd(getContext(), textList));
    }

    private void menuBtnOnClick() {
        getParentFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.mainFrame, new FragCategory()).commit();
        MainActivity.btmNav.setSelectedItemId(R.id.category);
    }

    private void setRecyclersDemo() {
        Data data = new Data();

        flashDeals.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        flashDeals.setAdapter(new FlashDealsAd(getContext(), data.getAllProduct()));

        dailyFeatures.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        dailyFeatures.setAdapter(new DailyFeaturesAd(getContext(), data.getAllProduct()));

        hotCategories.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        hotCategories.setAdapter(new HotCateAd(getContext(), data.getAllProduct()));

        brands.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        brands.setAdapter(new BrandsAd(getContext(), data.getAllProduct()));

        bestSale.setLayoutManager(new GridLayoutManager(getContext(), 2));
        bestSale.setAdapter(new ProductAdsAd(getContext(), data.getAllProduct()));


    }

    private void imageSliderHandler() {
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.slider_xd, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.slider_one, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.slider_two, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.slider_three, ScaleTypes.FIT));
        imageSlider.setImageList(imageList);
    }

    private void initial(View view) {
        MainActivity.btmCard.setVisibility(View.VISIBLE);
        MainActivity.fab.setVisibility(View.VISIBLE);
        MainActivity.btmNav.setSelectedItemId(R.id.home);
        ///////////////////////////////////////////////////
        menuBtn = view.findViewById(R.id.menuBtn);
        imageSlider = view.findViewById(R.id.imageSlider);
        textRecycler = view.findViewById(R.id.textRecycler);
        textRecycler.setHasFixedSize(false);
        flashDeals = view.findViewById(R.id.flashDeals);
        dailyFeatures = view.findViewById(R.id.dailyFeatures);
        hotCategories = view.findViewById(R.id.hotCategories);
        brands = view.findViewById(R.id.brands);
        bestSale = view.findViewById(R.id.bestSale);
        couponBtn = view.findViewById(R.id.couponBtn);
        giftCBtn = view.findViewById(R.id.giftCBtn);
        slashBtn = view.findViewById(R.id.slashBtn);
        pcbBtn = view.findViewById(R.id.pcbBtn);
    }
}