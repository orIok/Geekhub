package com.nemyrovskiy.o.geekhub.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nemyrovskiy.o.geekhub.ListData;
import com.nemyrovskiy.o.geekhub.R;

public class ListFrag extends ListFragment {
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

        ListContent listContent = new ListContent();

        getFragmentManager().beginTransaction().replace(R.id.list_conteiner, listContent).commit();

    }
}
