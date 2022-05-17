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

public class WishlistFrag extends Fragment {
    private ImageButton wishBack;
    private RecyclerView wishRecycler;
    private List<ProductsModel> wList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_wishlist, container, false);

        initial(view);

        wishBack.setOnClickListener(view1 -> {
            getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new HomeFrag()).commit();
            MainActivity.btmNav.setSelectedItemId(R.id.home);

        });

        showWishlistDemo();

        return view;
    }

    private void showWishlistDemo() {
        wList.clear();
        wList.add(new ProductsModel("Power Bank Water Gold","G11 Chair","1","Sound Box","750.00","550.00",R.drawable.one,"Discription","200.00",10,R.drawable.diesel));
        wList.add(new ProductsModel("Power Bank Water Gold","G11 Mouse","2","Sound Box","430.00","230.00",R.drawable.two,"Discription","200.00",10,R.drawable.gionee));
        wList.add(new ProductsModel("Power Bank Water Gold","Gaming Pc","3","Sound Box","1430.00","1230.00",R.drawable.three,"Discription","200.00",10,R.drawable.fedex));
        wList.add(new ProductsModel("Power Bank Water Gold","G11 Headphone","4","Sound Box","1430.00","1230.00",R.drawable.four,"Discription","200.00",10,R.drawable.micromax));
        wList.add(new ProductsModel("Power Bank Water Gold","G11 Chair","5","Sound Box","750.00","550.00",R.drawable.one,"Discription","200.00",10,R.drawable.diesel));
        wList.add(new ProductsModel("Power Bank Water Gold","G11 Mouse","6","Sound Box","430.00","230.00",R.drawable.two,"Discription","200.00",10,R.drawable.gionee));
        wList.add(new ProductsModel("Power Bank Water Gold","Gaming Pc","7","Sound Box","1430.00","1230.00",R.drawable.three,"Discription","200.00",10,R.drawable.fedex));
        wList.add(new ProductsModel("Power Bank Water Gold","G11 Headphone","8","Sound Box","1430.00","1230.00",R.drawable.four,"Discription","200.00",10,R.drawable.micromax));

        wishRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        wishRecycler.setAdapter(new AdapterTwo(getContext(),wList,2));
    }

    private void initial(View view) {
        wishBack = view.findViewById(R.id.wishBack);
        wishRecycler = view.findViewById(R.id.wishRecycler);
        wList = new ArrayList<>();
    }
}