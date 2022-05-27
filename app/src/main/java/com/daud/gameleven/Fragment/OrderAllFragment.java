package com.daud.gameleven.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.daud.gameleven.Adapter.OrderAd;
import com.daud.gameleven.R;
import com.daud.gameleven.Util.Data;

public class OrderAllFragment extends Fragment {
    public OrderAllFragment() {
    }

    public static OrderAllFragment newInstance() {
        OrderAllFragment fragment = new OrderAllFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.item_order_recycler, container, false);

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.order_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        Data data = new Data();

        //set data and list adapter
        OrderAd mAdapter = new OrderAd(data.getAllOrderList(),getContext());
        recyclerView.setAdapter(mAdapter);

        return root;
    }
}
