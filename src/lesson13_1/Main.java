package lesson13_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> taskList = new ArrayList<>();
        boolean exit = false;
        while (!exit) {
            System.out.println("Select an action: ");
            System.out.println("1. Add task \n" +
                               "2. List tasks \n" +
                               "3. Delete task \n" +
                               "0. Exit");
            try {
                int action = Integer.parseInt(scanner.nextLine());
                if (action < 0 || action > 3) {
                    System.out.println("Only digits from 0 to 3 are available!");
                }
                switch (action) {
                    case 0 -> exit = true;
                    case 1 -> addTask(taskList);
                    case 2 -> printTasks(taskList);
                    case 3 -> deleteTask(taskList);
                }
            } catch (Exception e) {
                System.out.println("Only digits are available!");
            }
        }
        scanner.close();
    }

    private static void addTask(ArrayList<String> taskList) {
        while (true) {
            System.out.println("Input task name or \"end\" for exit: ");
            String taskName = scanner.nextLine();
            if (taskName.equals("end")) {
                break;
            }
            taskList.add(taskName);
        }
        printTasks(taskList);
    }

    private static void deleteTask(ArrayList<String> taskList) {
        while (taskList.size() > 0) {
            System.out.println("Input a task number for delete or \"0\" for exit");
            try {
                int taskNumber = Integer.parseInt(scanner.nextLine());
                if (taskNumber == 0){
                    break;
                }
                if (taskNumber > taskList.size()){
                    System.out.println("You haven't " + taskNumber + " task number! Only " +
                                       taskList.size() +
                                       " tasks in your list");
                } else {
                    taskList.remove(taskNumber-1);
                    System.out.println("The task number " + taskNumber +
                                       " deleted! There are " + taskList.size() +
                                       " tasks left in the list");
                }
            } catch (Exception e) {
                System.out.println("Only digits are available!");
            }
        }
        if (taskList.size() == 0) {
            System.out.println("You don't have any tasks in the list!");
        }
    }

    private static void printTasks(ArrayList<String> taskList) {
        int i = 0;
        if (taskList.size() > 0) {
            System.out.println("You have " + taskList.size() + " tasks in your list");
            for (String task : taskList) {
                i++;
                System.out.println(i + ". " + task);
            }
        } else {
            System.out.println("Task list is empty!");
        }
    }
}
