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
        else if(questionText.equals("화정관"))
        {
            //tbSetText.setText("화정관 전화번호는 0507-147-8226입니다.");
            DataBox("F-001");
        }
        else if(questionText.equals("뚜따구치"))
        {
            //tbSetText.setText("뚜따구치 전화번호는 041-534-3357입니다.");
            DataBox("F-002");
        }
        else if(questionText.equals("언니네식당"))
        {
            //tbSetText.setText("언니네식당 전화번호는 0507-1420-2240입니다.");
            DataBox("F-003");
        }
        else if(questionText.equals("은화수식당"))
        {
            //tbSetText.setText("은화수식당 전화번호는 0507-147-8226입니다.");
            DataBox("F-004");
        }
        else if(questionText.equals("도스마스"))
        {
            //tbSetText.setText("도스마스 전화번호는 041-544-8099입니다.");
            DataBox("F-005");
        }
        else if(questionText.equals("한솥도시락"))
        {
            //tbSetText.setText("한솥도시락 전화번호는 041-544-4530입니다.");
            DataBox("F-006");
        }
        else if(questionText.equals("큰맘할매순대국"))
        {
            //tbSetText.setText("큰맘할매순대국 전화번호는 0507-1435-0246입니다.");
            DataBox("F-007");
        }
        else if(questionText.equals("김밥천국"))
        {
            //tbSetText.setText("김밥천국 전화번호는 0507-1340-5855입니다.");
            DataBox("F-008");
        }
        else if(questionText.equals("느티나무집"))
        {
            //tbSetText.setText("느티나무집 전화번호는 0507-1403-2141입니다.");
            DataBox("F-009");
        }
        else if(questionText.equals("59쌀피자"))
        {
            //tbSetText.setText("59쌀피자 전화번호는 041-545-8259입니다.");
            DataBox("F-010");
        }
        else if(questionText.equals("두찜"))
        {
            //tbSetText.setText("두찜 전화번호는 041-546 7737입니다.");
            DataBox("F-011");
        }
        else if(questionText.equals("몬스터꼬맹이김밥"))
        {
            //tbSetText.setText("몬스터꼬맹이김밥 전화번호는 041-542-6533입니다.");
            DataBox("F-012");
        }
        else if(questionText.equals("메콩타이"))
        {
            //tbSetText.setText("메콩타이 전화번호는 041-532-7733입니다.");
            DataBox("F-013");
        }
        else if(questionText.equals("푸라닭"))
        {
            //tbSetText.setText("푸라닭 전화번호는 041-533-9206입니다.");
            DataBox("F-014");
        }
        else if(questionText.equals("처갓집"))
        {
            //tbSetText.setText("처갓집 전화번호는 041-548-9997입니다.");
            DataBox("F-015");
        }
        else if(questionText.equals("본도시락"))
        {
            //tbSetText.setText("본도시락 전화번호는 0507-1307-4282입니다.");
            DataBox("F-016");
        }
        else if(questionText.equals("등촌샤브샤브"))
        {
            //tbSetText.setText("등촌샤브샤브 전화번호는 041-548-2253입니다);
            DataBox("F-017");
        }
        else if(questionText.equals("서서갈비"))
        {
            //tbSetText.setText("서서갈비 전화번호는 0507-1407-4862입니다.");
            DataBox("F-018");
        }
        else if(questionText.equals("두부랑 가마솥 손두부"))
        {
            //tbSetText.setText("두부랑 가마솥 손두부 전화번호는 0507-1368-3116입니다.");
            DataBox("F-019");
        }
        else if(questionText.equals("멘야미쯔리"))
        {
            //tbSetText.setText("멘야미쯔리 전화번호는 041-544-6907입니다.");
            DataBox("F-020");
        }
        else if(questionText.equals("더진국수육국밥"))
        {
            //tbSetText.setText("더진국수육국밥 전화번호는 041-532-5738입니다.");
            DataBox("F-021");
        }
        else if(questionText.equals("BHC치킨"))
        {
            //tbSetText.setText("BHC치킨 전화번호는 041-531-0707입니다.");
            DataBox("F-022");
        }
        else if(questionText.equals("교촌치킨"))
        {
            //tbSetText.setText("교촌치킨 전화번호는 041-532-1995입니다.");
            DataBox("F-023");
        }
        else if(questionText.equals("굽네치킨"))
        {
            //tbSetText.setText("굽네치킨 전화번호는 041-542-9492입니다.");
            DataBox("F-024");
        }
        else if(questionText.equals("원주통닭"))
        {
            //tbSetText.setText("원주통닭 전화번호는 041-549-3330입니다.");
            DataBox("F-025");
        }
        else if(questionText.equals("족발야시장"))
        {
            //tbSetText.setText("족발야시장 전화번호는 041-541-4969입니다.");
            DataBox("F-026");
        }
        else if(questionText.equals("단골집"))
        {
            //tbSetText.setText("단골집 전화번호는 041-534-3218입니다.");
            DataBox("F-027");
        }
        else if(questionText.equals("이자돌"))
        {
            //tbSetText.setText("연탄집 전화번호는 0507-1315-9404입니다.");
            DataBox("F-028");
        }
        else if(questionText.equals("연탄집"))
        {
            //tbSetText.setText("연탄집 전화번호는 0507-1315-9404입니다.");
            DataBox("F-029");
        }
        else if(questionText.equals("신의주찹쌀순대"))
        {
            //tbSetText.setText("신의주찹쌀순대 전화번호는 041-546-5421입니다.");
            DataBox("F-030");
        }
        else if(questionText.equals("택이네조개찜"))
        {
            //tbSetText.setText("택이네조개찜 전화번호는 0507-1330-8294입니다.");
            DataBox("F-031");
        }
        else if(questionText.equals("냉삼집"))
        {
            //tbSetText.setText("냉삼집 전화번호는 0507-1335-8987입니다.");
            DataBox("F-032");
        }
        else if(questionText.equals("터를리"))
        {
            //tbSetText.setText("터를리 전화번호는 041-533-5545입니다.");
            DataBox("F-033");
        }
        else if(questionText.equals("79대포"))
        {
            //tbSetText.setText("79대포 전화번호는 0507-1304-2299입니다.");
            DataBox("F-034");
        }
        else if(questionText.equals("진사또"))
        {
            //tbSetText.setText("진사또 전화번호는 041-545-3457입니다.");
            DataBox("F-035");
        }
        else if(questionText.equals("짬뽕지존"))
        {
            //tbSetText.setText("짬뽕지존 전화번호는 0507-1356-5161입니다.");
            DataBox("F-036");
        }
        else if(questionText.equals("피그펍돈까스"))
        {
            //tbSetText.setText("피그펍돈까스 전화번호는 041-541-8833입니다.");
            DataBox("F-037");
        }
        else if(questionText.equals("수호두파이"))
        {
            //tbSetText.setText("수호두파이 전화번호는 041-545-8295입니다.");
            DataBox("F-038");
        }
        else if(questionText.equals("노걸대감자탕"))
        {
            //tbSetText.setText("노걸대감자탕 전화번호는 041-533-7402입니다.");
            DataBox("F-039");
        }
        else if(questionText.equals("윤가네 부대찌개"))
        {
            //tbSetText.setText("윤가네 부대찌개 전화번호는 041-532-0414입니다.");
            DataBox("F-040");
        }
        else if(questionText.equals("제주복돼지"))
        {
            //tbSetText.setText("제주복돼지 전화번호는 041-534-0286입니다.");
            DataBox("F-041");
        }
        else if(questionText.equals("국어국문학과"))
        {
            //tbSetText.setText("국어국문학과 전화번호는 041-530-2403입니다.");
            DataBox("kor");
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