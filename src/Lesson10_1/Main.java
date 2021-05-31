package Lesson10_1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);
        System.out.format("%nPlayer with %d weapon slots,"
                        + " input the number to shoot,"
                        + " -1 for exit%n",
                player.getSlotsCount()
        );
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input == -1) {
                    break;
                }
                player.shotWithWeapon(input - 1);
            } catch (Exception e) {
                System.out.println("Input error!");
            }
        }
        System.out.println("Game over!");
        scanner.close();
    }
}
