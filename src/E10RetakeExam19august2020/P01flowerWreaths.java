package E10RetakeExam19august2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01flowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        ArrayDeque<Integer> lilies = new ArrayDeque<>(); //queue
        ArrayDeque<Integer> roses = new ArrayDeque<>(); //stack

        Arrays.stream(input1.split(",\\s+")).mapToInt(Integer::parseInt).forEach(lilies::push);
        Arrays.stream(input2.split(",\\s+")).mapToInt(Integer::parseInt).forEach(roses::offer);

        int counter = 5;
        int left = 0;

        while (!(roses.isEmpty() || lilies.isEmpty()) || counter > 5) {
            int singleTulips = lilies.pop();
            int singleDaffodils = roses.poll();

            while (true){
                if (singleTulips + singleDaffodils < 15) {left += singleTulips + singleDaffodils;break;}
                else if (singleTulips + singleDaffodils == 15) {counter--;break;}
                else {singleTulips -= 2;}
            }
        }

        counter -= left / 15;

        if (counter <= 0) {
            System.out.println("You made it, you are going to the competition with 5 wreaths!");
        } else {
            System.out.println("You didn't make it, you need " + counter + " wreaths more!");
        }
    }
}