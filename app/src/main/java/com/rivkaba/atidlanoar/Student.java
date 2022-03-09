package com.rivkaba.atidlanoar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Student extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
    }

    public void feedback(View view) {
        startActivity(new Intent(Student.this,Feedback.class));
    }

    public void profile(View view) {
        startActivity(new Intent(Student.this,Profile.class));
    }
}