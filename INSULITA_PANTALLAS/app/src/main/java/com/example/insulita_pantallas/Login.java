package com.example.insulita_pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity
{
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void SiguienteLogin(View view)
    {
        Intent siguiente = new Intent(this,MainActivity.class);
        startActivity(siguiente);

    }
    public void SiguienteParaRegistro(View view)
    {
        Intent siguienteR = new Intent(this,Registro.class);
        startActivity(siguienteR);

    }

}