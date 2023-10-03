import java.util.*;

class BankAcct {
    private double balance;

    public BankAcct(double initialBal) {
        balance = initialBal;
    }

    public double getBal() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println();
            System.out.println("Deposit successful!");
            System.out.println();
            System.out.println("Your new balance: " + balance);
        } else {
            System.out.println("Deposited ammount is invalid");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println();
            System.out.println("Withdrawal successful!");
            System.out.println();
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Balance is insufficient!");
        }
    }
}

class ATM {
    private BankAcct bankAccount;
    private Scanner scanner;
    public ATM(BankAcct account) {
        bankAccount = account;
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        boolean continueRunning = true;
        do {
            System.out.println("\n-----------Welcome to OasisInfobyteBank---------");
            System.out.println();
            System.out.println("Press the button to continue : ");
            System.out.println();
            System.out.println("Press 1 ---> Check Balance");
            System.out.println("Press 2 ---> Deposit");
            System.out.println("Press 3 ---> Withdraw");
            System.out.println("Press 4 ---> Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Thank you for using this ATM!");
                    System.out.println("Hope you have a great day ahead!");
                    System.out.println();
                    continueRunning = false;
                    break;
                default:
                    System.out.println("Your choice is invalid. Please select a valid option between 1 to 4");
            }

            if (continueRunning) {
                System.out.println();
                System.out.print("Do you want to continue? (yes/no): ");
                String response = scanner.next();
                if (!response.equals("yes")) {
                    System.out.println("Thank you for using this ATM!");
                    System.out.println("Hope you have a great day ahead!");
                    continueRunning = false;
                }
            }
        } while (continueRunning);
    }

    private void checkBalance() {
        double balance = bankAccount.getBal();
        System.out.println();
        System.out.println("Your account balance is: " + balance);
        System.out.println();
    }

    private void deposit() {
        System.out.println();
        System.out.print("Amount to be deposited: ");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
    }

    private void withdraw() {
        System.out.println();
        System.out.print("Amount to be withrawed: ");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }
}

public class Autotellermachine{
    public static void main(String[] args) {
        BankAcct account = new BankAcct(0);
        ATM atm = new ATM(account);
        atm.run();
    }
}