package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    public FirebaseAuth mAuth;
    public FirebaseFirestore db;
    public  String[] items ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


        Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        ArrayList<String> team = new ArrayList<String>();
        db.collection("Teams")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot doc : task.getResult()) {
                                if ((Boolean.TRUE.equals(doc.getBoolean("old"))) != true) {
                                    team.add(doc.getString("name"));
                                }
                                items = new String[team.size()];
                                    team.toArray(items);
                                    for (int i=0;i<team.size();i++)
                                    {
                                        Toast.makeText(Login.this,items[i], Toast.LENGTH_LONG).show();

                                    }
                            }

                        } else {
                            Toast.makeText(Login.this, "Error", Toast.LENGTH_LONG).show();
                            // Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
        //@@@@@@@@@@@@@@@@@@@@@@

 //  String[] items = new String[] { "רשות מקומית", "עמותה ", "פרטי" };

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, team);

        dynamicSpinner.setAdapter(adapter);

        dynamicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
        int position, long id) {
            Toast.makeText(Login.this, (String) parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
       //     Log.v("item", (String) parent.getItemAtPosition(position));
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // TODO Auto-generated method stub
        }
    });



    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            startActivity(new Intent(Login.this,Opening_questionnaire .class));


        }
    }
        public void login(View view) {
            EditText email=findViewById(R.id.Email);
            EditText password =findViewById(R.id.Password);

            mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                startActivity(new Intent(Login.this,Student.class));
                          /*  Intent intent = new Intent(LoginActivity.this, profile.class);
                            intent.putExtra("mAuth", FirebaseAuth.getInstance());
                            startActivity(intent);*/
                            } else {
                                Toast.makeText(Login.this,"כניסה נכשלה:)",Toast.LENGTH_LONG).show();
                                // If sign in fails, display a message to the user.

                            }
                        }

                    });

            }

    public void register(View view) {
        startActivity(new Intent(Login.this,SignUp.class));
    }

}