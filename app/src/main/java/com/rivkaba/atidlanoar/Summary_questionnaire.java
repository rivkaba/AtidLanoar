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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Summary_questionnaire extends AppCompatActivity {
    public FirebaseFirestore db;
    String uid;
    String q1;
    private TextView age;
    private Button p2;
    private SeekBar seekBar;
    private TextView gender;
    private TextView agee;
    private RadioButton q110;
    private RadioButton q111;
    private RadioButton q112;
    private EditText q113;
    boolean ch = false;
    private Button questionnair;
    private ScrollView scrollView;
    private ScrollView scrollView1;
    private LinearLayout linearButtons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_questionnaire);
        questionnair = (Button) findViewById(R.id.questionnair);
        scrollView = (ScrollView) findViewById(R.id.Scroll_view_questionnaire);
        scrollView1 = (ScrollView) findViewById(R.id.Scroll_view_questionnaire_1);
        linearButtons = (LinearLayout) findViewById(R.id.linear_buttons);
        gender = (TextView) findViewById(R.id.gender);
        agee = (TextView) findViewById(R.id.agee);
        q110 = (RadioButton) findViewById(R.id.q110);
        q111 = (RadioButton) findViewById(R.id.q111);
        q112 = (RadioButton) findViewById(R.id.q112);
        q113 = (EditText) findViewById(R.id.q113);
        p2 = (Button) findViewById(R.id.p2);
        Intent intent = getIntent();
        String part = intent.getStringExtra("part");
        if (Objects.equals(part, "P1"))
            part1();

        db = FirebaseFirestore.getInstance();
        // seekBar age
        age = (TextView) findViewById(R.id.age);
        seekBar = (SeekBar) findViewById(R.id.q11);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                agee.setText(String.valueOf(progress));
                ch = true;
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

        scrollView.setVisibility(view.INVISIBLE);
        questionnair.setVisibility(view.INVISIBLE);
        scrollView1.setVisibility(view.VISIBLE);
        linearButtons.setVisibility(view.VISIBLE);


    }

    //part 1
    public void P1(View view) {
        linearButtons.setVisibility(view.VISIBLE);
        scrollView.setVisibility(view.INVISIBLE);
        scrollView1.setVisibility(view.VISIBLE);

    }

    public void part1() {
        linearButtons.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.INVISIBLE);
        scrollView1.setVisibility(View.VISIBLE);


    }

    //part 2
    public void P2(View view) {

        startActivity(new Intent(Summary_questionnaire.this, Summary_questionnaire_2.class));


    }


    //q1 gender
    public void onRadioButtonClicked1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q110:
                if (checked)
                    q1 = "זכר";
                break;
            case R.id.q111:
                if (checked)
                    q1 = "נקבה";
                break;
            case R.id.q112://אחר
                if (checked)
                    q113.setVisibility(view.VISIBLE);
                //   q1 = q113.getText().toString();
                break;

        }
    }

    public void save(View view) {
        //fulling
        if ((!q110.isChecked()) && (!q111.isChecked()) && (!q112.isChecked())) {
            gender.setError("דרוש מגדר");
            gender.requestFocus();
        } else {//"אחר"
            if (q112.isChecked()) {
                q1 = q113.getText().toString();
            }
        }
            if (!ch) {
                age.setError("דרוש גיל");
                age.requestFocus();
            }
//                if (teamm.getText().toString().equals("")) {
//                    teamm.setHintTextColor(getResources().getColor(R.color.design_default_color_error));
//                }

            if (((q110.isChecked()) || (q111.isChecked()) || (q112.isChecked())) && (ch)) {
                Map<String, Object> part1 = new HashMap<>();
                part1.put("gender", q1);
                part1.put("age", agee.getText().toString());
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    uid = user.getUid();
                }
                db.collection("students").document(uid).collection("questionnaires").document("Summary questionnaire").collection("answers").document("part1").set(part1)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Summary_questionnaire.this, " תודה, הטופס נשמר בהצלחה", Toast.LENGTH_LONG).show();
                                p2.setEnabled(true);
                                startActivity(new Intent(Summary_questionnaire.this, Summary_questionnaire_2.class));

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Summary_questionnaire.this, "השמירה נכשלה", Toast.LENGTH_LONG).show();

                            }
                        });
            }
        }
    }

