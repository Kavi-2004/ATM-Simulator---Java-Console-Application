import java.util.Scanner;
import java.io.Console;

public class ATM {
    private Account realAccount;
    private Account fakeAccount;
    private Scanner scanner;

    public ATM(Account real, Account fake, Scanner scanner) {
        this.realAccount = real;
        this.fakeAccount = fake;
        this.scanner = scanner;
    }

    // Prompt user for PIN before sensitive operations
    private Account authenticateUser() {
        Console con = System.console();
        String enteredPin;

        if (con != null) {
            char[] pin = con.readPassword("Enter your PIN: ");
            enteredPin = new String(pin);
        } else {
            System.out.print("Enter your PIN: ");
            enteredPin = scanner.nextLine();
        }

        if (enteredPin.equals(realAccount.getPin())) {
            return realAccount;
        } else if (enteredPin.equals(fakeAccount.getPin())) {
            return fakeAccount;
        } else {
            System.out.println("Incorrect PIN. Transaction Aborted.");
            return null;
        }
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transaction History");
            System.out.println("5. Mini Statement");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input. Try again.");
                scanner.nextLine(); // Flush invalid input
                continue;
            }

            switch (choice) {
                case 1 -> {
                    Account acc = authenticateUser();
                    if (acc != null) {
                        if (acc == fakeAccount) {
                            System.out.println("Balance: Rs. 10.00");
                        } else {
                            System.out.println("Balance: Rs. " + acc.getBalance());
                        }
                    }
                }

                case 2 -> {
                    Account acc = authenticateUser();
                    if (acc != null) {
                        if (acc == fakeAccount) {
                            System.out.println("Transaction failed. Please try again later.");
                        } else {
                            System.out.print("Enter deposit amount: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            acc.deposit(amount);
                        }
                    }
                }

                case 3 -> {
                    Account acc = authenticateUser();
                    if (acc != null) {
                        if (acc == fakeAccount) {
                            System.out.println("Transaction failed. Please try again later.");
                        } else {
                            System.out.print("Enter withdrawal amount: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            acc.withdraw(amount);
                        }
                    }
                }

                case 4 -> {
                    Account acc = authenticateUser();
                    if (acc != null) {
                        if (acc == fakeAccount) {
                            System.out.println("No transactions found.");
                        } else {
                            acc.printTransactionHistory();
                        }
                    }
                }

                case 5 -> {
                    Account acc = authenticateUser();
                    if (acc != null) {
                        if (acc == fakeAccount) {
                            System.out.println("No transactions found.");
                        } else {
                            acc.showMiniStatement();
                        }
                    }
                }

                case 6 -> {
                    System.out.println("Thank You for using the ATM. Goodbye!");
                    return;
                }

                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

