package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    public FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            startActivity(new Intent(Login.this,Student .class));


        }
    }
        public void login(View view) {
            EditText email=findViewById(R.id.editEmail);
            EditText password =findViewById(R.id.editPassword);

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