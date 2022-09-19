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
//    private String q21;
//    private String q22;
//    private String q23;
//    private String q24;
//    private String q25;
//    private String q26;
//    private String q27;
//    private String q28;
//    private String q29;
//    private String q210;
//    private String q211;
//    private String q212;
//    private RadioButton radio210;
//    private RadioButton radio211;
//    private RadioButton radio212;
//    private RadioButton radio213;
//    private RadioButton radio214;
//    private RadioButton radio220;
//    private RadioButton radio221;
//    private RadioButton radio222;
//    private RadioButton radio223;
//    private RadioButton radio224;
//    private RadioButton radio230;
//    private RadioButton radio231;
//    private RadioButton radio232;
//    private RadioButton radio233;
//    private RadioButton radio234;
//    private RadioButton radio240;
//    private RadioButton radio241;
//    private RadioButton radio242;
//    private RadioButton radio243;
//    private RadioButton radio244;
//    private RadioButton radio250;
//    private RadioButton radio251;
//    private RadioButton radio252;
//    private RadioButton radio253;
//    private RadioButton radio254;
//    private RadioButton radio260;
//    private RadioButton radio261;
//    private RadioButton radio262;
//    private RadioButton radio263;
//    private RadioButton radio264;
//    private RadioButton radio270;
//    private RadioButton radio271;
//    private RadioButton radio272;
//    private RadioButton radio273;
//    private RadioButton radio274;
//    private RadioButton radio280;
//    private RadioButton radio281;
//    private RadioButton radio282;
//    private RadioButton radio283;
//    private RadioButton radio284;
//    private RadioButton radio290;
//    private RadioButton radio291;
//    private RadioButton radio292;
//    private RadioButton radio293;
//    private RadioButton radio294;
//    private RadioButton radio2100;
//    private RadioButton radio2101;
//    private RadioButton radio2102;
//    private RadioButton radio2103;
//    private RadioButton radio2104;
//    private RadioButton radio2110;
//    private RadioButton radio2111;
//    private RadioButton radio2112;
//    private RadioButton radio2113;
//    private RadioButton radio2114;
//    private RadioButton radio2120;
//    private RadioButton radio2121;
//    private RadioButton radio2122;
//    private RadioButton radio2123;
//    private RadioButton radio2124;

    private Button questionnaire;
    private ScrollView ScrollViewQuestionnaire;
    private ScrollView scrollView1;
    private ScrollView scrollView2;
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
                q1 = q113.getText().toString();
                break;


        }
    }

//    //part2
//    //q1
//    public void onRadioButtonClicked21(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radio210:
//                if (checked)
//                    q21 = "0";
//                break;
//            case R.id.radio211:
//                if (checked)
//                    q21 = "1";
//                break;
//            case R.id.radio212:
//                if (checked)
//                    q21 = "2";
//                break;
//            case R.id.radio213:
//                if (checked)
//                    q21 = "3";
//                break;
//            case R.id.radio214:
//                if (checked)
//                    q21 = "4";
//                break;
//        }
//    }
//
//    //q2
//    public void onRadioButtonClicked22(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radio220:
//                if (checked)
//                    q22 = "0";
//                break;
//            case R.id.radio221:
//                if (checked)
//                    q22 = "1";
//                break;
//            case R.id.radio222:
//                if (checked)
//                    q22 = "2";
//                break;
//            case R.id.radio223:
//                if (checked)
//                    q22 = "3";
//                break;
//            case R.id.radio224:
//                if (checked)
//                    q22 = "4";
//                break;
//        }
//
//    }
//
//    //q3
//    public void onRadioButtonClicked23(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radio230:
//                if (checked)
//                    q23 = "0";
//                break;
//            case R.id.radio231:
//                if (checked)
//                    q23 = "1";
//                break;
//            case R.id.radio232:
//                if (checked)
//                    q23 = "2";
//                break;
//            case R.id.radio233:
//                if (checked)
//                    q23 = "3";
//                break;
//            case R.id.radio234:
//                if (checked)
//                    q23 = "4";
//                break;
//        }
//
//    }
//
//    //q4
//    public void onRadioButtonClicked24(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radio240:
//                if (checked)
//                    q24 = "0";
//                break;
//            case R.id.radio241:
//                if (checked)
//                    q24 = "1";
//                break;
//            case R.id.radio242:
//                if (checked)
//                    q24 = "2";
//                break;
//            case R.id.radio243:
//                if (checked)
//                    q24 = "3";
//                break;
//            case R.id.radio244:
//                if (checked)
//                    q24 = "4";
//                break;
//        }
//
//    }
//
//    //q5
//    public void onRadioButtonClicked25(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radio250:
//                if (checked)
//                    q25 = "0";
//                break;
//            case R.id.radio251:
//                if (checked)
//                    q25 = "1";
//                break;
//            case R.id.radio252:
//                if (checked)
//                    q25 = "2";
//                break;
//            case R.id.radio253:
//                if (checked)
//                    q25 = "3";
//                break;
//            case R.id.radio254:
//                if (checked)
//                    q25 = "4";
//                break;
//        }
//
//    }
//
//    //q6
//    public void onRadioButtonClicked26(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radio260:
//                if (checked)
//                    q26 = "0";
//                break;
//            case R.id.radio261:
//                if (checked)
//                    q26 = "1";
//                break;
//            case R.id.radio262:
//                if (checked)
//                    q26 = "2";
//                break;
//            case R.id.radio263:
//                if (checked)
//                    q26 = "3";
//                break;
//            case R.id.radio264:
//                if (checked)
//                    q26 = "4";
//                break;
//        }
//
//    }
//
//    //q7
//    public void onRadioButtonClicked27(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radio270:
//                if (checked)
//                    q27 = "0";
//                break;
//            case R.id.radio271:
//                if (checked)
//                    q27 = "1";
//                break;
//            case R.id.radio272:
//                if (checked)
//                    q27 = "2";
//                break;
//            case R.id.radio273:
//                if (checked)
//                    q27 = "3";
//                break;
//            case R.id.radio274:
//                if (checked)
//                    q27 = "4";
//                break;
//        }
//
//    }
//
//    //q8
//    public void onRadioButtonClicked28(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radio280:
//                if (checked)
//                    q28 = "0";
//                break;
//            case R.id.radio281:
//                if (checked)
//                    q28 = "1";
//                break;
//            case R.id.radio282:
//                if (checked)
//                    q28 = "2";
//                break;
//            case R.id.radio283:
//                if (checked)
//                    q28 = "3";
//                break;
//            case R.id.radio284:
//                if (checked)
//                    q28 = "4";
//                break;
//        }
//
//    }
//
//    //q9
//    public void onRadioButtonClicked29(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radio290:
//                if (checked)
//                    q29 = "0";
//                break;
//            case R.id.radio291:
//                if (checked)
//                    q29 = "1";
//                break;
//            case R.id.radio292:
//                if (checked)
//                    q29 = "2";
//                break;
//            case R.id.radio293:
//                if (checked)
//                    q29 = "3";
//                break;
//            case R.id.radio294:
//                if (checked)
//                    q29 = "4";
//                break;
//        }
//
//    }
//
//    //q10
//    public void onRadioButtonClicked210(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radio2100:
//                if (checked)
//                    q210 = "0";
//                break;
//            case R.id.radio2101:
//                if (checked)
//                    q210 = "1";
//                break;
//            case R.id.radio2102:
//                if (checked)
//                    q210 = "2";
//                break;
//            case R.id.radio2103:
//                if (checked)
//                    q210 = "3";
//                break;
//            case R.id.radio2104:
//                if (checked)
//                    q210 = "4";
//                break;
//        }
//
//    }
//
//    //q11
//    public void onRadioButtonClicked211(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radio2110:
//                if (checked)
//                    q211 = "0";
//                break;
//            case R.id.radio2111:
//                if (checked)
//                    q211 = "1";
//                break;
//            case R.id.radio2112:
//                if (checked)
//                    q211 = "2";
//                break;
//            case R.id.radio2113:
//                if (checked)
//                    q211 = "3";
//                break;
//            case R.id.radio2114:
//                if (checked)
//                    q211 = "4";
//                break;
//        }
//
//    }
//
//    //q12
//    public void onRadioButtonClicked212(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radio2120:
//                if (checked)
//                    q212 = "0";
//                break;
//            case R.id.radio2121:
//                if (checked)
//                    q212 = "1";
//                break;
//            case R.id.radio2122:
//                if (checked)
//                    q212 = "2";
//                break;
//            case R.id.radio2123:
//                if (checked)
//                    q212 = "3";
//                break;
//            case R.id.radio2124:
//                if (checked)
//                    q212 = "4";
//                break;
//        }

   // }

    public void save(View view) {
        //fulling
        if ((!q110.isChecked()) && (!q111.isChecked()) && (!q112.isChecked())) {
            gender.setTextColor(getResources().getColor(R.color.design_default_color_error));
        }
        if (!ch) {
            agee.setTextColor(getResources().getColor(R.color.design_default_color_error));
    }
//                if (teamm.getText().toString().equals("")) {
//                    teamm.setHintTextColor(getResources().getColor(R.color.design_default_color_error));
//                }

//&&(send2()==1)
            if (((q110.isChecked()) || (q111.isChecked()) || (q112.isChecked())) && (ch)) {

                gender.setTextColor(getResources().getColor(R.color.black));
                agee.setTextColor(getResources().getColor(R.color.black));
                Map<String, Object> answers = new HashMap<>();
                Map<String, Object> part1 = new HashMap<>();
                part1.put("gender", q1);
                part1.put("age", age.getText().toString());
//                //  part1.put("teamName", teamName);
//                Map<String, Object> part2 = new HashMap<>();
//                part2.put("q1", qq21);
//                part2.put("q2", qq22);
//                part2.put("q3", qq23);
//                part2.put("q4", qq24);
//                part2.put("q5", qq25);
//                part2.put("q6", qq26);
//                part2.put("q7", qq27);
//                part2.put("q8", qq28);
//                part2.put("q9", qq29);
//                part2.put("q10", qq210);
//                part2.put("q11", qq211);
//                part2.put("q12", qq212);


            //    Map<String, Object> part3 = new HashMap<>();
//        Q31=String.valueOf(q31.getRating());
//        Q32=String.valueOf(q32.getRating());
//        Q33=String.valueOf(q33.getRating());
//        Q34=String.valueOf(q34.getRating());
//
//        part3.put("q31", Q31);
//        part3.put("q32", Q32);
//        part3.put("q33", Q33);
//        part3.put("q34", Q34);

        //        Map<String, Object> part4 = new HashMap<>();
//        String Q41 = q41.getText().toString();
//        String Q42 = q42.getText().toString();
//        part4.put("q41", Q41);
//        part4.put("q42", Q42);

                answers.put("part1", part1);
                //answers.put("part2", part2);
//                answers.put("part3", part3);
//                answers.put("part4", part4);
                 FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    uid = user.getUid();
                }
                db.collection("students").document(uid).collection("questionnaires").document("Opening questionnaire").set(answers)
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



//    public int send2() {
//        if ((!radio210.isChecked()) && (!radio211.isChecked()) && (!radio212.isChecked()) && (!radio213.isChecked()) && (!radio214.isChecked())) {
//            qq21.setTextColor(getResources().getColor(R.color.design_default_color_error));
//            return 0;
//        }
//        if ((!radio220.isChecked()) && (!radio221.isChecked()) && (!radio222.isChecked()) && (!radio223.isChecked()) && (!radio224.isChecked())) {
//            qq22.setTextColor(getResources().getColor(R.color.design_default_color_error));
//            return 0 ;
//        }
//        if ((!radio230.isChecked()) && (!radio231.isChecked()) && (!radio232.isChecked()) && (!radio233.isChecked()) && (!radio234.isChecked())) {
//            qq23.setTextColor(getResources().getColor(R.color.design_default_color_error));
//            return 0;
//        }
//        if ((!radio240.isChecked()) && (!radio241.isChecked()) && (!radio242.isChecked()) && (!radio243.isChecked()) && (!radio244.isChecked())) {
//            qq24.setTextColor(getResources().getColor(R.color.design_default_color_error));
//            return 0;
//        }
//        if ((!radio250.isChecked()) && (!radio251.isChecked()) && (!radio252.isChecked()) && (!radio253.isChecked()) && (!radio254.isChecked())) {
//            qq25.setTextColor(getResources().getColor(R.color.design_default_color_error));
//            return 0;
//        }
//        if ((!radio260.isChecked()) && (!radio261.isChecked()) && (!radio262.isChecked()) && (!radio263.isChecked()) && (!radio264.isChecked())) {
//            qq26.setTextColor(getResources().getColor(R.color.design_default_color_error));
//            return 0;
//        }
//        if ((!radio270.isChecked()) && (!radio271.isChecked()) && (!radio272.isChecked()) && (!radio273.isChecked()) && (!radio274.isChecked())) {
//            qq27.setTextColor(getResources().getColor(R.color.design_default_color_error));
//            return 0;
//        }
//        if ((!radio280.isChecked()) && (!radio281.isChecked()) && (!radio282.isChecked()) && (!radio283.isChecked()) && (!radio284.isChecked())) {
//            qq28.setTextColor(getResources().getColor(R.color.design_default_color_error));
//            return 0;
//        }
//        if ((!radio290.isChecked()) && (!radio291.isChecked()) && (!radio292.isChecked()) && (!radio293.isChecked()) && (!radio294.isChecked())) {
//            qq29.setTextColor(getResources().getColor(R.color.design_default_color_error));
//            return 0;
//        }
//        if ((!radio2100.isChecked()) && (!radio2101.isChecked()) && (!radio2102.isChecked()) && (!radio2103.isChecked()) && (!radio2104.isChecked())) {
//            qq210.setTextColor(getResources().getColor(R.color.design_default_color_error));
//            return 0;
//        }
//        if ((!radio2110.isChecked()) && (!radio2111.isChecked()) && (!radio2112.isChecked()) && (!radio2113.isChecked()) && (!radio2114.isChecked())) {
//            qq211.setTextColor(getResources().getColor(R.color.design_default_color_error));
//            return 0;
//        }
//        if ((!radio2120.isChecked()) && (!radio2121.isChecked()) && (!radio2122.isChecked()) && (!radio2123.isChecked()) && (!radio2124.isChecked())) {
//            qq212.setTextColor(getResources().getColor(R.color.design_default_color_error));
//            return 0;
//        }
//
//
//
//        return 1;
//
//    }
}