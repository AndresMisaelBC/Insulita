package com.example.insulita_pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Informacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
    }
public void SiguienteAtencion (View view)
{
    Intent siguienteatencionobj = new Intent(this,Mensajeria.class );
    startActivity(siguienteatencionobj);
}


}