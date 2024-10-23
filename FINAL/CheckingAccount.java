public class CheckingAccount extends BankAccount {
    private double overdraftFee;

    public CheckingAccount(String accountNumber, double initialBalance, double overdraftFee) {
        super(accountNumber, initialBalance);
        this.overdraftFee = overdraftFee;
    }

    @Override
    public void showAccountDetails() {
        System.out.println("Checking Account Number: " + accountNumber + ", Balance: " + balance + ", Overdraft Fee: " + overdraftFee);
    }
}
