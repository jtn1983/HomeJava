package Lesson7_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String[] products = new String[]{"Bread", "Milk", "Apple"};
        int[] prices = new int[]{50, 80, 100};
        int[] counts = new int[products.length];

        Scanner scanner = new Scanner(System.in);
        System.out.println("List of products to buy:");
        for (int i=0; i<products.length; i++) {
            System.out.println(i + 1 + ". " + products[i] + "   " + prices[i] + "rub");
        }
        while (true){
            System.out.println("Enter the product number and quantity to purchase, or \"end\" to display the final cart: ");
            try {
                String inputString = scanner.nextLine();
                if (inputString.equals("end")) {
                    break;
                }
                String[] splitInputString = inputString.split(" ");
                if (splitInputString.length == 2) {
                    int productNumber = Integer.parseInt(splitInputString[0]);
                    int productCount = Integer.parseInt(splitInputString[1]);
                    if (productNumber <= products.length) {
                        counts[productNumber - 1] = counts[productNumber - 1] + productCount;
                        System.out.println(productCount + " of " + products[productNumber-1] + " added successfully!");
                    } else {
                        System.out.println("The product number is incorrect. Product not added");
                    }
                } else {
                    System.out.println("You must input two parameters. Product not added");
                }
            }
            catch (Exception e) {
                System.out.println("Input string is not valid! Try again.");
            }
        }
        generateCart(products, counts, prices);
        scanner.close();
    }

    public static void generateCart(String[] products, int[] counts, int[] prices){
        int productTotalPrice = 0;
        int totalPrice =0;
        System.out.println("Your cart:");
        for (int i=0; i<counts.length; i++) {
            if (counts[i] > 0) {
                productTotalPrice = counts[i] * prices[i];
                System.out.println(products[i] + "  "
                        + counts[i] + "pc." + "  "
                        + prices[i] + "rub" + "  "
                        + productTotalPrice + "rub");
                totalPrice += productTotalPrice;
            }
        }
        if (totalPrice != 0) {
            System.out.println("Total price: " + totalPrice + "rub");
        } else {
            System.out.println("Cart is empty!");
        }
    }
}
