package Lesson8_2;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static final int SIZE = 10;
    public static final int EMPTY = 0;
    public static final int SHIP = 1;
    public static final int DEAD = 2;
    public static final int MISS = 3;
    public static final int MAX_COUNT = 10;
    public static final int ATTEMPTS = 30;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("The game 'Sea Battle' ");
        System.out.println("Generating field ...");
        TimeUnit.SECONDS.sleep(2);

        int[][] warField = new int[SIZE][SIZE];
        Random random = new Random();
        for (int i = 0; i < MAX_COUNT; i++){
            int shipCoordinate1 = random.nextInt(SIZE);
            int shipCoordinate2 = random.nextInt(SIZE);
            if (warField[shipCoordinate1][shipCoordinate2] == SHIP){
                i--;
            }
            warField[shipCoordinate1][shipCoordinate2] = SHIP;
        }

        Scanner scanner = new Scanner(System.in);
        int currentAttempt = ATTEMPTS;

        while (currentAttempt > 0) {
            try {
                System.out.println("Input coordinates for attack (attempts left: " + currentAttempt + "):");
                String input = scanner.nextLine();
                int firstCoordinate = Integer.parseInt(input.split(":")[0]);
                int secondCoordinate = Integer.parseInt(input.split(":")[1]);

                shoot(warField, firstCoordinate, secondCoordinate);
                if (isWin(warField)){
                    break;
                };
                currentAttempt --;
            } catch (Exception e) {
                System.out.println("Input format is invalid!");
            }

        }
        if (currentAttempt != 0) {
            System.out.println("You've won!");
        } else {
            System.out.println("You've lost!");
        }
        printField(warField);
        scanner.close();
    }

    public static void printField(int[][] matrix) {
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                System.out.format("%2d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isWin(int[][] matrix) {
        int countOne = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (matrix[i][j] == 1) {
                    countOne++;
                }
            }
        }
        return (countOne !=0 ) ? false : true;
    }

    public static void shoot (int[][] matrix, int coordinate1, int coordinate2){
        switch (matrix[coordinate1-1][coordinate2-1]) {
            case SHIP:
                matrix[coordinate1-1][coordinate2-1] = DEAD;
                System.out.println("You've hit the ship!");
                break;
            case EMPTY:
                matrix[coordinate1-1][coordinate2-1] = MISS;
                System.out.println("You missed!");
                break;
            default:
                System.out.println("You've already shot here!");
        }
    }
}
