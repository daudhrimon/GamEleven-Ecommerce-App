package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daud.gameleven.Adapter.ProductAd;
import com.daud.gameleven.Model.ProductsModel;
import com.daud.gameleven.R;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class FragDetails extends Fragment {
    private ImageSlider imageSliderPd;
    private RecyclerView relatedPR;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_details, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbarPd);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(null);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initial(view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        imageSliderHandler();

        setRelatedProductDemo();
    }

    private void setRelatedProductDemo() {
        List<ProductsModel> pList = new ArrayList<>();
        pList.add(new ProductsModel("Power Bank Water Gold","G11 Chair","1","Sound Box","750.00","550.00",R.drawable.one,"Discription","200.00",10,R.drawable.diesel));
        pList.add(new ProductsModel("Power Bank Water Gold","G11 Mouse","2","Sound Box","430.00","230.00",R.drawable.two,"Discription","200.00",10,R.drawable.gionee));
        pList.add(new ProductsModel("Power Bank Water Gold","Gaming Pc","3","Sound Box","1430.00","1230.00",R.drawable.three,"Discription","200.00",10,R.drawable.fedex));
        pList.add(new ProductsModel("Power Bank Water Gold","G11 Headphone","4","Sound Box","1430.00","1230.00",R.drawable.four,"Discription","200.00",10,R.drawable.micromax));
        pList.add(new ProductsModel("Power Bank Water Gold","G11 Chair","5","Sound Box","750.00","550.00",R.drawable.one,"Discription","200.00",10,R.drawable.diesel));
        pList.add(new ProductsModel("Power Bank Water Gold","G11 Mouse","6","Sound Box","430.00","230.00",R.drawable.two,"Discription","200.00",10,R.drawable.gionee));
        pList.add(new ProductsModel("Power Bank Water Gold","Gaming Pc","7","Sound Box","1430.00","1230.00",R.drawable.three,"Discription","200.00",10,R.drawable.fedex));
        pList.add(new ProductsModel("Power Bank Water Gold","G11 Headphone","8","Sound Box","1430.00","1230.00",R.drawable.four,"Discription","200.00",10,R.drawable.micromax));

        relatedPR.setLayoutManager(new GridLayoutManager(getContext(),2));
        relatedPR.setAdapter(new ProductAd(getContext(),pList));
    }


    private void imageSliderHandler() {
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.four, ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel(R.drawable.two, ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel(R.drawable.one, ScaleTypes.CENTER_INSIDE));
        imageSliderPd.setImageList(imageList);
    }

    private void initial(View view) {
        imageSliderPd = view.findViewById(R.id.imageSliderPd);
        relatedPR = view.findViewById(R.id.relatedPR);
    }
}