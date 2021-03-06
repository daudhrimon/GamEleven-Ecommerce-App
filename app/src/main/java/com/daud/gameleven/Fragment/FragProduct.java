package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daud.gameleven.Adapter.ProductAdsAd;
import com.daud.gameleven.Activity.MainActivity;
import com.daud.gameleven.R;
import com.daud.gameleven.Util.Data;

public class FragProduct extends Fragment {
    private RecyclerView productRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_product, container, false);

        initial(view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        demoDataSet();
    }

    private void demoDataSet() {
        Data data = new Data();
        productRv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        productRv.setAdapter(new ProductAdsAd(getContext(), data.getAllProduct()));
    }

    private void backPressedHandler() {
        getParentFragmentManager().popBackStack();
    }

    private void initial(View view) {
        MainActivity.fab.setVisibility(View.GONE);
        MainActivity.btmCard.setVisibility(View.GONE);
        /////////////////////////////////////////////////
        productRv = view.findViewById(R.id.productRv);
        productRv.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }
}