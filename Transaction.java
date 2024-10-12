// Transaction abstract class
import java.util.Date;

abstract class Transaction {
    protected String transactionID;
    protected double amount;
    protected Date timestamp;

    public Transaction(String transactionID, double amount) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.timestamp = new Date();
    }

    public abstract void execute();
}
