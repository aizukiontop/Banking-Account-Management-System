import java.util.List;
import java.util.Scanner;

public class Admin {
    private AccountManager manager;
    private Scanner scanner;

    public Admin(AccountManager manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = scanner;
    }

    public void handleAdminOperations() {
        while (true) {
            System.out.println("===== Admin Operations =====");
            System.out.println("1. Create Checking Account");
            System.out.println("2. Create Savings Account");
            System.out.println("3. Search Account by Account Number");
            System.out.println("4. Filter Accounts by Minimum Balance");
            System.out.println("5. Filter Accounts by Account Type");
            System.out.println("6. Filter Accounts by Balance Range");
            System.out.println("7. Update Account Balance");
            System.out.println("8. Delete Account");
            System.out.println("9. Logout");
            System.out.print("Choose an option: ");

            int choice = getValidIntegerInput();

            switch (choice) {
                case 1:
                    createCheckingAccount();
                    break;
                case 2:
                    createSavingsAccount();
                    break;
                case 3:
                    searchAccount();
                    break;
                case 4:
                    filterAccountsByMinBalance();
                    break;
                case 5:
                    filterAccountsByType();
                    break;
                case 6:
                    filterAccountsByBalanceRange();
                    break;
                case 7:
                    updateAccountBalance();
                    break;
                case 8:
                    deleteAccount();
                    break;
                case 9:
                    return; // Logout
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createCheckingAccount() {
        String accountNumber = Main.generateUniqueAccountNumber();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = getValidDoubleInput("Please enter a valid balance.");
        System.out.print("Enter Overdraft Fee: ");
        double overdraftFee = getValidDoubleInput("Please enter a valid overdraft fee.");
        CheckingAccount account = new CheckingAccount(accountNumber, initialBalance, overdraftFee);
        manager.addAccount(account);
        System.out.println("Checking account created successfully with Account Number: " + accountNumber);
    }

    private void createSavingsAccount() {
        String accountNumber = Main.generateUniqueAccountNumber();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = getValidDoubleInput("Please enter a valid balance.");
        System.out.print("Enter Interest Rate: ");
        double interestRate = getValidDoubleInput("Please enter a valid interest rate.");
        SavingsAccount account = new SavingsAccount(accountNumber, initialBalance, interestRate);
        manager.addAccount(account);
        System.out.println("Savings account created successfully with Account Number: " + accountNumber);
    }

    private void searchAccount() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        BankAccount account = manager.getAccountDetails(accountNumber);
        if (account != null) {
            account.showAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    private void filterAccountsByMinBalance() {
        System.out.print("Enter Minimum Balance: ");
        double minBalance = getValidDoubleInput("Please enter a valid minimum balance.");
        List<BankAccount> filteredAccounts = manager.filterByBalance(minBalance);
        if (filteredAccounts.isEmpty()) {
            System.out.println("No accounts found with balance greater than or equal to " + minBalance);
        } else {
            System.out.println("Filtered Accounts:");
            for (BankAccount account : filteredAccounts) {
                account.showAccountDetails();
            }
        }
    }

    private void filterAccountsByType() {
        System.out.println("Select Account Type to Filter:");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");
        int typeChoice = getValidIntegerInput();

        Class<? extends BankAccount> type = (typeChoice == 1) ? CheckingAccount.class : SavingsAccount.class;
        List<BankAccount> filteredAccounts = manager.filterByAccountType(type);

        if (filteredAccounts.isEmpty()) {
            System.out.println("No accounts found of the selected type.");
        } else {
            System.out.println("Filtered Accounts:");
            for (BankAccount account : filteredAccounts) {
                account.showAccountDetails();
            }
        }
    }

    private void filterAccountsByBalanceRange() {
        System.out.print("Enter Minimum Balance: ");
        double minBalance = getValidDoubleInput("Please enter a valid minimum balance.");
        System.out.print("Enter Maximum Balance: ");
        double maxBalance = getValidDoubleInput("Please enter a valid maximum balance.");
        
        List<BankAccount> filteredAccounts = manager.filterByBalanceRange(minBalance, maxBalance);
        if (filteredAccounts.isEmpty()) {
            System.out.println("No accounts found in the specified balance range.");
        } else {
            System.out.println("Filtered Accounts:");
            for (BankAccount account : filteredAccounts) {
                account.showAccountDetails();
            }
        }
    }

    private void updateAccountBalance() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter Amount to Update: ");
        double amount = getValidDoubleInput("Please enter a valid amount.");
        manager.updateAccountBalance(accountNumber, amount);
    }

    private void deleteAccount() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        manager.deleteAccount(accountNumber);
    }

    private int getValidIntegerInput() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }
    }

    private double getValidDoubleInput(String errorMessage) {
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println(errorMessage);
                scanner.next(); // Consume the invalid input
            }
        }
    }
}