package com.nemyrovskiy.o.geekhub;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TaskTwoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edText;
    private TextView textView;


    public static int factorial(int n) {
        if (n > 10) return -1;
        int f = 1;
        for (int i = 1; i <= n; ++i) f *= i;
        return f;
    }

    static int fib(int n) {
        if (n > 9) return -1;
        return n > 1 ? fib(n - 1) + fib(n - 2) : n;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasktwo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        /*ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        findViewById(android.R.id.content).setBackgroundColor(PreferenceManager.
                getDefaultSharedPreferences(this).getInt("color", android.R.color.background_light));*/

        edText = (EditText) findViewById(R.id.edittext_fib);
        textView = (TextView) findViewById(R.id.textview_fib);

        findViewById(R.id.btn_factorial).setOnClickListener(this);
        findViewById(R.id.btn_fibonacci).setOnClickListener(this);
        updateColor();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_factorial:
                try {
                    textView.setText
                            (String.valueOf(factorial(Integer.parseInt
                                    (edText.getText().toString()))));

                    if (factorial(Integer.parseInt(edText.getText().toString())) == -1)
                        textView.setText("завелике число");

                } catch (Exception ex) {
                    textView.setText("введіть ціле число");
                }
                break;

            case R.id.btn_fibonacci:
                try {
                    if (textView.getText() != null) {
                        textView.setText
                                (String.valueOf(fib(Integer.parseInt
                                        (edText.getText().toString()) - 1)));
                    }

                    if (fib(Integer.parseInt(edText.getText().toString()) - 1) == -1)
                        textView.setText("завелике число");
                } catch (Exception ex) {
                    textView.setText("введіть ціле число");
                }
                break;
        }

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
