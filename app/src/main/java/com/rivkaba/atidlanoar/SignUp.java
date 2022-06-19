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
import android.widget.EditText;
import android.widget.Spinner;
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
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class SignUp extends AppCompatActivity {
    public FirebaseAuth mAuth;
    public FirebaseFirestore db;
    ArrayList<String> team = new ArrayList<String>();

    //  public String[] ArrayTeam= new String[] { "רשות מקומית", "עמותה ", "פרטי" };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        Spinner teamSpinner = (Spinner) findViewById(R.id.team_spinner);

        //$$$$$$$$$$$$$$$$$$$
        //$$$$$$$$$$$$$$$$$$
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        db.collection("Teams")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    //  public String[] ArrayTeamm;
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot doc : task.getResult()) {
                                    if ((Boolean.TRUE.equals(doc.getBoolean("old"))) != true) {
                                team.add(doc.getString("name"));
                               //  Toast.makeText(SignUp.this, doc.getString("name"), Toast.LENGTH_SHORT).show();
                                   }
                            }
                            //   ArrayTeamm = new String[team.size()];
                            //    team.toArray(ArrayTeamm);
                        } else {
                            Toast.makeText(SignUp.this, "Error", Toast.LENGTH_LONG).show();
                            //   Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
        //@@@@@@@@@@@@@@@@@@@@@@
        // *********************************************
//        db.collection("Teams").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            public String[] ArrayTeamm;
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                //   Map<String, Object> team = new HashMap<>();
//
//
//                ArrayList<String> team = new ArrayList<String>();
//                    for (DocumentSnapshot doc : task.getResult()) {
//                            if ((doc.getBoolean("old")) != true) {
//                                team.add(doc.getString("name"));
//
//                            }
//                        }
//
//
//
//                ArrayTeamm = new String[team.size()];
//               team.toArray(ArrayTeamm);
//               int i;
//                for (i=0;i<team.size();i++) {
//                    Toast.makeText(SignUp.this, ArrayTeamm[i], Toast.LENGTH_LONG).show();
//
//                }
//
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(SignUp.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
        //***********************************
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, team);
        //     adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        teamSpinner.setAdapter(adapter);
        teamSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void register(View view) {
        EditText ID = findViewById(R.id.editTexID);
        EditText Email = findViewById(R.id.editTextEmail);
        EditText Fname = findViewById(R.id.editTextName);
        EditText Lname = findViewById(R.id.editTextLName);
        EditText Phone = findViewById(R.id.editPhone);
        mAuth.createUserWithEmailAndPassword(Email.getText().toString(), Phone.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this, " בתור התחלה מס' הפלאפון ישמש כסיסמה", Toast.LENGTH_LONG).show();
                            // Sign in success, upda
                            // te UI with the signed-in user's information
                            //register in waitforapproval
                            String Team = findViewById(R.id.editPhone).toString();//*************************
                            String TeamName = findViewById(R.id.editPhone).toString();//***********
                            String id = ID.getText().toString();
                            String email = Email.getText().toString();
                            String fname = Fname.getText().toString();
                            String lname = Lname.getText().toString();
                            String phone = Phone.getText().toString();
                            String uid = mAuth.getUid();
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
                            waitforapproval.put("teamName", phone);
                            waitforapproval.put("type", "students");
                            waitforapproval.put("uid", uid);
// Add a new document with a generated ID
                            db.collection("waitforapproval")
                                    .add(waitforapproval)
                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            Toast.makeText(SignUp.this, "נרשמת בהצלחה ", Toast.LENGTH_LONG).show();
                                            //Opening questionnaire
                                            Intent intent = new Intent(SignUp.this, Opening_questionnaire.class);
//                                          startActivity(intent);
                                            startActivity(intent);
                                        }
//                                         Intent intent = new Intent(SignUp.this, Student.class);
//                                          startActivity(intent);
//                                      startActivity(new Intent(SignUp.this,Student.class));
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(SignUp.this, "הרשמה נכשלה", Toast.LENGTH_LONG).show();
                                        }
                                    });
                        } else {
                            Toast.makeText(SignUp.this, "ההרשמה נכשלה:)", Toast.LENGTH_LONG).show();
                            // If sign in fails, display a message to the user.
                        }
                    }
                });
//        EditText email=findViewById(R.id.editTextEmail);
//        EditText password =findViewById(R.id.editPhone);
    }


}