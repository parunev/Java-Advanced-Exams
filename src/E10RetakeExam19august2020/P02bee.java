package E10RetakeExam19august2020;

import java.util.Arrays;
import java.util.Scanner;

public class P02bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        int[] beePos = new int[2];
        int[] out = new int[1];
        createMatrix(matrix, beePos, scanner);

        int flowers = 0;

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("End")){break;}

            matrix[beePos[0]][beePos[1]] = '.';
            changePosition(command, beePos, n, out);

            if (out[0] == 1) {break;}

            if (matrix[beePos[0]][beePos[1]] == 'O') {
                matrix[beePos[0]][beePos[1]] = '.';
                changePosition(command, beePos, n, out);
            }if (matrix[beePos[0]][beePos[1]] == 'f') {
                flowers++;
            }
            matrix[beePos[0]][beePos[1]] = 'B';
        }

        if (out[0] == 1) {System.out.println("The bee got lost!");}
        if (flowers>=5) {System.out.println("Great job, the bee manage to pollinate " + flowers + " flowers!");}
        else{System.out.println("The bee couldn't pollinate the flowers, she needed " + (5-flowers) + " flowers more");}
        Arrays.stream(matrix).map(String::valueOf).forEach(System.out::println);
    }

    public static boolean InTheMatrix(int row, int col, int rowMatrix) {
        return row >= 0 && row < rowMatrix && col >= 0 && col < rowMatrix;
    }

    public static void createMatrix(char[][] matrix, int[] beePosition, Scanner console) {
        for (int i = 0; i < matrix.length; i++) {
            String input = console.nextLine();
            for (int j = 0; j < input.length(); j++) {
                matrix[i][j] = input.charAt(j);
                if (input.charAt(j) == 'B') {
                    beePosition[0] = i;
                    beePosition[1] = j;
                }
            }
        }
    }

    public static void changePosition(String command, int[] beePosition, int rowMatrix, int[] outOfTerritory) {
        switch (command) {
            case "up":
                if (InTheMatrix(beePosition[0] - 1, beePosition[1], rowMatrix)) {beePosition[0]--;}
                else {outOfTerritory[0] = 1;}break;
            case "down":
                if (InTheMatrix(beePosition[0] + 1, beePosition[1], rowMatrix)) {beePosition[0]++;}
                else {outOfTerritory[0] = 1;}break;
            case "left":
                if (InTheMatrix(beePosition[0], beePosition[1] - 1, rowMatrix)) {beePosition[1]--;}
                else {outOfTerritory[0] = 1;}break;
            case "right":
                if (InTheMatrix(beePosition[0], beePosition[1] + 1, rowMatrix)) {beePosition[1]++;}
                else {outOfTerritory[0] = 1;}break;
        }
    }
}