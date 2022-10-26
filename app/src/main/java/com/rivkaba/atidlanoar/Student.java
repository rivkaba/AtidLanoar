package com.rivkaba.atidlanoar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

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

    public void signout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(Student.this,MainActivity.class));
    }
    // Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuItem menuItem1 = menu.add("שאלון סיום");
        MenuItem menuItem2 = menu.add("שאלון פתיחה");
        MenuItem menuItem3 = menu.add("עדכון פרופיל");
        MenuItem menuItem4 = menu.add("יציאה");


        menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                startActivity(new Intent(Student.this,Summary_questionnaire.class));
                return true;
            }
        });
        menuItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Student.this,Opening_questionnaire.class));
                return true;
            }
        });
        menuItem3.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Student.this,Profile.class));
                return true;
            }
        });
        menuItem4.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Student.this,Login.class));
                return true;
            }
        });
        return true;
    }
    //end Menu
}