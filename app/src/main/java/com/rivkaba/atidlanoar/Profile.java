package com.rivkaba.atidlanoar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class Profile extends AppCompatActivity {
    String uid;
    EditText Fname ;
    EditText Lname ;
    EditText Phone ;
    EditText Password1 ;
    EditText Password2 ;
    public FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        db = FirebaseFirestore.getInstance();
    }
    // Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuItem menuItem1 = menu.add("מילוי משוב");
        MenuItem menuItem2 = menu.add("שאלות סיום");
        MenuItem menuItem3 = menu.add("יציאה");
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
                startActivity(new Intent(Profile.this,Summary_questionnaire.class));
                return true;
            }
        });
        menuItem3.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
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
        Fname = findViewById(R.id.fName);
        Lname = findViewById(R.id.lName);
         Phone = findViewById(R.id.phone);
         Password1 = findViewById(R.id.password1);
         Password2 = findViewById(R.id.password2);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            //  boolean emailVerified = user.isEmailVerified();
            uid = user.getUid();
//            Map<String, Object> city = new HashMap<>();
//            city.put("name", "Los Angeles");
//            city.put("state", "CA");
//            city.put("country", "USA");
//
//            db.collection("students").document(uid)
//                    .set(city)
//                    .addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void aVoid) {
//                            Log.d(TAG, "DocumentSnapshot successfully written!");
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Log.w(TAG, "Error writing document", e);
//                        }
//                    });
            ///////////////////
            db.collection("students").document(uid)
                    .update(
                            "fname", "רבקה",
                            "lname", "ישראל"

                    );

        }
}
    }