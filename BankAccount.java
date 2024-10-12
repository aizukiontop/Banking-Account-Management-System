import java.util.ArrayList;
import java.util.List;

// Base BankAccount class
abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected String accountType;
    protected List<Transaction> transactions;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = this.getClass().getSimpleName(); // Set account type based on class name
        this.transactions = new ArrayList<>(); // Initialize transactions list
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction); // Add transaction to the list
        transaction.execute(); // Execute the transaction
    }

    // Update balance method
    public void updateBalance(double amount) {
        this.balance += amount;
        System.out.println("Updated balance for account " + accountNumber + ": " + this.balance);
    }
}