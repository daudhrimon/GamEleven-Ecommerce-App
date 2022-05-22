package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.daud.gameleven.Activity.MainActivity;
import com.daud.gameleven.R;

public class FragAccount extends Fragment {
    private ImageButton accountBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_account, container, false);

        initial(view);

        accountBack.setOnClickListener(view1 -> {
            accountBackClickHandler();
        });
        return view;
    }

    private void accountBackClickHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome()).commit();
        MainActivity.btmNav.setSelectedItemId(R.id.home);
    }

    private void initial(View view) {
        accountBack = view.findViewById(R.id.accountBack);
    }
}