package com.daud.gameleven;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import javax.xml.validation.Validator;

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
            sInBackClickHandler();
        });

        signInBtn.setOnClickListener(view1 ->  {
           signInBtnClickHandler();
        });

        signUpBtn.setOnClickListener(view1 -> {
            signUpBtnClickHandler();
        });

        return view;
    }

    private void sInBackClickHandler() {
        MainActivity.btmCard.setVisibility(View.VISIBLE);
        MainActivity.fab.setVisibility(View.VISIBLE);
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragHome()).commit();
        MainActivity.btmNav.setSelectedItemId(R.id.home);
    }

    private void signUpBtnClickHandler() {
        getParentFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragSignUp()).commit();
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
            MainActivity.btmCard.setVisibility(View.VISIBLE);
            MainActivity.fab.setVisibility(View.VISIBLE);
        }
    }

    private void initial(View view) {
        sInPhnEt = view.findViewById(R.id.sInPhnEt);
        sInPassEt = view.findViewById(R.id.sInPassEt);
        forgotPass = view.findViewById(R.id.forgotPass);
        signInBtn = view.findViewById(R.id.signInBtn);
        signUpBtn = view.findViewById(R.id.signUpBtn);
        sInBack = view.findViewById(R.id.sInBack);
    }
}