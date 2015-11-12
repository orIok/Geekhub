package com.nemyrovskiy.o.geekhub.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nemyrovskiy.o.geekhub.R;

public class ListContent extends Fragment {


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.list_content, null);
        TextView textView = (TextView) v.findViewById(R.id.chem_descript);
        textView.setText("Chloroform is an organic compound with formula CHCl3. It is a colorless," +
                " sweet-smelling, dense liquid that is produced on a large scale as a precursor to " +
                "PTFE and refrigerants, but the latter application is declining." +
                " It is one of the four chloromethanes and a trihalomethane.");

        return inflater.inflate(R.layout.list_content, container, false);
    }
}
