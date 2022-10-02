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

public class Opening_questionnaire extends AppCompatActivity {
    public FirebaseFirestore db;
    String uid;
    ArrayList<String> team = new ArrayList<String>();
    private TextView age;
    private SeekBar q12;
    String q1;
    private EditText q113;
    String teamName;
    private TextView gender;
    private TextView agee;
    private TextView teamm;

    private RadioButton q110;
    private RadioButton q111;
    private RadioButton q112;

    private Button questionnaire;
    private ScrollView ScrollViewQuestionnaire;
    private ScrollView scrollView1;
    private LinearLayout linearButtons;
    private Button p1;
    private Button p2;
    private Button p3;
    private Button p4;
    boolean ch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_questionnaire);

        q113 = (EditText) findViewById(R.id.q113);
        ScrollViewQuestionnaire = (ScrollView) findViewById(R.id.Scroll_view_questionnaire);
        scrollView1 = (ScrollView) findViewById(R.id.Scroll_view_questionnaire_1);
       // scrollView2 = (ScrollView) findViewById(R.id.Scroll_view_questionnaire_2);
        linearButtons = (LinearLayout) findViewById(R.id.linear_buttons);
        gender = (TextView) findViewById(R.id.gender);
        agee = (TextView) findViewById(R.id.agee);
        teamm = (TextView) findViewById(R.id.team);
        q110 = (RadioButton) findViewById(R.id.q110);
        q111 = (RadioButton) findViewById(R.id.q111);
        q112 = (RadioButton) findViewById(R.id.q112);
        Intent intent = getIntent();
        String part = intent.getStringExtra("part");
        if(Objects.equals(part, "P1"))
            part1();



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
                teamName = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


        age = (TextView) findViewById(R.id.age);
        q12 = (SeekBar) findViewById(R.id.q12);

        q12.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                age.setText(String.valueOf(progress));
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
        questionnaire = (Button) findViewById(R.id.questionnaire);
        linearButtons.setVisibility(view.VISIBLE);
        ScrollViewQuestionnaire.setVisibility(view.INVISIBLE);
        scrollView1.setVisibility(view.VISIBLE);

    }

    //part 1
    public void P1(View view) {
        linearButtons.setVisibility(view.VISIBLE);
        ScrollViewQuestionnaire.setVisibility(view.INVISIBLE);
        scrollView1.setVisibility(view.VISIBLE);
    //    scrollView2.setVisibility(view.INVISIBLE);
    }

    private void part1() {
        linearButtons.setVisibility(View.VISIBLE);
        ScrollViewQuestionnaire.setVisibility(View.INVISIBLE);
        scrollView1.setVisibility(View.VISIBLE);
       // scrollView2.setVisibility(View.INVISIBLE);


    }

    //part 2
    public void P2(View view) {
//        linearButtons.setVisibility(view.VISIBLE);
//        ScrollViewQuestionnaire.setVisibility(view.INVISIBLE);
//        scrollView1.setVisibility(view.INVISIBLE);
//        scrollView2.setVisibility(view.VISIBLE);
        startActivity(new Intent(Opening_questionnaire.this, Opening_questionnaire_2.class));
    }

//    private void part2() {
//        linearButtons.setVisibility(View.VISIBLE);
//        ScrollViewQuestionnaire.setVisibility(View.INVISIBLE);
//        scrollView1.setVisibility(View.INVISIBLE);
//        scrollView2.setVisibility(View.VISIBLE);
//
//    }

    //part 3
    public void P3(View view) {
        startActivity(new Intent(Opening_questionnaire.this, Opening_questionnaire_3.class));
    }

    //part 4
    public void P4(View view) {
        Intent intent = new Intent(Opening_questionnaire.this, Opening_questionnaire_3.class);
        intent.putExtra("part", "P4");
        startActivity(intent);


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
              //  q1 = q113.getText().toString();
                break;


        }
    }


    public void save(View view) {
        //fulling
        if ((!q110.isChecked()) && (!q111.isChecked()) && (q113.getText().toString().equals(""))) {
            gender.setError("דרוש מגדר");
            gender.requestFocus();
        }
        else {//"אחר"
            if (q112.isChecked()) {
                q1 = q113.getText().toString();
            }
        }
        if (!ch) {
            agee.setError("דרוש גיל");
            agee.requestFocus();
            return;

    }
//                if (teamm.getText().toString().equals("")) {
//                    teamm.setHintTextColor(getResources().getColor(R.color.design_default_color_error));
//                }

            if (((q110.isChecked()) || (q111.isChecked()) || (q112.isChecked())) && (ch)) {

                Map<String, Object> part1 = new HashMap<>();
                part1.put("gender", q1);
                part1.put("age", age.getText().toString());

                 FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    uid = user.getUid();
                }
                db.collection("students").document(uid).collection("questionnaires").document("Opening questionnaire").collection("answers").document("part1").set(part1)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Opening_questionnaire.this, " תודה, הטופס נשלח בהצלחה", Toast.LENGTH_LONG).show();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Opening_questionnaire.this, "השליחה נכשלה", Toast.LENGTH_LONG).show();

                            }
                        });
            }
        }

}