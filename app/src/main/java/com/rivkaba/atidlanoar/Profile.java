package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Profile extends AppCompatActivity {
    public FirebaseAuth mAuth;
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
        mAuth = FirebaseAuth.getInstance();
    }
    // Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuItem menuItem1 = menu.add("מילוי משוב");
        MenuItem menuItem2 = menu.add("שאלון פתיחה");
        MenuItem menuItem3 = menu.add("שאלון סיום");
        MenuItem menuItem4 = menu.add("יציאה");
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
                ////fill one time
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    uid = user.getUid();
                    DocumentReference docRef = db.collection("students").document(uid).collection("Opening questionnaire").document("form");
                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task1) {
                            if (task1.isSuccessful()) {
                                DocumentSnapshot document = task1.getResult();
                                if (document.exists()) {
                                    Toast.makeText(Profile.this, " כבר מילאת שאלון פתיחה", Toast.LENGTH_LONG).show();
                                } else {
                                    startActivity(new Intent(Profile.this, Opening_questionnaire.class));

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
                ////fill one time
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    uid = user.getUid();
                    DocumentReference docRef = db.collection("students").document(uid).collection("Summary questionnaire").document("form");
                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task1) {
                            if (task1.isSuccessful()) {
                                DocumentSnapshot document = task1.getResult();
                                if (document.exists()) {
                                    Toast.makeText(Profile.this, " כבר מילאת שאלון סיום", Toast.LENGTH_LONG).show();
                                } else {
                                    startActivity(new Intent(Profile.this, Summary_questionnaire.class));

                                }
                            }

                        }

                    });
                }
                /////
                return true;
            }
        });

        menuItem4.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
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
        Fname1 = findViewById(R.id.f_name);
        Lname1 = findViewById(R.id.l_name);
        Phone1 = findViewById(R.id.phone);
        Password11 = findViewById(R.id.password1);
        Password21 = findViewById(R.id.password2);
        String Fname = Fname1.getText().toString();
        String Lname = Lname1.getText().toString();
        String Phone = Phone1.getText().toString();
        String Password1 = Password11.getText().toString();
        String Password2 = Password21.getText().toString();
        if (Password1.length()>6)
        {
            Password11.setError("הסיסמה חייבת להכיל לפחות 6 תווים");
            Password11.requestFocus();
            return;
        }
        if (!Password1.equals(Password2)){
            Password21.setError("הסיסמה אינה תואמת לאימות");
             Password21.requestFocus();
        return;
    }

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.updatePassword(Password1)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Profile.this, "  הפרופיל השתנה בהצלחה", Toast.LENGTH_LONG).show();

                        }

                    }
                });

        //___________
       // mAuth.getCurrentUser().updatePassword(Password1);

        if (user != null) {

//            final String email = user.getEmail();
//            String oldpass = user.getp();
//
//
//            AuthCredential credential = EmailAuthProvider.getCredential(email,oldpass);
//
//            user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
//                @Override
//                public void onComplete(@NonNull Task<Void> task) {
//                    if(task.isSuccessful()){
//                        user.updatePassword(Password1).addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if(!task.isSuccessful()){
//
//                                }else {
//
//                                }
//                            }
//                        });
//                    }else {
//
//                    }
//                }
//            });
//        }
        /////////////////////
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