package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Opening_questionnaire extends AppCompatActivity {
    public FirebaseFirestore db;
    ArrayList<String> team = new ArrayList<String>();
    private TextView textView;
    private SeekBar seekBar;

    private  TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private  TextView textView5;
    private  Button questionnaire;
    private   ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_questionnaire);
        db = FirebaseFirestore.getInstance();
        Spinner teamSpinner = (Spinner) findViewById(R.id.team_spinner2);
        db.collection("Teams")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot doc : task.getResult()) {
                                if ((Boolean.TRUE.equals(doc.getBoolean("old"))) != true) {
                                    team.add(doc.getString("name"));

                                }
                            }
                        } else {
                            Toast.makeText(Opening_questionnaire.this, "Error", Toast.LENGTH_LONG).show();
                            //   Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, team);
        teamSpinner.setAdapter(adapter);
        teamSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

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
        textView = (TextView) findViewById(R.id.textView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textView.setText(String.valueOf(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        }

    public void questionnaire(View view) {
        textView1=(TextView) findViewById(R.id.textVie1);
         textView2=(TextView) findViewById(R.id.textView2);
         textView3=(TextView) findViewById(R.id.textView3);
         textView4=(TextView) findViewById(R.id.textView4);
         textView5=(TextView) findViewById(R.id.textView5);
         questionnaire=(Button) findViewById(R.id.questionnaire);
         scrollView=(ScrollView) findViewById(R.id.ScrollViewQuestionnaire);

        textView1.setVisibility(view.INVISIBLE);
        textView2.setVisibility(view.INVISIBLE);
        textView3.setVisibility(view.INVISIBLE);
        textView4.setVisibility(view.INVISIBLE);
        textView5.setVisibility(view.INVISIBLE);
        questionnaire.setVisibility(view.INVISIBLE);
        scrollView.setVisibility(view.VISIBLE);

    }
//part 2
    public void P2 (View view) {
        scrollView.setVisibility(view.INVISIBLE);

    }

    public void P3(View view) {
    }
}