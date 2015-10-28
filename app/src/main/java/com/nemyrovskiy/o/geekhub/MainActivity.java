package com.nemyrovskiy.o.geekhub;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

// TODO: 28.10.2015 Перепілити всьо під стрінги, добавити лендскейп, добавити свої теми для кожного кольору,
// допілить зафарбовування екшн і статусбара, удалити тоаст з 2го актівіті

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String COLOR_EXTRA = "color";
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateColor();

        findViewById(R.id.btn_tuskone).setOnClickListener(this);
        findViewById(R.id.btn_tusktwo).setOnClickListener(this);
        findViewById(R.id.btn_tuskthree).setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateColor();
    }

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

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (data == null) return;
                int color = data.getIntExtra(COLOR_EXTRA, android.R.color.background_light);
                break;
        }
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tuskone:
                startActivityForResult(new Intent(this, TaskOneActivity.class), REQUEST_CODE);
                break;

            case R.id.btn_tusktwo:
                Intent intent = new Intent(this, TaskTwoActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_tuskthree:
                startActivity(new Intent(this, TaskThreeActivity.class));
                break;
        }
    }
}
