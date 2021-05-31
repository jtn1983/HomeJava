package Lesson7_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[]{
                new Product(90000, "Phone", "description1"),
                new Product(150000, "Tv", "description2"),
                new Product(102000, "Tablet", "description3"),
                new Product(70000, "Computer", "description4"),
                new Product(256000, "Notebook", "description5"),
        };

        int leftBorder = 0;
        int rightBorder = products.length - 1;
        Comparator<Product> comparator;
        String textSortingType;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which field to sort by? (default by name)");
        System.out.println("1. By price \n2. By Name \n3. By description");

        try {
            int sortingType = scanner.nextInt();

            switch (sortingType) {
                case 1:
                    comparator = Comparator.comparing(obj -> obj.getPrice());
                    textSortingType = "price";
                    break;
                case 3:
                    comparator = Comparator.comparing(obj -> obj.getDescription());
                    textSortingType = "description";
                    break;
                case 2:
                default:
                    comparator = Comparator.comparing(obj -> obj.getName());
                    textSortingType = "name";
            }
        } catch (Exception e) {
            System.out.println("Oops! Something wrong. We will sort array by name!");
            comparator = Comparator.comparing(obj -> obj.getName());
            textSortingType = "name";
        }

        mySort(products, leftBorder, rightBorder, comparator);
        System.out.println("Array sorting by " + textSortingType + "\n" + Arrays.toString(products));
        scanner.close();
    }

    public static void mySort(Product[] products, int leftBorder, int rightBorder, Comparator comparator) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        Product pivot = products[(leftMarker + rightMarker) / 2];
        do {
            while (comparator.compare(products[leftMarker], pivot) < 0) {
                leftMarker++;
            }
            while (comparator.compare(products[rightMarker], pivot) > 0) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    Product tmp = products[leftMarker];
                    products[leftMarker] = products[rightMarker];
                    products[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            mySort(products, leftMarker, rightBorder, comparator);
        }
        if (leftBorder < rightMarker) {
            mySort(products, leftBorder, rightMarker, comparator);
        }
    }
}

