package E09RetakeExam16december2020;

import java.util.*;
import java.util.stream.Collectors;

public class P01cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(input1.split("\\s+")).mapToInt(Integer::parseInt).forEach(liquids::offer);
        Arrays.stream(input2.split("\\s+")).mapToInt(Integer::parseInt).forEach(ingredients::push);

        Map<Integer, String> foodRes = new HashMap<>();
        foodRes.put(25, "Bread");foodRes.put(50, "Cake");foodRes.put(75, "Pastry");foodRes.put(100, "Fruit Pie");

        Map<String, Integer> food = new TreeMap<>();

        while (!(ingredients.isEmpty() || liquids.isEmpty())) {
            int firstLiquid = liquids.poll();
            int firstIngredient = ingredients.pop();
            int sum = firstLiquid + firstIngredient;

            if (foodRes.containsKey(sum)) {
                String current = foodRes.get(sum);
                food.putIfAbsent(current, 0);
                food.put(current, food.get(current) + 1);
            } else {
                ingredients.push(firstIngredient + 3);
            }
        }

        if (food.size() == 4) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            String liquidsLeft = String.format("Liquids left: %s", liquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println(liquidsLeft);
        }

        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            String ingredientsLeft = String.format("Ingredients left: %s", ingredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println(ingredientsLeft);
        }

        System.out.println("Bread: " + (food.getOrDefault("Bread", 0)));
        System.out.println("Cake: " + (food.getOrDefault("Cake", 0)));
        System.out.println("Fruit Pie: " + (food.getOrDefault("Fruit Pie", 0)));
        System.out.println("Pastry: " + (food.getOrDefault("Pastry", 0)));
    }
}
