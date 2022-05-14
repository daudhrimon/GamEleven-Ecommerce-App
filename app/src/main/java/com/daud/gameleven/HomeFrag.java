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
    private RecyclerView textRecycler;
    private LinearLayoutManager layoutManager;
    private ImageSlider imageSlider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);

        initial(view);

        imageSliderHandler();

        return view;
    }

    private void imageSliderHandler() {
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.slider_one, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.slider_two, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.slider_three, ScaleTypes.FIT));
        imageSlider.setImageList(imageList);
    }

    private void initial(View view) {
        textRecycler = view.findViewById(R.id.textRecycler);
        imageSlider = view.findViewById(R.id.imageSlider);
        textRecycler.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        textRecycler.setLayoutManager(layoutManager);
        textRecycler.setAdapter(new TextBtnAdapter(getContext()));
    }
}