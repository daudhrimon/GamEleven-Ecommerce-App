package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.daud.gameleven.MainActivity;
import com.daud.gameleven.R;
import com.google.android.material.textfield.TextInputEditText;

public class FragSignIn extends Fragment {
    private EditText sInPhnEt;
    private TextInputEditText sInPassEt;
    private TextView forgotPass;
    private Button signInBtn,signUpBtn;
    private ImageButton sInBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_signin, container, false);

        initial(view);

        sInBack.setOnClickListener(view1 -> {
            backPressedHandler();
        });

        signInBtn.setOnClickListener(view1 ->  {
           signInBtnClickHandler();
        });

        signUpBtn.setOnClickListener(view1 -> {
            signUpBtnClickHandler();
        });

        return view;
    }

    private void signUpBtnClickHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragSignUp()).addToBackStack(null).commit();
    }

    private void signInBtnClickHandler() {
        if (sInPhnEt.getText().toString().isEmpty()){
            sInPhnEt.setError("Empty");
            sInPhnEt.requestFocus();
            return;
        }

        if (sInPassEt.getText().toString().isEmpty()){
            sInPassEt.setError("Empty");
            sInPassEt.requestFocus();
            return;
        }

        if (sInPassEt.getText().toString().length() < 6){
            sInPassEt.setError("Password is too Short");
            sInPassEt.requestFocus();
            return;
        }

        if (sInPassEt.getText().toString().equals("123456") && sInPassEt.getText().toString().equals("123456")){
            MainActivity.editor.putInt("SIGNIN",1).commit();
            getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragAccount()).commit();
        }
    }

    private void backPressedHandler() {
        getParentFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.mainFrame,new FragHome()).commit();
    }

    private void initial(View view) {
        MainActivity. fab.setVisibility(View.GONE);
        MainActivity.btmCard.setVisibility(View.GONE);
        ///////////////////////////////////////////////
        sInPhnEt = view.findViewById(R.id.sInPhnEt);
        sInPassEt = view.findViewById(R.id.sInPassEt);
        forgotPass = view.findViewById(R.id.forgotPass);
        signInBtn = view.findViewById(R.id.signInBtn);
        signUpBtn = view.findViewById(R.id.signUpBtn);
        sInBack = view.findViewById(R.id.sInBack);
    }
}