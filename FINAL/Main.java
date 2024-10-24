import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountManager manager = new AccountManager();

        while (true) {
            System.out.println("===== Banking Management System =====");
            System.out.println("1. Customer Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int userTypeChoice = getValidIntegerInput(scanner);

            switch (userTypeChoice) {
                case 1:
                    Customer customer = new Customer(manager, scanner);
                    customer.handleCustomerOperations();
                    break;

                case 2:
                    Admin admin = new Admin(manager, scanner);
                    admin.handleAdminOperations();
                    break;

                case 3:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); 
        }
    }

    public static String generateUniqueAccountNumber() {
        StringBuilder accountNumber = new StringBuilder();
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        for (int i = 0; i < 9; i++) {
            int index = random.nextInt(characters.length());
            accountNumber.append(characters.charAt(index));
        }
        return accountNumber.toString();
    }

    private static int getValidIntegerInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }
}
