package com.rivkaba.atidlanoar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.Objects;

public class Summary_questionnaire_2 extends AppCompatActivity {
    private ScrollView scrollView3;
    private   ScrollView scrollView4;
    private LinearLayout LinearLayout5;
    private LinearLayout linearButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_questionnaire2);
        scrollView3=(ScrollView) findViewById(R.id.ScrollViewQuestionnaire3);
        scrollView4=(ScrollView) findViewById(R.id.ScrollViewQuestionnaire4);
        LinearLayout5=(LinearLayout) findViewById(R.id.LinearLayout5);
        linearButtons =(LinearLayout) findViewById(R.id.linearButtons);
        Intent intent = getIntent();
        String part = intent.getStringExtra("part");
        if(Objects.equals(part, "P4"))
            part4();
    }
    public void P1(View view) {
        Intent intent = new Intent(Summary_questionnaire_2.this, Summary_questionnaire.class);
        intent.putExtra("part", "P1");
        startActivity(intent);
    }
    public void P2(View view) {
        Intent intent = new Intent(Summary_questionnaire_2.this, Summary_questionnaire.class);
        intent.putExtra("part", "P2");
        startActivity(intent);
    }
    public void P3(View view) {
        linearButtons.setVisibility(view.VISIBLE);
        scrollView3.setVisibility(view.VISIBLE);
        scrollView4.setVisibility(view.INVISIBLE);
    }
    //part 4
    public void P4(View view) {
        linearButtons.setVisibility(view.VISIBLE);
        scrollView3.setVisibility(view.INVISIBLE);
        scrollView4.setVisibility(view.VISIBLE);
    }

    private void part4() {
        linearButtons.setVisibility(View.VISIBLE);
        scrollView4.setVisibility(View.VISIBLE);
        scrollView3.setVisibility(View.INVISIBLE);

    }


    public void sending(View view) {
        linearButtons.setVisibility(view.INVISIBLE);
        scrollView3.setVisibility(view.INVISIBLE);
        scrollView4.setVisibility(view.INVISIBLE);
        LinearLayout5.setVisibility(view.VISIBLE);
    }
}