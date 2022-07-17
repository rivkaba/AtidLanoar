package com.rivkaba.atidlanoar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class Profile extends AppCompatActivity {
    String uid;
    EditText Fname1 ;
    EditText Lname1;
    EditText Phone1 ;
    EditText Password11 ;
    EditText Password21 ;
    public FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        db = FirebaseFirestore.getInstance();
    }
    // Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuItem menuItem1 = menu.add("מילוי משוב");
        MenuItem menuItem2 = menu.add("שאלות סיום");
        MenuItem menuItem3 = menu.add("יציאה");
        menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                startActivity(new Intent(Profile.this,Feedback.class));
                return true;
            }
        });
        menuItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                startActivity(new Intent(Profile.this,Summary_questionnaire.class));
                return true;
            }
        });
        menuItem3.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Profile.this,Login.class));
                return true;
            }
        });
        return true;
    }
    //end Menu
    public void back(View view) {
        startActivity(new Intent(Profile.this,Student.class));

    }


    public void update(View view) {
        Fname1 = findViewById(R.id.fName);
        Lname1 = findViewById(R.id.lName);
         Phone1 = findViewById(R.id.phone);
         Password11 = findViewById(R.id.password1);
         Password21 = findViewById(R.id.password2);
        String Fname = Fname1.getText().toString();
        String Lname = Lname1.getText().toString();
        String Phone = Phone1.getText().toString();
        String Password1 = Password11.getText().toString();
        String Password2 = Password21.getText().toString();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            //  boolean emailVerified = user.isEmailVerified();
            uid = user.getUid();
            db.collection("students").document(uid)
                    .update(
                            "fname", Fname,
                            "lname", Lname,
                            "phone",Phone

                    );

        }
}
    }