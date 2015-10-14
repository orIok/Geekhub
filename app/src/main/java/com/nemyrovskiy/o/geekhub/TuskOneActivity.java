package com.nemyrovskiy.o.geekhub;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TuskOneActivity extends AppCompatActivity {

    AlertDialog.Builder ad;
    Context context;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuskone_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = TuskOneActivity.this;
        ad = new AlertDialog.Builder(context);
        ad.setTitle("Chose color");
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        final LinearLayout secElement = (LinearLayout) findViewById(R.id.conteiner1);

        final Button button = (Button) findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final String[] mColors = {"brown", "blue", "orange"};


                builder.setTitle("Chose color");

                ad.setItems(mColors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                //window.setStatusBarColor(getResources().getColor(R.color.colorBrown));
                                secElement.setBackgroundColor(Color.parseColor("#795548"));
                                //ActionBar bar = getActionBar();
                                //getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.colorBrown));
                                //bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#795548")));
                                break;
                            case 1:
                                //window.setStatusBarColor(getResources().getColor(R.color.colorBlue));
                                secElement.setBackgroundColor(Color.parseColor("#448AFF"));
                                break;
                            case 2:
                                //window.setStatusBarColor(getResources().getColor(R.color.colorOrange));
                                secElement.setBackgroundColor(Color.parseColor("#FF9800"));
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
