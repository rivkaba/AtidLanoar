package com.rivkaba.atidlanoar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import java.util.Objects;

public class Opening_questionnaire_2 extends AppCompatActivity {
    private   ScrollView scrollView3;
    private   ScrollView scrollView4;
   // public Button p3;
   //  public Button p4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_questionnaire2);
       // p3=(Button) findViewById(R.id.p3);
      //  p4=(Button) findViewById(R.id.p4);
        scrollView3=(ScrollView) findViewById(R.id.ScrollViewQuestionnaire3);
        scrollView4=(ScrollView) findViewById(R.id.ScrollViewQuestionnaire4);
        Intent intent = getIntent();
        String part = intent.getStringExtra("part");
        if(Objects.equals(part, "P4"))
            closeShutter();

    }
    public void P1(View view) {
        startActivity(new Intent(Opening_questionnaire_2.this,Opening_questionnaire .class));

    }
    public void P2(View view) {
        startActivity(new Intent(Opening_questionnaire_2.this,Opening_questionnaire .class));

    }
//    public void pppp(){
//        p3.setOnClickListener(new View.OnClickListener() {
//        public void onClick(View v) {
//            scrollView3.setVisibility(v.VISIBLE);
//            scrollView4.setVisibility(v.INVISIBLE);
//
//        }
//    });}


    public void P3(View view) {

        scrollView3.setVisibility(view.VISIBLE);
        scrollView4.setVisibility(view.INVISIBLE);
    }
    //part 4
    public void P4(View view) {

        scrollView3.setVisibility(view.INVISIBLE);
        scrollView4.setVisibility(view.VISIBLE);


    }
    private void closeShutter() {
        if (scrollView4 != null) {
            scrollView4.setVisibility(View.VISIBLE);
            scrollView3.setVisibility(View.INVISIBLE);

        }
    }
//    public void pppp(){
//        p4.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                scrollView3.setVisibility(v.INVISIBLE);
//                scrollView4.setVisibility(v.VISIBLE);
//
//            }
//        });}
}

