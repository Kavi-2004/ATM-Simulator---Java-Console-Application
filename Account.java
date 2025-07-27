import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    private String pin;
    private List<Transaction> transactionHistory = new ArrayList<>();  // ✅ Now stores Transaction objects

     // New fields for spending limit tracking
    private final double DAILY_LIMIT = 5000.0;
    private double withdrawnToday = 0.0;
    private LocalDate lastWithdrawalDate = LocalDate.now();

    public Account(String accountHolder, String accountNumber, double initialBalance, String pin) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.pin = pin;
        addTransaction("Account created with initial balance: Rs. " + initialBalance);
    }

    public boolean verifyPin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited Rs. " + amount);
            addTransaction("Deposited: Rs. " + amount + " | Balance: Rs. " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
            addTransaction("Failed deposit attempt: Invalid amount");
        }
    }

    public void withdraw(double amount) {
        LocalDate today = LocalDate.now();

        // Reset daily counter if new day
        if (!today.equals(lastWithdrawalDate)) {
            withdrawnToday = 0.0;
            lastWithdrawalDate = today;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        if ((withdrawnToday + amount) > DAILY_LIMIT) {
            System.out.println("Withdrawal exceeds daily limit of Rs. " + DAILY_LIMIT + ". Transaction denied.");
            return;
        }

        // Proceed with withdrawal
        balance -= amount;
        withdrawnToday += amount;
        transactionHistory.add(new Transaction("Withdrawal: " +amount));
        System.out.println("Rs. " + amount + " withdrawn successfully.");
    }


    // ✅ Logs a transaction with timestamp
    public void addTransaction(String description) {
        transactionHistory.add(new Transaction(description));
    }

    // ✅ Shows all transaction records
    public void printTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            System.out.println("\n--- Transaction History ---");
            for (Transaction t : transactionHistory) {
                System.out.println("- " + t);
            }
            System.out.println("----------------------------\n");
        }
    }

    // ✅ Inner class to represent a transaction
    private class Transaction {
        private String description;
        private LocalDateTime timestamp;

        public Transaction(String description) {
            this.description = description;
            this.timestamp = LocalDateTime.now();
        }

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            return "[" + timestamp.format(formatter) + "] " + description;
        }
    }

    //Mini statement
    public void showMiniStatement() {
        int size = transactionHistory.size();
        if (size == 0) {
            System.out.println("No transactions to show.");
        } else {
            System.out.println("\n--- Mini Statement (Last 3 Transactions) ---");
            int start = Math.max(0, size - 3);
            for (int i = start; i < size; i++) {
                System.out.println(transactionHistory.get(i));
            }
            System.out.println("--------------------------------------------\n");
        }
    }

}

