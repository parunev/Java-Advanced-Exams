package E06Exam26june2021;

import java.util.Scanner;

public class P02python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",\\s+");

        String[][] matrix = new String[n][n];
        int[] pythonPos = new int[3];

        fillMatrix(scanner, n, matrix, pythonPos);

        int pythonLength = 1;
        boolean isDead = false;

        for (String command : commands) {
            changePositions(command, pythonPos, n);
            if(matrix[pythonPos[0]][pythonPos[1]].equals("f")){
                pythonLength++;
                pythonPos[2]--;
            }
            if(matrix[pythonPos[0]][pythonPos[1]].equals("e")){
                isDead = true;
                break;
            }
        }

        if(pythonPos[2]==0) {
            System.out.println( "You win! Final python length is " + pythonLength);
        } else if(isDead) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.println("You lose! There is still " + pythonPos[2] + " food to be eaten.");
        }
    }

    public static void changePositions(String command, int[] pitonPosition, int rowMatrix) {
        switch (command) {
            case "up":
                if (InTheMatrix(pitonPosition[0] - 1, pitonPosition[1], rowMatrix)) {pitonPosition[0]--;}
                else {pitonPosition[0] = rowMatrix - 1;}
                break;
            case "down":
                if (InTheMatrix(pitonPosition[0] + 1, pitonPosition[1], rowMatrix)) {pitonPosition[0]++;}
                else {pitonPosition[0] = 0;}
                break;
            case "left":
                if (InTheMatrix(pitonPosition[0], pitonPosition[1] - 1, rowMatrix)) {pitonPosition[1]--;}
                else {pitonPosition[1] = rowMatrix - 1;}
                break;
            case "right":
                if (InTheMatrix(pitonPosition[0], pitonPosition[1] + 1, rowMatrix)) {pitonPosition[1]++;}
                else {pitonPosition[1] = 0;}
                break;
        }
    }

    public static boolean InTheMatrix(int row, int col, int rowMatrix) {
        return row >= 0 && row < rowMatrix && col >= 0 && col < rowMatrix;
    }

    private static void fillMatrix(Scanner console, int rowMatrix, String[][] matrix, int[] pitonPosition) {
        for (int i = 0; i < rowMatrix; i++) {
            String input = console.nextLine();
            matrix[i] = input.split("\\s+");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("s")) {
                    matrix[i][j] = "*";
                    pitonPosition[0] = i;
                    pitonPosition[1] = j;
                }
                if (matrix[i][j].equals("f")) {
                    pitonPosition[2]++;
                }
            }
        }
    }
}
