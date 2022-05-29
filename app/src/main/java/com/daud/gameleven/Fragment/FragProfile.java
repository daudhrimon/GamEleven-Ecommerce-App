package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.daud.gameleven.MainActivity;
import com.daud.gameleven.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class FragProfile extends Fragment {
    private ImageButton backBtn;
    private TextView personEtv,emailEtv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity. fab.setVisibility(View.GONE);
        MainActivity.btmCard.setVisibility(View.GONE);
        View view = inflater.inflate(R.layout.frag_profile, container, false);

        initial(view);

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

        backBtn.setOnClickListener(view1 -> {
            backPressedHandler();
        });

        personEtv.setOnClickListener(view1 -> {
            personEtvClickHandler();
        });

        emailEtv.setOnClickListener(view1 -> {
            emailEtvClickHandler();
        });

        return view;
    }

    private void personEtvClickHandler() {
        BottomSheetDialog btmSheet =  new BottomSheetDialog(getContext(),R.style.AppBottomSheetDialogTheme);
        btmSheet.setContentView(R.layout.btmsheet_personalinfo);
        btmSheet.show();
    }

    private void emailEtvClickHandler() {
        BottomSheetDialog btmSheet =  new BottomSheetDialog(getContext(),R.style.AppBottomSheetDialogTheme);
        btmSheet.setContentView(R.layout.btmsheet_email);
        btmSheet.show();
    }

    private void backPressedHandler() {
        getParentFragmentManager().popBackStack();
    }

    private void initial(View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        //////////////////////////////////////////////
        personEtv = view.findViewById(R.id.personEtv);
        emailEtv = view.findViewById(R.id.emailEtv);
        backBtn = view.findViewById(R.id.profileBack);
    }
}