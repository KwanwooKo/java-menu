package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderHistory {

    private static final Integer CATEGORY_SIZE = 6;
    private static final Integer MAX_USE_COUNT = 2;
    private static final Integer START_NUMBER_OF_CATEGORY = 1;
    private static final Integer END_NUMBER_OF_CATEGORY = 5;

    // order 역사들을 모두 기록
    private ArrayList<Order> orderHistory = new ArrayList<>();
    private int[] categoryUsedCount = new int[CATEGORY_SIZE];
    private ArrayList<Coach> coaches;
    private Menu menu = new Menu();

    private HashMap<Integer, String> categoryNumberToName = new HashMap<>() {
        {
            put(1, "일식");
            put(2, "한식");
            put(3, "중식");
            put(4, "아시안");
            put(5, "양식");
        }
    };

    public OrderHistory(ArrayList<Coach> coaches) {
        this.coaches = coaches;
    }

    // create order 메서드 필요 => application에서 createOrder 5번 호출하도록
    public void createOrder() {
        for (int i = 0; i < END_NUMBER_OF_CATEGORY; i++) {
            createSingleOrder();
        }

    }

    private void createSingleOrder() {
        HashMap<String, String> foodSelectedByCoach = new HashMap<>();
        int category = selectCategory();
        for (Coach coach : coaches) {
            String menu = recommendFoodToCoach(coach, category);
            foodSelectedByCoach.put(coach.getName(), menu);
        }
        Order order = new Order(categoryNumberToName.get(category), foodSelectedByCoach);
        orderHistory.add(order);
    }

    // 결과 출력하는 함수
    public void printResult() {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(getCategoryLine());
        for (Coach coach : coaches) {
            System.out.println(getSingleCoachLine(coach));
        }
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    private String getSingleCoachLine(Coach coach) {
        int count = 1;
        StringBuilder singleCoachLine = new StringBuilder("[ " + coach.getName() + " | ");
        for (Order order : orderHistory) {
            if (count == END_NUMBER_OF_CATEGORY) {
                singleCoachLine.append(order.getFoodSelectedByCoach(coach.getName())).append(" ]");
                break;
            }
            singleCoachLine.append(order.getFoodSelectedByCoach(coach.getName())).append(" | ");
            count++;
        }
        return singleCoachLine.toString();
    }

    private String getCategoryLine() {
        int count = 1;
        StringBuilder categoryLine = new StringBuilder("[ 카테고리 | ");
        for (Order order : orderHistory) {
            if (count == END_NUMBER_OF_CATEGORY) {
                categoryLine.append(order.getSelectedCategory()).append(" ]");
                break;
            }
            categoryLine.append(order.getSelectedCategory()).append(" | ");
            count++;
        }
        return categoryLine.toString();
    }

    // category 랜덤 선택 메서드
    private int selectCategory() {
        while (true) {
            int category = Randoms.pickNumberInRange(START_NUMBER_OF_CATEGORY, END_NUMBER_OF_CATEGORY);
            if (canSelectCategory(category)) {
                categoryUsedCount[category]++;
                return category;
            }
        }
    }

    // category 중복 확인 메서드
    // MAX_USE_COUNT까지 사용했으면 더이상 사용불가
    private boolean canSelectCategory(int category) {
        if (categoryUsedCount[category] == MAX_USE_COUNT) {
            return false;
        }
        return true;
    }

    // 코치에게 음식 추천 메서드 (랜덤으로 추출)
    private String recommendFoodToCoach(Coach coach, int category) {
        List<String> menus = menu.getCategory(category);
        while (true) {
            String menu = Randoms.shuffle(menus).get(0);
            if (coach.canEatFood(menu)) {
                coach.addCannotEatFoodSet(menu);
                return menu;
            }
        }
    }


}























