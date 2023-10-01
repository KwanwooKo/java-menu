package menu;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.mockito.internal.matchers.Or;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        // TODO: coach 2명 이상 입력 받는 예외처리 구현
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String coachInput = Console.readLine();
        String[] coachNames = coachInput.split(",");

        // Coach 정보들 다 기록 완료
        ArrayList<Coach> coaches = createCoaches(coachNames);
        OrderHistory orderHistory = new OrderHistory(coaches);
        orderHistory.createOrder();

        orderHistory.printResult();
    }
    private static ArrayList<Coach> createCoaches(String[] coachNames) {
        ArrayList<Coach> coaches = new ArrayList<>();

        for (String coachName : coachNames) {
            String foodInput = inputOfFoodNames(coachName);
            coaches.add(createCoach(coachName, foodInput));
        }

        return coaches;
    }

    private static String inputOfFoodNames(String coachName) {
        System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        return Console.readLine();
    }

    private static Coach createCoach(String coachName, String foodInput) {
        String[] foodNames = foodInput.split(",");
        Set<String> cannotEatFoodSet = createCannotEatFoodSet(foodNames);
        return new Coach(coachName, cannotEatFoodSet);
    }


    private static Set<String> createCannotEatFoodSet(String[] foodNames) {
        return new HashSet<>(Arrays.asList(foodNames));
    }
}
