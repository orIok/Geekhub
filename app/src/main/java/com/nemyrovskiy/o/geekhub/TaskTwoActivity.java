package com.nemyrovskiy.o.geekhub;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TaskTwoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText facEdText, fibEdText;
    private TextView facText, fibText;

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
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        findViewById(android.R.id.content).setBackgroundColor(PreferenceManager.
                getDefaultSharedPreferences(this).getInt("color", android.R.color.background_light));

        facEdText = (EditText) findViewById(R.id.edittext_fac);
        facText = (TextView) findViewById(R.id.textview_fac);

        fibEdText = (EditText) findViewById(R.id.edittext_fib);
        fibText = (TextView) findViewById(R.id.textview_fib);

        findViewById(R.id.btn_factorial).setOnClickListener(this);
        findViewById(R.id.btn_fibonacci).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_factorial:
                try {
                    facText.setText
                            (String.valueOf(factorial(Integer.parseInt(facEdText.getText().toString()))));

                    if (factorial(Integer.parseInt(facEdText.getText().toString())) == -1)
                        facText.setText("завелике число");

                } catch (Exception ex) {
                    facText.setText("введіть ціле число");
                }
                break;

            case R.id.btn_fibonacci:
                try {
                    if (fibText.getText() != null) {
                        fibText.setText
                                (String.valueOf(fib(Integer.parseInt(fibEdText.getText().toString()) - 1)));
                    }

                    if (fib(Integer.parseInt(fibEdText.getText().toString()) - 1) == -1)
                        fibText.setText("завелике число");
                } catch (Exception ex) {
                    fibText.setText("введіть ціле число");
                }
                break;
        }

    }
}