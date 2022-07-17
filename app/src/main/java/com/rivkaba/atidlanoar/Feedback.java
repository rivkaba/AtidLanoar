package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Feedback extends AppCompatActivity  {

    String uid;
    EditText editTextDate;
    EditText feedback1;
    String q1;
    String q2;
    String q3;
    String q4;
    boolean canUpdate=false;
    public FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        db = FirebaseFirestore.getInstance();

    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(Feedback.this, MainActivity.class));

    }
   // Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuItem menuItem1 = menu.add("פרופיל");
        MenuItem menuItem2 = menu.add("שאלות סיום");
        MenuItem menuItem3 = menu.add("יציאה");
        menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                startActivity(new Intent(Feedback.this,Profile.class));
                return true;
            }
        });
        menuItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
         {
             @Override
             public boolean onMenuItemClick(MenuItem item)
             {
                 startActivity(new Intent(Feedback.this,Summary_questionnaire.class));
                 return true;
             }
         });
        menuItem3.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Feedback.this,Login.class));
                return true;
            }
        });
        return true;
    }
    // end Menu
    public void back(View view) {

        startActivity(new Intent(Feedback.this,Student.class));
    }

    public void send(View view) {
        editTextDate =findViewById(R.id.editTextDate);
        feedback1=findViewById(R.id.feedback);
        String feedback = feedback1.getText().toString();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Check if user's email is verified
          //  boolean emailVerified = user.isEmailVerified();
             uid = user.getUid();
        }
        String date1 = editTextDate.getText().toString();
       // canUpdate
        Map<String, Object> docData = new HashMap<>();
        docData.put("approved", true);
        docData.put("date", date1);


        Map<String, Object> form = new HashMap<>();
        form.put("canUpdate", canUpdate);
        form.put("feedback", feedback);

        Map<String, Object> feeedbackMeeting = new HashMap<>();
        feeedbackMeeting.put("q1", q1);
        feeedbackMeeting.put("q2", q2);
        feeedbackMeeting.put("q3", q3);
        feeedbackMeeting.put("q4", q4);

        form.put("feeedbackMeeting", feeedbackMeeting);
        docData.put("from", form);

        db.collection("students").document(uid).collection("comes").document(date1).set(docData)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Feedback.this, " תודה, הטופס נשלח בהצלחה", Toast.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Feedback.this, "השליחה נכשלה", Toast.LENGTH_LONG).show();

                    }
                });

        ///////////////


    }
    //q1
    public void onRadioButtonClicked1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio10:
                if (checked)
                   q1="0";
                    break;
            case R.id.radio11:
                if (checked)
                    q1="1";
                    break;
            case R.id.radio12:
                if (checked)
                    q1="2";
                    break;
            case R.id.radio13:
                if (checked)
                    q1="3";
                break;
            case R.id.radio14:
                if (checked)
                    q1="4";
                break;
        }
    }
//q2

    public void onRadioButtonClicked2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio20:
                if (checked)
                    q2="0";
                break;
            case R.id.radio21:
                if (checked)
                    q2="1";
                break;
            case R.id.radio22:
                if (checked)
                    q2="2";
                break;
            case R.id.radio23:
                if (checked)
                    q2="3";
                break;
            case R.id.radio24:
                if (checked)
                    q2="4";
                break;
        }
    }
//q3
    public void onRadioButtonClicked3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio30:
                if (checked)
                    q3="0";
                break;
            case R.id.radio31:
                if (checked)
                    q3="1";
                break;
            case R.id.radio32:
                if (checked)
                    q3="2";
                break;
            case R.id.radio33:
                if (checked)
                    q3="3";
                break;
            case R.id.radio34:
                if (checked)
                    q3="4";
                break;
        }
    }
//q4
    public void onRadioButtonClicked4(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio40:
                if (checked)
                    q4="0";
                break;
            case R.id.radio41:
                if (checked)
                    q4="1";
                break;
            case R.id.radio42:
                if (checked)
                    q4="2";
                break;
            case R.id.radio43:
                if (checked)
                    q4="3";
                break;
            case R.id.radio44:
                if (checked)
                    q4="4";
                break;
        }
    }
}