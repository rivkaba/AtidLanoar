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
        TabHost.TabSpec spec= tabHost.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Tab One");
        tabHost.addTab(spec);
        //tab2
        spec= tabHost.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Tab Two");
        tabHost.addTab(spec);
        //tab3
        spec= tabHost.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Tab Three");
        tabHost.addTab(spec);
        //tab4
        spec= tabHost.newTabSpec("Tab four");
        spec.setContent(R.id.tab4);
        spec.setIndicator("Tab four");
        tabHost.addTab(spec);


    }
}