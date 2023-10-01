package menu;

import java.util.HashSet;
import java.util.Set;

public class Coach {

    private String name;
    private Set<String> cannotEatFoodSet;

    public Coach(String name, Set<String> cannotEatFoodSet) {
        this.name = name;
        this.cannotEatFoodSet = cannotEatFoodSet;
    }

    public void addCannotEatFoodSet(String foodName) {
        cannotEatFoodSet.add(foodName);
    }

    /**
     * food를 먹을 수 있는지 확인하는 메서드
     */
    public boolean canEatFood(String foodName) {
        if (cannotEatFoodSet.contains(foodName)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }
}
