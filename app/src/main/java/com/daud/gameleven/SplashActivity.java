package com.daud.gameleven;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private ImageView spImg;
    private FrameLayout spFrame;
    public static SharedPreferences getPreferences;
    public static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initial();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getPreferences.getInt("SKIP",0)==1){
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }else {
                    Animation fadeoutAnim = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fade_out);
                    spImg.startAnimation(fadeoutAnim);
                    spFrame.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                            .replace(R.id.spFrame,new OnBoardingFrag()).commit();
                    spImg.setVisibility(View.GONE);
                }
            }
        }, 2000);
    }

    private void initial() {
        spImg = findViewById(R.id.spImg);
        spFrame = findViewById(R.id.spFrame);
        getPreferences = getSharedPreferences("MySp",MODE_PRIVATE);
        editor = getPreferences.edit();
    }
}