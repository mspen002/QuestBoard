package com.qbteam.questboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        //Declare and instantiate Firebase user with the current user to check if anyone is logged in

        if(currentUser == null)
        //If no user is logged in, go to activity_acct_login
        {
            Intent createIntent = new Intent(MainActivity.this,
                    AcctLogin.class);
            startActivity(createIntent);
            finish();
        }
    }
}
