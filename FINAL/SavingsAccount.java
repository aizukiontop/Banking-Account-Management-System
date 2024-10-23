public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void showAccountDetails() {
        System.out.println("Savings Account Number: " + accountNumber + ", Balance: " + balance + ", Interest Rate: " + interestRate);
    }
}