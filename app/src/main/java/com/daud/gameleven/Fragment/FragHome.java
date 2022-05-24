package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.daud.gameleven.Adapter.ProductAd;
import com.daud.gameleven.Adapter.TextListAd;
import com.daud.gameleven.Adapter.BrandsAd;
import com.daud.gameleven.Adapter.DailyFeaturesAd;
import com.daud.gameleven.Adapter.FlashDealsAd;
import com.daud.gameleven.Adapter.HotCateAd;
import com.daud.gameleven.Model.ProductsModel;
import com.daud.gameleven.R;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;


import java.util.ArrayList;
import java.util.List;

public class FragHome extends Fragment {
    private ImageButton menuBtn;
    private RecyclerView textRecycler,flashDeals,dailyFeatures,hotCategories,brands,bestSale;
    private ImageSlider imageSlider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);

        initial(view);

        menuBtn.setOnClickListener(view1 -> {
            menuBtnOnClick();
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

    private void topTextSliderHandler() {
        String[] textList = {"Hot","Computer & Office","Phone Accessories","Gaming PC","Toys"};
        textRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        textRecycler.setAdapter(new TextListAd(getContext(),textList));
    }

    private void menuBtnOnClick() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragCategory()).commit();
    }

    private void setRecyclersDemo() {
        List<ProductsModel> pList = new ArrayList<>();
        pList.add(new ProductsModel("Power Bank Water Gold","G11 Chair","1","Sound Box","750.00","550.00",R.drawable.one,"Discription","200.00",10,R.drawable.diesel));
        pList.add(new ProductsModel("Power Bank Water Gold","G11 Mouse","2","Sound Box","430.00","230.00",R.drawable.two,"Discription","200.00",10,R.drawable.gionee));
        pList.add(new ProductsModel("Power Bank Water Gold","Gaming Pc","3","Sound Box","1430.00","1230.00",R.drawable.three,"Discription","200.00",10,R.drawable.fedex));
        pList.add(new ProductsModel("Power Bank Water Gold","G11 Headphone","4","Sound Box","1430.00","1230.00",R.drawable.four,"Discription","200.00",10,R.drawable.micromax));
        pList.add(new ProductsModel("Power Bank Water Gold","G11 Chair","5","Sound Box","750.00","550.00",R.drawable.one,"Discription","200.00",10,R.drawable.diesel));
        pList.add(new ProductsModel("Power Bank Water Gold","G11 Mouse","6","Sound Box","430.00","230.00",R.drawable.two,"Discription","200.00",10,R.drawable.gionee));
        pList.add(new ProductsModel("Power Bank Water Gold","Gaming Pc","7","Sound Box","1430.00","1230.00",R.drawable.three,"Discription","200.00",10,R.drawable.fedex));
        pList.add(new ProductsModel("Power Bank Water Gold","G11 Headphone","8","Sound Box","1430.00","1230.00",R.drawable.four,"Discription","200.00",10,R.drawable.micromax));

        flashDeals.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        flashDeals.setAdapter(new FlashDealsAd(getContext(),pList));

        dailyFeatures.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        dailyFeatures.setAdapter(new DailyFeaturesAd(getContext(),pList));

        hotCategories.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        hotCategories.setAdapter(new HotCateAd(getContext(),pList));

        brands.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        brands.setAdapter(new BrandsAd(getContext(),pList));

        bestSale.setLayoutManager(new GridLayoutManager(getContext(),2));
        bestSale.setAdapter(new ProductAd(getContext(),pList));


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
        menuBtn = view.findViewById(R.id.menuBtn);
        imageSlider = view.findViewById(R.id.imageSlider);
        textRecycler = view.findViewById(R.id.textRecycler);
        textRecycler.setHasFixedSize(false);
        flashDeals = view.findViewById(R.id.flashDeals);
        dailyFeatures = view.findViewById(R.id.dailyFeatures);
        hotCategories = view.findViewById(R.id.hotCategories);
        brands = view.findViewById(R.id.brands);
        bestSale = view.findViewById(R.id.bestSale);
    }
}