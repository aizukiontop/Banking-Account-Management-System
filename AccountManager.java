import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AccountManager {
    private Map<String, BankAccount> accountMap;

    public AccountManager() {
        this.accountMap = new HashMap<>();
    }

    public void addAccount(BankAccount account) {
        if (validateAccountNumber(account.accountNumber) && account.balance >= 0) {
            accountMap.put(account.accountNumber, account);
            System.out.println("Account created: " + account.accountNumber);
        } else {
            System.out.println("Invalid account details.");
        }
    }

    public void getAccountDetails(String accountNumber) {
        if (validateAccountNumber(accountNumber)) {
            BankAccount account = accountMap.get(accountNumber);
            if (account != null) {
                System.out.println("Account Number: " + account.accountNumber);
                System.out.println("Account Balance: " + account.getBalance());
            } else {
                System.out.println("Account not found: " + accountNumber);
            }
        } else {
            System.out.println("Invalid account number.");
        }
    }

    public void updateAccountBalance(String accountNumber, double amount) {
        if (validateAccountNumber(accountNumber) && amount >= 0) {
            BankAccount account = accountMap.get(accountNumber);
            if (account != null) {
                account.updateBalance(amount);
            } else {
                System.out.println("Account not found: " + accountNumber);
            }
        } else {
            System.out.println("Invalid amount or account number.");
        }
    }

    public void deleteAccount(String accountNumber) {
        if (validateAccountNumber(accountNumber)) {
            if (accountMap.remove(accountNumber) != null) {
                System.out.println("Account deleted: " + accountNumber);
            } else {
                System.out.println("Account not found: " + accountNumber);
            }
        } else {
            System.out.println("Invalid account number.");
        }
    }

    public BankAccount searchByAccountNumber(String accountNumber) {
        if (validateAccountNumber(accountNumber)) {
            return accountMap.get(accountNumber);
        } else {
            System.out.println("Invalid account number.");
            return null;
        }
    }

    public List<BankAccount> filterByBalance(double minBalance) {
        List<BankAccount> filteredAccounts = new ArrayList<>();
        if (minBalance >= 0) {
            for (BankAccount account : accountMap.values()) {
                if (account.getBalance() >= minBalance) {
                    filteredAccounts.add(account);
                }
            }
        } else {
            System.out.println("Invalid minimum balance.");
        }
        return filteredAccounts;
    }

    private boolean validateAccountNumber(String accountNumber) {
        return accountNumber != null && !accountNumber.trim().isEmpty();
    }
}