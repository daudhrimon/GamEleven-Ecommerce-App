package com.daud.gameleven;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class OnBoardActivity extends AppCompatActivity {
    private ViewPager onbViewPager;
    private ImageView dot1,dot2,dot3;
    private Button skipBtn;
    private ImageView[] dots;
    int Position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initial();

        onbViewPager.setAdapter(new OnBoardAdapter(OnBoardActivity.this));

        addDots(0);

        onbViewPager.addOnPageChangeListener(changeListener);

        skipBtn.setOnClickListener(view1 -> {
            skipBtnOnClick();
        });
    }

    private void skipBtnOnClick() {
        if (Position < 2){
            onbViewPager.setCurrentItem(Position+1);
        }else{
            startActivity(new Intent(OnBoardActivity.this,MainActivity.class));
            SplashActivity.editor.putBoolean("SKIP",true).commit();
            finish();
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
        @Override
        public void onPageSelected(int position) {
            Position = position;
            addDots(position);
        }
        @Override
        public void onPageScrollStateChanged(int state) {}
    };

    private void addDots(int position){
        switch (position){
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

    private void initial() {
        onbViewPager = findViewById(R.id.onbViewPager);
        skipBtn = findViewById(R.id.skipBtn);
        dot1 = findViewById(R.id.dot1);
        dot2 = findViewById(R.id.dot2);
        dot3 = findViewById(R.id.dot3);
    }
}