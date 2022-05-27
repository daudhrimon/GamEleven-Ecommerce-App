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

import com.daud.gameleven.Adapter.ProductAdsAd;
import com.daud.gameleven.Model.ProductModel;
import com.daud.gameleven.R;
import com.daud.gameleven.Util.Data;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class FragProDetails extends Fragment {
    private ImageSlider imageSliderPd;
    private RecyclerView relatedPR;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_prodetails, container, false);
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

    private void initial(View view) {
        imageSliderPd = view.findViewById(R.id.imageSliderPd);
        relatedPR = view.findViewById(R.id.relatedPR);
    }
}