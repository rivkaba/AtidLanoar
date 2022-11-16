package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class Login extends AppCompatActivity {
    public FirebaseAuth mAuth;
    public FirebaseFirestore db;
    String uid = "";
    //  final Task<DocumentSnapshot> type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            ////if have ok from management
            uid = user.getUid();
            DocumentReference docRef = db.collection("students").document(uid);
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task1) {
                    if (task1.isSuccessful()) {
                        DocumentSnapshot document = task1.getResult();
                        if (document.exists()) {
                            startActivity(new Intent(Login.this,Student.class));
                        } else {
                            Toast.makeText(Login.this, "יש לחכות לאישור המנהל", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(Login.this, "הכניסה נכשלה", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
        //////
    }




        public void login(View view) {
            EditText email=findViewById(R.id.email);

            EditText password =findViewById(R.id.password);
            if(email.getText().toString().equals("")) {
                email.setHintTextColor(getResources().getColor(R.color.design_default_color_error));
            }
            if(password.getText().toString().equals("")) {
                password.setHintTextColor(getResources().getColor(R.color.design_default_color_error));
            }
            if((!email.getText().toString().equals(""))&&(!password.getText().toString().equals(""))) {

                mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                   /////// ////if have ok from management
                                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                    String uid = "";
                                    if (user != null) {
                                        uid = user.getUid();
                                        DocumentReference docRef = db.collection("students").document(uid);
                                        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DocumentSnapshot> task1) {
                                                if (task1.isSuccessful()) {
                                                    DocumentSnapshot document = task1.getResult();
                                                    if (document.exists()) {
                                                        startActivity(new Intent(Login.this, Student.class));
                                                    } else {
                                                        Toast.makeText(Login.this, "יש לחכות לאישור המנהל", Toast.LENGTH_LONG).show();
                                                    }
                                                } else {
                                                    Toast.makeText(Login.this, "הכניסה נכשלה", Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });

                                    }else {
                                        Toast.makeText(Login.this, "יש לבדוק את פרטי כניסה", Toast.LENGTH_LONG).show();
                                    }
                               ///////
                                }
                            }

                        });
            }
                                    }

    public void register(View view) {
        startActivity(new Intent(Login.this,SignUp.class));
    }

    public void forget_password(View view) {
        startActivity(new Intent(Login.this,Forget_password.class));
    }
}