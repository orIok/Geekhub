package com.nemyrovskiy.o.geekhub;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nemyrovskiy.o.geekhub.animations.FadeInActivity;

public class TaskFiveActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskfive);

        updateColor();

        Button btn1 = (Button) findViewById(R.id.anim_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TaskFiveActivity.this, FadeInActivity.class);
                startActivity(i);
            }
        });

    }


    private void updateColor() {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        int colorStatusBar = getResources().getColor(PreferenceManager.getDefaultSharedPreferences(this).getInt("colorS", android.R.color.background_dark));
        int colorActionBar = getResources().getColor(PreferenceManager.getDefaultSharedPreferences(this).getInt("colorA", android.R.color.background_light));
        findViewById(android.R.id.content).setBackgroundColor(colorActionBar);

        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(colorActionBar));
            //getSupportActionBar().setElevation(0);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(colorStatusBar);


    }


}
