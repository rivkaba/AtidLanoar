package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Summary_questionnaire_3 extends AppCompatActivity {

    private ScrollView scrollView3;
    private   ScrollView scrollView4;
    private LinearLayout LinearLayout5;
    private LinearLayout linearButtons;
    RatingBar q31;
    RatingBar q32;
    RatingBar q33;
    RatingBar q34;
    String Q31;
    String Q32;
    String Q33;
    String Q34;
    String Q41;
    String Q42;
    String Q43;
    String Q44;
    SeekBar q45;
    SeekBar   q46;
    EditText q47;
    EditText q48;

    String uid;
    public FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_questionnaire3);
        scrollView3=(ScrollView) findViewById(R.id.Scroll_view_questionnaire_3);
        scrollView4=(ScrollView) findViewById(R.id.Scroll_view_questionnaire_4);
        LinearLayout5=(LinearLayout) findViewById(R.id.Linear_Layout);
        linearButtons =(LinearLayout) findViewById(R.id.linear_buttons);
        Intent intent = getIntent();
        String part = intent.getStringExtra("part");
        if(Objects.equals(part, "P4"))
            part4();
        q31=(RatingBar)findViewById(R.id.q31);
        q32=(RatingBar)findViewById(R.id.q32);
        q33=(RatingBar)findViewById(R.id.q33);
        q34=(RatingBar)findViewById(R.id.q34);
        q45= (SeekBar) findViewById(R.id.q45);
        q46=(SeekBar) findViewById(R.id.q46);
        q47=(EditText) findViewById(R.id.q47);
        q48=(EditText) findViewById(R.id.q48);
        db = FirebaseFirestore.getInstance();
    }
    public void P1(View view) {
        Intent intent = new Intent(Summary_questionnaire_3.this, Summary_questionnaire.class);
        intent.putExtra("part", "P1");
        startActivity(intent);
    }
    public void P2(View view) {
        startActivity(new Intent(Summary_questionnaire_3.this, Summary_questionnaire_2.class));

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
        //  FirebaseFirestore.setLoggingEnabled(true);
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

        part4.put("q41", Q41);
        part4.put("q42", Q42);
        part4.put("q43", Q43);
        part4.put("q44", Q44);
        int Q45= q45.getProgress();
        int Q46= q46.getProgress();
        part4.put("q45", Q45);
        part4.put("q46", Q46);
        String Q47 = q47.getText().toString();
        String Q48 = q48.getText().toString();
        part4.put("q47", Q47);
        part4.put("q48", Q48);
        answers.put("part1", part1);
        answers.put("part2", part2);
        answers.put("part3", part3);
        answers.put("part4", part4);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            uid = user.getUid();
        }
        db.collection("students").document(uid).collection("questionnaires").document("Summary questionnaire").set(answers)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Summary_questionnaire_3.this, " תודה, הטופס נשלח בהצלחה", Toast.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Summary_questionnaire_3.this, "השליחה נכשלה", Toast.LENGTH_LONG).show();

                    }
                });


        LinearLayout5.setVisibility(view.VISIBLE);
    }
    //q1
    public void onRadioButtonClicked1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.q410:
                if (checked)
                    Q41="0";
                break;
            case R.id.q411:
                if (checked)
                    Q41="1";
                break;
            case R.id.q412:
                if (checked)
                    Q41="2";
                break;
            case R.id.q413:
                if (checked)
                    Q41="3";
                break;
            case R.id.q414:
                if (checked)
                    Q41="4";
                break;
            case R.id.q415:
                if (checked)
                    Q41="5";
                break;
        }
    }
//q2

    public void onRadioButtonClicked2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.q420:
                if (checked)
                    Q42="0";
                break;
            case R.id.q421:
                if (checked)
                    Q42="1";
                break;
            case R.id.q422:
                if (checked)
                    Q42="2";
                break;
            case R.id.q423:
                if (checked)
                    Q42="3";
                break;
            case R.id.q424:
                if (checked)
                    Q42="4";
                break;
            case R.id.q425:
                if (checked)
                    Q42="5";
                break;
        }
    }
    //q3
    public void onRadioButtonClicked3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.q430:
                if (checked)
                    Q43="0";
                break;
            case R.id.q431:
                if (checked)
                    Q43="1";
                break;
            case R.id.q432:
                if (checked)
                    Q43="2";
                break;
            case R.id.q433:
                if (checked)
                    Q43="3";
                break;
            case R.id.q434:
                if (checked)
                    Q43="4";
                break;
            case R.id.q435:
                if (checked)
                    Q43="5";
                break;
        }
    }
    //q4
    public void onRadioButtonClicked4(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.q440:
                if (checked)
                    Q44="0";
                break;
            case R.id.q441:
                if (checked)
                    Q44="1";
                break;
            case R.id.q442:
                if (checked)
                    Q44="2";
                break;
            case R.id.q443:
                if (checked)
                    Q44="3";
                break;
            case R.id.q444:
                if (checked)
                    Q44="4";
                break;
            case R.id.q445:
                if (checked)
                    Q44="5";
                break;
        }
    }
}