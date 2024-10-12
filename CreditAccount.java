// CreditAccount class
class CreditAccount extends BankAccount {
    private final double creditLimit;

    public CreditAccount(String accountNumber, double balance, double creditLimit) {
        super(accountNumber, balance);
        this.creditLimit = creditLimit;
    }

    public void withdraw(double amount) {
        if (balance + creditLimit >= amount) {
            balance -= amount;
            Transaction transaction = new Withdraw("W" + (transactions.size() + 1), amount); // Corrected size access
            addTransaction(transaction);
        } else {
            System.out.println("Withdrawal denied: Exceeds credit limit.");
        }
    }
}