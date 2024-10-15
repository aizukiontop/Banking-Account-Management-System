import java.util.ArrayList;
import java.util.List;

abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected String accountType;
    protected List<Transaction> transactions;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = this.getClass().getSimpleName(); 
        this.transactions = new ArrayList<>(); 
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction); 
        transaction.execute(); 
    }

 
    public void updateBalance(double amount) {
        this.balance += amount;
        System.out.println("Updated balance for account " + accountNumber + ": " + this.balance);
    }
}