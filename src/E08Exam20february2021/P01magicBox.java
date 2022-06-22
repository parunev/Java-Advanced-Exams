package E08Exam20february2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01magicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        ArrayDeque<Integer> magicBoxOne = new ArrayDeque<>(); //queue
        ArrayDeque<Integer> magicBoxTwo = new ArrayDeque<>(); //stack

        Arrays.stream(input1.split("\\s+")).map(Integer::parseInt).forEach(magicBoxOne::offer);
        Arrays.stream(input2.split("\\s+")).map(Integer::parseInt).forEach(magicBoxTwo::push);

        int sum = 0;
        while(!(magicBoxOne.isEmpty() || magicBoxTwo.isEmpty())){
            if ((magicBoxOne.peek() + magicBoxTwo.peek()) % 2 == 0){
                sum += magicBoxOne.poll() + magicBoxTwo.pop();
            }else{
                magicBoxOne.offer(magicBoxTwo.pop());
            }
        }
        if (magicBoxOne.isEmpty()){
            System.out.println("First magic box is empty.");
        }else {
            System.out.println("Second magic box is empty.");
        }

        if (sum >= 90){
            System.out.println("Wow, your prey was epic! Value: "+sum);
        }else{
            System.out.println("Poor prey... Value: " + sum);
        }
    }
}
