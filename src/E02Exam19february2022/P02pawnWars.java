package E02Exam19february2022;

import java.util.Scanner;

public class P02pawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[8][8];

        int blackRow = -1;
        int blackCol = -1;
        int whiteRow = -1;
        int whiteCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            String input = scanner.nextLine();
            for (int col = 0; col < input.length(); col++) {
                matrix[row][col] = input.charAt(col);
                if (input.charAt(col) == 'w') { //insert white
                    whiteRow = row;
                    whiteCol = col;
                }
                if (input.charAt(col) == 'b') { //insert black
                    blackRow = row;
                    blackCol = col;
                }
            }
        }

        while (true) {
            //we check if white have contact with black
            if (isCaptured(whiteRow-1, whiteCol-1, 'b', matrix)) {break;}
            if (isCaptured(whiteRow-1, whiteCol+1, 'b', matrix)) {break;}
            //we check if white reached the end of the table
            if (whiteRow - 1 == 0) {
                char col = (char) ('a' + whiteCol);
                System.out.println("Game over! White pawn is promoted to a queen at " + col + "8.");
                break;
            }
            //we switch white position
            matrix[whiteRow][whiteCol] = '-';
            whiteRow--;
            matrix[whiteRow][whiteCol] = 'w';

            //we check if black have contact with white
            if (isCaptured(blackRow+1, blackCol-1, 'w', matrix)) {break;}
            if (isCaptured(blackRow+1, blackCol+1, 'w', matrix)) {break;}
            //we check if white reached the end of the table
            if (blackRow + 1 == 7) {
                char col = (char) ('a' + blackCol);
                System.out.println("Game over! Black pawn is promoted to a queen at " + col + "1.");
                break;
            }
            //we switch black position
            matrix[blackRow][blackCol] = '-';
            blackRow++;
            matrix[blackRow][blackCol] = 'b';
        }

    }
    //with this method we check if black or white captured each other figure
    public static boolean isCaptured(int row, int col, char pawn, char[][] matrix){
        if(row>=0 && row<=7 && col>=0 && col<=7 && matrix[row][col] == pawn){
            String captureColour = pawn == 'b' ? "White" : "Black";
            char colCapture = (char) ('a' + col);
            System.out.println("Game over! " + captureColour + " capture on " + colCapture + (8-row) + ".");
            return true;
        }
        return false;
    }
}
