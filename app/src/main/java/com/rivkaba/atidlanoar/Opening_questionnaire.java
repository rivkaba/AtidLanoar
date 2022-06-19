package com.rivkaba.atidlanoar;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.widget.TabHost;

public class Opening_questionnaire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_questionnaire);
        TabHost tabHost=(TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
//tab1
        TabHost.TabSpec spec= tabHost.newTabSpec("חלק א'");
        spec.setContent(R.id.tab1);
        spec.setIndicator("חלק א'");
        tabHost.addTab(spec);
        //tab2
        spec= tabHost.newTabSpec("חלק ב");
        spec.setContent(R.id.tab2);
        spec.setIndicator("חלק ב");
        tabHost.addTab(spec);
        //tab3
        spec= tabHost.newTabSpec("חלק ג");
        spec.setContent(R.id.tab3);
        spec.setIndicator("חלג ג");
        tabHost.addTab(spec);
        //tab4
        spec= tabHost.newTabSpec("חלק ד");
        spec.setContent(R.id.tab4);
        spec.setIndicator("חלק ד");
        tabHost.addTab(spec);


    }
}