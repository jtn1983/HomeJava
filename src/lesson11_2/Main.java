package lesson11_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Account[] accounts = {
                new SavingsAccount(1000, "Saving account"),
                new CreditAccount(-3000, "Credit account"),
                new CheckingAccount(10000, "Checking Account")
        };
        printAccountInfo(accounts);
        System.out.println("");
        accounts[2].transfer(accounts[0], 400);
        accounts[1].pay(100);
        accounts[0].pay(1000);
        System.out.println("");
        printAccountInfo(accounts);
    }

    private static void printAccountInfo(Account[] accounts){
        for (Account account : accounts) {
            account.printBalance();
        }
    }
}
