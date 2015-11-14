package com.nemyrovskiy.o.geekhub.TaskSix;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.nemyrovskiy.o.geekhub.R;

public class TaskSixActivity extends AppCompatActivity implements ListFrag.ListCallback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
           setContentView(R.layout.activity_six);
        } else {
           setContentView(R.layout.activity_six);
        }*/

        setContentView(R.layout.activity_six);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        ListFrag listFrag = new ListFrag();

        getFragmentManager().beginTransaction().replace(R.id.list_conteiner_horizontal, listFrag).commit();
//        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
//        }

        updateColor();


    }

    @Override
    public void onClicked(int position) {
        ListContent listContent = new ListContent();
        getFragmentManager().beginTransaction().replace(R.id.list_contnt_horizontal, listContent).commit();
    }

    private void updateColor() {

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        int colorStatusBar = getResources().getColor(PreferenceManager.
                getDefaultSharedPreferences(this).getInt("colorS", android.R.color.background_dark));
        int colorActionBar = getResources().getColor(PreferenceManager.
                getDefaultSharedPreferences(this).getInt("colorA", android.R.color.background_light));

        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(colorActionBar));
            /*getSupportActionBar().setElevation(0);*/
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(colorStatusBar);
    }

}
