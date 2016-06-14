package com.tutorials.hp.mysqlregister;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tutorials.hp.mysqlregister.m_MySQL.RegistrationHelper;


public class MainActivity extends AppCompatActivity {

//PHP SCRIPT URL
    final static String urlAddress="http://10.0.2.2/android/users.php";
    //EDITTEXTS
    EditText fullnameTxt,usernameTxt,emailTxt,passwdTxt,confirmPwdTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fullnameTxt= (EditText) findViewById(R.id.fullnameEditTxt);
        usernameTxt= (EditText) findViewById(R.id.usernameEditTxt);
        emailTxt= (EditText) findViewById(R.id.emailEditTxt);
        passwdTxt= (EditText) findViewById(R.id.passwordEditTxt);
        confirmPwdTxt= (EditText) findViewById(R.id.confirmPwdEditTxt);
         Button registerBtn= (Button) findViewById(R.id.registerBtn);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 String fullname=fullnameTxt.getText().toString();
                 String username=usernameTxt.getText().toString();
                 String email=emailTxt.getText().toString();
                 String password=passwdTxt.getText().toString();
                 String confirmPwd=confirmPwdTxt.getText().toString();

//BASIC VALIDATION
                if((fullname.length()<=0 || fullname==null)  || (username.length()<=0|| username==null) || (email.length()<=0||email==null) ||( password.length()<=0 || password==null))
                {
                    Toast.makeText(MainActivity.this,"Please Enter all data correctly",Toast.LENGTH_SHORT).show();
                }
                else
                if( ! password.equals(confirmPwd))
                {
                    Toast.makeText(MainActivity.this,"Password must be same as Confirm password",Toast.LENGTH_SHORT).show();

                }else {
                    new RegistrationHelper(MainActivity.this,urlAddress,fullnameTxt,usernameTxt,emailTxt,passwdTxt).execute();
                    confirmPwdTxt.setText("");
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


}
