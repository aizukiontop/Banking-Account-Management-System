import java.util.ArrayList;
import java.util.List;

class Admin {
    private String adminID;
    private List<BankAccount> accounts;

    public Admin(String adminID) {
        this.adminID = adminID;
        this.accounts = new ArrayList<>();
    }

    public void createAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account created: " + account.accountNumber);
    }

    public void deleteAccount(String accountNumber) {
        accounts.removeIf(account -> account.accountNumber.equals(accountNumber));
        System.out.println("Account deleted: " + accountNumber);
    }

    public void listAccounts() {
        for (BankAccount account : accounts) {
            System.out.println("Account Number: " + account.accountNumber + ", Balance: " + account.getBalance());
        }
    }
}
