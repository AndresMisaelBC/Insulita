package com.example.insulita_pantallas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registro extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText edt_email;
    private EditText edt_password;
    private EditText edt_confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();

        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);
        edt_confirm_password = findViewById(R.id.edt_confirm_password);

    }

    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }


    public void RegistrarUsuario(View v) {

        if (edt_password.getText().toString().equals(edt_confirm_password.getText().toString())) {
            mAuth.createUserWithEmailAndPassword(edt_email.getText().toString(), edt_password.getText().toString())
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information


                            Toast.makeText(getApplicationContext(), R.string.Toast1, Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();

                            Intent siguienteRaMain = new Intent(getApplicationContext(), Login.class);
                            startActivity(siguienteRaMain);

                        } else {


                            Toast.makeText(getApplicationContext(), R.string.Toast2, Toast.LENGTH_SHORT).show();

                        }
                    });
        } else {
            Toast.makeText(getApplicationContext(), R.string.Toast3, Toast.LENGTH_SHORT).show();
        }

    }
}


