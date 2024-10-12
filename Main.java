import java.util.List;
public class Main {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager();

        // Create some accounts
        CheckingAccount checkingAccount = new CheckingAccount("CHK123", 500.0, 50.0);
        SavingsAccount savingsAccount = new SavingsAccount("SAV456", 1000.0, 0.02);

        // Add accounts
        manager.addAccount(checkingAccount);
        manager.addAccount(savingsAccount);

        // Search by account number
        BankAccount account = manager.searchByAccountNumber("CHK123");
        if (account != null) {
            System.out.println("Found account with balance: " + account.getBalance());
        }

        // Filter accounts by balance
        List<BankAccount> filteredAccounts = manager.filterByBalance(800);
        System.out.println("Accounts with balance >= 800:");
        for (BankAccount acc : filteredAccounts) {
            System.out.println("Account Number: " + acc.accountNumber + ", Balance: " + acc.getBalance());
        }

        // Update account balance with valid amount
        manager.updateAccountBalance("CHK123", 200.0); // Valid
        manager.updateAccountBalance("CHK123", -100.0); // Invalid (negative amount)
    }
}