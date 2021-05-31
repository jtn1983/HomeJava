package Lesson8_1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 12;

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] colors = new int[SIZE][SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        System.out.println("Generated matrix:");
        printMatrix(colors);

        int angle = 0;

        while (true){
            try {
                System.out.println("Input angle for rotate matrix: ");
                angle = Integer.parseInt(scanner.nextLine());
                if (angle % 90 == 0 && angle > 0) {
                    break;
                } else {
                    System.out.println("The angel must be a multiple 90 deg and greater than 0 deg");
                }

            } catch (Exception e) {
                System.out.println("The angel must be a digit!");
            }

        }

        printMatrix(rotateMatrix(colors, angle));
        scanner.close();
    }

    public static void printMatrix(int[][] elements) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", elements[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] rotateMatrix(int[][] elements, int angle){
        int rotateCount = angle / 90;
        int[][] rotateMatrix = new int[SIZE][SIZE];
        for (int count = 0; count < rotateCount; count++) {
            if (count != 0) {
                for (int i = 0; i < SIZE; i++){
                    System.arraycopy(rotateMatrix[i], 0, elements[i], 0, SIZE);
                };
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    rotateMatrix[i][j] = elements[SIZE - (j + 1)][i];
                }
            }
        }
        return rotateMatrix;
    }
}
