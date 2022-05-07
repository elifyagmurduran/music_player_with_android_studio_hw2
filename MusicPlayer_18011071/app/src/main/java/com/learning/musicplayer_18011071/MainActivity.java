package com.learning.musicplayer_18011071;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//changing screens sign in sign up
        Button btn1 = (Button)findViewById(R.id.signinbtn);
        Button btn2 = (Button)findViewById(R.id.signupbtn);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent1 = new Intent(MainActivity.this,
                                SignInActivity.class);
                        startActivity(intent1);
                    }
                }
        );

        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent(MainActivity.this,
                                SignUpActivity.class);
                        startActivity(intent2);
                    }
                }
        );
    }
}