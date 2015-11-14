package com.nemyrovskiy.o.geekhub.TaskSix;

import android.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nemyrovskiy.o.geekhub.R;

public class ListContent extends Fragment {
    Bundle bundle;
    TextView tView;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        bundle = getArguments();

        /*View v = inflater.inflate(R.layout.content_fragm_tasksix, null);
        TextView textView = (TextView) v.findViewById(R.id.chem_descript);
        textView.setText("Chloroform is an organic compound with formula CHCl3. It is a colorless," +
                " sweet-smelling, dense liquid that is produced on a large scale as a precursor to " +
                "PTFE and refrigerants, but the latter application is declining." +
                " It is one of the four chloromethanes and a trihalomethane.");

        textView.setText("123");*/

        return inflater.inflate(R.layout.content_fragm_tasksix, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListData listData = new ListData();
        tView = (TextView) view.findViewById(R.id.content_view);
        int i = PreferenceManager.
                getDefaultSharedPreferences(getActivity()).getInt(ListFrag.POSITION, 0);
        tView.setText(listData.dataC[i]);
    }
}
