package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daud.gameleven.Adapter.ProductAdsAd;
import com.daud.gameleven.MainActivity;
import com.daud.gameleven.Model.ProductModel;
import com.daud.gameleven.R;
import com.daud.gameleven.Util.Data;

import java.util.ArrayList;
import java.util.List;

public class FragProduct extends Fragment {
    private RecyclerView productRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity. fab.setVisibility(View.GONE);
        MainActivity.btmCard.setVisibility(View.GONE);
        View view = inflater.inflate(R.layout.frag_product, container, false);

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

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        demoDataSet();
    }

    private void demoDataSet() {
        Data data = new Data();
        productRv.setLayoutManager(new GridLayoutManager(getContext(),2));
        productRv.setAdapter(new ProductAdsAd(getContext(),data.getAllProduct()));
    }

    private void backPressedHandler() {
        getParentFragmentManager().popBackStack();
    }

    private void initial(View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        /////////////////////////////////////////////////
        productRv = view.findViewById(R.id.productRv);
        productRv.setLayoutManager(new GridLayoutManager(getContext(),2));
    }
}