package com.rivkaba.atidlanoar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.util.UidVerifier;
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
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
public class SignUp extends AppCompatActivity {
    public FirebaseAuth mAuth;
    public FirebaseFirestore db;
    ArrayList<String> team = new ArrayList<String>();
    String teamName;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        Spinner teamSpinner = (Spinner) findViewById(R.id.team_spinner);


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        db.collection("Teams")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    //  public String[] ArrayTeamm;
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot doc : task.getResult()) {
                                    if (!(Boolean.TRUE.equals(doc.getBoolean("old")))) {
                                team.add(doc.getString("name"));
                               //  Toast.makeText(SignUp.this, doc.getString("name"), Toast.LENGTH_SHORT).show();
                                   }
                            }

                        } else {
                            Toast.makeText(SignUp.this, "Error", Toast.LENGTH_LONG).show();
                              // Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
        //@@@@@@@@@@@@@@@@@@@@@@

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, team);
        //     adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        teamSpinner.setAdapter(adapter);
        teamSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

               // teamSpinner.
              //  Log.v("item", (String) parent.getItemAtPosition(position));
          //      Toast.makeText(SignUp.this,(String) parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();

                teamName =(String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void register(View view) {
        EditText ID = findViewById(R.id.ID);
        EditText Email = findViewById(R.id.email);
        EditText Fname = findViewById(R.id.f_name);
        EditText Lname = findViewById(R.id.l_name);
        EditText Phone = findViewById(R.id.Phone);
        if(Fname.getText().toString().equals("")) {
            Fname.setHintTextColor(getResources().getColor(R.color.design_default_color_error));
        }
        if(Lname.getText().toString().equals("")) {
            Lname.setHintTextColor(getResources().getColor(R.color.design_default_color_error));
        }

        if(Phone.getText().toString().equals("")) {
            Phone.setHintTextColor(getResources().getColor(R.color.design_default_color_error));
        }
        if(ID.getText().toString().equals("")) {
            ID.setHintTextColor(getResources().getColor(R.color.design_default_color_error));
        }
        if(Email.getText().toString().equals("")) {
            Email.setHintTextColor(getResources().getColor(R.color.design_default_color_error));
        }

        if((!Fname.getText().toString().equals(""))&&(!Lname.getText().toString().equals(""))&&(!Phone.getText().toString().equals(""))&&(!ID.getText().toString().equals(""))&&(!Email.getText().toString().equals("")))
            {
                mAuth.createUserWithEmailAndPassword(Email.getText().toString(), Phone.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignUp.this, " בתור התחלה מס' הפלאפון ישמש כסיסמה", Toast.LENGTH_LONG).show();
                                    // Sign in success, upda
                                    // te UI with the signed-in user's information
                                    //register in waitforapproval
                                    String Team = findViewById(R.id.Phone).toString();//*************************

                                    String id = ID.getText().toString();
                                    String email = Email.getText().toString();
                                    String fname = Fname.getText().toString();
                                    String lname = Lname.getText().toString();
                                    String phone = Phone.getText().toString();
                                    String uid="";
                                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                    if (user != null) {
                                         uid = user.getUid();
                                    }
                                    // Toast.makeText(SignUp.this,uid,Toast.LENGTH_LONG).show();
                                    //  User user= new User( ID, false,email, fname, lname, phone, team, teamName, "student") ;
                                    Map<String, Object> waitforapproval = new HashMap<>();
                                    waitforapproval.put("ID", id);
                                    waitforapproval.put("approve", false);
                                    waitforapproval.put("email", email);
                                    waitforapproval.put("fname", fname);
                                    waitforapproval.put("lname", lname);
                                    waitforapproval.put("phone", phone);
                                    waitforapproval.put("team", phone);
                                    waitforapproval.put("teamName", teamName);
                                    waitforapproval.put("type", "students");
                                    waitforapproval.put("uid", uid);
// Add a new document with a generated ID
                                    db.collection("waitforapproval").document(uid).set(waitforapproval)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    Toast.makeText(SignUp.this, " נרשמת בהצלחה", Toast.LENGTH_LONG).show();
                                                    Intent intent = new Intent(SignUp.this, Student.class);
                                                    startActivity(intent);
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Toast.makeText(SignUp.this, "הרשמה נכשלה", Toast.LENGTH_LONG).show();

                                                }
                                            });



                            }else {
                                    Toast.makeText(SignUp.this, "ההרשמה נכשלה:)", Toast.LENGTH_LONG).show();
                                    // If sign in fails, display a message to the user.
                                }
                            }
                        });

            }
        }

    public void login(View view) {
        startActivity(new Intent(SignUp.this,Login.class));

    }

    public void back(View view) {
        startActivity(new Intent(SignUp.this,MainActivity.class));

    }
}