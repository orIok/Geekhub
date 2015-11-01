package com.nemyrovskiy.o.geekhub.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nemyrovskiy.o.geekhub.R;
import com.nemyrovskiy.o.geekhub.abstractC.interfaces;

public class firstFragm extends Fragment implements View.OnClickListener {
    interfaces myInterface;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            myInterface = (interfaces) context;
        } catch (ClassCastException ex) {

        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button11).setOnClickListener(this);
        view.findViewById(R.id.button21).setOnClickListener(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button11:
                myInterface.ShowNext();
                break;
            case R.id.button21:
                myInterface.ShowPrev();
                break;
        }
    }
}
