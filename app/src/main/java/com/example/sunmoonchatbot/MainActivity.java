package com.example.sunmoonchatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
{
    FirebaseAuth firebaseAuth;
    EditText tbEmail, tbPassword;
    Button btLogin, btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        tbEmail = (EditText) findViewById(R.id.get_id); // get_id에 입력된 값을 tbEmail으로 연동한다.
        tbPassword = (EditText) findViewById(R.id.get_pass); // get_pass에 입력된 값을 tbPassword로 연동한다.
        btLogin = (Button) findViewById(R.id.bt_log); // bt_log 버튼을 btLogin으로 연동한다.
        btRegister = (Button) findViewById(R.id.bt_reg); // bt_reg 버튼을 btRegister로 연동한다.

        btLogin.setOnClickListener(new View.OnClickListener()
        { // 로그인 버튼을 클릭하면 실행 될 함수 작성
            @Override
            public void onClick(View v)
            {
                // 로그인시 실행 될 함수 작성
            }
        });

        btRegister.setOnClickListener(new View.OnClickListener()
        { // 회원가입 버튼을 클릭하면 실행 될 함수 작성
            @Override
            public void onClick(View v)
            {
                // 회원가입시 실행 될 함수 작성
                goRegister();
            }
        });
    }
    private void goRegister() // 회원가입 화면으로 이동시킨다.
    {
        startActivity(new Intent(this, Register.class));
    }
}