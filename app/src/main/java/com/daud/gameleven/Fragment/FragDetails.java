package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daud.gameleven.R;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class FragDetails extends Fragment {
    private ImageSlider imageSliderPd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_details, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbarPd);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(null);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initial(view);

        imageSliderHandler();

        return view;
    }



    private void imageSliderHandler() {
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.slider_one, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.slider_two, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.slider_three, ScaleTypes.FIT));
        imageSliderPd.setImageList(imageList);
    }

    private void initial(View view) {
        imageSliderPd = view.findViewById(R.id.imageSliderPd);
    }
}