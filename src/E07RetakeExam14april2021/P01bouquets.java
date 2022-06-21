package E07RetakeExam14april2021;

import java.util.*;

public class P01bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        ArrayDeque<Integer> tulips = new ArrayDeque<>(); //queue
        ArrayDeque<Integer> daffodils = new ArrayDeque<>(); //stack

        Arrays.stream(input1.split(",\\s+")).mapToInt(Integer::parseInt).forEach(tulips::push);
        Arrays.stream(input2.split(",\\s+")).mapToInt(Integer::parseInt).forEach(daffodils::offer);

        int counter = 5;
        int left = 0;

        while (!(daffodils.isEmpty() || tulips.isEmpty()) || counter > 5) {
            int singleTulips = tulips.pop();
            int singleDaffodils = daffodils.poll();

            while (true){
                if (singleTulips + singleDaffodils < 15) {left += singleTulips + singleDaffodils;break;}
                else if (singleTulips + singleDaffodils == 15) {counter--;break;}
                else {singleTulips -= 2;}
            }
        }

        counter -= left / 15;

        if (counter <= 0) {
            System.out.println("You made it! You go to the competition with 5 bouquets!");
        } else {
            System.out.println("You failed... You need more " + counter + " bouquets.");
        }
    }
}
