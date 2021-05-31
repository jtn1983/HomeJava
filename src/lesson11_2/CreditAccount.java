package lesson11_2;

public class CreditAccount extends Account{
    public CreditAccount(int amount, String accountName) {
        super(amount, accountName);
    }

    @Override
    boolean pay(int amount) {
        this.amount -= amount;
        System.out.println("Paid " + amount + "$");
        return true;
    }

    @Override
    boolean transfer(Account account, int amount) {
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
        if (this.amount + amount > 0) {
            System.out.println("Can't deposit account. You cannot keep funds in a credit account");
            return false;
        }
        this.amount += amount;
        System.out.println("The deposit to the account in the amount " + amount + "$ has been successfully complete");
        return true;
    }
}
