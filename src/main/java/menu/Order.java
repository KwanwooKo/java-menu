package menu;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 말 그대로 Order 정보만 지니고 있으면 돼
 * 이 Order는 어떤 category를 선택했는지
 * 각각의 coach 마다 어떤 음식을 추천 받았는지
 * 에 대한 정보만 기록, 추천하는 로직은 OrderHistory에서
 */
public class Order {

    // {coach name : food name}
    private HashMap<String, String> foodSelectedByCoach;
    private String selectedCategory;

    public Order(String category, HashMap<String, String> foodSelectedByCoach) {
        this.selectedCategory = category;
        this.foodSelectedByCoach = foodSelectedByCoach;
    }

    public String getFoodSelectedByCoach(String coachName) {
        return foodSelectedByCoach.get(coachName);
    }

    public String getSelectedCategory() {
        return selectedCategory;
    }
}
