package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Student extends AppCompatActivity {
    public FirebaseFirestore db;
    String uid = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        db = FirebaseFirestore.getInstance();
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
                ////fill one time
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    uid = user.getUid();
                    DocumentReference docRef = db.collection("students").document(uid).collection("Summary questionnaire").document("part4");
                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task1) {
                            if (task1.isSuccessful()) {
                                DocumentSnapshot document = task1.getResult();
                                if (document.exists()) {
                                    Toast.makeText(Student.this, " כבר מילאת שאלון סיום", Toast.LENGTH_LONG).show();
                                } else {
                                    startActivity(new Intent(Student.this, Summary_questionnaire.class));

                                }
                            }

                        }

                    });
                }
                /////
                            return true;
            }
        });
        menuItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                ////fill one time
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    uid = user.getUid();
                    DocumentReference docRef = db.collection("students").document(uid).collection("Opening questionnaire").document("part4");
                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task1) {
                            if (task1.isSuccessful()) {
                                DocumentSnapshot document = task1.getResult();
                                if (document.exists()) {
                                    Toast.makeText(Student.this, " כבר מילאת שאלון פתיחה", Toast.LENGTH_LONG).show();
                                } else {
                                    startActivity(new Intent(Student.this, Opening_questionnaire.class));

                                }
                            }

                        }

                    });
                }
                /////
                return true;
            }
        });
        menuItem3.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
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