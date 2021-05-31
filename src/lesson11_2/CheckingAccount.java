package lesson11_2;

public class CheckingAccount extends Account{
    public CheckingAccount(int amount, String accountName) {
        super(amount, accountName);
    }

    @Override
    boolean pay(int amount) {
        if (this.amount < amount) {
            System.out.println("There are not enough funds in the account");
            return false;
        }
        this.amount -= amount;
        System.out.println("Paid " + amount + "$");
        return true;
    }

    @Override
    boolean transfer(Account account, int amount) {
        if (this.amount < amount) {
            System.out.println("There are not enough funds in the account");
            return false;
        }

        if (!account.addMoney(amount)){
            System.out.println("Transfer from account " + accountName + " to " + account + " failed!");
            return false;
        }
        this.amount -= amount;
        System.out.println("Transfer from account " + accountName +
                " to " + account +
                " in the amount of " + amount +
                "$ has been successfully complete");
        return true;
    }

    @Override
    boolean addMoney(int amount) {
        this.amount += amount;
        System.out.println("The deposit to the account in the amount " + amount + "$ has been successfully complete");
        return true;
    }
}
