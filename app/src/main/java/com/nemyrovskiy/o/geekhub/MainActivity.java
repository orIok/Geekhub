package com.nemyrovskiy.o.geekhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_tuskone).setOnClickListener(this);
        findViewById(R.id.btn_tusktwo).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tuskone:
                startActivity(new Intent(MainActivity.this, TuskOneActivity.class));
                break;

            case R.id.btn_tusktwo:
                startActivity(new Intent(MainActivity.this, TuskTwoActivity.class));
                break;
        }
    }
}
