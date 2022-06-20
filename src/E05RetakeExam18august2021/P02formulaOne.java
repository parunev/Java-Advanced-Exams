package E05RetakeExam18august2021;

import java.util.Scanner;

public class P02formulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int cmdCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        int[] playerPos = new int[2];

        for (int row = 0; row < n ; row++) {
            String input = scanner.nextLine();
            for (int col = 0; col < input.length(); col++) {
                matrix[row][col] = input.charAt(col);
                if (input.charAt(col) == 'P'){
                    playerPos[0] = row;
                    playerPos[1] = col;
                }
            }
        }

        int[] playerOldPos = new int[2];
        boolean raceOver = false;

        while (cmdCount-- > 0){
            String cmd = scanner.nextLine();

            playerOldPos[0] = playerPos[0];
            playerOldPos[1] = playerPos[1];

            matrix[playerPos[0]][playerPos[1]] = '.';
            changePosition(cmd,playerPos,n);

            if (matrix[playerPos[0]][playerPos[1]] == 'B'){
                changePosition(cmd,playerPos,n);
            }
            if (matrix[playerPos[0]][playerPos[1]] == 'T'){
                playerPos[0] = playerOldPos[0];
                playerPos[1] = playerOldPos[1];
            }
            if (matrix[playerPos[0]][playerPos[1]] == 'F'){
                matrix[playerPos[0]][playerPos[1]] = 'P';
                raceOver = true;
                break;
            }
            matrix[playerPos[0]][playerPos[1]] = 'P';
        }

        if (raceOver){
            System.out.println("Well done, the player won first place!");
        }else{
            System.out.println("Oh no, the player got lost on the track!");
        }

        for (char[] c : matrix){
            System.out.println(String.valueOf(c));
        }
    }

    public static boolean inTheMatrix(int row, int col, int rowMatrix) {
        return row >= 0 && row < rowMatrix && col >= 0 && col < rowMatrix;
    }

    public static void changePosition(String cmd, int[] playerPos, int n){
        switch (cmd) {
            case "up":
                if (inTheMatrix(playerPos[0] - 1, playerPos[1], n)) {playerPos[0]--;}
                else playerPos[0] = n - 1;
                break;
            case "down":
                if (inTheMatrix(playerPos[0] + 1, playerPos[1], n)) {playerPos[0]++;}
                else playerPos[0] = 0;
                break;
            case "left":
                if (inTheMatrix(playerPos[0], playerPos[1] - 1, n)) {playerPos[1]--;}
                else playerPos[1] = n - 1;
                break;
            case "right":
                if (inTheMatrix(playerPos[0], playerPos[1] + 1, n)) {playerPos[1]++;}
                else playerPos[1] = 0;
                break;
        }
    }
}
