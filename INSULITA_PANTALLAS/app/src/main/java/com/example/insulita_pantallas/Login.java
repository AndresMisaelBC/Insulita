package com.example.insulita_pantallas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity
{

    private EditText edtEmail;
    private EditText edtPassword;
    private FirebaseAuth mAuth;

    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        mAuth = FirebaseAuth.getInstance();


    }

    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
       // updateUI(currentUser);
    }

    public void IniciarSesion(View v)
    {

        if(!edtEmail.getText().toString().isEmpty() && !edtPassword.getText().toString().isEmpty()) {
            mAuth.signInWithEmailAndPassword(edtEmail.getText().toString(), edtPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {


                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent siguienteRaMain = new Intent(getApplicationContext(), MainActivity.class);
                                Toast.makeText(getApplicationContext(), R.string.Toastcre, Toast.LENGTH_SHORT).show();
                                startActivity(siguienteRaMain);

                            } else {


                                Toast.makeText(getApplicationContext(), R.string.Toast4,
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

        }else
        {
            Toast.makeText(getApplicationContext(), R.string.Toast3, Toast.LENGTH_SHORT).show();
        }

    }



    public void SiguienteParaRegistro(View view)
    {
        Intent siguienteR = new Intent(this,Registro.class);
        startActivity(siguienteR);

    }

}