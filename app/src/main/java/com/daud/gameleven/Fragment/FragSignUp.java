package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
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
        MainActivity. fab.setVisibility(View.GONE);
        MainActivity.btmCard.setVisibility(View.GONE);
        View view = inflater.inflate(R.layout.frag_signup, container, false);

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
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        ////////////////////////////////////////////////
        signInBtn = view.findViewById(R.id.upSignInBtn);
        sUpBack = view.findViewById(R.id.sUpBack);
    }
}