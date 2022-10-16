package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");

            System.out.print("Number: ");
            Integer accountNumber = sc.nextInt();

            sc.nextLine();

            System.out.print("Holder: ");
            String accountHolder = sc.nextLine();

            System.out.print("Initial balance: ");
            Double balance = sc.nextDouble();

            System.out.print("Withdraw limit: ");
            Double withdrawLimit = sc.nextDouble();

            Account account = new Account(accountNumber, accountHolder, balance, withdrawLimit);

            System.out.print("\nEnter amount for withdraw: ");
            Double amount = sc.nextDouble();

            account.withdraw(amount);

            System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
        }

        catch (RuntimeException exception) {
            System.out.println("Unexpected error");
        }

        catch (DomainException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
