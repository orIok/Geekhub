package com.nemyrovskiy.o.geekhub.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nemyrovskiy.o.geekhub.R;

public class secFragm4 extends android.support.v4.app.Fragment {
    TextView tView;
    Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        bundle = getArguments();
        return inflater.inflate(R.layout.frgment_two, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tView = (TextView) view.findViewById(R.id.textView21);
        tView.setText(bundle.getString("t1"));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}