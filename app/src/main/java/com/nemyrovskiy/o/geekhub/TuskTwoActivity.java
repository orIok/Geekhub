package com.nemyrovskiy.o.geekhub;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TuskTwoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText facEdText;
    private TextView facText;

    public static int factorial(int n) {
        if (n > 10) return -1;
        int f = 1;
        for (int i = 1; i <= n; ++i) f *= i;
        return f;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tusktwo_activity);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        facEdText = (EditText) findViewById(R.id.fac_edittext);
        facText = (TextView) findViewById(R.id.fac_textview);

        findViewById(R.id.Factorial_button).setOnClickListener(this);
        findViewById(R.id.Fibonacci_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Factorial_button:
                int fa = factorial(Integer.parseInt(facEdText.getText().toString()));
                facText.setText(String.valueOf(fa));
                break;
            case R.id.Fibonacci_button:

                break;
        }

    }
}
