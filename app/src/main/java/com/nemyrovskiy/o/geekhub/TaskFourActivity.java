package com.nemyrovskiy.o.geekhub;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;

import com.nemyrovskiy.o.geekhub.abstractC.BaseActivity;
import com.nemyrovskiy.o.geekhub.abstractC.interfaces;
import com.nemyrovskiy.o.geekhub.fragments.secFragm;

public class TaskFourActivity extends BaseActivity implements interfaces {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isAddFragment())
            setContentView(R.layout.fragm_activity);

        updateColor();
    }

    @Override
    public boolean isAddFragment() {
        return true;
    }

    @Override
    public void ShowNext() {
        FragmentManager manager = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString("t1", "next");
        secFragm fragment = new secFragm();
        fragment.setArguments(bundle);
        manager.beginTransaction().replace(R.id.tr2, fragment).commit();
    }

    @Override
    public void ShowPrev() {
        FragmentManager manager = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putString("t1", "previous");
        secFragm fragment = new secFragm();
        fragment.setArguments(bundle);
        manager.beginTransaction().replace(R.id.tr2, fragment).commit();
    }

    private void updateColor() {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        int colorStatusBar = getResources().getColor(PreferenceManager.
                getDefaultSharedPreferences(this).getInt("colorS", android.R.color.background_dark));
        int colorActionBar = getResources().getColor(PreferenceManager.
                getDefaultSharedPreferences(this).getInt("colorA", android.R.color.background_light));
        findViewById(android.R.id.content).setBackgroundColor(colorActionBar);

        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(colorActionBar));
            //getSupportActionBar().setElevation(0);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(colorStatusBar);

    }


}

