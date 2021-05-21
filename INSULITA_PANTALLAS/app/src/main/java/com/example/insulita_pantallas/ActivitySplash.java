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
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
      finish();


//        TimerTask tarea = new TimerTask() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(ActivitySplash.this, Registro.class);
//                startActivity(intent);
//                finish();
//            }
//        };
//        Timer tiempo = new Timer();
//        tiempo.schedule(tarea,5000);
    }
}