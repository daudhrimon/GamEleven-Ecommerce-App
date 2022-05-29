package com.daud.gameleven.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.daud.gameleven.MainActivity;
import com.daud.gameleven.Adapter.CartAd;
import com.daud.gameleven.Model.ProductModel;
import com.daud.gameleven.R;
import com.daud.gameleven.Util.Data;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FragCart extends Fragment {
    private ImageButton cartBack,cartDlt;
    private FloatingActionButton fabAllSe,fabAllUn;
    private LinearLayout cartCOut;
    private RecyclerView cartRecycler;
    private List<ProductModel> cList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_cart, container, false);
        onBackPressed(view);

        initial(view);

        cartBack.setOnClickListener(view1 -> {
            backPressedHandler();
        });

        cartDlt.setOnClickListener(view1 -> {
            cartDltClickHandler();

        });

        fabAllSe.setOnClickListener(view1 -> {
            fabAllSe.setVisibility(View.GONE);
            fabAllUn.setVisibility(View.VISIBLE);
        });

        fabAllUn.setOnClickListener(view1 -> {
            fabAllUn.setVisibility(View.GONE);
            fabAllSe.setVisibility(View.VISIBLE);
        });

        return view;
    }

    private void cartDltClickHandler() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.aleartdialog_delete,null);
        Button cancelBtn = view.findViewById(R.id.cancelBtn);
        Button okBtn = view.findViewById(R.id.okBtn);
        builder.setView(view);
        final Dialog dialog = builder.create();
        dialog.show();

        okBtn.setOnClickListener(view1 -> {
            dialog.dismiss();
        });

        cancelBtn.setOnClickListener(view1 -> {
            dialog.dismiss();
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        cartDemo();
    }

    private void cartDemo() {
        Data data = new Data();

        cartRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        cartRecycler.setAdapter(new CartAd(getContext(),data.getCarts()));
    }

    private void backPressedHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
        MainActivity.btmNav.setSelectedItemId(R.id.home);
    }

    private void initial(View view) {
        MainActivity.btmCard.setVisibility(View.VISIBLE);
        MainActivity.fab.setVisibility(View.VISIBLE);
        cartBack = view.findViewById(R.id.cartBack);
        cartDlt = view.findViewById(R.id.cartDlt);
        fabAllSe = view.findViewById(R.id.fabAllSe);
        fabAllUn = view.findViewById(R.id.fabAllUn);
        cartCOut = view.findViewById(R.id.cartCOut);
        cartRecycler = view.findViewById(R.id.cartRecycler);
        cList = new ArrayList<>();
    }

    private void onBackPressed(View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i==KeyEvent.KEYCODE_BACK){
                    backPressedHandler();
                    return true;
                }
                return false;
            }
        });
    }
}