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
    String  teamName;
   private TextView gender;
   private TextView agee;
    private TextView teamm;
    private RadioButton q110;
    private RadioButton q111;
    private RadioButton q112;
//    String q120;
//    String q121;
//    String q122;
//    String q123;
//    String q130;
//    String q131;
//    String q132;
//    String q133;
//    String q140;
//    String q141;
//    String q142;
//    String q143;
//    String q150;
//    String q151;
//    String q152;
//    String q153;
//    String q160;
//    String q161;
//    String q162;
//    String q163;
//    String q170;
//    String q171;
//    String q172;
//    String q173;
//    String q180;
//    String q181;
//    String q182;
//    String q183;
//    String q190;
//    String q191;
//    String q192;
//    String q193;
//    String q1100;
//    String q1101;
//    String q1102;
//    String q1103;
//    String q1110;
//    String q1111;
//    String q1112;
//    String q1113;


    private  Button questionnaire;
    private   ScrollView ScrollViewQuestionnaire;
    private   ScrollView scrollView1;
    private   ScrollView scrollView2;
    private LinearLayout linearButtons;
    private  Button p1;
    private  Button p2;
    private  Button p3;
    private  Button p4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_questionnaire);
        q113=(EditText)findViewById(R.id.q113);
        ScrollViewQuestionnaire=(ScrollView) findViewById(R.id.Scroll_view_questionnaire);
        scrollView1=(ScrollView) findViewById(R.id.Scroll_view_questionnaire_1);
        scrollView2=(ScrollView) findViewById(R.id.Scroll_view_questionnaire_2);
        linearButtons=(LinearLayout) findViewById(R.id.linear_buttons);
        gender= (TextView)findViewById(R.id.gender);
        agee=(TextView) findViewById(R.id.agee);
       teamm=(TextView) findViewById(R.id.team);
        q110=(RadioButton) findViewById(R.id.q110);
        q111=(RadioButton) findViewById(R.id.q111);
        q112=(RadioButton) findViewById(R.id.q112);

        Intent intent = getIntent();
        String part = intent.getStringExtra("part");
        if(Objects.equals(part, "P1"))
            part1();
        else {
            if (Objects.equals(part, "P2"))
                part2();
        }

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
                teamName =(String) parent.getItemAtPosition(position);

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
         questionnaire=(Button) findViewById(R.id.questionnaire);
      linearButtons.setVisibility(view.VISIBLE);
     ScrollViewQuestionnaire.setVisibility(view.INVISIBLE);
        scrollView1.setVisibility(view.VISIBLE);

    }
    //part 1
    public void P1(View view) {
        linearButtons.setVisibility(view.VISIBLE);
        ScrollViewQuestionnaire.setVisibility(view.INVISIBLE);
        scrollView1.setVisibility(view.VISIBLE);
        scrollView2.setVisibility(view.INVISIBLE);
    }
    private void part1() {
        linearButtons.setVisibility(View.VISIBLE);
        ScrollViewQuestionnaire.setVisibility(View.INVISIBLE);
        scrollView1.setVisibility(View.VISIBLE);
        scrollView2.setVisibility(View.INVISIBLE);


    }
//part 2
    public void P2 (View view) {
        linearButtons.setVisibility(view.VISIBLE);
        ScrollViewQuestionnaire.setVisibility(view.INVISIBLE);
        scrollView1.setVisibility(view.INVISIBLE);
        scrollView2.setVisibility(view.VISIBLE);
    }
    private void part2() {
        linearButtons.setVisibility(View.VISIBLE);
        ScrollViewQuestionnaire.setVisibility(View.INVISIBLE);
        scrollView1.setVisibility(View.INVISIBLE);
        scrollView2.setVisibility(View.VISIBLE);

    }
    //part 3
    public void P3(View view) {
       startActivity(new Intent(Opening_questionnaire.this,Opening_questionnaire_2 .class));
    }
    //part 4
    public void P4(View view) {
        Intent intent = new Intent(Opening_questionnaire.this, Opening_questionnaire_2.class);
        intent.putExtra("part", "P4");
        startActivity(intent);


    }
    //q1 gender
    public void onRadioButtonClicked1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio110:
                if (checked)
                    q1="זכר";
                break;
            case R.id.radio111:
                if (checked)
                    q1="נקבה";
                break;
            case R.id.radio112://אחר
                if (checked)
               q1=q113.getText().toString();
                break;
                

        }
    }

//    //q3
//    public void onRadioButtonClicked3(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.radio30:
//                if (checked)
//                    q3="0";
//                break;
//            case R.id.radio31:
//                if (checked)
//                    q3="1";
//                break;
//            case R.id.radio32:
//                if (checked)
//                    q3="2";
//                break;
//            case R.id.radio33:
//                if (checked)
//                    q3="3";
//                break;
//            case R.id.radio34:
//                if (checked)
//                    q3="4";
//                break;
//        }
//    }
//    //q4
//    public void onRadioButtonClicked4(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radio40:
//                if (checked)
//                    q4 = "0";
//                break;
//            case R.id.radio41:
//                if (checked)
//                    q4 = "1";
//                break;
//            case R.id.radio42:
//                if (checked)
//                    q4 = "2";
//                break;
//            case R.id.radio43:
//                if (checked)
//                    q4 = "3";
//                break;
//            case R.id.radio44:
//                if (checked)
//                    q4 = "4";
//                break;
//        }
//
//    }
    ////////
    public void send(View view) {
        //fulling
        if ((q110.isChecked()==false)&&(q111.isChecked()==false)&&(q112.isChecked()==false))
      {
           gender.setHintTextColor(getResources().getColor(R.color.design_default_color_error));
        }
//        if (agee.getText().toString().equals("")) {
//            agee.setHintTextColor(getResources().getColor(R.color.design_default_color_error));
//        }
//                if (teamm.getText().toString().equals("")) {
//                    teamm.setHintTextColor(getResources().getColor(R.color.design_default_color_error));
//                }
else{
      //  if ((!(gender.getText().toString().equals("")) && !(agee.getText().toString().equals("")))) {


            Map<String, Object> answers = new HashMap<>();
            Map<String, Object> part1 = new HashMap<>();
            part1.put("gender", q1);
            part1.put("age", age);
            //  part1.put("teamName", teamName);
            Map<String, Object> part2 = new HashMap<>();


            Map<String, Object> part3 = new HashMap<>();
//        Q31=String.valueOf(q31.getRating());
//        Q32=String.valueOf(q32.getRating());
//        Q33=String.valueOf(q33.getRating());
//        Q34=String.valueOf(q34.getRating());
//
//        part3.put("q31", Q31);
//        part3.put("q32", Q32);
//        part3.put("q33", Q33);
//        part3.put("q34", Q34);

            Map<String, Object> part4 = new HashMap<>();
//        String Q41 = q41.getText().toString();
//        String Q42 = q42.getText().toString();
//        part4.put("q41", Q41);
//        part4.put("q42", Q42);

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


    public void gender(View view) {
         q113.setVisibility(view.VISIBLE);
    }
}
