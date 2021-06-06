package com.example.insulita_pantallas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Mensajeria extends AppCompatActivity
{
    EditText etMsj, etCel;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajeria);

        etMsj = findViewById(R.id.editTextTextPersonName);
        etCel = findViewById(R.id.editTextTextPersonName2);
        btnEnviar = findViewById(R.id.button);

        if (ActivityCompat.checkSelfPermission(Mensajeria.this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(Mensajeria.this, new String[]{Manifest.permission.SEND_SMS}, 1);
        }

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SmsManager smsManager =  SmsManager.getDefault();
                smsManager.sendTextMessage(etCel.getText().toString(), null, etMsj.getText().toString(), null, null);
                Toast.makeText(Mensajeria.this, R.string.ToastSMG, Toast.LENGTH_LONG).show();

            }
        });
    }
    public void SiguienteCalif (View view)
    {
        Intent siguienteC = new Intent(this,CalificacionEmpleado.class );
        startActivity(siguienteC);
    }
}

