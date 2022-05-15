package com.daud.gameleven;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;


import java.util.ArrayList;
import java.util.List;

public class HomeFrag extends Fragment {
    private RecyclerView textRecycler,flashDeals,dailyFeatures,hotCategories,brands;
    private ImageSlider imageSlider;
    private List<ProductsModel> pList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);

        initial(view);

        imageSliderHandler();

        setRecyclersDemo();

        return view;
    }

    private void setRecyclersDemo() {
        pList.clear();
        pList.add(new ProductsModel("Power Bank Water Gold","1","Sound Box","750.00","550.00",R.drawable.one,"Discription","200.00",10,R.drawable.diesel));
        pList.add(new ProductsModel("Power Bank Water Gold","1","Sound Box","430.00","230.00",R.drawable.two,"Discription","200.00",10,R.drawable.gionee));
        pList.add(new ProductsModel("Power Bank Water Gold","1","Sound Box","1430.00","1230.00",R.drawable.three,"Discription","200.00",10,R.drawable.fedex));
        pList.add(new ProductsModel("Power Bank Water Gold","1","Sound Box","1430.00","1230.00",R.drawable.four,"Discription","200.00",10,R.drawable.micromax));
        pList.add(new ProductsModel("Power Bank Water Gold","1","Sound Box","750.00","550.00",R.drawable.one,"Discription","200.00",10,R.drawable.diesel));
        pList.add(new ProductsModel("Power Bank Water Gold","1","Sound Box","430.00","230.00",R.drawable.two,"Discription","200.00",10,R.drawable.gionee));
        pList.add(new ProductsModel("Power Bank Water Gold","1","Sound Box","1430.00","1230.00",R.drawable.three,"Discription","200.00",10,R.drawable.fedex));
        pList.add(new ProductsModel("Power Bank Water Gold","1","Sound Box","1430.00","1230.00",R.drawable.four,"Discription","200.00",10,R.drawable.micromax));

        flashDeals.setAdapter(new DealsAdapter(getContext(),pList,1));

        dailyFeatures.setAdapter(new DealsAdapter(getContext(),pList,0));

        hotCategories.setAdapter(new DealsAdapter(getContext(),pList,1));

        brands.setAdapter(new DealsAdapter(getContext(),pList,2));

        ////////////////////////////////////////////////////////////////////////////////////////////

    }

    private void imageSliderHandler() {
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.slider_one, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.slider_two, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.slider_three, ScaleTypes.FIT));
        imageSlider.setImageList(imageList);
    }

    private void initial(View view) {
        imageSlider = view.findViewById(R.id.imageSlider);

        textRecycler = view.findViewById(R.id.textRecycler);
        textRecycler.setHasFixedSize(false);
        textRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        flashDeals = view.findViewById(R.id.flashDeals);
        flashDeals.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        dailyFeatures = view.findViewById(R.id.dailyFeatures);
        dailyFeatures.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        hotCategories = view.findViewById(R.id.hotCategories);
        hotCategories.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        brands = view.findViewById(R.id.brands);
        brands.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        textRecycler.setAdapter(new TextBtnAdapter(getContext()));
        pList = new ArrayList<>();
    }
}