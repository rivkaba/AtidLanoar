package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Opening_questionnaire_2 extends AppCompatActivity {
    private TextView qq21;
    private TextView qq22;
    private TextView qq23;
    private TextView qq24;
    private TextView qq25;
    private TextView qq26;
    private TextView qq27;
    private TextView qq28;
    private TextView qq29;
    private TextView qq210;
    private TextView qq211;
    private TextView qq212;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_questionnaire2);
        qq21 = (TextView) findViewById(R.id.qq21);
        qq22 = (TextView) findViewById(R.id.qq22);
        qq23 = (TextView) findViewById(R.id.qq23);
        qq24 = (TextView) findViewById(R.id.qq24);
        qq25 = (TextView) findViewById(R.id.qq25);
        qq26 = (TextView) findViewById(R.id.qq26);
        qq27 = (TextView) findViewById(R.id.qq27);
        qq28 = (TextView) findViewById(R.id.qq28);
        qq29 = (TextView) findViewById(R.id.qq29);
        qq210 = (TextView) findViewById(R.id.qq210);
        qq211 = (TextView) findViewById(R.id.qq211);
        qq212 = (TextView) findViewById(R.id.qq212);


    }
    //part1
    public void P1(View view) {
        Intent intent = new Intent(Opening_questionnaire_2.this, Opening_questionnaire.class);
        intent.putExtra("part", "P1");
        startActivity(intent);
    }
    //part 3
    public void P3(View view) {
        startActivity(new Intent(Opening_questionnaire_2.this, Opening_questionnaire_3.class));
    }

    //part 4
    public void P4(View view) {
        Intent intent = new Intent(Opening_questionnaire_2.this, Opening_questionnaire_3.class);
        intent.putExtra("part", "P4");
        startActivity(intent);


    }

}

