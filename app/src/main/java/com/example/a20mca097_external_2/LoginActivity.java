package com.example.a20mca097_external_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //Creating Variables
    EditText etUsername,etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Getting Button And TextViews
        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);

        //Setting onClick for Login Button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Saving Values in String format
                String uname=etUsername.getText().toString();
                String pass=etPassword.getText().toString();

                //Checking if id pass is admin/admin
                if(uname.equals("admin")&& pass.equals("admin"))
                {
                    //If they match saving admin in SharedPreferences
                    SharedPreferences sharedPref = getSharedPreferences("Users", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("username", uname);
                    editor.commit();

                    //Changing activity to Home
                    Intent i=new Intent(LoginActivity.this,Home.class);
                    startActivity(i);
                }
                else
                {
                    //If they dont match giving out error toast
                    Toast.makeText(LoginActivity.this,"Invalid Username & Password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}