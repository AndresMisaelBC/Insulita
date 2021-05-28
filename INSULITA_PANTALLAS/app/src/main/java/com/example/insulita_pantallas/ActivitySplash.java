package com.example.insulita_pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplash extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // mProgress = (ProgressBar) findViewById(R.id.loading);
        //Intent intent= new Intent(ActivitySplash.this, Login.class);
        //startActivity(intent);
        TimerTask Tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(ActivitySplash.this, Login.class );
                startActivity(intent);
                finish();
            }
        };

        // finish();
        Timer tiempo = new Timer();
        tiempo.schedule(Tarea, 3000);


    }

}