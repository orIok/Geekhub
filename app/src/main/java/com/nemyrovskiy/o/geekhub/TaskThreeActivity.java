package com.nemyrovskiy.o.geekhub;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TaskThreeActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] values = new String[]{"Android", "iPhone", "WindowsMobile", "Blackberry",
            "Ubuntu", "Windows7", "Mac OS X", "Linux", "Ubuntu", "Windows7", "Mac OS X", "Linux",
            "Ubuntu", "Windows7", "Android", "iPhone", "WindowsMobile"};

    private TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskthree);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        findViewById(android.R.id.content).setBackgroundColor(PreferenceManager.getDefaultSharedPreferences(this).getInt("color", android.R.color.background_light));


        textView1 = (TextView) findViewById(R.id.textview_taskthree1);
        textView2 = (TextView) findViewById(R.id.textview_taskthree2);

        textView1.setText((Arrays.toString(values).replaceAll("\\[|\\]", "")));


        findViewById(R.id.button_t_three1).setOnClickListener(this);
        findViewById(R.id.button_t_three2).setOnClickListener(this);
        findViewById(R.id.button_t_three3).setOnClickListener(this);
        findViewById(R.id.button_t_three4).setOnClickListener(this);
        findViewById(R.id.textview_taskthree2).setOnClickListener(this);
    }


    private void task1() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(values));
        Collections.reverse(list);
        String result = TextUtils.join(", ", list);
        textView2.setText(result);
    }

    private void task2() {
        List<String> list = new LinkedList<>(Arrays.asList(values));

        for (String s : list) {
            Log.i("", s);
        }
        ListIterator<String> iterator = list.listIterator();
        for (int i = 1; i < list.size() + 3; i++) {
            iterator.next();
            if (i % 3 == 0) iterator.remove();
        }

        String result = TextUtils.join(", ", list);
        textView2.setText(result);
    }

    private void task3() {
        HashSet<String> list = new HashSet<>(Arrays.asList(values));
        String result = TextUtils.join(", ", list);
        textView2.setText(result);
    }

    private void task4() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(values));
        Collections.sort(list);
        String result = TextUtils.join(", ", list);
        textView2.setText(result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_t_three1:
                task1();
                break;

            case R.id.button_t_three2:
                task2();
                break;

            case R.id.button_t_three3:
                task3();
                break;

            case R.id.button_t_three4:
                task4();
                break;

            case R.id.textview_taskthree2:
                textView2.setText(null);
                break;

        }
    }


}
