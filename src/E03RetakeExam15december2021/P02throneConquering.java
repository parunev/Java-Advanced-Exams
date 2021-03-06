package E03RetakeExam15december2021;

import java.util.Scanner;

public class P02throneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][];
        int pRow = 0;
        int pCol = 0;
        boolean helenIsHere = false;

        for (int i = 0; i < rows; i++) {
            char[] array = scanner.nextLine().toCharArray();
            matrix[i] = array;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char currentChar = matrix[i][j];
                if (currentChar == 'P') {
                    pRow = i;
                    pCol = j;
                }
            }
        }

        while (energy > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String cmd = input[0];
            int eRow = Integer.parseInt(input[1]);
            int eCol = Integer.parseInt(input[2]);

            matrix[eRow][eCol] = 'S';
            energy--;

            switch (cmd) {
                case "up":
                    if (pRow - 1 != -1) {
                        matrix[pRow][pCol] = '-';
                        pRow--;
                        if (matrix[pRow][pCol] == 'S') {
                            energy -= 2;
                            if (energy <= 0) {
                                matrix[pRow][pCol] = 'X';
                            } else {
                                matrix[pRow][pCol] = '-';
                            }
                        }
                        if (matrix[pRow][pCol] == 'H') {
                            helenIsHere = true;
                            matrix[pRow][pCol] = '-';
                            break;
                        }
                    }
                    break;
                case "down":
                    if (pRow + 1 < matrix.length) {
                        matrix[pRow][pCol] = '-';
                        pRow++;
                        if (matrix[pRow][pCol] == 'S') {
                            energy -= 2;
                            if (energy <= 0) {
                                matrix[pRow][pCol] = 'X';
                            } else {
                                matrix[pRow][pCol] = '-';
                            }
                        }
                        if (matrix[pRow][pCol] == 'H') {
                            helenIsHere = true;
                            matrix[pRow][pCol] = '-';
                            break;
                        }
                    }
                    break;
                case "left":
                    if (pCol - 1 >= 0) {
                        matrix[pRow][pCol] = '-';
                        pCol--;
                        if (matrix[pRow][pCol] == 'S') {
                            energy -= 2;
                            if (energy <= 0) {
                                matrix[pRow][pCol] = 'X';
                            } else {
                                matrix[pRow][pCol] = '-';
                            }
                        }
                        if (matrix[pRow][pCol] == 'H') {
                            helenIsHere = true;
                            matrix[pRow][pCol] = '-';
                            break;
                        }
                    }
                    break;
                case "right":
                    if (pCol + 1 < matrix[pRow].length) {
                        matrix[pRow][pCol] = '-';
                        pCol++;
                        if (matrix[pRow][pCol] == 'S') {
                            energy -= 2;
                            if (energy <= 0) {
                                matrix[pRow][pCol] = 'X';
                            } else {
                                matrix[pRow][pCol] = '-';
                            }
                        }
                        if (matrix[pRow][pCol] == 'H') {
                            helenIsHere = true;
                            matrix[pRow][pCol] = '-';
                            break;
                        }
                    }
                    break;
            }
            if (helenIsHere) {break;}
            if (energy <= 0) {matrix[pRow][pCol] = 'X';}
        }

        if (helenIsHere) {System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
        } else {System.out.printf("Paris died at %d;%d.%n", pRow, pCol);}

        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
