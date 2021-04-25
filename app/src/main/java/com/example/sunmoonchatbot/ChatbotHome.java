package com.example.sunmoonchatbot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChatbotHome extends AppCompatActivity
{
    FirebaseDatabase firebasedb;
    TextView tbSetText;
    EditText tbSendText;
    Button getSend;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot_home);
        // DB 질의응답

        firebasedb = FirebaseDatabase.getInstance();
        tbSetText = (TextView) findViewById(R.id.set_text);
        tbSendText = (EditText) findViewById(R.id.get_sendtext); // 질문내용을 입력받는다.
        getSend = (Button) findViewById(R.id.get_send); // 버튼을 클릭하면 답변처리를 진행한다.

        getSend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // 메세지를 전송한다. 질문 실행하는곳
                QuestionTable();
            }
        });
    }

    public void QuestionTable()
    {
        String questionText = tbSendText.getText().toString(); // 입력받은 질문 내용을 퀘션텍스트 스트링 형태로 저장한다.

        if(questionText == null || questionText.equals("")) // 내용이 null 값이거나 아무내용이 없을때 실행한다.
        {
            Toast.makeText(this, "당신은 질문내용을 입력하지 않았습니다.", Toast.LENGTH_LONG).show(); // 토스트 메세지 안내출력.
            return;
        }
        else if(questionText.equals("날씨"))
        {
            //tbSetText.setText("오늘 맑아요");
            DataBox("Weather");
        }
        else if(questionText.equals("음식점"))
        {
            //tbSetText.setText("학교주변에는 느티나무집, 이모네밥, 맘스터치, 화정관이 있습니다.");
            DataBox("F-000");
        }
        else if(questionText.equals("e강의동"))
        {
            //tbSetText.setText("https://lms.sunmoon.ac.kr/ilos/main/main_form.acl");
            DataBox("display");
        }
        else if(questionText.equals("학사정보"))
        {
            //tbSetText.setText("https://lily.sunmoon.ac.kr/Page/Story/SMEvents.aspx");
            DataBox("StudentInfo");
        }
        else if(questionText.equals("수강신청"))
        {
            //tbSetText.setText("https://sws.sunmoon.ac.kr/UA/Course/CourseUpdate.aspx");
            DataBox("StudyAdd");
        }
        else
        {
            Toast.makeText(this, "당신의 질문은 이해할 수 없습니다.", Toast.LENGTH_LONG).show(); // 토스트 메세지 안내출력.
        }
    }

    public void DataBox(String answer)
    {
        DatabaseReference root = firebasedb.getReference();
        DatabaseReference node = root.child(answer); // answer로 원하는 정보의 노드값을 찾아낸다.

        node.addValueEventListener(new ValueEventListener()
        { // 파이어베이스에서 값을 읽어올때 사용한다.
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                String allData = "";
                for(DataSnapshot ds : snapshot.getChildren())
                {
                    String getData = (String) ds.getValue(); // answer의 해당하는 데이터를 가져온다.
                    allData = allData + getData; // 하위노드 값 저장진행
                }
                tbSetText.setText(allData); // 출력한다.
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });
        return;
    }
}