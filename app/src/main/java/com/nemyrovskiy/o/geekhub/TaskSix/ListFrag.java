package com.nemyrovskiy.o.geekhub.TaskSix;

import android.app.ListFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFrag extends ListFragment {

    private static final String POSITION = "POSITION";

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListData listData = new ListData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, listData.dataS);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        SharedPreferences preferences = PreferenceManager.
                getDefaultSharedPreferences(getActivity());
        preferences.edit().putInt(POSITION, position).apply();

        startActivity(new Intent(getActivity(), TaskSixContentActivity.class));

    }
}
