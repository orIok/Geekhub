package com.nemyrovskiy.o.geekhub;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class TaskOneActivity extends AppCompatActivity {

    AlertDialog.Builder addDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskone);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }


        final String COLOR_STATUSBAR = "colorS";
        final String COLOR_ACTIONBAR = "colorA";

        findViewById(android.R.id.content).setBackgroundColor(getResources().getColor(PreferenceManager.getDefaultSharedPreferences(this).getInt(COLOR_ACTIONBAR, android.R.color.background_light)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(PreferenceManager.getDefaultSharedPreferences(this).getInt(COLOR_STATUSBAR, android.R.color.background_light)));
        }

        addDialog = new AlertDialog.Builder(this);
        addDialog.setTitle("Chose color");

        final LinearLayout thisLayout = (LinearLayout) findViewById(R.id.taskone_frame);

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

                                                /*if (colorS == android.R.color.background_light) {
                            getWindow().setStatusBarColor(Color.BLACK);

                        }*/

                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(TaskOneActivity.this);


                        if (colorS == android.R.color.background_light) {
                            preferences.edit().remove(COLOR_STATUSBAR).apply();
                            preferences.edit().remove(COLOR_ACTIONBAR).apply();
                        } else {
                            preferences.edit().putInt(COLOR_STATUSBAR, colorS).apply();
                            preferences.edit().putInt(COLOR_ACTIONBAR, colorA).apply();
                        }

                        thisLayout.setBackgroundColor(getResources().getColor(colorA));
                        getWindow().setStatusBarColor(getResources().getColor(colorS));
                        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
                        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(PreferenceManager.getDefaultSharedPreferences(TaskOneActivity.this).getInt("colorA", android.R.color.background_light))));



                      /*  Intent intent = new Intent();
                        intent.putExtra(MainActivity.COLOR_EXTRA, color);
                        setResult(RESULT_OK, intent);*/

                       /* Toast.makeText(getApplicationContext(), "Выбраний колір: " + mColors[item],
                                Toast.LENGTH_SHORT).show();*/
                    }
                });

                addDialog.show();
            }
        });

        updateColor();

    }
/*
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "lalka", Toast.LENGTH_LONG).show();

    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    private void updateColor() {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        int colorStatusBar = getResources().getColor(PreferenceManager.getDefaultSharedPreferences(this).getInt("colorS", android.R.color.background_light));
        int colorActionBar = getResources().getColor(PreferenceManager.getDefaultSharedPreferences(this).getInt("colorA", android.R.color.background_light));
        findViewById(android.R.id.content).setBackgroundColor(colorActionBar);

        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(colorActionBar));
            getSupportActionBar().setElevation(0);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(colorStatusBar);
    }
}
