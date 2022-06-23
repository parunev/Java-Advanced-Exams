package E11Exam28june2020;

import java.util.*;
import java.util.stream.Collectors;

public class P01bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        ArrayDeque<Integer> effects = new ArrayDeque<>(); //queue
        ArrayDeque<Integer> casing = new ArrayDeque<>(); //stack

        Arrays.stream(input1.split(",\\s+")).map(Integer::parseInt).forEach(effects::offer);
        Arrays.stream(input2.split(",\\s+")).map(Integer::parseInt).forEach(casing::push);

        Map<String, Integer> bombs = new HashMap<>();
        bombs.put("Datura Bombs",0);bombs.put("Cherry Bombs",0);bombs.put("Smoke Decoy Bombs",0);

        while (!(effects.isEmpty() || casing.isEmpty())) {
            int firstEffect = effects.peek();
            int firstCasing = casing.pop();
            int sum = firstEffect + firstCasing;

            switch(sum){
                case 40:
                    bombs.put("Datura Bombs",bombs.get("Datura Bombs")+1);
                    effects.poll();
                    break;
                case 60:
                    bombs.put("Cherry Bombs",bombs.get("Cherry Bombs")+1);
                    effects.poll();
                    break;
                case 120:
                    bombs.put("Smoke Decoy Bombs",bombs.get("Smoke Decoy Bombs")+1);
                    effects.poll();
                    break;
                default:
                    casing.push(firstCasing-5);
            }
            if (bombs.values().stream().filter(s -> s >=3).count()==3){
                break;
            }
        }

        if (bombs.values().stream().filter(s -> s >=3).count()==3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (effects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            String effectsLeft = String.format("Bomb Effects: %s", effects.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println(effectsLeft);
        }

        if (casing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            String casingsLeft = String.format("Bomb Casings: %s", casing.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println(casingsLeft);
        }

        System.out.println("Cherry Bombs: " + (bombs.getOrDefault("Cherry Bombs", 0)));
        System.out.println("Datura Bombs: " + (bombs.getOrDefault("Datura Bombs", 0)));
        System.out.println("Smoke Decoy Bombs: " + (bombs.getOrDefault("Smoke Decoy Bombs", 0)));
    }
}