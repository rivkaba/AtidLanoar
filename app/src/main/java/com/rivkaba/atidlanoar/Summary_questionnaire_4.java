package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Summary_questionnaire_4 extends AppCompatActivity {
    private LinearLayout LinearLayout5;
    private LinearLayout linear_buttons;
    private ScrollView scroll_view_questionnaire_4;
    private RadioButton q440;
    private RadioButton q441;
    private RadioButton q442;
    private RadioButton q443;
    private RadioButton q444;
    private RadioButton q445;
    private RadioButton q430;
    private RadioButton q431;
    private RadioButton q432;
    private RadioButton q433;
    private RadioButton q434;
    private RadioButton q435;
    private RadioButton q420;
    private RadioButton q421;
    private RadioButton q422;
    private RadioButton q423;
    private RadioButton q424;
    private RadioButton q425;
    private RadioButton q411;
    private RadioButton q410;
    private RadioButton q412;
    private RadioButton q413;
    private RadioButton q414;
    private RadioButton q415;
    TextView qq45;
    TextView qq46;
    String Q41;
    String Q42;
    String Q43;
    String Q44;
    SeekBar q45;
    SeekBar q46;
    EditText q47;
    EditText q48;
    String uid;
    public FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_questionnaire4);
        qq45 = (TextView) findViewById(R.id.qq45);
        qq46 = (TextView) findViewById(R.id.qq46);
        q440 = (RadioButton) findViewById(R.id.q440);
        q441 = (RadioButton) findViewById(R.id.q441);
        q442 = (RadioButton) findViewById(R.id.q442);
        q443 = (RadioButton) findViewById(R.id.q443);
        q444 = (RadioButton) findViewById(R.id.q444);
        q445 = (RadioButton) findViewById(R.id.q445);
        q430 = (RadioButton) findViewById(R.id.q430);
        q431 = (RadioButton) findViewById(R.id.q431);
        q432 = (RadioButton) findViewById(R.id.q432);
        q433 = (RadioButton) findViewById(R.id.q433);
        q434 = (RadioButton) findViewById(R.id.q434);
        q435 = (RadioButton) findViewById(R.id.q435);
        q420 = (RadioButton) findViewById(R.id.q420);
        q421 = (RadioButton) findViewById(R.id.q421);
        q422 = (RadioButton) findViewById(R.id.q422);
        q423 = (RadioButton) findViewById(R.id.q423);
        q424 = (RadioButton) findViewById(R.id.q424);
        q425 = (RadioButton) findViewById(R.id.q425);
        q410 = (RadioButton) findViewById(R.id.q410);
        q411 = (RadioButton) findViewById(R.id.q411);
        q412 = (RadioButton) findViewById(R.id.q412);
        q413 = (RadioButton) findViewById(R.id.q413);
        q414 = (RadioButton) findViewById(R.id.q414);
        q415 = (RadioButton) findViewById(R.id.q415);
        q45 = (SeekBar) findViewById(R.id.q45);
        q46 = (SeekBar) findViewById(R.id.q46);
        q47 = (EditText) findViewById(R.id.q47);
        q48 = (EditText) findViewById(R.id.q48);
        scroll_view_questionnaire_4 =(ScrollView) findViewById(R.id.scroll_view_questionnaire_4);
        LinearLayout5 = (LinearLayout) findViewById(R.id.Linear_layout);
        linear_buttons = (LinearLayout) findViewById(R.id.linear_buttons);
        db = FirebaseFirestore.getInstance();
    }
    public void P1(View view) {
        Intent intent = new Intent(Summary_questionnaire_4.this, Summary_questionnaire.class);
        intent.putExtra("part", "P1");
        startActivity(intent);
    }
    public void P2(View view) {
        startActivity(new Intent(Summary_questionnaire_4.this, Summary_questionnaire_2.class));

    }
    public void P3(View view) {
        startActivity(new Intent(Summary_questionnaire_4.this, Summary_questionnaire_3.class));

    }
    //q1
    public void onRadioButtonClicked1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q410:
                if (checked)
                    Q41 = "0";
                break;
            case R.id.q411:
                if (checked)
                    Q41 = "1";
                break;
            case R.id.q412:
                if (checked)
                    Q41 = "2";
                break;
            case R.id.q413:
                if (checked)
                    Q41 = "3";
                break;
            case R.id.q414:
                if (checked)
                    Q41 = "4";
                break;
            case R.id.q415:
                if (checked)
                    Q41 = "5";
                break;
        }
    }
//q2

    public void onRadioButtonClicked2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q420:
                if (checked)
                    Q42 = "0";
                break;
            case R.id.q421:
                if (checked)
                    Q42 = "1";
                break;
            case R.id.q422:
                if (checked)
                    Q42 = "2";
                break;
            case R.id.q423:
                if (checked)
                    Q42 = "3";
                break;
            case R.id.q424:
                if (checked)
                    Q42 = "4";
                break;
            case R.id.q425:
                if (checked)
                    Q42 = "5";
                break;
        }
    }

    //q3
    public void onRadioButtonClicked3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q430:
                if (checked)
                    Q43 = "0";
                break;
            case R.id.q431:
                if (checked)
                    Q43 = "1";
                break;
            case R.id.q432:
                if (checked)
                    Q43 = "2";
                break;
            case R.id.q433:
                if (checked)
                    Q43 = "3";
                break;
            case R.id.q434:
                if (checked)
                    Q43 = "4";
                break;
            case R.id.q435:
                if (checked)
                    Q43 = "5";
                break;
        }
    }

    //q4
    public void onRadioButtonClicked4(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q440:
                if (checked)
                    Q44 = "0";
                break;
            case R.id.q441:
                if (checked)
                    Q44 = "1";
                break;
            case R.id.q442:
                if (checked)
                    Q44 = "2";
                break;
            case R.id.q443:
                if (checked)
                    Q44 = "3";
                break;
            case R.id.q444:
                if (checked)
                    Q44 = "4";
                break;
            case R.id.q445:
                if (checked)
                    Q44 = "5";
                break;
        }
    }
      public int  send2() {
            if ((!q410.isChecked()) && (!q411.isChecked()) && (!q412.isChecked()) && (!q413.isChecked()) && (!q414.isChecked()) && (!q415.isChecked())) {
                q410.setError("דרושה התשובה שלך");
                q410.requestFocus();
                return 0;

            }
            if ((!q420.isChecked()) && (!q421.isChecked()) && (!q422.isChecked()) && (!q423.isChecked()) && (!q424.isChecked()) && (!q425.isChecked())) {
                q420.setError("דרושה התשובה שלך");
                q420.requestFocus();
                return 0;

            }
            if ((!q430.isChecked()) && (!q431.isChecked()) && (!q432.isChecked()) && (!q433.isChecked()) && (!q444.isChecked()) && (!q435.isChecked())) {
                q430.setError("דרושה התשובה שלך");
                q430.requestFocus();
                return 0;
            }
            if ((!q440.isChecked()) && (!q441.isChecked()) && (!q442.isChecked()) && (!q443.isChecked()) && (!q444.isChecked()) && (!q445.isChecked())) {
                q440.setError("דרושה התשובה שלך");
                q440.requestFocus();
                return 0;
            }

            if (q45.getProgress() == 0) {
                qq45.setError("דרושה התשובה שלך");
                qq45.requestFocus();
                return 0;
            }
            if (q46.getProgress() == 0) {
                qq46.setError("דרושה התשובה שלך");
                qq46.requestFocus();
                return 0;

            }
            if (q47.getText().toString().equals("")) {
                q47.setError("דרושה התשובה שלך");
                q47.requestFocus();
                return 0;
            }
            if (q48.getText().toString().equals("")) {
                q48.setError("דרושה התשובה שלך");
                q48.requestFocus();
                return 0;
            }
            return 1;
        }

        public void sending (View view){
            if (send2() == 1) {
                Map<String, Object> part4 = new HashMap<>();

                part4.put("q41", Q41);
                part4.put("q42", Q42);
                part4.put("q43", Q43);
                part4.put("q44", Q44);

                part4.put("q45", q45.getProgress());
                part4.put("q46", q46.getProgress());
                part4.put("q47", q47.getText().toString());
                part4.put("q48", q48.getText().toString());
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    uid = user.getUid();
                }
               // db.collection("students").document(uid).collection("questionnaires").document("Summary questionnaire").collection("answers").document("part4").set(part4)
                db.collection("students").document(uid).collection("Summary questionnaire").document("part4").set(part4)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Summary_questionnaire_4.this, " תודה, הטופס נשלח בהצלחה", Toast.LENGTH_LONG).show();
                                linear_buttons.setVisibility(View.INVISIBLE);
                                scroll_view_questionnaire_4.setVisibility(View.INVISIBLE);
                                LinearLayout5.setVisibility(View.VISIBLE);


                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Summary_questionnaire_4.this, "השליחה נכשלה", Toast.LENGTH_LONG).show();

                            }
                        });

            }
        }
    }
