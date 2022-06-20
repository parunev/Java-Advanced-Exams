package E04Exam23october2021;

import java.util.*;

public class P01autumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //number of ingredients
        String input1 = scanner.nextLine();

        //freshness level
        String input2 = scanner.nextLine();

        Queue<Integer> ingredients = new ArrayDeque<>();
        Stack<Integer> freshLevel = new Stack<>();

        Arrays.stream(input1.split("\\s+")).mapToInt(Integer::parseInt).forEach(ingredients::offer);
        Arrays.stream(input2.split("\\s+")).mapToInt(Integer::parseInt).forEach(freshLevel::push);

        Map<String,Integer> cocktails = new TreeMap<>();

        while (!ingredients.isEmpty() && !freshLevel.isEmpty()){
            //in case you have ingredient with a value 0 you have to remove it and continue mixing
            if (ingredients.peek() == 0){ingredients.poll();continue;}

            int firstIngredient = ingredients.poll();
            int firstLevel = freshLevel.pop();

            if (firstIngredient * firstLevel == 150){ //Pear Sour
                cocktails.putIfAbsent("Pear Sour",0);
                cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
            }else if (firstIngredient * firstLevel == 250 ){//The Harvest
                cocktails.putIfAbsent("The Harvest",0);
                cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
            }else if (firstIngredient * firstLevel == 300){ //Apple Hinny
                cocktails.putIfAbsent("Apple Hinny",0);
                cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
            }else if (firstIngredient * firstLevel == 400){ //High Fashion
                cocktails.putIfAbsent("High Fashion",0);
                cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
            }else{
                ingredients.offer(firstIngredient+5);
            }
        }

        System.out.println(cocktails.size() == 4 ? "It's party time! The cocktails are ready!" : "What a pity! " +
                "You didn't manage to prepare all cocktails.");
        if (ingredients.size() > 0){
            System.out.println("Ingredients left: " + ingredients.stream().mapToInt(e -> e).sum());
        }
        cocktails.entrySet().stream().forEach(e -> System.out.println(" # " + e.getKey() + " --> " + e.getValue()));
    }
}
