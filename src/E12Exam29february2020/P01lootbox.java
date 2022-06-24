package E12Exam29february2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        ArrayDeque<Integer> firstLootBox = new ArrayDeque<>(); //queue
        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>(); //stack

        Arrays.stream(input1.split("\\s+")).map(Integer::parseInt).forEach(firstLootBox::offer);
        Arrays.stream(input2.split("\\s+")).map(Integer::parseInt).forEach(secondLootBox::push);

        int sum = 0;
        while(!(firstLootBox.isEmpty() || secondLootBox.isEmpty())){
            if ((firstLootBox.peek() + secondLootBox.peek()) % 2 == 0){
                sum += firstLootBox.poll() + secondLootBox.pop();
            }else{
                firstLootBox.offer(secondLootBox.pop());
            }
        }
        if (firstLootBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }else {
            System.out.println("Second lootbox is empty");
        }

        if (sum >= 100){
            System.out.println("Your loot was epic! Value: "+sum);
        }else{
            System.out.println("Your loot was poor... Value: " + sum);
        }
    }
}