package com.daud.gameleven.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.daud.gameleven.MainActivity;
import com.daud.gameleven.Activity.SplashActivity;
import com.daud.gameleven.Adapter.OnBoardAd;
import com.daud.gameleven.R;

public class FragOnBoarding extends Fragment {
    private ViewPager onbViewPager;
    private ImageView dot1, dot2, dot3;
    private Button skipBtn;
    private ImageView[] dots;
    int Position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_onboarding, container, false);

        initial(view);

        onbViewPager.setAdapter(new OnBoardAd(getContext()));

        addDots(0);

        onbViewPager.addOnPageChangeListener(changeListener);

        skipBtn.setOnClickListener(view1 -> {
            skipBtnOnClick();
        });

        return view;
    }

    private void skipBtnOnClick() {
        if (Position < 2) {
            onbViewPager.setCurrentItem(Position + 1);
        } else {
            SplashActivity.editor.putInt("RUN", 1).commit();
            startActivity(new Intent(getContext(), MainActivity.class));
            getActivity().finish();
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            Position = position;
            addDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    private void addDots(int position) {
        switch (position) {
            case 0:
                dot1.setImageResource(R.drawable.dot_selected);
                dot2.setImageResource(R.drawable.dot_unselected);
                dot3.setImageResource(R.drawable.dot_unselected);
                break;
            case 1:
                dot1.setImageResource(R.drawable.dot_unselected);
                dot2.setImageResource(R.drawable.dot_selected);
                dot3.setImageResource(R.drawable.dot_unselected);
                break;
            case 2:
                dot1.setImageResource(R.drawable.dot_unselected);
                dot2.setImageResource(R.drawable.dot_unselected);
                dot3.setImageResource(R.drawable.dot_selected);
                break;
            default:
                break;
        }
    }

    private void initial(View view) {
        onbViewPager = view.findViewById(R.id.onbViewPager);
        skipBtn = view.findViewById(R.id.skipBtn);
        dot1 = view.findViewById(R.id.dot1);
        dot2 = view.findViewById(R.id.dot2);
        dot3 = view.findViewById(R.id.dot3);
    }
}