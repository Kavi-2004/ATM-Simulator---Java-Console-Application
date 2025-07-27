import java.util.Scanner;
import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Console console = System.console();
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Welcome to the ATM Simulator ***");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your account number: ");
        String accNum = scanner.nextLine();

        // Set REAL PIN
        String realPin;
        if (console != null) {
            char[] pin = console.readPassword("Set Your PIN: ");
            realPin = new String(pin);
        } else {
            System.out.print("Set Your PIN (not hidden as console is unavailable): ");
            realPin = scanner.nextLine();
        }

        // Set FAKE PIN
        String fakePin;
        while (true) {
            if (console != null) {
                char[] pinChars = console.readPassword("Set your FAKE PIN (for emergency situations): ");
                fakePin = new String(pinChars);
            } else {
                System.out.print("Set your FAKE PIN: ");
                fakePin = scanner.nextLine();
            }

            if (fakePin.equals(realPin)) {
                System.out.println("Fake PIN cannot be the same as the real PIN. Please enter a different fake PIN.");
            } else {
                break;
            }
        }

        // Initial Balance
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume leftover newline

        System.out.println();

        // Create both accounts with the same balance
        Account fakeAccount = new Account(name, accNum, balance, fakePin);
        Account realAccount = new Account(name, accNum, balance, realPin);

        // Launch ATM
        ATM atm = new ATM(realAccount, fakeAccount, scanner);
        atm.showMenu();
    }
}
