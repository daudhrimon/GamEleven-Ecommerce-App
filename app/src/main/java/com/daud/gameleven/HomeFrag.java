package com.daud.gameleven;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFrag extends Fragment {
    private RecyclerView textRecycler;
    private LinearLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);

        initial(view);

        return view;
    }

    private void initial(View view) {
        textRecycler = view.findViewById(R.id.textRecycler);
        textRecycler.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        textRecycler.setLayoutManager(layoutManager);
        textRecycler.setAdapter(new TextBtnAdapter(getContext()));

    }
}