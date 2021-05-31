package lesson13_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String[] employeeFields = {"Surname", "Name", "Age", "Sex", "Education", "Position", "Department"};
    public static void main(String[] args) {
        ArrayList<Employee> employeesList = new ArrayList<>();

        while (true) {
            System.out.println("Input information about an employee (surname, name, age, sex, education, position, department)");
            try {
                String surname = scanner.next();
                String name = scanner.next();
                int age = Integer.parseInt(scanner.next());
                String sex = scanner.next();
                String education = scanner.next();
                String position = scanner.next();
                String department = scanner.next();
                scanner.nextLine();
                Employee employee = new Employee(surname, name, age, sex, education, position, department);
                employeesList.add(employee);
                System.out.println("Any symbol to continue. If you want to exit, input \"end\"");
                String input = scanner.nextLine();
                if ("end".equals(input)) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Input error!");
            }
        }
        printEmployeesList(employeesList);

        while (true) {
            System.out.println("Change data (any symbol to continue)? If you don't want to change data input \"end\"");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            System.out.println("Input \"surname _ name\" of the employee for whom you want to change the data");
            String surname = scanner.next();
            String name = scanner.next();
            scanner.nextLine();

            int empIndex = searchBySurname(surname, name, employeesList);
            if (empIndex != -1) {
                changeAllEmployeesAttributes(employeesList.get(empIndex));
            } else {
                System.out.println("The employee not found!");
            }

        }
        printEmployeesList(employeesList);
    }

    private static int searchBySurname(String surname, String name, ArrayList<Employee> employeesList) {
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).getSurname().equals(surname) && employeesList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private static void printEmployeesList(ArrayList<Employee> employeesList) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", "Item", "Surname", "Name", "Age", "Sex", "Education", "Position", "Department");
        for (int i = 0; i < employeesList.size(); i++) {
            System.out.printf("%-10d %s \n", i+1, employeesList.get(i));
        }
    }

    public static void changeAllEmployeesAttributes (Employee employee) {
        for (int i = 0; i < employeeFields.length; i++) {
            System.out.println("Change " + employeeFields[i] + " ? (yes/No)");
            try {
                String answer = scanner.nextLine();
                if ("yes".equals(answer)) {
                    System.out.println("Input new " + employeeFields[i] + ":");
                    answer = scanner.nextLine();
                    switch (employeeFields[i]) {
                        case "Surname" -> employee.setSurname(answer);
                        case "Name" -> employee.setName(answer);
                        case "Age" -> {
                            try {
                                employee.setAge(Integer.parseInt(answer));
                            }catch (Exception e) {
                                System.out.println("The age must be a digit!");
                                i--;
                            }
                        }
                        case "Sex" -> employee.setSex(answer);
                        case "Education" -> employee.setEducation(answer);
                        case "Position" -> employee.setPosition(answer);
                        case "Department" -> employee.setDepartment(answer);
                    }
                }
            }catch (Exception e) {
                System.out.println("Input error!");
            }
        }
        System.out.println("New employees data:");
        System.out.println(employee);
    }
}
