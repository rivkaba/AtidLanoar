package com.rivkaba.atidlanoar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
import java.util.Objects;

public class SignUp extends AppCompatActivity {
    public FirebaseAuth mAuth;
    public FirebaseFirestore db;
    ArrayList<String> team = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    String teamName;
    String teamId="";
    private QuerySnapshot Teams;
private ProgressDialog progressDialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        progressDialog= new ProgressDialog(SignUp.this);
        progressDialog.setTitle("loading");
        progressDialog.setMessage("please wait");
         Spinner teamSpinner = (Spinner) findViewById(R.id.team_spinner);

        adapter= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,team);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teamSpinner.setAdapter(adapter);
        teamSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                  @Override
                                                  public void onItemSelected(AdapterView<?> adapterView, View view,
                                                                             int i, long l) {
                                                      teamName=adapter.getItem(i);
                                                    //  Toast.makeText(getApplicationContext(), adapter.getItem(i), Toast.LENGTH_SHORT).show();
                                               //       teamId=Teams.getDocuments().get(i).getId();
                                                  }

                                                  public void onNothingSelected(AdapterView<?> adapterView) {
                                                  }
                                              });

        getData();
  }

    public void register(View view) {
        EditText ID = findViewById(R.id.ID);
        EditText Email = findViewById(R.id.email);
        EditText Fname = findViewById(R.id.f_name);
        EditText Lname = findViewById(R.id.l_name);
        EditText Phone = findViewById(R.id.Phone);
        if(Fname.getText().toString().equals("")) {
            Fname.setError("דרוש שמך");
            Fname.requestFocus();
            return;
        }
        if(Lname.getText().toString().equals("")) {
            Lname.setError("דרוש שם משפחתך");
            Lname.requestFocus();
            return;
        }

        if(Phone.getText().toString().equals("")) {
            Phone.setError("דרוש פלאפון");
            Phone.requestFocus();
            return;
        }
        if(ID.getText().toString().equals("")) {
            ID.setError("דרוש תעודת זהות");
            ID.requestFocus();
            return;
        }
        if(Email.getText().toString().equals("")) {
            Email.setError("דרוש מייל");
            Email.requestFocus();
            return;
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
                                    /////////////////
//                                    db.collection("Teams")
//                                            .whereEqualTo("name", teamName)
//                                            .get()
//                                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                                                @Override
//                                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                                    if (task.isSuccessful()) {
//                                                        for (QueryDocumentSnapshot document : task.getResult()) {
//                                                            teamId=document.getId();
//                                                         //   Log.d(TAG, document.getId() + " => " + document.getData());
//                                                        }
//                                                    } else {
//                                                          Toast.makeText(getApplicationContext(), "אנא בחר שוב קבוצה", Toast.LENGTH_SHORT).show();
//                                                    }
//                                                }
//                                            });
                                    /////////////////////
                                    /////////////
//                                    db.collection("Teams").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                                        @Override
//                                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                                            if (queryDocumentSnapshots.size() > 0) {
//
//                                                for (DocumentSnapshot doc : queryDocumentSnapshots) {
//                                                    if (Objects.equals(doc.getString("name"), teamName)) {
//                                                        teamId= doc.getId();
//                                                    }
//                                                }
//
//                                            }
//                                        }
//                                    }).addOnFailureListener(new OnFailureListener() {
//                                        @Override
//                                        public void onFailure(@NonNull Exception e) {
//                                            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//
//                                        }
//                                    });
                                    ///////////////////
                                    // Toast.makeText(SignUp.this,uid,Toast.LENGTH_LONG).show();
                                    //  User user= new User( ID, false,email, fname, lname, phone, team, teamName, "student") ;
                                    Map<String, Object> waitforapproval = new HashMap<>();
                                    waitforapproval.put("ID", id);
                                    waitforapproval.put("approve", false);
                                    waitforapproval.put("email", email);
                                    waitforapproval.put("fname", fname);
                                    waitforapproval.put("lname", lname);
                                    waitforapproval.put("phone", phone);
                                    waitforapproval.put("team", teamId);
                                    waitforapproval.put("teamName", teamName);
                                    waitforapproval.put("type", "students");
                                    waitforapproval.put("uid", uid);
// Add a new document with a generated ID
                                    db.collection("waitforapproval").document(uid).set(waitforapproval)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    Toast.makeText(SignUp.this, " נרשמת בהצלחה", Toast.LENGTH_LONG).show();
                                                    Intent intent = new Intent(SignUp.this, Login.class);
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
    private void getData(){
        progressDialog.show();
        db.collection("Teams").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                progressDialog.hide();
                Teams = queryDocumentSnapshots;
                if (queryDocumentSnapshots.size() > 0) {
                    team.clear();
                    for (DocumentSnapshot doc : queryDocumentSnapshots) {
                        if (!(Boolean.TRUE.equals(doc.getBoolean("old")))) {
                            team.add(doc.getString("name"));
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
