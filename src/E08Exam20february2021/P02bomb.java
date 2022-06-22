package E08Exam20february2021;

import java.util.Objects;
import java.util.Scanner;

public class P02bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] command = scanner.nextLine().split(",");

        String[][] matrix = new String[n][n];
        int[] playerPos = new int[2];

        int bombNumber = 0;
        for (int row = 0; row < matrix.length ; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                if (Objects.equals(matrix[row][col], "s")){
                    playerPos[0] = row;
                    playerPos[1] = col;
                    matrix[playerPos[0]][playerPos[1]] = "+";
                }
                if (matrix[row][col].equals("B")){
                    bombNumber++;
                }
            }
        }

        boolean end = false;
        boolean bombsFound = false;

        for (String s : command){
            changePosition(s,playerPos,n);

            if (matrix[playerPos[0]][playerPos[1]].equals("B")){
                System.out.println("You found a bomb!");
                bombNumber--;
                if (bombNumber == 0){
                    bombsFound = true;
                    break;
                }
                matrix[playerPos[0]][playerPos[1]] = "+";
            }

            if (matrix[playerPos[0]][playerPos[1]].equals("e")){
                end = true;
                break;
            }
        }

        if (bombsFound){
            System.out.println("Congratulations! You found all bombs!");
        }else if (end){
            System.out.printf("END! %d bombs left on the field%n",bombNumber);
        }else{
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",bombNumber,playerPos[0],playerPos[1]);
        }

    }

    private static void changePosition(String command, int[] playerPos, int n) {
        switch (command){
            case"up":
                if (inMatrix(playerPos[0]-1,playerPos[1],n)){playerPos[0]--;}break;
            case"down":
                if (inMatrix(playerPos[0]+1,playerPos[1],n)){playerPos[0]++;}break;
            case"left":
                if (inMatrix(playerPos[0],playerPos[1]-1,n)){playerPos[1]--;}break;
            case"right":
                if (inMatrix(playerPos[0],playerPos[1]+1,n)){playerPos[1]++;}break;
        }
    }

    private static boolean inMatrix(int row, int col, int n) {
        return row >= 0 && row<n && col>= 0 && col <n;
    }

}
