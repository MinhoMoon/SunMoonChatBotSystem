package com.example.sunmoonchatbot;

public class Data {
    int random = (int) (Math.random() * 41);
    public String getFood() {
        String randomFood = "없음";
        String food = "";
            switch (random) {
            case 0:
                randomFood = "화정관";
                break;
            case 1:
                randomFood = "뚜따구치나";
                break;
            case 2:
                randomFood = "언니네식당";
                break;
            case 3:
                randomFood = "은화수식당";
                break;
            case 4:
                randomFood = "도스마스";
                break;
            case 5:
                randomFood = "한솥도시락";
                break;
            case 6:
                randomFood = "큰맘할매순대국";
                break;
            case 7:
                randomFood = "김밥천국";
                break;
            case 8:
                randomFood = "느티나무집";
                break;
            case 9:
                randomFood = "59쌀피자";
                break;
            case 10:
                randomFood = "두찜";
                break;
            case 11:
                randomFood = "몬스터꼬맹이김밥";
                break;
            case 12:
                randomFood = "예콩타이";
                break;
            case 13:
                randomFood = "푸라닭";
                break;
            case 14:
                randomFood = "처갓집";
                break;
            case 15:
                randomFood = "본도시락";
                break;
            case 16:
                randomFood = "등촌샤브샤브";
                break;
            case 17:
                randomFood = "서서갈비";
                break;
            case 18:
                randomFood = "두부랑가마솥손두부";
                break;
            case 19:
                randomFood = "멘야미쯔리";
                break;
            case 20:
                randomFood = "더진국수육국밥";
                break;
            case 21:
                randomFood = "bhc치킨";
                break;
            case 22:
                randomFood = "교촌치킨";
                break;
            case 23:
                randomFood = "굽네치킨";
                break;
            case 24:
                randomFood = "원주통닭";
                break;
            case 25:
                randomFood = "족발야시장";
                break;
            case 26:
                randomFood = "단골집";
                break;
            case 27:
                randomFood = "이자돌";
                break;
            case 28:
                randomFood = "연탄집";
                break;
            case 29:
                randomFood = "신의주찹쌀순대";
                break;
            case 30:
                randomFood = "택이네조개찜";
                break;
            case 31:
                randomFood = "냉삼짐";
                break;
            case 32:
                randomFood = "터를리";
                break;
            case 33:
                randomFood = "79대포";
                break;
            case 34:
                randomFood = "진사또";
                break;
            case 35:
                randomFood = "짬뽕지존";
                break;
            case 36:
                randomFood = "피그펍돈까스";
                break;
            case 37:
                randomFood = "수호두파이";
                break;
            case 38:
                randomFood = "노걸대감자탕";
                break;
            case 39:
                randomFood = "윤가네부대찌개";
                break;
            case 40:
                randomFood = "제주복돼지";
                break;
        }
        if(randomFood == "없음")
        {
            food = ("추천에 실패하였습니다.\n 잠시 후 다시 이용해주세요!");
        }
        else
        {
            food = "오늘의 추천 음식점입니다!\n" + randomFood + "에서 한끼는 어떠신가요?";
        }

        return food;
    }
}
