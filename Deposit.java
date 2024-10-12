// Deposit class
class Deposit extends Transaction {
    public Deposit(String transactionID, double amount) {
        super(transactionID, amount);
    }

    @Override
    public void execute() {
        System.out.println("Executing deposit of " + amount + " at " + timestamp);
    }
}
