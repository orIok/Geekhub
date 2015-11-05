package com.nemyrovskiy.o.geekhub.animations;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.nemyrovskiy.o.geekhub.R;

public class ZoomInActivity extends Activity implements AnimationListener {

    TextView imgPoster;
    Button btnStart;

    Animation animZoomIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_activity);

        imgPoster = (TextView) findViewById(R.id.anim_text);
        btnStart = (Button) findViewById(R.id.anim_button);

        animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_in);

        animZoomIn.setAnimationListener(this);

        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imgPoster.startAnimation(animZoomIn);
            }
        });

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
