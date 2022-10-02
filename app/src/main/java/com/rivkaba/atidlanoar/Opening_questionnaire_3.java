package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Opening_questionnaire_3 extends AppCompatActivity {
    private ScrollView scrollView3;
    RatingBar q31;
    RatingBar q32;
    RatingBar q33;
    RatingBar q34;
    String Q31;
    String Q32;
    String Q33;
    String Q34;
    TextView qq31;
    TextView qq32;
    TextView qq33;
    TextView qq34;

    String uid;
    public FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_questionnaire3);
        db = FirebaseFirestore.getInstance();
        scrollView3 = (ScrollView) findViewById(R.id.Scroll_view_questionnaire_3);
        q31 = (RatingBar) findViewById(R.id.q31);
        q32 = (RatingBar) findViewById(R.id.q32);
        q33 = (RatingBar) findViewById(R.id.q33);
        q34 = (RatingBar) findViewById(R.id.q34);
        qq31 = (TextView) findViewById(R.id.qq31);
        qq32 = (TextView) findViewById(R.id.qq32);
        qq33 = (TextView) findViewById(R.id.qq33);
        qq34 = (TextView) findViewById(R.id.qq34);


    }

    public void P1(View view) {
        Intent intent = new Intent(Opening_questionnaire_3.this, Opening_questionnaire.class);
        intent.putExtra("part", "P1");
        startActivity(intent);

    }

    public void P2(View view) {
        startActivity(new Intent(Opening_questionnaire_3.this, Opening_questionnaire_2.class));
    }


    //part 4
    public void P4(View view) {
        startActivity(new Intent(Opening_questionnaire_3.this, Opening_questionnaire_4.class));
    }


//part3
    public void save(View view) {
        if(send2()==1) {
            Map<String, Object> part3 = new HashMap<>();

            part3.put("q31", Q31);
            part3.put("q32", Q32);
            part3.put("q33", Q33);
            part3.put("q34", Q34);
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                uid = user.getUid();
            }
            db.collection("students").document(uid).collection("questionnaires").document("Opening questionnaire").collection("answers").document("part3").set(part3)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(Opening_questionnaire_3.this, " תודה, הטופס נשלח בהצלחה", Toast.LENGTH_LONG).show();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Opening_questionnaire_3.this, "השליחה נכשלה", Toast.LENGTH_LONG).show();

                        }
                    });
        }

    }


  public int  send2(){
      Q31=String.valueOf(q31.getRating());
      Q32=String.valueOf(q32.getRating());
      Q33=String.valueOf(q33.getRating());
      Q34=String.valueOf(q34.getRating());
      if(Objects.equals(Q31, "0.0")) {
          qq31.setError("נחוץ קורות חיים");
          qq31.requestFocus();
          return 0;
      }
      if(Objects.equals(Q32, "0.0")) {
          qq32.setError("נחוץ ראיון עבודה");
          qq32.requestFocus();
          return 0;
      }
      if(Objects.equals(Q33, "0.0")) {
          qq33.setError("נחוץ כתיבת תוכנית עסקית");
          qq33.requestFocus();
          return 0;
      }
      if(Objects.equals(Q34, "0.0")) {
          qq33.setError("נחוץ תכנון גאנט עבודה");
          qq33.requestFocus();
          return 0;
      }
      return 1;
  }


}

