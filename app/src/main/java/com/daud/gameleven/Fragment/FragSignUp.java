package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.daud.gameleven.MainActivity;
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
            onBackPressedHandler();
        });

        signInBtn.setOnClickListener(view1 -> {
            onBackPressedHandler();
        });

        return view;
    }

    private void onBackPressedHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragSignIn()).commit();
    }

    private void initial(View view) {
        signInBtn = view.findViewById(R.id.upSignInBtn);
        sUpBack = view.findViewById(R.id.sUpBack);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onBackPressedHandler();
    }
}