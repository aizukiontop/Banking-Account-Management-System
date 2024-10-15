class Withdraw extends Transaction {
    public Withdraw(String transactionID, double amount) {
        super(transactionID, amount);
    }

    @Override
    public void execute() {
        System.out.println("Executing withdrawal of " + amount + " at " + timestamp);
    }
}
