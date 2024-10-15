class CheckingAccount extends BankAccount {
    private final double overdraftFee;

    public CheckingAccount(String accountNumber, double balance, double overdraftFee) {
        super(accountNumber, balance);
        this.overdraftFee = overdraftFee;
    }

    public void withdraw(double amount) {
        if (balance + overdraftFee >= amount) {
            balance -= amount;
            Transaction transaction = new Withdraw("W" + (transactions.size() + 1), amount); 
            addTransaction(transaction);
        } else {
            System.out.println("Withdrawal denied: Insufficient funds.");
        }
    }
}
