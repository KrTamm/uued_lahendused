package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Scanner;

public class Lesson4 {
    // Store account nr as a key and account balance as value
    // HashMap<String, Account> accountBalanceMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> accountBalanceMap = new HashMap<>();
        while (true) {
            System.out.println();
            System.out.println("Choose an option.");
            System.out.println("createAccount, getBalance, depositMoney, withdrawMoney, transfer, exit");
            String line = scanner.nextLine();
            int money = 0;
            int newBalance = 0;
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            // TODO 1
            // Add command: "createAccount ${accountNr}"
            // this has to store accountNr with 0 balance
            else if (line.equalsIgnoreCase("createAccount")) {
                System.out.println("What would be the account number?");
                line = scanner.nextLine();
                accountBalanceMap.put(line, 0);
                System.out.println("You have created an account named " + line + ".");
            }
            // TODO 2
            // Add command: "getBalance ${accountNr}"
            // this has to display account balance of specific account
            else if (line.equalsIgnoreCase("getBalance")) {
                System.out.println("What account number balance would you like to access?");
                line = scanner.nextLine();
                if (accountBalanceMap.containsKey(line)) {
                    System.out.println("Balance for this account is " + accountBalanceMap.get(line) + ".");
                } else {
                    System.out.println("No such account exists.");
                }
            }
            // TODO 3
            // Add command: "depositMoney ${accountNr} ${amount}
            // this has to add specified amount of money to account
            // You have to check that amount is positive number
            else if (line.equalsIgnoreCase("depositMoney")) {
                System.out.println("To what account would you like to make the deposit?");
                line = scanner.nextLine();
                if (accountBalanceMap.containsKey(line)) {
                    System.out.println("How much would you like to deposit?");
                    money = scanner.nextInt();
                    if (money > 0) {
                        newBalance = accountBalanceMap.get(line) + money;
                        accountBalanceMap.replace(line, newBalance);
                        System.out.println("You have added " + money + " to the account.");
                    }
                } else {
                    System.out.println("No such account exists.");
                }

            }
            // TODO 4
            // Add command: "withdrawMoney ${accountNr} ${amount}
            // This has to remove specified amount of money from account
            // You have to check that amount is positive number
            // You may not allow this transaction if account balance would become negative
            else if (line.equalsIgnoreCase("withdrawMoney")) {
                System.out.println("From what account would you like to withdraw from?");
                line = scanner.nextLine();
                if (accountBalanceMap.containsKey(line)) {
                    System.out.println("How much would you  like to withdraw?");
                    money = scanner.nextInt();
                    if (money > 0 && accountBalanceMap.get(line) > 0) {
                        newBalance = accountBalanceMap.get(line) - money;
                        accountBalanceMap.replace(line, newBalance);
                        System.out.println("You have removed " + money + "from account " + line + ".");
                    }
                } else {
                    System.out.println("No such account exists.");
                }
            }
            // TODO 5
            // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
            // This has to remove specified amount from fromAccount and add it to toAccount
            // Your application needs to check that toAccount is positive
            // And from account has enough money to do that transaction
            else if (line.equalsIgnoreCase("transfer")) {
                System.out.println("From what account would you like to transfer money?");
                line = scanner.nextLine();
                if (accountBalanceMap.containsKey(line)) {
                    System.out.println("How much would you like to transfer?");
                    money = scanner.nextInt();
                    if (money <= accountBalanceMap.get(line)){
                        newBalance = accountBalanceMap.get(line) - money;
                        accountBalanceMap.replace(line, newBalance);
                        System.out.println("To what account would you like to transfer");
                        line = scanner.nextLine();
                        line = scanner.nextLine();
                        if (accountBalanceMap.containsKey(line)) {
                            newBalance = accountBalanceMap.get(line) + money;
                            accountBalanceMap.replace(line, newBalance);
                            System.out.println("Transfer successful!");
                        } else if (accountBalanceMap.containsKey(line)){
                            System.out.println("Account " + line + " does not have enough funds.");
                        } else {
                            System.out.println("No such account exists.");
                        }
                    }
                } else {
                    System.out.println("No such account exists.");
                }
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
