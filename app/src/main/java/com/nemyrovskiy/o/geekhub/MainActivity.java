package com.nemyrovskiy.o.geekhub;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    AlertDialog.Builder ad;
    Context context;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        context = MainActivity.this;
        ad = new AlertDialog.Builder(context);
        ad.setTitle("Chose color");
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);


        final Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        final LinearLayout bgElement = (LinearLayout) findViewById(R.id.conteiner);


        final Button button = (Button) findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final String[] mColors = {"brown", "blue", "orange"};


                builder.setTitle("Chose color");

                ad.setItems(mColors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0: window.setStatusBarColor(getResources().getColor(R.color.colorBrown));
                              bgElement.setBackgroundColor(Color.parseColor("#795548"));
                                break;
                            case 1: window.setStatusBarColor(getResources().getColor(R.color.colorBlue));
                                bgElement.setBackgroundColor(Color.parseColor("#448AFF"));
                                break;
                            case 2: window.setStatusBarColor(getResources().getColor(R.color.colorOrange));
                                bgElement.setBackgroundColor(Color.parseColor("#FF9800"));
                                break;
                        }
                        Toast.makeText(getApplicationContext(),
                                "Выбраний колір: " + mColors[item],
                                Toast.LENGTH_SHORT).show();
                    }
                });
                ad.show();

                builder.setCancelable(false);

            }
        });
    }

}
