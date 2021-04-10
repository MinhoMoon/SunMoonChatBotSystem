package com.example.sunmoonchatbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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
                goLogin();
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

    private void goLogin()
    {
        String email = tbEmail.getText().toString(); // tbEmail에 입력된 값을 가져온다.
        String password = tbPassword.getText().toString(); // // tbPassword에 입력된 값을 가져온다.

        firebaseAuth.signInWithEmailAndPassword(email, password).
                // signInWithEmailAndPassword는 이메일, 패스워드를 가져와서 파이어베이스로 보낸 뒤, 정상적으로 존재하는 계정인지 확인한 후 로그인 성공, 실패여부를 가져다준다.
                        addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) // 로그인에 성공했는지 확인한다.
                        {
                            finish(); // 로그인 화면을 삭제한다.
                            startActivity(new Intent(getApplicationContext(), ChatbotHome.class)); // 챗봇홈으로 이동한다.
                        }
                        else
                        {
                            // 로그인에 실패하면 해당 문구를 출력한다.
                            Toast.makeText(getApplicationContext(), "당신은 로그인에 실패하였습니다.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void goRegister() // 회원가입 화면으로 이동시킨다.
    {
        startActivity(new Intent(this, Register.class));
    }
}