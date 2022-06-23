package com.rivkaba.atidlanoar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class Opening_questionnaire extends AppCompatActivity {
   // public TextView textView1=(TextView) findViewById(R.id.textVie1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_questionnaire);

//        TabHost tabHost=(TabHost) findViewById(R.id.tabHost);
//        tabHost.setup();
////tab1
//        TabHost.TabSpec spec= tabHost.newTabSpec("חלק א'");
//        spec.setContent(R.id.tab1);
//        spec.setIndicator("חלק א'");
//        Spinner dynamicSpinner = (Spinner) findViewById(R.id.age_spinner);
//
//        String[] items = new String[] { "15", "16 ", "17" ,"18","19"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, items);
//
//        dynamicSpinner.setAdapter(adapter);
//
//        dynamicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view,
//                                       int position, long id) {
//                Log.v("item", (String) parent.getItemAtPosition(position));
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                // TODO Auto-generated method stub
//            }
//        });
//        tabHost.addTab(spec);
//        //tab2
//        spec= tabHost.newTabSpec("חלק ב");
//        spec.setContent(R.id.tab2);
//        spec.setIndicator("חלק ב");
//        tabHost.addTab(spec);
//        //tab3
//        spec= tabHost.newTabSpec("חלק ג");
//        spec.setContent(R.id.tab3);
//        spec.setIndicator("חלג ג");
//        tabHost.addTab(spec);
//        //tab4
//        spec= tabHost.newTabSpec("חלק ד");
//        spec.setContent(R.id.tab4);
//        spec.setIndicator("חלק ד");
//        tabHost.addTab(spec);


    }

    public void questionnaire(View view) {
 TextView textView1=(TextView) findViewById(R.id.textVie1);
        TextView textView2=(TextView) findViewById(R.id.textView2);
        TextView textView3=(TextView) findViewById(R.id.textView3);
        TextView textView4=(TextView) findViewById(R.id.textView4);
        TextView textView5=(TextView) findViewById(R.id.textView5);
        Button questionnaire=(Button) findViewById(R.id.questionnaire);
        ScrollView scrollView=(ScrollView) findViewById(R.id.ScrollViewQuestionnaire);
        textView1.setVisibility(view.INVISIBLE);
        textView2.setVisibility(view.INVISIBLE);
        textView3.setVisibility(view.INVISIBLE);
        textView4.setVisibility(view.INVISIBLE);
        textView5.setVisibility(view.INVISIBLE);
        questionnaire.setVisibility(view.INVISIBLE);
        scrollView.setVisibility(view.VISIBLE);

    }
}