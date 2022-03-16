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

public class SignUp extends AppCompatActivity {
    public FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
    }

    public void register(View view) {
        EditText email=findViewById(R.id.editTextEmail);
        EditText password =findViewById(R.id.editPhone);
        mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this," בתור התחלה מס' הפלאפון ישמש כסיסמה",Toast.LENGTH_LONG).show();
                            // Sign in success, upda
                            // te UI with the signed-in user's information

                        } else {
                            Toast.makeText(SignUp.this,"ההרשמה נכשלה:)",Toast.LENGTH_LONG).show();
                            // If sign in fails, display a message to the user.

                        }
                    }
                });
    }
}
