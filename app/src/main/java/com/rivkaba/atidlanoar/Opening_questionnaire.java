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
    private   ScrollView scrollView1;
    private   ScrollView scrollView2;
    private  Button p1;
    private  Button p2;
    private  Button p3;
    private  Button p4;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
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
        textView1=(TextView) findViewById(R.id.textVie1);
         textView2=(TextView) findViewById(R.id.textView2);
         textView3=(TextView) findViewById(R.id.textView3);
         textView4=(TextView) findViewById(R.id.textView4);
         textView5=(TextView) findViewById(R.id.textView5);
         questionnaire=(Button) findViewById(R.id.questionnaire);
         scrollView1=(ScrollView) findViewById(R.id.ScrollViewQuestionnaire1);
        scrollView2=(ScrollView) findViewById(R.id.ScrollViewQuestionnaire2);
         p1=(Button) findViewById(R.id.p1);
                 p2=(Button) findViewById(R.id.p2);
                 p3=(Button) findViewById(R.id.p3);
                 p4=(Button) findViewById(R.id.p4);
                 image1=(ImageView) findViewById(R.id.image1);
        image2=(ImageView) findViewById(R.id.image2);
        image3=(ImageView) findViewById(R.id.image3);
p1.setVisibility(view.VISIBLE);
        p2.setVisibility(view.VISIBLE);
        p3.setVisibility(view.VISIBLE);
                p4.setVisibility(view.VISIBLE);
                image1.setVisibility(view.VISIBLE);
        image2.setVisibility(view.VISIBLE);
        image3.setVisibility(view.VISIBLE);

        textView1.setVisibility(view.INVISIBLE);
        textView2.setVisibility(view.INVISIBLE);
        textView3.setVisibility(view.INVISIBLE);
        textView4.setVisibility(view.INVISIBLE);
        textView5.setVisibility(view.INVISIBLE);
        questionnaire.setVisibility(view.INVISIBLE);
        scrollView1.setVisibility(view.VISIBLE);

    }
    //part 1
    public void P1(View view) {
        scrollView1.setVisibility(view.VISIBLE);
        scrollView2.setVisibility(view.INVISIBLE);
    }
//part 2
    public void P2 (View view) {
        scrollView1.setVisibility(view.INVISIBLE);
        scrollView2.setVisibility(view.VISIBLE);
    }
    //part 3
    public void P3(View view) {
        startActivity(new Intent(Opening_questionnaire.this,Opening_questionnaire_2 .class));
    }
    //part 4
    public void P4(View view) {
        startActivity(new Intent(Opening_questionnaire.this,Opening_questionnaire_2 .class));


    }

}