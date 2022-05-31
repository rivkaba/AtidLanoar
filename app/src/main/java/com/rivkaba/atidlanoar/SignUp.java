package com.rivkaba.atidlanoar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    public FirebaseAuth mAuth;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
    }

    public void register(View view) {

       EditText ID= findViewById(R.id.editTexID);
        EditText Email=findViewById(R.id.editTextEmail);
        EditText Fname= findViewById(R.id.editTextName);
        EditText Lname=findViewById(R.id.editTextLName);
        EditText Phone=findViewById(R.id.editPhone);

     mAuth.createUserWithEmailAndPassword(Email.getText().toString(), Phone.getText().toString())
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



        String   Team=findViewById(R.id.editPhone).toString();//*************************
        String TeamName=findViewById(R.id.editPhone).toString();//***********
        String id=ID.getText().toString();
        String email=Email.getText().toString();
        String fname=Fname.getText().toString();
        String lname=Lname.getText().toString();
        String phone=Phone.getText().toString();
        String uid= mAuth.getUid();

       // Toast.makeText(SignUp.this,uid,Toast.LENGTH_LONG).show();

        //  User user= new User( ID, false,email, fname, lname, phone, team, teamName, "student") ;
        Map<String, Object> waitforapproval = new HashMap<>();
        waitforapproval.put("ID",id);
        waitforapproval.put("approve",false);
        waitforapproval.put("email", email);
        waitforapproval.put("fname", fname);
        waitforapproval.put("lname", lname);
        waitforapproval.put("phone", phone);
        waitforapproval.put("team", phone);
        waitforapproval.put("teamName", phone);
        waitforapproval.put("type", "students");
        waitforapproval.put("uid", uid);






// Add a new document with a generated ID
        db.collection("waitforapproval")
                .add(waitforapproval)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {

        @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(SignUp.this,"נרשמת בהצלחה " ,Toast.LENGTH_LONG).show();                    }
                   // Intent intent = new Intent(SignUp.this, Student.class);
                  //  startActivity(intent);
                 //   startActivity(new Intent(SignUp.this,Student.class));

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignUp.this,"הרשמה נכשלה" ,Toast.LENGTH_LONG).show();
                    }
                });



    }
    private void loadTeam(){
        db.collection("Teams").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                Map<String, Object> team = new HashMap<>();
                for (DocumentSnapshot doc : task.getResult()) {
                    if ((doc.getBoolean("old")) == false)
                        team.put("name", doc.getString("name"));

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUp.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });




}

}

