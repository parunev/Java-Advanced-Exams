package E09RetakeExam16december2020;

import java.util.Arrays;
import java.util.Scanner;

public class P02selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][]matrix = new char[n][n];
        int[] playerPos = new int[2];
        int[][] pillarC = new int[2][2];
        int[] outPastry = new int[1];

        fillMatrix(matrix, playerPos, scanner, pillarC);

        int money = 0;

        while (money < 50){
            String input = scanner.nextLine();
            matrix[playerPos[0]][playerPos[1]] = '-';
            changePosition(input, playerPos, n, outPastry);

            if (outPastry[0] == 1){
                break;
            }

            if (String.valueOf(matrix[playerPos[0]][playerPos[1]]).matches("\\d")){
                money += Integer.parseInt(String.valueOf(matrix[playerPos[0]][playerPos[1]]));
            }

            if (matrix[playerPos[0]][playerPos[1]] == 'O'){
                matrix[playerPos[0]][playerPos[1]] = '-';
                if (playerPos[0] == pillarC[0][0] && playerPos[1] == pillarC[0][1]){
                    playerPos[0] = pillarC[1][0];
                    playerPos[1] = pillarC[1][1];
                }else{
                    playerPos[0] = pillarC[0][0];
                    playerPos[1] = pillarC[0][1];
                }
            }
            matrix[playerPos[0]][playerPos[1]] = 'S';
        }

        if (outPastry[0] == 1){
            System.out.println("Bad news, you are out of the E09RetakeExam16december2020.bakery.");
        }else{
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n",money);
        Arrays.stream(matrix).map(String::valueOf).forEach(System.out::println);

    }

    private static void changePosition(String input, int[] playerPos, int n, int[] outPastry) {
        switch (input){
            case"up":
                if (inMatrix(playerPos[0]-1,playerPos[1],n)){playerPos[0]--;
                }else{outPastry[0] = 1;}break;
            case"down":
                if (inMatrix(playerPos[0]+1,playerPos[1],n)){playerPos[0]++;
                }else{outPastry[0] = 1;}break;
            case"left":
                if (inMatrix(playerPos[0],playerPos[1]-1,n)){playerPos[1]--;
                }else{outPastry[0] = 1;}break;
            case"right":
                if (inMatrix(playerPos[0],playerPos[1]+1,n)){playerPos[1]++;
                }else{outPastry[0] = 1;}break;
        }
    }

    private static boolean inMatrix(int row, int col, int n) {
        return row >= 0 && row<n && col>= 0 && col <n;
    }

    private static void fillMatrix(char[][] matrix, int[] playerPos, Scanner scanner, int[][] pillarC) {
        int pillarR = 0;
        for (int row = 0; row <matrix.length ; row++) {
            String input = scanner.nextLine();
            for (int col = 0; col < input.length(); col++) {
                matrix[row][col] = input.charAt(col);
                if (input.charAt(col) == 'S'){
                    playerPos[0] = row;
                    playerPos[1] = col;
                }
                if (input.charAt(col) == 'O'){
                    pillarC[pillarR][0] = row;
                    pillarC[pillarR][1] = col;
                    pillarR++;
                }
            }
        }
    }
}
