import java.util.List;
public class Main {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager();

        CheckingAccount checkingAccount = new CheckingAccount("CHK123", 500.0, 50.0);
        SavingsAccount savingsAccount = new SavingsAccount("SAV456", 1000.0, 0.02);

        manager.addAccount(checkingAccount);
        manager.addAccount(savingsAccount);

        BankAccount account = manager.searchByAccountNumber("CHK123");
        if (account != null) {
            System.out.println("Found account with balance: " + account.getBalance());
        }

        List<BankAccount> filteredAccounts = manager.filterByBalance(800);
        System.out.println("Accounts with balance >= 800:");
        for (BankAccount acc : filteredAccounts) {
            System.out.println("Account Number: " + acc.accountNumber + ", Balance: " + acc.getBalance());
        }

        manager.updateAccountBalance("CHK123", 200.0); 
        manager.updateAccountBalance("CHK123", -100.0); 
    }
}