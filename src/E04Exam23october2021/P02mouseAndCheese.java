package E04Exam23october2021;

import java.util.Scanner;

public class P02mouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[n][n];
        int[] cMPosition = new int[2];

        for (int row = 0; row < n; row++) {
            String input = scanner.nextLine();
            for (int col = 0; col < input.length(); col++) {
                territory[row][col] = input.charAt(col);
                if (input.charAt(col) == 'M'){
                    cMPosition[0] = row;
                    cMPosition[1] = col;
                }
            }
        }

        int[] mOut = new int[1];
        int ate = 0;

        while (true){
            String cmd = scanner.nextLine();
            if (cmd.equals("end")){break;}

            territory[cMPosition[0]][cMPosition[1]] = '-';
            changePosition(cmd,cMPosition,n,mOut);

            if (territory[cMPosition[0]][cMPosition[1]] == 'B'){
                territory[cMPosition[0]][cMPosition[1]] = '-';
                changePosition(cmd,cMPosition,n,mOut);
            }

            if (mOut[0] == 1){break;}
            if (territory[cMPosition[0]][cMPosition[1]] == 'c'){ate++;}
            territory[cMPosition[0]][cMPosition[1]] = 'M';
        }

        if (mOut[0] == 1){System.out.println("Where is the mouse?");}
        if (ate<5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5-ate);
        }else{
            System.out.printf("Great job, the mouse is fed %d cheeses!%n",ate);
        }

        for (char[] i:territory) {System.out.println(String.valueOf(i));}

    }

    public static void changePosition(String cmd, int[] curMousePosition, int rowMatrix, int[] mouseIsOut){
        switch (cmd) {
            case "up":
                if (InTheMatrix(curMousePosition[0] - 1, curMousePosition[1], rowMatrix)) {curMousePosition[0]--;}
                else {mouseIsOut[0] = 1;}
                break;
            case "down":
                if (InTheMatrix(curMousePosition[0] + 1, curMousePosition[1], rowMatrix)) {curMousePosition[0]++;}
                else {mouseIsOut[0] = 1;}
                break;
            case "left":
                if (InTheMatrix(curMousePosition[0], curMousePosition[1] - 1, rowMatrix)) {curMousePosition[1]--;}
                else {mouseIsOut[0] = 1;}
                break;
            case "right":
                if (InTheMatrix(curMousePosition[0], curMousePosition[1] + 1, rowMatrix)) {curMousePosition[1]++;}
                else {mouseIsOut[0] = 1;}
                break;
        }
    }

    public static boolean InTheMatrix(int row, int col, int rowMatrix) {
        return row >= 0 && row < rowMatrix && col >= 0 && col < rowMatrix;
    }
}
