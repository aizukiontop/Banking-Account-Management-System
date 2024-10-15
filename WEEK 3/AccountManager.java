import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountManager {
    private Map<String, BankAccount> accounts;

    public AccountManager() {
        accounts = new HashMap<>();
    }

    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public void updateAccountBalance(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.updateBalance(amount);
            System.out.println("Balance updated for account " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transferMoney(String senderAccNum, String receiverAccNum, double amount) {
        BankAccount senderAccount = accounts.get(senderAccNum);
        BankAccount receiverAccount = accounts.get(receiverAccNum);
        if (senderAccount != null && receiverAccount != null) {
            senderAccount.updateBalance(-amount);
            receiverAccount.updateBalance(amount);
            System.out.println("Transfer successful from " + senderAccNum + " to " + receiverAccNum);
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    public BankAccount getAccountDetails(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void deleteAccount(String accountNumber) {
        if (accounts.remove(accountNumber) != null) {
            System.out.println("Account " + accountNumber + " deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    public List<BankAccount> filterByBalance(double minBalance) {
        List<BankAccount> filteredAccounts = new ArrayList<>();
        for (BankAccount account : accounts.values()) {
            if (account.getBalance() >= minBalance) {
                filteredAccounts.add(account);
            }
        }
        return filteredAccounts;
    }

    // New method to filter by account type
    public List<BankAccount> filterByAccountType(Class<? extends BankAccount> type) {
        List<BankAccount> filteredAccounts = new ArrayList<>();
        for (BankAccount account : accounts.values()) {
            if (type.isInstance(account)) {
                filteredAccounts.add(account);
            }
        }
        return filteredAccounts;
    }

    // New method to filter by balance range
    public List<BankAccount> filterByBalanceRange(double minBalance, double maxBalance) {
        List<BankAccount> filteredAccounts = new ArrayList<>();
        for (BankAccount account : accounts.values()) {
            if (account.getBalance() >= minBalance && account.getBalance() <= maxBalance) {
                filteredAccounts.add(account);
            }
        }
        return filteredAccounts;
    }
}