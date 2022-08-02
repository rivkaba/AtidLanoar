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
    private   ScrollView scrollView3;
    private   ScrollView scrollView4;
    RatingBar q31;
    RatingBar q32;
    RatingBar q33;
    RatingBar q34;
    String Q31;
    String Q32;
    String Q33;
    String Q34;
    EditText q41;
    EditText q42;
    String uid;
    public FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_questionnaire2);
        db = FirebaseFirestore.getInstance();
        scrollView3=(ScrollView) findViewById(R.id.Scroll_view_questionnaire_3);
        scrollView4=(ScrollView) findViewById(R.id.Scroll_view_questionnaire_4);
        q31=(RatingBar)findViewById(R.id.q31);
        q32=(RatingBar)findViewById(R.id.q32);
        q33=(RatingBar)findViewById(R.id.q33);
        q34=(RatingBar)findViewById(R.id.q34);
        q41=findViewById(R.id.q41);
        q42=findViewById(R.id.q42);
        Intent intent = getIntent();
        String part = intent.getStringExtra("part");
        if(Objects.equals(part, "P4"))
            part4();

    }
    public void P1(View view) {
        Intent intent = new Intent(Opening_questionnaire_2.this, Opening_questionnaire.class);
        intent.putExtra("part", "P1");
        startActivity(intent);

    }
    public void P2(View view) {
        Intent intent = new Intent(Opening_questionnaire_2.this, Opening_questionnaire.class);
        intent.putExtra("part", "P2");
        startActivity(intent);

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
    private void part4() {
            scrollView4.setVisibility(View.VISIBLE);
            scrollView3.setVisibility(View.INVISIBLE);

        }

/////////
    public void send(View view) {

        Map<String, Object> answers = new HashMap<>();
        Map<String, Object> part1 = new HashMap<>();

        Map<String, Object> part2 = new HashMap<>();


        Map<String, Object> part3 = new HashMap<>();
        Q31=String.valueOf(q31.getRating());
        Q32=String.valueOf(q32.getRating());
        Q33=String.valueOf(q33.getRating());
        Q34=String.valueOf(q34.getRating());

        part3.put("q31", Q31);
        part3.put("q32", Q32);
        part3.put("q33", Q33);
        part3.put("q34", Q34);

        Map<String, Object> part4 = new HashMap<>();
        String Q41 = q41.getText().toString();
        String Q42 = q42.getText().toString();
        part4.put("q41", Q41);
        part4.put("q42", Q42);

        answers.put("part1", part1);
        answers.put("part2", part2);
        answers.put("part3", part3);
        answers.put("part4", part4);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            uid = user.getUid();
        }
  db.collection("students").document(uid).collection("questionnaires").document("Opening questionnaire").set(answers)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
        @Override
        public void onSuccess(Void aVoid) {
            Toast.makeText(Opening_questionnaire_2.this, " תודה, הטופס נשלח בהצלחה", Toast.LENGTH_LONG).show();

        }
    })
            .addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            Toast.makeText(Opening_questionnaire_2.this, "השליחה נכשלה", Toast.LENGTH_LONG).show();

        }
    });
    }

}

