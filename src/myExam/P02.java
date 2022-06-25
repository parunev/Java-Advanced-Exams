package myExam;

import java.util.Scanner;

public class P02 {

    private static boolean caught = false;
    private static int dRow = -1;
    private static int dCol = -1;
    private static int stolen = 0;
    private static char[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        matrix = new char[n][];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            char[] row = line.toCharArray();

            if (line.contains("D")) {dRow = i;dCol = line.indexOf("D");}
            matrix[i] = row;
        }

        int i = 0;
        while (i < commands.length && !caught) {
            String direction = commands[i];

            int[] newCoordinates = changePosition(direction);
            int nextRow = newCoordinates[0];
            int nextCol = newCoordinates[1];

            if (!isValid(nextRow, nextCol)) {
                System.out.println("You cannot leave the town, there is police outside!");
                i++;
                continue;
            }

            matrix[dRow][dCol] = '+';
            if (matrix[nextRow][nextCol] == '$') {
                int money = nextRow * nextCol;
                stolen += money;
                System.out.printf("You successfully stole %d$.%n", money);
            } else if (matrix[nextRow][nextCol] == 'P') {
                caught = true;
                matrix[nextRow][nextCol] = '#';
                break;
            }
            dRow = nextRow;
            dCol = nextCol;
            matrix[dRow][dCol] = 'D';

            i++;
        }

        if (!caught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolen);
        } else {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", stolen);
        }

        printMatrix();
    }

    private static void printMatrix() {
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(int nextRow, int nextCol) {
        return nextRow < matrix.length && nextRow >= 0 && nextCol < matrix[nextRow].length && nextCol >= 0;
    }

    private static int[] changePosition(String direction) {
        int[] coordinates = new int[2];
        switch (direction) {
            case "up": coordinates[0] = dRow - 1;coordinates[1] = dCol;break;
            case "down": coordinates[0] = dRow + 1;coordinates[1] = dCol;break;
            case "left": coordinates[0] = dRow;coordinates[1] = dCol - 1;break;
            case "right": coordinates[0] = dRow;coordinates[1] = dCol + 1;break;
        }
        return coordinates;
    }
}