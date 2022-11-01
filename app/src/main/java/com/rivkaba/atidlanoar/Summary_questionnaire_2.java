package com.rivkaba.atidlanoar;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RatingBar;
        import android.widget.ScrollView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.OnFailureListener;
        import com.google.android.gms.tasks.OnSuccessListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.firestore.FirebaseFirestore;
        import com.google.firebase.firestore.QuerySnapshot;

        import org.jetbrains.annotations.NotNull;

        import java.util.HashMap;
        import java.util.Map;
        import java.util.Objects;

public class Summary_questionnaire_2 extends AppCompatActivity {
    public FirebaseFirestore db;
    String uid;
    private Button p3;
    private String q21;
    private String q22;
    private String q23;
    private String q24;
    private String q25;
    private String q26;
    private String q27;
    private String q28;
    private String q29;
    private String q210;
    private String q211;
    private RadioButton radio210;
    private RadioButton radio211;
    private RadioButton radio212;
    private RadioButton radio213;
    private RadioButton radio214;
    private RadioButton radio220;
    private RadioButton radio221;
    private RadioButton radio222;
    private RadioButton radio223;
    private RadioButton radio224;
    private RadioButton radio230;
    private RadioButton radio231;
    private RadioButton radio232;
    private RadioButton radio233;
    private RadioButton radio234;
    private RadioButton radio240;
    private RadioButton radio241;
    private RadioButton radio242;
    private RadioButton radio243;
    private RadioButton radio244;
    private RadioButton radio250;
    private RadioButton radio251;
    private RadioButton radio252;
    private RadioButton radio253;
    private RadioButton radio254;
    private RadioButton radio260;
    private RadioButton radio261;
    private RadioButton radio262;
    private RadioButton radio263;
    private RadioButton radio264;
    private RadioButton radio270;
    private RadioButton radio271;
    private RadioButton radio272;
    private RadioButton radio273;
    private RadioButton radio274;
    private RadioButton radio280;
    private RadioButton radio281;
    private RadioButton radio282;
    private RadioButton radio283;
    private RadioButton radio284;
    private RadioButton radio290;
    private RadioButton radio291;
    private RadioButton radio292;
    private RadioButton radio293;
    private RadioButton radio294;
    private RadioButton radio2100;
    private RadioButton radio2101;
    private RadioButton radio2102;
    private RadioButton radio2103;
    private RadioButton radio2104;
    private RadioButton radio2110;
    private RadioButton radio2111;
    private RadioButton radio2112;
    private RadioButton radio2113;
    private RadioButton radio2114;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_questionnaire2);
        db = FirebaseFirestore.getInstance();
        p3=(Button) findViewById(R.id.p3);
        radio210 = (RadioButton) findViewById(R.id.radio210);
        radio211 = (RadioButton) findViewById(R.id.radio211);
        radio212 = (RadioButton) findViewById(R.id.radio212);
        radio213 = (RadioButton) findViewById(R.id.radio213);
        radio214 = (RadioButton) findViewById(R.id.radio214);
        radio220 = (RadioButton) findViewById(R.id.radio220);
        radio221 = (RadioButton) findViewById(R.id.radio221);
        radio222 = (RadioButton) findViewById(R.id.radio222);
        radio223 = (RadioButton) findViewById(R.id.radio223);
        radio224 = (RadioButton) findViewById(R.id.radio224);
        radio230 = (RadioButton) findViewById(R.id.radio230);
        radio231 = (RadioButton) findViewById(R.id.radio231);
        radio232 = (RadioButton) findViewById(R.id.radio232);
        radio233 = (RadioButton) findViewById(R.id.radio233);
        radio234 = (RadioButton) findViewById(R.id.radio234);
        radio240 = (RadioButton) findViewById(R.id.radio240);
        radio241 = (RadioButton) findViewById(R.id.radio241);
        radio242 = (RadioButton) findViewById(R.id.radio242);
        radio243 = (RadioButton) findViewById(R.id.radio243);
        radio244 = (RadioButton) findViewById(R.id.radio244);
        radio250 = (RadioButton) findViewById(R.id.radio250);
        radio251 = (RadioButton) findViewById(R.id.radio251);
        radio252 = (RadioButton) findViewById(R.id.radio252);
        radio253 = (RadioButton) findViewById(R.id.radio253);
        radio254 = (RadioButton) findViewById(R.id.radio254);
        radio260 = (RadioButton) findViewById(R.id.radio260);
        radio261 = (RadioButton) findViewById(R.id.radio261);
        radio262 = (RadioButton) findViewById(R.id.radio262);
        radio263 = (RadioButton) findViewById(R.id.radio263);
        radio264 = (RadioButton) findViewById(R.id.radio264);
        radio270 = (RadioButton) findViewById(R.id.radio270);
        radio271 = (RadioButton) findViewById(R.id.radio271);
        radio272 = (RadioButton) findViewById(R.id.radio272);
        radio273 = (RadioButton) findViewById(R.id.radio273);
        radio274 = (RadioButton) findViewById(R.id.radio274);
        radio280 = (RadioButton) findViewById(R.id.radio280);
        radio281 = (RadioButton) findViewById(R.id.radio281);
        radio282 = (RadioButton) findViewById(R.id.radio282);
        radio283 = (RadioButton) findViewById(R.id.radio283);
        radio284 = (RadioButton) findViewById(R.id.radio284);
        radio290 = (RadioButton) findViewById(R.id.radio290);
        radio291 = (RadioButton) findViewById(R.id.radio291);
        radio292 = (RadioButton) findViewById(R.id.radio292);
        radio293 = (RadioButton) findViewById(R.id.radio293);
        radio294 = (RadioButton) findViewById(R.id.radio294);
        radio2100 = (RadioButton) findViewById(R.id.radio2100);
        radio2101 = (RadioButton) findViewById(R.id.radio2101);
        radio2102 = (RadioButton) findViewById(R.id.radio2102);
        radio2103 = (RadioButton) findViewById(R.id.radio2103);
        radio2104 = (RadioButton) findViewById(R.id.radio2104);
        radio2110 = (RadioButton) findViewById(R.id.radio2110);
        radio2111 = (RadioButton) findViewById(R.id.radio2111);
        radio2112 = (RadioButton) findViewById(R.id.radio2112);
        radio2113 = (RadioButton) findViewById(R.id.radio2113);
        radio2114 = (RadioButton) findViewById(R.id.radio2114);

    }
    //q1
    public void onRadioButtonClicked21(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio210:
                if (checked)
                    q21 = "0";
                break;
            case R.id.radio211:
                if (checked)
                    q21 = "1";
                break;
            case R.id.radio212:
                if (checked)
                    q21 = "2";
                break;
            case R.id.radio213:
                if (checked)
                    q21 = "3";
                break;
            case R.id.radio214:
                if (checked)
                    q21 = "4";
                break;
        }
    }

    //q2
    public void onRadioButtonClicked22(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio220:
                if (checked)
                    q22 = "0";
                break;
            case R.id.radio221:
                if (checked)
                    q22 = "1";
                break;
            case R.id.radio222:
                if (checked)
                    q22 = "2";
                break;
            case R.id.radio223:
                if (checked)
                    q22 = "3";
                break;
            case R.id.radio224:
                if (checked)
                    q22 = "4";
                break;
        }

    }

    //q3
    public void onRadioButtonClicked23(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio230:
                if (checked)
                    q23 = "0";
                break;
            case R.id.radio231:
                if (checked)
                    q23 = "1";
                break;
            case R.id.radio232:
                if (checked)
                    q23 = "2";
                break;
            case R.id.radio233:
                if (checked)
                    q23 = "3";
                break;
            case R.id.radio234:
                if (checked)
                    q23 = "4";
                break;
        }

    }

    //q4
    public void onRadioButtonClicked24(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio240:
                if (checked)
                    q24 = "0";
                break;
            case R.id.radio241:
                if (checked)
                    q24 = "1";
                break;
            case R.id.radio242:
                if (checked)
                    q24 = "2";
                break;
            case R.id.radio243:
                if (checked)
                    q24 = "3";
                break;
            case R.id.radio244:
                if (checked)
                    q24 = "4";
                break;
        }

    }

    //q5
    public void onRadioButtonClicked25(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio250:
                if (checked)
                    q25 = "0";
                break;
            case R.id.radio251:
                if (checked)
                    q25 = "1";
                break;
            case R.id.radio252:
                if (checked)
                    q25 = "2";
                break;
            case R.id.radio253:
                if (checked)
                    q25 = "3";
                break;
            case R.id.radio254:
                if (checked)
                    q25 = "4";
                break;
        }

    }

    //q6
    public void onRadioButtonClicked26(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio260:
                if (checked)
                    q26 = "0";
                break;
            case R.id.radio261:
                if (checked)
                    q26 = "1";
                break;
            case R.id.radio262:
                if (checked)
                    q26 = "2";
                break;
            case R.id.radio263:
                if (checked)
                    q26 = "3";
                break;
            case R.id.radio264:
                if (checked)
                    q26 = "4";
                break;
        }

    }

    //q7
    public void onRadioButtonClicked27(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio270:
                if (checked)
                    q27 = "0";
                break;
            case R.id.radio271:
                if (checked)
                    q27 = "1";
                break;
            case R.id.radio272:
                if (checked)
                    q27 = "2";
                break;
            case R.id.radio273:
                if (checked)
                    q27 = "3";
                break;
            case R.id.radio274:
                if (checked)
                    q27 = "4";
                break;
        }

    }

    //q8
    public void onRadioButtonClicked28(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio280:
                if (checked)
                    q28 = "0";
                break;
            case R.id.radio281:
                if (checked)
                    q28 = "1";
                break;
            case R.id.radio282:
                if (checked)
                    q28 = "2";
                break;
            case R.id.radio283:
                if (checked)
                    q28 = "3";
                break;
            case R.id.radio284:
                if (checked)
                    q28 = "4";
                break;
        }

    }

    //q9
    public void onRadioButtonClicked29(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio290:
                if (checked)
                    q29 = "0";
                break;
            case R.id.radio291:
                if (checked)
                    q29 = "1";
                break;
            case R.id.radio292:
                if (checked)
                    q29 = "2";
                break;
            case R.id.radio293:
                if (checked)
                    q29 = "3";
                break;
            case R.id.radio294:
                if (checked)
                    q29 = "4";
                break;
        }

    }

    //q10
    public void onRadioButtonClicked210(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio2100:
                if (checked)
                    q210 = "0";
                break;
            case R.id.radio2101:
                if (checked)
                    q210 = "1";
                break;
            case R.id.radio2102:
                if (checked)
                    q210 = "2";
                break;
            case R.id.radio2103:
                if (checked)
                    q210 = "3";
                break;
            case R.id.radio2104:
                if (checked)
                    q210 = "4";
                break;
        }

    }

    //q11
    public void onRadioButtonClicked211(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio2110:
                if (checked)
                    q211 = "0";
                break;
            case R.id.radio2111:
                if (checked)
                    q211 = "1";
                break;
            case R.id.radio2112:
                if (checked)
                    q211 = "2";
                break;
            case R.id.radio2113:
                if (checked)
                    q211 = "3";
                break;
            case R.id.radio2114:
                if (checked)
                    q211 = "4";
                break;
        }



    }
    //part1
    public void p1(View view) {
        Intent intent = new Intent(Summary_questionnaire_2.this, Summary_questionnaire.class);
        intent.putExtra("part", "P1");
        startActivity(intent);
    }
    //part 3
    public void p3(View view) {
        startActivity(new Intent(Summary_questionnaire_2.this, Summary_questionnaire_3.class));

    }

    public void save(View view) {
        if(send2()==1) {
            Map<String, Object> part2 = new HashMap<>();
            part2.put("q1", q21);
            part2.put("q2", q22);
            part2.put("q3", q23);
            part2.put("q4", q24);
            part2.put("q5", q25);
            part2.put("q6", q26);
            part2.put("q7", q27);
            part2.put("q8", q28);
            part2.put("q9", q29);
            part2.put("q10", q210);
            part2.put("q11", q211);
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                uid = user.getUid();
            }
            db.collection("students").document(uid).collection("questionnaires").document("Summary questionnaire").collection("answers").document("part2").set(part2)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(Summary_questionnaire_2.this, " תודה, הטופס נשמר בהצלחה", Toast.LENGTH_LONG).show();
                             p3.setEnabled(true);
                            startActivity(new Intent(Summary_questionnaire_2.this, Summary_questionnaire_3.class));

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Summary_questionnaire_2.this, "השמירה נכשלה", Toast.LENGTH_LONG).show();

                        }
                    });


                            }

    }
    public int send2() {
        if ((!radio210.isChecked()) && (!radio211.isChecked()) && (!radio212.isChecked()) && (!radio213.isChecked()) && (!radio214.isChecked())) {
            radio210.setError("דרושה התשובה שלך");
            radio210.requestFocus();
            return 0;
        }
        if ((!radio220.isChecked()) && (!radio221.isChecked()) && (!radio222.isChecked()) && (!radio223.isChecked()) && (!radio224.isChecked())) {
            radio220.setError("דרושה התשובה שלך");
            radio220.requestFocus();
            return 0;
        }
        if ((!radio230.isChecked()) && (!radio231.isChecked()) && (!radio232.isChecked()) && (!radio233.isChecked()) && (!radio234.isChecked())) {
            radio230.setError("דרושה התשובה שלך");
            radio230.requestFocus();
            return 0;
        }
        if ((!radio240.isChecked()) && (!radio241.isChecked()) && (!radio242.isChecked()) && (!radio243.isChecked()) && (!radio244.isChecked())) {
            radio240.setError("דרושה התשובה שלך");
            radio240.requestFocus();
            return 0;
        }
        if ((!radio250.isChecked()) && (!radio251.isChecked()) && (!radio252.isChecked()) && (!radio253.isChecked()) && (!radio254.isChecked())) {
            radio250.setError("דרושה התשובה שלך");
            radio250.requestFocus();
            return 0;
        }
        if ((!radio260.isChecked()) && (!radio261.isChecked()) && (!radio262.isChecked()) && (!radio263.isChecked()) && (!radio264.isChecked())) {
            radio260.setError("דרושה התשובה שלך");
            radio260.requestFocus();
            return 0;
        }
        if ((!radio270.isChecked()) && (!radio271.isChecked()) && (!radio272.isChecked()) && (!radio273.isChecked()) && (!radio274.isChecked())) {
            radio270.setError("דרושה התשובה שלך");
            radio270.requestFocus();
            return 0;
        }
        if ((!radio280.isChecked()) && (!radio281.isChecked()) && (!radio282.isChecked()) && (!radio283.isChecked()) && (!radio284.isChecked())) {
            radio280.setError("דרושה התשובה שלך");
            radio280.requestFocus();
            return 0;
        }
        if ((!radio290.isChecked()) && (!radio291.isChecked()) && (!radio292.isChecked()) && (!radio293.isChecked()) && (!radio294.isChecked())) {
            radio290.setError("דרושה התשובה שלך");
            radio290.requestFocus();
            return 0;
        }
        if ((!radio2100.isChecked()) && (!radio2101.isChecked()) && (!radio2102.isChecked()) && (!radio2103.isChecked()) && (!radio2104.isChecked())) {
            radio2100.setError("דרושה התשובה שלך");
            radio2100.requestFocus();
            return 0;
        }
        if ((!radio2110.isChecked()) && (!radio2111.isChecked()) && (!radio2112.isChecked()) && (!radio2113.isChecked()) && (!radio2114.isChecked())) {
            radio2110.setError("דרושה התשובה שלך");
            radio2110.requestFocus();
            return 0;

        }
        //everything full

        return 1;

    }


}

