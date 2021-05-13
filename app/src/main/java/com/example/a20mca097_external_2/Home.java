package com.example.a20mca097_external_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    //Creating two Variables to store TextView and Button Object
    Button btnLogout;
    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Creating Object of SharedPreferences
        SharedPreferences sharedPref = getSharedPreferences("Users", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        //Getting username value from SharedPreferences
        String value = sharedPref.getString("username", null);

        //Getting both Button And TextView
        tvWelcome = (TextView)findViewById(R.id.tvWelcome);
        btnLogout = (Button)findViewById(R.id.btnLogout);

        //Setting Welcome TextView with Username Stored in SharedPreferences
        tvWelcome.setText("Welcome, " + value);

        //Setting onClick for Logout Button
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Setting username to null in SharedPreferences
                editor.putString("username", null);
                editor.commit();

                //Changing activity back to Login
                Intent i=new Intent(Home.this,LoginActivity.class);
                startActivity(i);
                finish();;
            }
        });
    }
}