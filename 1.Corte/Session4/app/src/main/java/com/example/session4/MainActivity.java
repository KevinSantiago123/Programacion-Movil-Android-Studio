package com.example.session4;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity   {
    private static final String TAG = "1";
    EditText tEmail, tPassword;
    Button bLogin;
    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //startActivity(new Intent(MainActivity.this, ActDashboard.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tEmail = (EditText) findViewById(R.id.Email);
        tPassword = (EditText) findViewById(R.id.Password);
        bLogin =(Button) findViewById(R.id.Login);
        mAuth = FirebaseAuth.getInstance();
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateUser();
            }
        });


        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
            insertUser();
        }
        });
    }

    private void validateUser (){
        String  email = tEmail.getText().toString();
        String  password = tPassword.getText().toString();
        mAuth.signInWithEmailAndPassword(email,  password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "signInWithEmail:success");
                         FirebaseUser user = mAuth.getCurrentUser();
                        startActivity(new Intent(MainActivity.this, ActDashboard.class));

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(MainActivity.this, "Usuario no Resgistrado.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }

    private void insertUser(){
        String  email = tEmail.getText().toString();
        String  password = tPassword.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(MainActivity.this, "Registro exitoso.",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(MainActivity.this, "Fallo el registro del usuario.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }
}



