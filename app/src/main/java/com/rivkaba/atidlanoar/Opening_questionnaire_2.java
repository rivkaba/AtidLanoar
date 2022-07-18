package com.rivkaba.atidlanoar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

public class Opening_questionnaire_2 extends AppCompatActivity {
    private   ScrollView scrollView3;
    private   ScrollView scrollView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_questionnaire2);
        scrollView3=(ScrollView) findViewById(R.id.ScrollViewQuestionnaire3);
        scrollView4=(ScrollView) findViewById(R.id.ScrollViewQuestionnaire4);
    }
    public void P1(View view) {
        startActivity(new Intent(Opening_questionnaire_2.this,Opening_questionnaire .class));

    }
    public void P2(View view) {
        startActivity(new Intent(Opening_questionnaire_2.this,Opening_questionnaire .class));

    }

    public void P3(View view) {

        scrollView3.setVisibility(view.VISIBLE);
        scrollView4.setVisibility(view.INVISIBLE);
    }
    //part 4
    public void P4(View view) {

        scrollView3.setVisibility(view.INVISIBLE);
        scrollView4.setVisibility(view.VISIBLE);


    }
}