package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Opening_questionnaire_4 extends AppCompatActivity {
    private ScrollView scrollView4;
    EditText q41;
    EditText q42;
    String uid;
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
        Map<String, Object> part4 = new HashMap<>();

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
        part4.put("q41", q41.getText().toString());
        part4.put("q42", q42.getText().toString());


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            uid = user.getUid();
        }
        db.collection("students").document(uid).collection("questionnaires").document("Opening questionnaire").collection("answers").document("part4").set(part4)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Opening_questionnaire_4.this, " תודה, הטופס נשלח בהצלחה", Toast.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Opening_questionnaire_4.this, "השליחה נכשלה", Toast.LENGTH_LONG).show();

                    }
                });
    }
}