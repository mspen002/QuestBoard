package com.qbteam.questboard;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

public class AcctCreation extends AppCompatActivity {

    Button signUpButton, returnButton;
    EditText inputEmail, inputPass, confirmPass;
    String email, password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acct_creation);

        //EditText values to hold the inputs provided by the user
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        inputPass = (EditText) findViewById(R.id.inputPass);
        confirmPass = (EditText) findViewById(R.id.confirmPass);

        signUpButton = (Button) findViewById(R.id.signUpButton);
        returnButton = (Button) findViewById(R.id.returnButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cannot succeed on button click until these are accounted for
                if((inputEmail.getText().toString() != null) &&
                        (inputPass.getText().toString() != null) &&
                        (inputPass.getText().toString() == confirmPass.getText().toString()))
                {
                    email = inputEmail.getText().toString();
                    password = confirmPass.getText().toString();
                    //TODO: Account creation code here
                    Intent createIntent = new Intent( AcctCreation.this,
                            MainActivity.class);
                    startActivity(createIntent);
                }
                else
                {
                    //TODO: Add popup message for not having proper credentials
                }

            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createIntent = new Intent( AcctCreation.this,
                        AcctLogin.class);
                startActivity(createIntent);
            }
        });
    }
}
