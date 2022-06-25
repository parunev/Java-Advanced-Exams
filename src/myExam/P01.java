package myExam;

import java.util.*;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        ArrayDeque<Double> milk = new ArrayDeque<>(); //stack
        ArrayDeque<Double> cocoa = new ArrayDeque<>(); //queue

        Arrays.stream(input1.split("\\s+")).mapToDouble(Double::parseDouble).forEach(milk::offer);
        Arrays.stream(input2.split("\\s+")).mapToDouble(Double::parseDouble).forEach(cocoa::push);

        Map<String, Integer> ready = new TreeMap<>();

        while (!(milk.isEmpty() || cocoa.isEmpty())){

            double firstMilk = milk.peek();
            double firstCocoa = cocoa.peek();

            double sum = firstCocoa / (firstMilk + firstCocoa) * 100;


            if (sum == 30){
                ready.putIfAbsent("Milk Chocolate",0);
                ready.put("Milk Chocolate",ready.get("Milk Chocolate")+1);
                milk.poll();
                cocoa.pop();
            }else if (sum == 50){
                ready.putIfAbsent("Dark Chocolate",0);
                ready.put("Dark Chocolate", ready.get("Dark Chocolate") + 1);
                milk.poll();
                cocoa.pop();
            }else if (sum == 100){
                ready.putIfAbsent("Baking Chocolate",0);
                ready.put("Baking Chocolate",ready.get("Baking Chocolate") + 1);
                milk.poll();
                cocoa.pop();
            }else{
                cocoa.pop();
                double increase = milk.peek() + 10;
                milk.poll();
                milk.offer(increase);
            }
        }

        System.out.println(ready.size() == 3 ? "It’s a Chocolate Time. All chocolate types are prepared." :
                "Sorry, but you didn't succeed to prepare all types of chocolates.");

        ready.entrySet().stream().forEach(e -> System.out.println("# " + e.getKey() + " --> " + e.getValue()));
    }
}
