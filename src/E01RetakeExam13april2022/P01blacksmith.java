package E01RetakeExam13april2022;

import java.util.*;
import java.util.stream.Collectors;

public class P01blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //steel
        String input1 = scanner.nextLine();
        //carbon
        String input2 = scanner.nextLine();

        Queue<Integer> steel = new ArrayDeque<>();
        Stack<Integer> carbon = new Stack<>();

        //we add the steel input inside the queue
        Arrays.stream(input1.split("\\s+")).mapToInt(Integer::parseInt).forEach(steel::offer);
        //we add the carbon input inside the stack
        Arrays.stream(input2.split("\\s+")).mapToInt(Integer::parseInt).forEach(carbon::push);

        Map<String,Integer> swords = new TreeMap<>(); swords.put("Sabre",0); swords.put("Katana",0); swords.put("Shamshir", 0); swords.put("Gladius",0);

        while (!steel.isEmpty() && !carbon.isEmpty()){
            int firstSteel = steel.poll();
            int firstCarbon = carbon.pop();

            if (firstSteel + firstCarbon == 70){ //Gladius
                swords.put("Gladius", swords.get("Gladius") + 1);
            }else if (firstSteel + firstCarbon == 80){ //Shamshir
                swords.put("Shamshir", swords.get("Shamshir") + 1);
            }else if (firstSteel + firstCarbon == 90){ //Katana
                swords.put("Katana", swords.get("Katana") + 1);
            }else if (firstSteel + firstCarbon == 110){ //Sabre
                swords.put("Sabre", swords.get("Sabre") + 1);
            }else{
                carbon.push(firstCarbon + 5);
            }
        }

        //we get the sum of swords
        int swordSum = swords.values().stream().mapToInt(Integer::intValue).sum();

        //we check if either we forget any swords or not
        if (swordSum != 0){
            System.out.printf("You have forged %d swords.%n", swordSum);
        }else{
            System.out.println("You did not have enough resources to forge a sword.");
        }

        //we check if we have any steel left or not
        if (steel.isEmpty()){
            System.out.println("Steel left: none");
        }else{
            String steelLeft = steel.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Steel left: " + steelLeft);
        }

        //we check if we have any carbon left or not
        if (carbon.isEmpty()){
            System.out.println("Carbon left: none");
        }else{
            List<String> carbonLeft = carbon.stream().map(String::valueOf).collect(Collectors.toList());
            Collections.reverse(carbonLeft);
            System.out.println("Carbon left: " + String.join(", ",carbonLeft));
        }

        swords.entrySet().stream().filter(e->e.getValue() != 0).forEach(e2 -> System.out.println(e2.getKey() + ": " + e2.getValue()));

    }
}
