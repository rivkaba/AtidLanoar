package com.rivkaba.atidlanoar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

public class Fast_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_screen);
        /****** Create Thread that will sleep for 4 seconds****/
        Thread background = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 4 seconds
                    SystemClock.sleep(4000);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(Fast_screen.this,Login.class);
                    startActivity(i);

                    //Remove activity
                    finish();
                } catch (Exception e) {
                }
            }
        };
        // start thread
        background.start();
    }
    }
