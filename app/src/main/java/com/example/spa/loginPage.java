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

public class loginPage extends AppCompatActivity {
    Button login,exit;
    TextView title;
    EditText email,password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        login = findViewById(R.id.loginLoginBtn);
        exit = findViewById(R.id.loginBack);
        title = findViewById(R.id.loginTitle);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailTxt=email.getText().toString();
                String passwordTxt=password.getText().toString();
               if (email(emailTxt)&&password(passwordTxt)){
                   openHome();

                }else{
                   Toast.makeText(loginPage.this, "Invalid Email & Password", Toast.LENGTH_SHORT).show();

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
    public boolean password(String password){
        return checkRegex("^([1-zA-Z0-1@.\\s]{1,255})$",password);
    }
    public void openHome(){
        Intent intent = new Intent(loginPage.this,homepage.class);
        startActivity(intent);

    }
    public void back(){
        Intent intent = new Intent(loginPage.this,welcome.class);
        startActivity(intent);
    }
    public boolean checkRegex(String pattern,String input){
        Pattern p =Pattern.compile(pattern);
      return  p.matcher(input).matches();

    }
}
