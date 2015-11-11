package com.nemyrovskiy.o.geekhub;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class TaskOneActivity extends AppCompatActivity {

    AlertDialog.Builder addDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskone);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        final String COLOR_STATUSBAR = "colorS";
        final String COLOR_ACTIONBAR = "colorA";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(PreferenceManager.
                    getDefaultSharedPreferences(this).
                    getInt(COLOR_STATUSBAR, android.R.color.background_light)));
        }

        addDialog = new AlertDialog.Builder(this);
        addDialog.setTitle("Chose color");

        final Button button = (Button) findViewById(R.id.btn_color);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String[] mColors = {"brown", "blue", "orange", "default"};
                addDialog.setItems(mColors, new DialogInterface.OnClickListener() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        int colorS = R.color.colorBrownS;
                        int colorA = R.color.colorBrownA;

                        switch (item) {
                            case 0:
                                colorS = R.color.colorBrownS;
                                colorA = R.color.colorBrownA;
                                updateColor();
                                break;
                            case 1:
                                colorS = R.color.colorBlueS;
                                colorA = R.color.colorBlueA;
                                updateColor();
                                break;
                            case 2:
                                colorS = R.color.colorOrangeS;
                                colorA = R.color.colorOrangeA;
                                updateColor();
                                break;
                            case 3:
                                colorS = android.R.color.background_dark;
                                colorA = android.R.color.background_light;
                                updateColor();
                                break;
                        }
                        updateColor();

                        SharedPreferences preferences = PreferenceManager.
                                getDefaultSharedPreferences(TaskOneActivity.this);

                        if (colorS == android.R.color.background_light) {
                            preferences.edit().remove(COLOR_STATUSBAR).apply();
                            preferences.edit().remove(COLOR_ACTIONBAR).apply();
                        } else {
                            preferences.edit().putInt(COLOR_STATUSBAR, colorS).apply();
                            preferences.edit().putInt(COLOR_ACTIONBAR, colorA).apply();
                        }

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                            getWindow().setStatusBarColor(getResources().getColor(colorS));

                        updateColor();
                    }
                });

                addDialog.show();

            }
        });

        updateColor();
    }


    private void updateColor() {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        int colorStatusBar = getResources().getColor(PreferenceManager.
                getDefaultSharedPreferences(this).getInt("colorS", android.R.color.background_dark));
        int colorActionBar = getResources().getColor(PreferenceManager.
                getDefaultSharedPreferences(this).getInt("colorA", android.R.color.background_light));

        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(colorActionBar));
            //getSupportActionBar().setElevation(0);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(colorStatusBar);
    }

}
