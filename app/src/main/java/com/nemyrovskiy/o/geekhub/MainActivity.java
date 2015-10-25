package com.nemyrovskiy.o.geekhub;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String COLOR_EXTRA = "color";
    public static final int REQUEST_CODE = 1;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateColor();

        findViewById(R.id.btn_tuskone).setOnClickListener(this);
        findViewById(R.id.btn_tusktwo).setOnClickListener(this);
        findViewById(R.id.btn_tuskthree).setOnClickListener(this);
        findViewById(R.id.test).setOnClickListener(this);
        b = (Button) findViewById(R.id.test);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateColor();
    }

    private void updateColor() {
        findViewById(android.R.id.content).setBackgroundColor(PreferenceManager.getDefaultSharedPreferences(this).getInt("color", android.R.color.background_light));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        b.setText("xyi");
        switch (requestCode) {
            case REQUEST_CODE:
                if (data == null) return;
                int color = data.getIntExtra(COLOR_EXTRA, android.R.color.background_light);

//                Toast.makeText(getApplicationContext(), "XYIXYIXYI", Toast.LENGTH_LONG).show();
                break;
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tuskone:
                startActivityForResult(new Intent(this, TaskOneActivity.class), REQUEST_CODE);
                break;

            case R.id.btn_tusktwo:
                Intent intent = new Intent(this, TaskTwoActivity.class);
                intent.putExtra("KEY", "VALUE");
                startActivity(intent);
                break;

            case R.id.btn_tuskthree:
                startActivity(new Intent(this, TaskThreeActivity.class));
                break;
        }
    }
}
