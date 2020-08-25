package com.example.spa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class welcome extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    TextView title1,title2,title3;
    Button exitBtn,loginBtn,signUpBtn;

    @Override
    public void onBackPressed() {

        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
          backToast = Toast.makeText(getBaseContext(),"Press Again To Exit",Toast.LENGTH_SHORT);
          backToast.show();
        }
        backPressedTime= System.currentTimeMillis();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);


        title1=findViewById(R.id.titletxt1);
        title2=findViewById(R.id.titletxt2);
        title3=findViewById(R.id.titletxt3);
        exitBtn=findViewById(R.id.welcomeExitbtn);
        loginBtn=findViewById(R.id.loginbtn);
        signUpBtn=findViewById(R.id.signUpbtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            openLogin();

            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            openSignUp();

            }
        });


    }
    public void openLogin(){
        Intent Intent = new Intent(welcome.this,loginPage.class);
        startActivity(Intent);

    }
    public void openSignUp(){
     Intent Intent= new Intent(welcome.this, signUpPage.class);
     startActivity(Intent);

    }




}


