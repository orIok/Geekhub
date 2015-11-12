package com.nemyrovskiy.o.geekhub.abstractC;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.nemyrovskiy.o.geekhub.R;
import com.nemyrovskiy.o.geekhub.fragments.firstFragm4;


public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isAddFragment()) {
            setContentView(R.layout.fragm_activity);
            addFragment();
        } else
            setContentView(R.layout.clean_activity);

    }

    public abstract boolean isAddFragment();

    public void addFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.fr1, new firstFragm4()).commit();

    }


}