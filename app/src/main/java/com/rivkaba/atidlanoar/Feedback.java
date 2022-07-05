package com.rivkaba.atidlanoar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(Feedback.this, MainActivity.class));

    }
   // Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuItem menuItem1 = menu.add("פרופיל");
        MenuItem menuItem2 = menu.add("שאלות סיום");
        MenuItem menuItem3 = menu.add("יציאה");
        menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                startActivity(new Intent(Feedback.this,Profile.class));
                return true;
            }
        });
        menuItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
         {
             @Override
             public boolean onMenuItemClick(MenuItem item)
             {
                 startActivity(new Intent(Feedback.this,Summary_questionnaire.class));
                 return true;
             }
         });
        menuItem3.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Feedback.this,Login.class));
                return true;
            }
        });
        return true;
    }

    // end Menu

//    @Override
//    public boolean onCreateOptionsMenu(final Menu menu) {
//        super.onCreateOptionsMenu(menu);
//
//        MenuItem privateState = menu.add("Call to manegment");
//        MenuItem exitMenu = menu.add("Exit");
//
//        privateState.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                CallToManegment();
//                return false;
//            }
//        });
//
//        exitMenu.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                exitApp();
//                return false;
//            }
//        });
//
//        return true;
//    }
//
//    private void exitApp() {
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
//        alertDialog.setTitle("Exit ");
//        alertDialog.setMessage("Do you want to exit ?");
//        alertDialog.setCancelable(false);
//        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener()
//            @Override
//            public void onClick (DialogInterface dialog,int which){
//                FirebaseAuth.getInstance().signOut();
//                Toast.makeText(Feedback.this, "Bye Bye ...", Toast.LENGTH_LONG).show();
//                finish();  // destroy this activity
//                //System.exit(0);
//                //  android.os.Process.killProcess(android.os.Process.myPid());
//                moveTaskToBack(true);
//
//
//            }
//        });
//        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss(); // close the dialog
//            }
//        });
//        alertDialog.show();
//    }
//
//    private void CallToManegment() {
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
//        alertDialog.setTitle("Exit ");
//        alertDialog.setMessage("Do you want to Call to manegment ?");
//        alertDialog.setCancelable(false);
//        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent = new Intent(Feedback.this, Login.class);
//                startActivity(intent);
//                //  android.os.Process.killProcess(android.os.Process.myPid());
//                //moveTaskToBack(true);
//
//            }
//        });
//        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss(); // close the dialog
//            }
//        });
//        alertDialog.show();
//        singIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Feedback.this, Login.class);
//                startActivity(intent);
//                finish();
//            }
//
//        });

 //   }
}