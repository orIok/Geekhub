package com.nemyrovskiy.o.geekhub;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
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

        final String keyS = "colorS";
        final String keyA = "colorA";

        findViewById(android.R.id.content).setBackgroundColor(getResources().getColor(PreferenceManager.getDefaultSharedPreferences(this).getInt(keyA, android.R.color.background_light)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(PreferenceManager.getDefaultSharedPreferences(this).getInt(keyS, android.R.color.background_light)));
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
                        ;
                        int colorA = R.color.colorBrownA;
                        ;
                        switch (item) {
                            case 0:
                                colorS = R.color.colorBrownS;
                                colorA = R.color.colorBrownA;
                                break;
                            case 1:
                                colorS = R.color.colorBlueS;
                                colorA = R.color.colorBlueS;
                                break;
                            case 2:
                                colorS = R.color.colorOrangeS;
                                colorA = R.color.colorOrangeS;
                                break;
                            case 3:
                                colorS = ContextCompat.getColor(TaskOneActivity.this, android.R.color.background_light);
                                colorA = ContextCompat.getColor(TaskOneActivity.this, android.R.color.background_light);
                                break;
                        }


                        thisLayout.setBackgroundColor(getResources().getColor(colorA));
                        getWindow().setStatusBarColor(getResources().getColor(colorS));
                        if (colorS == android.R.color.background_light)
                            getWindow().setStatusBarColor(Color.BLACK);


                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(TaskOneActivity.this);


                        if (colorS == android.R.color.background_light) {
                            preferences.edit().remove(keyS).apply();
                            preferences.edit().remove(keyA).apply();
                        } else {
                            preferences.edit().putInt(keyS, colorS).apply();
                            preferences.edit().putInt(keyA, colorA).apply();
                        }


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
}
