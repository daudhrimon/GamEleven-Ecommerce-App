package com.daud.gameleven.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daud.gameleven.MainActivity;
import com.daud.gameleven.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FragCkOutInfo extends Fragment {
    private ImageButton backBtn;
    private TextView fullAdrs;
    private FloatingActionButton halfAdrs, addContact;
    private LinearLayout orderBtn, demo1, demo2; // demo 1 & 2 have to remove later //

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_ckoutinfo, container, false);

        initial(view);

        //showAddressBtmSheet();

        backBtn.setOnClickListener(view1 -> {
            backPressedHandler();
        });

        fullAdrs.setOnClickListener(view1 -> {
            fullAddressBtmSheet();
        });

        halfAdrs.setOnClickListener(view1 -> {
            halfAddressBtmSheet();
        });

        addContact.setOnClickListener(view1 -> {
            addContactBtmSheet();
        });

        orderBtn.setOnClickListener(view1 -> {
            getParentFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.mainFrame,new FragOrderDetails()).addToBackStack(null).commit();
        });

        /////////////////////////////////////////

        demo1.setOnClickListener(view1 -> {
            demoClick();
        });

        demo2.setOnClickListener(view1 -> {
            demoClick();
        });

        return view;
    }

    private void showAddressBtmSheet() {
        BottomSheetDialog btmSheet = new BottomSheetDialog(getContext(), R.style.AppBottomSheetDialogTheme);
        btmSheet.setContentView(R.layout.btmsheet_no_address);
        ImageButton backBtn = btmSheet.findViewById(R.id.addressBack);
        ImageButton plusBtn = btmSheet.findViewById(R.id.addressPlus);
        btmSheet.setCancelable(false);
        btmSheet.show();

        backBtn.setOnClickListener(view -> {
            backPressedHandler();
            btmSheet.dismiss();
        });

        plusBtn.setOnClickListener(view -> {
            btmSheet.dismiss();
        });

        btmSheet.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i==keyEvent.KEYCODE_BACK){
                    backPressedHandler();
                    btmSheet.dismiss();
                    return true;
                }
                return false;
            }
        });
    }

    private void fullAddressBtmSheet() {
        BottomSheetDialog btmSheet = new BottomSheetDialog(getContext(), R.style.AppBottomSheetDialogTheme);
        btmSheet.setContentView(R.layout.btmsheet_address_full);
        btmSheet.show();
    }

    private void halfAddressBtmSheet() {
        BottomSheetDialog btmSheet = new BottomSheetDialog(getContext(), R.style.AppBottomSheetDialogTheme);
        btmSheet.setContentView(R.layout.btmsheet_address_half);
        btmSheet.show();
    }

    private void addContactBtmSheet() {
        BottomSheetDialog btmSheet = new BottomSheetDialog(getContext(), R.style.AppBottomSheetDialogTheme);
        btmSheet.setContentView(R.layout.btmsheet_contact);
        btmSheet.show();
    }

    private void backPressedHandler() {
        getParentFragmentManager().popBackStack();
    }

    private void initial(View view) {
        MainActivity.fab.setVisibility(View.GONE);
        MainActivity.btmCard.setVisibility(View.GONE);
        /////////////////////////////////////////////
        backBtn = view.findViewById(R.id.cOutBack);
        fullAdrs = view.findViewById(R.id.fullAdrs);
        halfAdrs = view.findViewById(R.id.halfAdrs);
        addContact = view.findViewById(R.id.addContact);
        orderBtn = view.findViewById(R.id.orderBtn);
        demo1 = view.findViewById(R.id.demo1);
        demo2 = view.findViewById(R.id.demo2);
    }

    public void demoClick() {
        getParentFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.mainFrame, new FragProDetails()).addToBackStack(null).commit();
    }
}