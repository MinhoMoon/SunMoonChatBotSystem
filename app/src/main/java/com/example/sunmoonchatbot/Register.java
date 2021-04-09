package com.example.sunmoonchatbot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Register extends AppCompatActivity
{
    FirebaseAuth firebaseAuth;
    EditText tbRegEmail, tbRegPass;
    Button btSetRegister, btSetReset;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        tbRegEmail = (EditText) findViewById(R.id.set_id); // set_id에 입력된 값을 tbRegEmail으로 연동한다.
        tbRegPass = (EditText) findViewById(R.id.set_pass); // set_pass에 입력된 값을 tbRegPass으로 연동한다.
        btSetRegister = (Button) findViewById(R.id.bt_dbreg); // bt_dbreg에 입력된 값을 btSetRegister으로 연동한다.
        btSetReset = (Button) findViewById(R.id.bt_regreset); // bt_regreset에 입력된 값을 btSetReset으로 연동한다.

        btSetRegister.setOnClickListener(new View.OnClickListener()
        { // 회원가입 버튼을 클릭하면 실행됨
            @Override
            public void onClick(View v)
            {
                // 회원가입 버튼 클릭하면 실행 될 함수 작성
                goSetRegister();
            }
        });
        btSetReset.setOnClickListener(new View.OnClickListener()
        { // 리셋 버튼을 클릭하면 실행됨
            @Override
            public void onClick(View v)
            {
                // 리셋 버튼 클릭하면 실행 될 함수 작성
                goSetReset();
            }
        });
    }

    public void goSetRegister() // 회원가입을 진행한다.
    {
        String email = tbRegEmail.getText().toString(); // tbRegEmail에 입력된 값을 가져온다.
        String password = tbRegPass.getText().toString(); // tbRegPass에 입력된 값을 가져온다.

        if(email == null || email.equals("")) // 이메일이 null 값인지 체크하고, 아무런값이 입력이 안된지 확인해준다.
        {
            Toast.makeText(this, "당신은 이메일 값을 입력하지 않았습니다.", Toast.LENGTH_LONG).show(); // 짧게 아래에 텍스트 형식으로 토스트 문구가 출력한다.
            return;
        }
        if(password == null || password.equals("") || password.length() < 8) // 패스워드 값이 null 값인지 체크하고, 아무런값이 입력이 안된지 확인해준다. 그리고, 8자리 미만인지 체크한다.
        {
            Toast.makeText(this, "당신은 비밀번호를 8자리 이상 입력해야 합니다.",Toast.LENGTH_LONG).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email,password).
                // createUserWithEmailAndPassword는 이메일, 패스워드를 가져와서 파이어베이스로 보낸 뒤, 중복인지 정상적으로 가입이 가능한지 파이어베이스에서 자체적으로 확인해준다.
                        addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) // 회원가입에 성공했는지 확인한다.
                        {
                            finish(); // 현재 회원가입 화면을 삭제시킨다.
                            startActivity(new Intent(getApplicationContext(), MainActivity.class)); // 로그인 화면으로 이동한다.
                        }
                        else // 회원가입에 실패하면 실패메세지를 띄워준다.
                        {
                            Toast.makeText(getApplicationContext(), "당신은 회원가입에 실패하였습니다.",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void goSetReset() // 이메일과 패스워드 입력칸에 입력된 값 초기화 진행한다.
    {
        tbRegEmail.setText("");
        tbRegPass.setText("");
    }
}