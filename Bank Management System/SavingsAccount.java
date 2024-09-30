class SavingsAccount extends BankAccount {
    private final double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return balance * interestRate;
    }

    public void deposit(double amount) {
        balance += amount;
        Transaction transaction = new Deposit("D" + (transactions.size() + 1), amount);
        addTransaction(transaction);
    }
}
