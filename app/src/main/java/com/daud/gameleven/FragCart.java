package com.daud.gameleven;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class FragCart extends Fragment {
    private ImageButton cartBack;
    private RecyclerView cartRecycler;
    private List<ProductsModel> cList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_cart, container, false);

        initial(view);

        cartRecyclerHandler();

        cartBack.setOnClickListener(view1 -> {
            cartBackOnClick();
        });

        return view;
    }

    private void cartBackOnClick() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome()).commit();
        ActivityMain.btmNav.setSelectedItemId(R.id.home);
    }

    private void cartRecyclerHandler() {
        cList.clear();
        cList.add(new ProductsModel("Power Bank Water Gold","G11 Chair","1","Sound Box","750.00","550.00",R.drawable.one,"Discription","200.00",10,R.drawable.diesel));
        cList.add(new ProductsModel("Power Bank Water Gold","G11 Mouse","2","Sound Box","430.00","230.00",R.drawable.two,"Discription","200.00",10,R.drawable.gionee));
        cList.add(new ProductsModel("Power Bank Water Gold","Gaming Pc","3","Sound Box","1430.00","1230.00",R.drawable.three,"Discription","200.00",10,R.drawable.fedex));
        cList.add(new ProductsModel("Power Bank Water Gold","G11 Headphone","4","Sound Box","1430.00","1230.00",R.drawable.four,"Discription","200.00",10,R.drawable.micromax));
        cList.add(new ProductsModel("Power Bank Water Gold","G11 Chair","5","Sound Box","750.00","550.00",R.drawable.one,"Discription","200.00",10,R.drawable.diesel));
        cList.add(new ProductsModel("Power Bank Water Gold","G11 Mouse","6","Sound Box","430.00","230.00",R.drawable.two,"Discription","200.00",10,R.drawable.gionee));
        cList.add(new ProductsModel("Power Bank Water Gold","Gaming Pc","7","Sound Box","1430.00","1230.00",R.drawable.three,"Discription","200.00",10,R.drawable.fedex));
        cList.add(new ProductsModel("Power Bank Water Gold","G11 Headphone","8","Sound Box","1430.00","1230.00",R.drawable.four,"Discription","200.00",10,R.drawable.micromax));

        cartRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        cartRecycler.setAdapter(new AdapterCart(getContext(),cList));


    }

    private void initial(View view) {
        cartBack = view.findViewById(R.id.cartBack);
        cartRecycler = view.findViewById(R.id.cartRecycler);
        cList = new ArrayList<>();
    }
}