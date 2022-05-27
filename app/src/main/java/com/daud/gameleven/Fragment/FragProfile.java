package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

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
        View view = inflater.inflate(R.layout.frag_profile, container, false);

        initial(view);

        backBtn.setOnClickListener(view1 -> {
            backBtnClickHandler();
        });

        personEtv.setOnClickListener(view1 -> {
            personEtvClickHandler();
        });

        emailEtv.setOnClickListener(view1 -> {
            emailEtvClickHandler();
        });

        return view;
    }

    private void backBtnClickHandler() {
        getParentFragmentManager().popBackStack();
        MainActivity.btmNav.setVisibility(View.VISIBLE);
        MainActivity.fab.setVisibility(View.VISIBLE);
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

    private void initial(View view) {
        personEtv = view.findViewById(R.id.personEtv);
        emailEtv = view.findViewById(R.id.emailEtv);
        backBtn = view.findViewById(R.id.profileBack);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getParentFragmentManager().popBackStack("PR", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        MainActivity.btmNav.setVisibility(View.VISIBLE);
        MainActivity.fab.setVisibility(View.VISIBLE);
    }
}