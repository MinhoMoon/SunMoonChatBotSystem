package com.example.sunmoonchatbot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import Weather.Weather;
import Weather.Response;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.os.SystemClock.sleep;

public class ChatbotHome extends AppCompatActivity
{
    FirebaseDatabase firebasedb;
    EditText tbSendText;
    Button getSend;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot_home);
        // DB 질의응답

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        firebasedb = FirebaseDatabase.getInstance();
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

        if(questionText.equals("test"))
        {
            ViewText("내용1", "내용2");
        }

        if(questionText == null || questionText.equals("")) // 내용이 null 값이거나 아무내용이 없을때 실행한다.
        {
            Toast.makeText(this, "당신은 질문내용을 입력하지 않았습니다.", Toast.LENGTH_LONG).show(); // 토스트 메세지 안내출력.
            return;
        }
        else if(questionText.equals("날씨") || questionText.equals("weather"))
        {
            try {
                Response response = Weather.get();

                /*String value = "현재온도: " + (response.getMain().getTemp() - 273.15) + "\n" +
                        "현재습도: " + (response.getMain().getHumidity()) + "\n" +
                        "날씨: " + (response.getWeather().get(0).getMain()) + "\n" +
                        "상세 날씨 설명: " + (response.getWeather().get(0).getDescription()) + "\n" +
                        "바람: " + (response.getWind().getSpeed()) + "\n" +
                        "구름: " +  (response.getClouds().getAll());*/
                String value = "현재온도: " + ((int)response.getMain().getTemp() - 273) + "°C\n" +
                        "현재습도: " + (response.getMain().getHumidity()) + "%\n" +
                        "날씨: " + (response.getWeather().get(0).getMain()) + "\n" +
                        "바람: " + (response.getWind().getSpeed()) + "m/s\n" +
                        "구름: " +  (response.getClouds().getAll());
                //tbSetText.setText(value);
                ViewText("날씨",value);
            } catch (Exception exception) {
                //tbSetText.setText(exception.getMessage());
            }
            //tbSetText.setText("오늘 맑아요");
            //DataBox("Weather");
        }
        else if(questionText.equals("음식점"))//날씨
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
            //tbSetText.setText("두찜 전화번호는 041-546 7737입니다.");
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
        else if(questionText.equals("두부랑가마솥손두부"))
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
        else if(questionText.equals("윤가네부대찌개"))
        {
            //tbSetText.setText("윤가네 부대찌개 전화번호는 041-532-0414입니다.");
            DataBox("F-040");
        }
        else if(questionText.equals("제주복돼지"))
        {
            //tbSetText.setText("제주복돼지 전화번호는 041-534-0286입니다.");
            DataBox("F-041");
        }
        else if(questionText.equals("국어국문학과") || questionText.equals("국문과") || questionText.equals("국문"))
        {
            //tbSetText.setText("국어국문학과 전화번호는 041-530-2403입니다.");
            DataBox("kor");
        }
        else if(questionText.equals("사회복지학과") || questionText.equals("사복과") || questionText.equals("사복"))
        {
            //tbSetText.setText("사회복지학과 전화번호는 041-530-2509입니다.");
            DataBox("welfare");
        }
        else if(questionText.equals("상담산업심리학과") || questionText.equals("상산과") || questionText.equals("상산"))
        {
            //tbSetText.setText("상담 산업심리학과 전화번호는 041-530-2568입니다.");
            DataBox("psychology");
        }
        else if(questionText.equals("역사영상콘텐츠학부") || questionText.equals("역영콘과") || questionText.equals("역영콘"))
        {
            //tbSetText.setText("역사 영상콘텐츠학부 전화번호는 041-530-2455입니다.");
            DataBox("hcc");
        }
        else if(questionText.equals("미디어커뮤니케이션학부") || questionText.equals("미커과") || questionText.equals("미커"))
        {
            //tbSetText.setText("미디어커뮤니케이션학부 전화번호는 041-530-2506/2054입니다.");
            DataBox("communication");
        }
        else if(questionText.equals("법경찰학과") || questionText.equals("법경과") || questionText.equals("법경"))
        {
            //tbSetText.setText("법 경찰학과 전화번호는 041-530-8403/8404입니다.");
            DataBox("dlp");
        }
        else if(questionText.equals("글로벌한국학과") || questionText.equals("글한과") || questionText.equals("글한"))
        {
            //tbSetText.setText("글로벌한국학과 전화번호는 041-530-2541입니다.");
            DataBox("gks");
        }
        else if(questionText.equals("시각디자인학과") || questionText.equals("시디과") || questionText.equals("시디"))
        {
            //tbSetText.setText("시각디자인학과 전화번호는 041-530-2594/2564입니다.");
            DataBox("design");
        }
        else if(questionText.equals("행정공기업학과") || questionText.equals("행공과") || questionText.equals("행공"))
        {
            //tbSetText.setText("행정공기업학과 전화번호는 041-530-2593입니다.");
            DataBox("public");
        }
        else if(questionText.equals("외국어자율전공학부") || questionText.equals("외자부") || questionText.equals("외자"))
        {
            //tbSetText.setText("외국어 자율전공학부 전화번호는 041-530-2424입니다.");
            DataBox("uem");
        }
        else if(questionText.equals("경영학과") || questionText.equals("경영과") || questionText.equals("경영"))
        {
            //tbSetText.setText("경영학과 전화번호는 041-530-2507/2567입니다.");
            DataBox("mgt");
        }
        else if(questionText.equals("IT경영학과") || questionText.equals("아이티경영과") || questionText.equals("아경"))
        {
            //tbSetText.setText("IT경영학과 전화번호는 041-530-2597입니다.");
            DataBox("itm");
        }
        else if(questionText.equals("국제경제통상학과") || questionText.equals("국경통") || questionText.equals("국경통"))
        {
            //tbSetText.setText("국제경제통상학과 전화번호는 041-530-2556입니다.");
            DataBox("economic");
        }
        else if(questionText.equals("글로벌관광학과") || questionText.equals("글관과") || questionText.equals("글관"))
        {
            //tbSetText.setText("글로벌관광학과 전화번호는 041-530-2551/8561입니다.");
            DataBox("tour");
        }
        else if(questionText.equals("국제관계학과") || questionText.equals("국관과") || questionText.equals("국관"))
        {
            //tbSetText.setText("국제관계학과 전화번호는 041-530-2505입니다.");
            DataBox("international");
        }
        else if(questionText.equals("신학과") || questionText.equals("신학"))
        {
            //tbSetText.setText("신학과 전화번호는 041-530-2686입니다.");
            DataBox("theolove");
        }
        else if(questionText.equals("제약생명공학과") || questionText.equals("제생과") || questionText.equals("제생"))
        {
            //tbSetText.setText("제약생명공학과 전화번호는 041-530-2270/2251입니다.");
            DataBox("btpe");
        }
        else if(questionText.equals("식품과학부") || questionText.equals("식과부") || questionText.equals("식품과학과"))
        {
            //tbSetText.setText("식품과학부 전화번호는 041-530-2278입니다.");
            DataBox("food");
        }
        else if(questionText.equals("수산생명의학과") || questionText.equals("수생과") || questionText.equals("수생"))
        {
            //tbSetText.setText("수산생명의학과 전화번호는 041-530-2280입니다.");
            DataBox("marine");
        }
        else if(questionText.equals("간호학과") || questionText.equals("간호과") || questionText.equals("간학"))
        {
            //tbSetText.setText("간호학과 전화번호는 041-530-2764입니다.");
            DataBox("nurs");
        }
        else if(questionText.equals("물리치료학과") || questionText.equals("물치과") || questionText.equals("물치"))
        {
            //tbSetText.setText("물리치료학과 전화번호는 041-530-2765입니다.");
            DataBox("physical");
        }
        else if(questionText.equals("치위생학과") || questionText.equals("치위과") || questionText.equals("치위생"))
        {
            //tbSetText.setText("치위생학과 전화번호는 041-530-2766입니다.");
            DataBox("dental");
        }
        else if(questionText.equals("응급구조학과") || questionText.equals("응구과") || questionText.equals("응구"))
        {
            //tbSetText.setText("응급구조학과 전화번호는 041-530-2763입니다.");
            DataBox("emt");
        }
        else if(questionText.equals("스포츠과학과") || questionText.equals("스과과") || questionText.equals("스과"))
        {
            //tbSetText.setText("스포츠과학과 전화번호는 041-530-2290/2919입니다.");
            DataBox("sports");
        }
        else if(questionText.equals("무도경호학과") || questionText.equals("무경과") || questionText.equals("무경"))
        {
            //tbSetText.setText("무도경호학과 전화번호는 041-530-2298/2272입니다.");
            DataBox("martial");
        }
        else if(questionText.equals("건축학부") || questionText.equals("건축과") || questionText.equals("건축"))
        {
            //tbSetText.setText("건축학부 전화번호는 041-530-2320/2652입니다.");
            DataBox("archi");
        }
        else if(questionText.equals("건설시스템안전공학과") || questionText.equals("건안공과") || questionText.equals("건안"))
        {
            //tbSetText.setText("건설시스템안전공학과 전화번호는 041-530-2319입니다.");
            DataBox("cisse");
        }
        else if(questionText.equals("기계공학과") || questionText.equals("기공과") || questionText.equals("기공"))
        {
            //tbSetText.setText("기계공학과 전화번호는 041-530-2303입니다.");
            DataBox("mecha");
        }
        else if(questionText.equals("정보통신공학과") || questionText.equals("정통과") || questionText.equals("정통"))
        {
            //tbSetText.setText("정보통신공학과 전화번호는 041-530-2309/2308입니다.");
            DataBox("information");
        }
        else if(questionText.equals("디스플레이반도체공학과") || questionText.equals("디반과") || questionText.equals("디반"))
        {
            //tbSetText.setText("디스플레이반도체공학과 전화번호는 041-530-2208/2204입니다.");
            DataBox("display");
        }
        else if(questionText.equals("전자공학과") || questionText.equals("전자과") || questionText.equals("전자"))
        {
            //tbSetText.setText("전자공학과 전화번호는 041-530-2313/8094입니다.");
            DataBox("electric");
        }
        else if(questionText.equals("신소재공학과") || questionText.equals("신소재과") || questionText.equals("신소재"))
        {
            //tbSetText.setText("신소재공학과 전화번호는 041-530-2312/2306입니다.");
            DataBox("ame");
        }
        else if(questionText.equals("환경생명화학공학과") || questionText.equals("환생화과") || questionText.equals("환생화"))
        {
            //tbSetText.setText("환경생명화학공학과 전화번호는 041-530-2314/2318입니다.");
            DataBox("ebce");
        }
        else if(questionText.equals("산업경영공학과") || questionText.equals("산경과") || questionText.equals("산경"))
        {
            //tbSetText.setText("산업경영공학과 전화번호는 041-530-2317입니다.");
            DataBox("ie");
        }
        else if(questionText.equals("스마트자동차공학부") || questionText.equals("스자공과") || questionText.equals("스자공"))
        {
            //tbSetText.setText("스마트자동차공학부 전화번호는 041-530-8330/8331입니다.");
            DataBox("smartcar");
        }
        else if(questionText.equals("컴퓨터공학부") || questionText.equals("컴공과") || questionText.equals("컴공"))
        {
            //tbSetText.setText("컴퓨터공학부 전화번호는 041-530-2211~2213입니다.");
            DataBox("cs");
        }
        else if(questionText.equals("AI소프트웨어학과") || questionText.equals("소웨과") || questionText.equals("소웨"))
        {
            //tbSetText.setText("AI소프트웨어학과 전화번호는 041-530-8480입니다.");
            DataBox("ais");
        }
        else if(questionText.equals("IT교육학부") || questionText.equals("아이티교육학과") || questionText.equals("아이티교육"))
        {
            //tbSetText.setText(IT교육학부 전화번호는 041-530-8589입니다.");
            DataBox("itedu");
        }
        else if(questionText.equals("e강의동"))
        {
            //tbSetText.setText("https://lms.sunmoon.ac.kr/ilos/main/main_form.acl");
            //DataBox("display");
        }
        else if(questionText.equals("학사정보"))
        {
            //tbSetText.setText("https://lily.sunmoon.ac.kr/Page/Story/SMEvents.aspx");
            //DataBox("StudentInfo");
        }
        else if(questionText.equals("수강신청"))
        {
            //tbSetText.setText("https://sws.sunmoon.ac.kr/UA/Course/CourseUpdate.aspx");
            //DataBox("StudyAdd");
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
                ViewText(answer, allData);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });
        return;
    }
    public void ViewText(String Q, String A)
    {
        LinearLayout layout = (LinearLayout) findViewById(R.id.chatbot);
        LinearLayout set_text = new LinearLayout(this);
        set_text.setOrientation(LinearLayout.VERTICAL);

        TextView tv_question = new TextView(this);
        tv_question.setText(tbSendText.getText().toString());
        tv_question.setTextSize(20);
        tv_question.setTextColor(Color.parseColor("#000000"));
        tv_question.setBackgroundResource(R.drawable.mymsg);
        tv_question.setGravity(Gravity.RIGHT);
        set_text.addView(tv_question);

        TextView tv_answer = new TextView(this);
        tv_answer.setText(A);
        tv_answer.setTextSize(20);
        tv_answer.setTextColor(Color.parseColor("#000000"));
        tv_answer.setBackgroundResource(R.drawable.chatbotmsg);
        tv_answer.setGravity(Gravity.LEFT);
        set_text.addView(tv_answer);
        layout.setBackgroundColor(0);
        layout.addView(set_text);
    }
}