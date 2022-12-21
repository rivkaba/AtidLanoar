package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class Opening_questionnaire_4 extends AppCompatActivity {
    private ScrollView scrollView4;
    EditText q41;
    EditText q42;
    String uid;
    Task<DocumentSnapshot> form;
    public FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = FirebaseFirestore.getInstance();
        setContentView(R.layout.activity_opening_questionnaire4);
        scrollView4 = (ScrollView) findViewById(R.id.Scroll_view_questionnaire_4);
        q41 = findViewById(R.id.q41);
        q42 = findViewById(R.id.q42);
    }
    public void save4(View view) {
        Map<String, Object> form = new HashMap<>();
        Map<String, Object> form1 = new HashMap<>();

        if(q41.getText().toString().equals(""))
        {
            q41.setError("התשובה שלך");
            q41.requestFocus();
            return;
        }

        if (q42.getText().toString().equals("")) {
            q42.setError("התשובה שלך");
            q42.requestFocus();
            return;
        }
        form.put("gender", getIntent().getExtras().getString("gender"));
        form.put("age", getIntent().getExtras().getString("age"));
        form.put("q1", getIntent().getExtras().getString("q1"));
        form.put("q2", getIntent().getExtras().getString("q2"));
        form.put("q3", getIntent().getExtras().getString("q3"));
        form.put("q4", getIntent().getExtras().getString("q4"));
        form.put("q5", getIntent().getExtras().getString("q5"));
        form.put("q6", getIntent().getExtras().getString("q6"));
        form.put("q7", getIntent().getExtras().getString("q7"));
        form.put("q8", getIntent().getExtras().getString("q8"));
        form.put("q9", getIntent().getExtras().getString("q9"));
        form.put("q10", getIntent().getExtras().getString("q10"));
        form.put("q11", getIntent().getExtras().getString("q11"));
        form.put("q2_1", getIntent().getExtras().getString("q2_1"));
        form.put("q2_2", getIntent().getExtras().getString("q2_2"));
        form.put("q2_3", getIntent().getExtras().getString("q2_3"));
        form.put("q2_4",getIntent().getExtras().getString("q2_4"));
        form.put("hopeTostudy", q41.getText().toString());
        form.put("needTostudy", q42.getText().toString());
        form1.put("form",form);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            uid = user.getUid();
        }
       // db.collection("students").document(uid).collection("questionnaires").document("Opening questionnaire").collection("answers").document("part4").set(part4)
        db.collection("students").document(uid).collection("Opening questionnaire").document("form").set(form1)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Opening_questionnaire_4.this, " תודה, הטופס נשלח בהצלחה", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(Opening_questionnaire_4.this,Student.class));

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Opening_questionnaire_4.this, "השליחה נכשלה", Toast.LENGTH_LONG).show();

                    }
                });
    /*  form =  db.collection("students").document(uid).collection("Opening questionnaire").document("form").get();
        Map<String, Object> form1 = new HashMap<>();
        for (DocumentSnapshot item:form) {
            form1.put(item);

        }
        form1.put("form",form);
        db.collection("students").document(uid).collection("Opening questionnaire").document("form").set(form1);
*/
    }
}