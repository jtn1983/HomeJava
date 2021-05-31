package lesson11_2;

abstract class Account {
    protected int amount;
    protected String accountName;

    public Account(int amount, String accountName) {
        this.amount = amount;
        this.accountName = accountName;
    }

    abstract boolean pay(int amount);
    abstract boolean transfer(Account account, int amount);
    abstract boolean addMoney(int amount);

    public int getAmount(){
        return amount;
    }

    @Override
    public String toString() {
        return accountName;
    }

    public void printBalance() {
        System.out.println(accountName + " balance " + amount + "$");
    }
}
