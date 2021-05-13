package com.example.a20mca097_external_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this is used to delay activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Creating Object of SharedPreferences
                SharedPreferences sharedPref = getSharedPreferences("Users", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                //Getting username value from SharedPreferences
                String value = sharedPref.getString("username", null);

                //if username value is null that means no user is logged in
                if (value != null)
                {
                    //since the value is not null we will change activity to home directly
                    startActivity(new Intent(getApplicationContext(),Home.class));
                    finish();
                }
                else
                {
                    //since the value is null the user is not logged in so we will send them to login activity
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                    finish();
                }
            }
            //giving 4 seconds delay
        },4000);
    }
}