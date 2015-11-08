package com.nemyrovskiy.o.geekhub;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class TaskFiveActivity extends AppCompatActivity implements Animation.AnimationListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskfive);

        updateColor();

        Button btn1 = (Button) findViewById(R.id.anim_1);
        Button btn2 = (Button) findViewById(R.id.anim_2);
        Button btn3 = (Button) findViewById(R.id.anim_3);
        Button btn4 = (Button) findViewById(R.id.anim_4);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animFadein;
                animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fade_in);
                TextView textView = (TextView) findViewById(R.id.text_anim);
                textView.setVisibility(View.VISIBLE);
                textView.startAnimation(animFadein);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animBlink;
                animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
                animBlink.setAnimationListener(TaskFiveActivity.this);
                TextView textView = (TextView) findViewById(R.id.text_anim);
                textView.setVisibility(View.VISIBLE);
                textView.startAnimation(animBlink);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animZoomIn;
                animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.zoom_in);
                animZoomIn.setAnimationListener(TaskFiveActivity.this);
                TextView textView = (TextView) findViewById(R.id.text_anim);
                textView.setVisibility(View.VISIBLE);
                textView.startAnimation(animZoomIn);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animRotate;
                animRotate = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.rotate);
                animRotate.setAnimationListener(TaskFiveActivity.this);
                TextView textView = (TextView) findViewById(R.id.text_anim);
                textView.setVisibility(View.VISIBLE);
                textView.startAnimation(animRotate);
            }
        });

    }


    private void updateColor() {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        int colorStatusBar = getResources().getColor(PreferenceManager.
                getDefaultSharedPreferences(this).getInt("colorS", android.R.color.background_dark));
        int colorActionBar = getResources().getColor(PreferenceManager.
                getDefaultSharedPreferences(this).getInt("colorA", android.R.color.background_light));
        /*findViewById(android.R.id.content).setBackgroundColor(colorActionBar);*/

        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(colorActionBar));
            //getSupportActionBar().setElevation(0);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(colorStatusBar);


    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub
    }


}
