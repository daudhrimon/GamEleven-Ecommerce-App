package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.daud.gameleven.Activity.MainActivity;
import com.daud.gameleven.R;

public class FragSignUp extends Fragment {
    private Button signInBtn;
    private ImageButton sUpBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_signup, container, false);

        initial(view);

        sUpBack.setOnClickListener(view1 -> {
            backPressedHandler();
        });

        signInBtn.setOnClickListener(view1 -> {
            backPressedHandler();
        });

        return view;
    }

    private void backPressedHandler() {
        getParentFragmentManager().popBackStack();
    }

    private void initial(View view) {
        MainActivity.fab.setVisibility(View.GONE);
        MainActivity.btmCard.setVisibility(View.GONE);
        ////////////////////////////////////////////////
        signInBtn = view.findViewById(R.id.upSignInBtn);
        sUpBack = view.findViewById(R.id.sUpBack);
    }
}