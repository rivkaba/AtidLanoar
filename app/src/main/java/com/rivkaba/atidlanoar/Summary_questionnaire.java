package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import java.util.Objects;

public class Summary_questionnaire extends AppCompatActivity {
    public FirebaseFirestore db;
    ArrayList<String> team = new ArrayList<String>();
    private TextView textView;
    private SeekBar seekBar;
    private Button questionnair;
    private ScrollView scrollView;
    private ScrollView scrollView1;
    private   ScrollView scrollView2;
    private LinearLayout linearButtons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_questionnaire);
        Intent intent = getIntent();
        String part = intent.getStringExtra("part");
        if(Objects.equals(part, "P1"))
            part1();
        else {
            if (Objects.equals(part, "P2"))
                part2();
        }
        //Spinner teams
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
                            Toast.makeText(Summary_questionnaire.this, "Error", Toast.LENGTH_LONG).show();
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
        // seekBar age
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

    public void questionnair(View view) {
            questionnair=(Button) findViewById(R.id.questionnair);
        scrollView=(ScrollView) findViewById(R.id.ScrollViewQuestionnaire);
            scrollView1=(ScrollView) findViewById(R.id.ScrollViewQuestionnaire1);
            scrollView2=(ScrollView) findViewById(R.id.ScrollViewQuestionnaire2);
        linearButtons =(LinearLayout) findViewById(R.id.linearButtons);
        scrollView.setVisibility(view.INVISIBLE);
        questionnair.setVisibility(view.INVISIBLE);
        scrollView1.setVisibility(view.VISIBLE);
        linearButtons.setVisibility(view.VISIBLE);


    }
    //part 1
    public void P1(View view) {
        linearButtons.setVisibility(view.VISIBLE);
            scrollView1.setVisibility(view.VISIBLE);
            scrollView2.setVisibility(view.INVISIBLE);

    }
    private void part1() {
        linearButtons.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.INVISIBLE);
        scrollView1.setVisibility(View.VISIBLE);
        scrollView2.setVisibility(View.INVISIBLE);


    }
    //part 2
    public void P2(View view) {
        linearButtons.setVisibility(view.VISIBLE);
        scrollView1.setVisibility(view.INVISIBLE);
        scrollView2.setVisibility(view.VISIBLE);

    }
    private void part2() {
        linearButtons.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.INVISIBLE);
        scrollView1.setVisibility(View.INVISIBLE);
        scrollView2.setVisibility(View.VISIBLE);

    }
    //part 3
    public void P3(View view) {
        startActivity(new Intent(Summary_questionnaire.this,Summary_questionnaire_2 .class));

    }

    public void P4(View view) {
        Intent intent = new Intent(Summary_questionnaire.this, Summary_questionnaire_2.class);
        intent.putExtra("part", "P4");
        startActivity(intent);

    }

}