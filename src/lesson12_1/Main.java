package lesson12_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input login");
        String login = scanner.nextLine();
        System.out.println("Input password");
        String password = scanner.nextLine();
        try {
            User user = getUserByLoginAndPassword(login, password);
            validateUser(user);
            System.out.println("Access granted!");
        } catch (UserNotFoundException | AccessDeniedException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static User[] getUsers() {
        User user1 = new User("Mike", "1234", "mike@mail.ru", 16);
        User user2 = new User("Pieter", "56789", "pieter@gmail.com", 30);
        User user3 = new User("Den", "password", "den@yahoo.com", 22);
        return new User[]{user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("Username or password is incorrect!");
    }

    public static void validateUser (User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Access denied! The user must be over the age of 18");
        }
    }
}
