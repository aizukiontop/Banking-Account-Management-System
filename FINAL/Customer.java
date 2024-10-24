import java.util.Scanner;

public class Customer {
    private AccountManager manager;
    private Scanner scanner;

    public Customer(AccountManager manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = scanner;
    }

    public void handleCustomerOperations() {
        while (true) {
            System.out.println("===== Customer Operations =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Transfer Money");
            System.out.println("4. View Account Details");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int choice = getValidIntegerInput();

            switch (choice) {
                case 1:
                    performDeposit();
                    break;
                case 2:
                    performWithdrawal();
                    break;
                case 3:
                    performTransfer();
                    break;
                case 4:
                    viewAccountDetails();
                    break;
                case 5:
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewAccountDetails() {
        String accountNumber = getValidAccountNumber(); 
        BankAccount account = manager.getAccountDetails(accountNumber);
        if (account != null) {
            account.showAccountDetails(); 
        } else {
            System.out.println("Account not found."); 
        }
    }

    private void performDeposit() {
        String accountNumber = getValidAccountNumber(); 
        System.out.print("Enter Amount to Deposit: ");
        double amount = getValidDoubleInput("Please enter a valid amount.");
        manager.updateAccountBalance(accountNumber, amount);
        System.out.println("Amount deposited successfully.");
    }

    private void performWithdrawal() {
        String accountNumber = getValidAccountNumber(); 
        System.out.print("Enter Amount to Withdraw: ");
        double amount = getValidDoubleInput("Please enter a valid amount.");
        manager.updateAccountBalance(accountNumber, -amount);
        System.out.println("Amount withdrawn successfully.");
    }

    private void performTransfer() {
        String senderAccountNumber = getValidAccountNumber(); 
        String receiverAccountNumber = getValidAccountNumber(); 
        System.out.print("Enter Amount to Transfer: ");
        double amount = getValidDoubleInput("Please enter a valid amount.");
        manager.transferMoney(senderAccountNumber, receiverAccountNumber, amount);
        System.out.println("Transfer successful.");
    }

    private String getValidAccountNumber() {
        while (true) {
            System.out.print("Enter Account Number: ");
            String accountNumber = scanner.next();
            if (isValidAccountNumber(accountNumber)) {
                BankAccount account = manager.getAccountDetails(accountNumber);
                if (account != null) {
                    return accountNumber; 
                } else {
                    System.out.println("Account not found. Please enter a valid account number.");
                }
            } else {
                System.out.println("Invalid account number. Please enter a valid 9-character account number.");
            }
        }
    }

    private boolean isValidAccountNumber(String accountNumber) {
        return accountNumber.length() == 9; 
    }

    private int getValidIntegerInput() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }
    }

    private double getValidDoubleInput(String errorMessage) {
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println(errorMessage);
                scanner.next(); 
            }
        }
    }
}
