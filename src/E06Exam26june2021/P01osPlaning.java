    package E06Exam26june2021;

    import java.util.ArrayDeque;
    import java.util.Arrays;
    import java.util.Scanner;
    import java.util.stream.Collectors;

    public class P01osPlaning {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String input1 = scanner.nextLine();
            String input2 = scanner.nextLine();

            ArrayDeque<Integer> tasks = new ArrayDeque<>(); //queue
            ArrayDeque<Integer> threads = new ArrayDeque<>(); //stack

            Arrays.stream(input1.split(", ")).map(Integer::parseInt).forEach(tasks::push);
            Arrays.stream(input2.split("\\s+")).map(Integer::parseInt).forEach(threads::offer);

            int taskToKill = Integer.parseInt(scanner.nextLine());

            while (true){
                if (tasks.peek() == taskToKill){
                    System.out.println("Thread with value " + threads.peek() + " killed task " + taskToKill);
                    break;
                }else if (threads.peek() >= tasks.peek()){
                    tasks.pop();
                    threads.poll();
                }else{
                    threads.poll();
                }
            }

            System.out.println(threads.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
