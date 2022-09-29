package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class Forget_password extends AppCompatActivity {
private EditText email;
private ProgressBar progressBar;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        email=(EditText) findViewById(R.id.email);
        progressBar=(ProgressBar)findViewById(R.id.progress_bar);
        auth=FirebaseAuth.getInstance();
    }

    public void reset_password(View view) {
        String emaill=email.getText().toString().trim();
        if(emaill.isEmpty())
        {
            email.setError("דרוש איימל");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emaill).matches())
        {
            email.setError("המייל אינו נכון");
            email.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(emaill).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())

                    Toast.makeText(Forget_password.this, "בדוק/י את המייל שלך לשינוי הסיסמה", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Forget_password.this, "נכשל,נסה/י שוב", Toast.LENGTH_LONG).show();

            }
        });
    }
}