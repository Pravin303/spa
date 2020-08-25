package com.example.spa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class signUpPage extends AppCompatActivity {

    TextView titleTxt;
    EditText userName,email,password;
    Button signUp,exit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signuppage);

        userName = findViewById(R.id.signupuser);
         titleTxt = findViewById(R.id.signuptxt);
         email = findViewById(R.id.signupemail);
         password = findViewById(R.id.signuppassword);
         signUp = findViewById(R.id.signuppagesignupbtn);
         exit = findViewById(R.id.signupexitbtn);

         signUp.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String emailTxt=email.getText().toString();
                 String passwordTxt=password.getText().toString();
                 if (email(emailTxt)&&password(passwordTxt)){
                     openHome();
                 }else{
                     Toast.makeText(signUpPage.this, "Please Provide valid details", Toast.LENGTH_SHORT).show();
                 }

             }
         });
         exit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 back();

             }
         });
    }
    public boolean email(String email){

        return checkRegex("[a-zA-Z0-9_\\.\\+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-\\.]+",email);
    }
    public  boolean password(String password){
        return checkRegex("^([1-zA-Z0-1@.\\s]{1,255})$",password);
    }
    public boolean checkRegex( String pattern, String input){
         Pattern p =Pattern.compile(pattern);
          return p.matcher(input).matches();



    }
    public void openHome(){
        Intent intent = new Intent(signUpPage.this,homepage.class);
        startActivity(intent);
    }
    public void back(){
        Intent intent = new Intent(signUpPage.this,welcome.class);
        startActivity(intent);

    }


}
