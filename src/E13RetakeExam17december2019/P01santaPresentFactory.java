package E13RetakeExam17december2019;

import java.util.*;
import java.util.stream.Collectors;

public class P01santaPresentFactory {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayDeque<Integer> materials = new ArrayDeque<>();

        Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(materials::push);

        ArrayDeque<Integer> magicLevel = Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        Map<String, Integer> present = new TreeMap<>();
        present.put("Doll", 0);present.put("Wooden train", 0);present.put("Teddy bear", 0);present.put("Bicycle", 0);

        while (!(materials.isEmpty() || magicLevel.isEmpty())) {
            if (materials.peek() == 0) {materials.pop();}
            if (magicLevel.peek() == 0) {magicLevel.poll();}
            if (materials.isEmpty() || magicLevel.isEmpty()) {break;}

            int firstM = materials.pop();
            int firstML = magicLevel.poll();
            int sum = firstM * firstML;

            switch (sum) {
                case 150: present.put("Doll", present.get("Doll") + 1);break;
                case 250: present.put("Wooden train", present.get("Wooden train") + 1);break;
                case 300: present.put("Teddy bear", present.get("Teddy bear") + 1);break;
                case 400: present.put("Bicycle", present.get("Bicycle") + 1);break;
                default:
                    if (sum < 0) {
                        materials.push(firstM + firstML);
                    } else {
                        materials.push(firstM + 15);
                    }
            }
        }

        if((present.get("Doll")>0 && present.get("Wooden train")>0) || (present.get("Teddy bear")>0 && present.get("Bicycle")>0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if(!materials.isEmpty()) {
            System.out.printf("Materials left: %s%n", materials.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if(!magicLevel.isEmpty()) {
            System.out.printf("Magic left: %s%n", magicLevel.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        present.entrySet().stream().filter(s -> s.getValue() > 0).forEach(s -> System.out.printf("%s: %d%n", s.getKey(), s.getValue()));
    }
}
