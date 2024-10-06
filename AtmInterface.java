package OasisInfobyte;

import java.util.ArrayList;
import java.util.List ;
import java.util.Scanner;

public class AtmInterface {
    private double balance;
    private List<String> miniStatement;
    private String atmNumber;
    private String atmPin;

    public AtmInterface() {
        this.balance = 0.0;
        this.miniStatement = new ArrayList<>();
        this.atmNumber = "60441011";
        this.atmPin = "257623";
    }

    public static void main(String[] args) {
        AtmInterface atm = new AtmInterface();
        Scanner scanner = new Scanner(System.in);
        if (atm.login(scanner)) {
            while (true) {
                System.out.println("\nATM Interface");
                System.out.println("1. View Balance");
                System.out.println("2. Deposit Balance");
                System.out.println("3. Withdraw Balance");
                System.out.println("4. View Mini Statement");
                System.out.println("5. Exit");
                System.out.print("Please select an option: ");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        atm.viewBalance();
                        break;
                    case 2:
                        atm.depositBalance(scanner);
                        break;
                    case 3:
                        atm.withdrawBalance(scanner);
                        break;
                    case 4:
                        atm.viewMiniStatement();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid ATM number or PIN. Exiting...");
        }
    }

    public boolean login(Scanner scanner) {
        System.out.print("Enter ATM number: ");
        String enteredAtmNumber = scanner.next();
        System.out.print("Enter ATM PIN: ");
        String enteredAtmPin = scanner.next();
        return enteredAtmNumber.equals(atmNumber) && enteredAtmPin.equals(atmPin);
    }

    public void viewBalance() {
        System.out.println("Available Balance: " + balance);
    }

    public void depositBalance(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        balance += amount;
        miniStatement.add("Deposit: " + amount);
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void withdrawBalance(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (balance >= amount) {
            balance -= amount;
            miniStatement.add("Withdrawal: " + amount);
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void viewMiniStatement() {
        System.out.println("Mini Statement:");
        for (String transaction : miniStatement) {
            System.out.println(transaction);
        }
    }
}