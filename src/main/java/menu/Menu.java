package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Menu {

    private HashMap<String, ArrayList<String>> menuList = new HashMap<>();

    public Menu() {
        ArrayList<String> japanFood = new ArrayList<>(Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        ArrayList<String> koreanFood = new ArrayList<>(Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        ArrayList<String> chineseFood = new ArrayList<>(Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        ArrayList<String> asianFood = new ArrayList<>(Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        ArrayList<String> europeanFood = new ArrayList<>(Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
        menuList.put("일식", japanFood);
        menuList.put("한식", koreanFood);
        menuList.put("중식", chineseFood);
        menuList.put("아시안", asianFood);
        menuList.put("양식", europeanFood);
    }

    /**
     * category 이름 or 번호를 넣으면 list 반환
     */
    public ArrayList<String> getCategory(String category) {
        return menuList.get(category);
    }

    public ArrayList<String> getCategory(Integer category) {
        if (category == 1) {
            return menuList.get("일식");
        }
        if (category == 2) {
            return menuList.get("한식");
        }
        if (category == 3) {
            return menuList.get("중식");
        }
        if (category == 4) {
            return menuList.get("아시안");
        }
        return menuList.get("양식");
    }



}
