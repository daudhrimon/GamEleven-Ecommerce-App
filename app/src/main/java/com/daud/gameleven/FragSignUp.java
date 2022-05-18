package com.daud.gameleven;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class FragSignUp extends Fragment {
    private Button signInBtn;
    private ImageButton sUpBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_signup, container, false);

        initial(view);

        sUpBack.setOnClickListener(view1 -> {
            sUpBackClickHandler();
        });

        signInBtn.setOnClickListener(view1 -> {
            signInBtnClickHandler();
        });

        return view;
    }

    private void sUpBackClickHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome()).commit();
        MainActivity.btmNav.setSelectedItemId(R.id.home);
        MainActivity.btmCard.setVisibility(View.VISIBLE);
        MainActivity.fab.setVisibility(View.VISIBLE);
    }

    private void signInBtnClickHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragSignIn()).commit();
    }

    private void initial(View view) {
        signInBtn = view.findViewById(R.id.upSignInBtn);
        sUpBack = view.findViewById(R.id.sUpBack);
    }
}