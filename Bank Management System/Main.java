public class Main {
    public static void main(String[] args) {
        // Create an admin
        Admin admin = new Admin("admin01");
        AccountManager accountManager = new AccountManager();

        // Create some accounts
        CheckingAccount checking = new CheckingAccount("CHK123", 500.00, 50.00);
        SavingsAccount savings = new SavingsAccount("SAV456", 1000.00, 0.02);
        CreditAccount credit = new CreditAccount("CREDIT789", 200.00, 1000.00);

        // Add accounts using AccountManager
        accountManager.addAccount(checking);
        accountManager.addAccount(savings);
        accountManager.addAccount(credit);

        // Read account details
        accountManager.getAccountDetails("CHK123");
        accountManager.getAccountDetails("SAV456");

        // Update account balance
        accountManager.updateAccountBalance("CHK123", 100.00); // Increase balance by 100
        accountManager.getAccountDetails("CHK123");

        // Delete an account
        accountManager.deleteAccount("CREDIT789");
        accountManager.getAccountDetails("CREDIT789"); // Should indicate not found
    }
}
