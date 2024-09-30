import java.util.HashMap;
import java.util.Map;

class AccountManager {
    private Map<String, BankAccount> accountMap;

    public AccountManager() {
        this.accountMap = new HashMap<>();
    }

    // Create account
    public void addAccount(BankAccount account) {
        accountMap.put(account.accountNumber, account);
        System.out.println("Account created: " + account.accountNumber);
    }

    // Read account details
    public void getAccountDetails(String accountNumber) {
        BankAccount account = accountMap.get(accountNumber);
        if (account != null) {
            System.out.println("Account Number: " + account.accountNumber);
            System.out.println("Account Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Update account balance
    public void updateAccountBalance(String accountNumber, double amount) {
        BankAccount account = accountMap.get(accountNumber);
        if (account != null) {
            account.updateBalance(amount);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Delete account
    public void deleteAccount(String accountNumber) {
        if (accountMap.remove(accountNumber) != null) {
            System.out.println("Account deleted: " + accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }
}
