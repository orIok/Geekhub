package com.nemyrovskiy.o.geekhub;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

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

        findViewById(android.R.id.content).setBackgroundColor(PreferenceManager.getDefaultSharedPreferences(this).getInt("color", android.R.color.background_light));

        addDialog = new AlertDialog.Builder(this);
        addDialog.setTitle("Chose color");

        final LinearLayout secElement = (LinearLayout) findViewById(R.id.conteiner1);

        final Button button = (Button) findViewById(R.id.btn_color);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String[] mColors = {"brown", "blue", "orange", "default"};
                addDialog.setItems(mColors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        int color = 0;
                        switch (item) {
                            case 0:
                                color = Color.parseColor("#795548");
                                break;
                            case 1:
                                color = Color.parseColor("#448AFF");
                                break;
                            case 2:
                                color = Color.parseColor("#FF9800");
                                break;
                            case 3:
                                color = ContextCompat.getColor(TaskOneActivity.this, android.R.color.background_light);
                                break;
                        }
                        secElement.setBackgroundColor(color);
                        Intent intent = new Intent();
                        intent.putExtra(MainActivity.COLOR_EXTRA, color);
                        setResult(RESULT_OK, intent);
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(TaskOneActivity.this);

                        String key = "color";
                        if (color == android.R.color.background_light) {
                            preferences.edit().remove(key).apply();
                        } else {
                            preferences.edit().putInt(key, color).apply();
                        }
                        Toast.makeText(getApplicationContext(), "Выбраний колір: " + mColors[item],
                                Toast.LENGTH_SHORT).show();
                    }
                });

                addDialog.show();
            }
        });

    }
/*
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Idi nahui, lalka", Toast.LENGTH_LONG).show();

    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
