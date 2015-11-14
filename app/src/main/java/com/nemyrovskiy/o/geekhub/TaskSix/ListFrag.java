package com.nemyrovskiy.o.geekhub.TaskSix;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFrag extends ListFragment {

    public static final String POSITION = "POSITION";
    private ListCallback callback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (ListCallback) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("ftgyhuijk");
        }
    }

    @Override
    public void onDetach() {
        callback = null;
        super.onDetach();
    }

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

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (callback != null) {
                callback.onClicked(position);
            }
        } else {
            startActivity(new Intent(getActivity(), TaskSixContentActivity.class));
        }



    }

    interface ListCallback {
        void onClicked(int position);
    }
}
