public interface Account {
    String getAccountNumber();
    double getBalance();
    void updateBalance(double amount);
    void showAccountDetails();
}