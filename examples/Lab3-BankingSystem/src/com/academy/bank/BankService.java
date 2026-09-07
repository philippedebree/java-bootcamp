package com.academy.bank;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BankService {

    private static final int MAX_CUSTOMERS = 50;
    private static final int MAX_ACCOUNTS = 100;
    private static final int MAX_TRANSACTIONS = 500;

    private final Customer[] customers = new Customer[MAX_CUSTOMERS];
    private final Account[] accounts = new Account[MAX_ACCOUNTS];
    private final Transaction[] transactions = new Transaction[MAX_TRANSACTIONS];

    private int customerCount = 0;
    private int accountCount = 0;
    private int transactionCount = 0;
    private int nextAccountNumber = 10001;
    private int nextTransactionNumber = 1;

    private final Scanner scanner;

    public BankService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void createCustomer() {
        if (customerCount >= MAX_CUSTOMERS){
            System.out.println("Customer limit reached.");
        }

        System.out.println("Customer ID: ");
        String newCustomerID = scanner.nextLine();

        if (findCustomer(newCustomerID) != null){
            System.out.println("Customer ID already exists");
            return;
        }

        System.out.println("Customer Name: ");
        String newCustomerName = scanner.nextLine().trim();

        System.out.println("Customer Email:");
        String newCustomerEmail = scanner.nextLine().trim();

        System.out.println("Customer Phone");
        String newCustomerPhone = scanner.nextLine().trim();

        customers[customerCount] = new Customer(newCustomerID, newCustomerName, newCustomerEmail, newCustomerPhone);
        customerCount++;

        System.out.println("Customer Created Successfully");
        // DONE: read customerId / name / email / phone; reject duplicate IDs
        // DONE: store new Customer; print "Customer Created Successfully."
    }

    public void createSavingsAccount() {
        if (accountCount >= MAX_ACCOUNTS){
            System.out.println("Account limi reached");
            return;
        }

        Customer customer = readExistingCustomer();

        if (customer == null){
            return;
        }

        double initialBalance = readPositiveAmount("Intial Balance : ");
        double interestRate = readPositiveAmount("Interest Rate : ");

        String accountNumber = String.valueOf(nextAccountNumber++);

        accounts[accountCount] = new SavingsAccount(
                accountNumber,
                initialBalance,
                customer,
                interestRate
        );

        accountCount++;

        System.out.println("Savings Account created successfully");

        // DONE: read existing customer, initial balance, interest rate
        // DONE: create SavingsAccount with nextAccountNumber++; store in accounts[]
    }

    public void createCurrentAccount() {
        if (accountCount >= MAX_ACCOUNTS){
            System.out.println("Account limit reached");
            return;
        }

        Customer customer = readExistingCustomer();

        if (customer == null){
            return;
        }

        double initialBalance = readPositiveAmount("Intial Balance : ");
        double transactionFee = readPositiveAmount("Transcation Fee : ");

        String accountNumber = String.valueOf(nextAccountNumber++);

        accounts[accountCount] = new CurrentAccount(
                accountNumber,
                initialBalance,
                customer,
                transactionFee
        );

        accountCount++;

        System.out.println("Savings Account created successfully");

        // DONE: read existing customer, initial balance, transaction fee
        // DONE: create CurrentAccount with nextAccountNumber++; store in accounts[]
    }

    public void deposit() {
        Account account = readExistingAccount();

        if (account == null){
            return;
        }

        double amount = readPositiveAmount("Deposit Amount : ");

        account.deposit(amount);

        recordTransaction(account.getAccountNumber(), amount, "DEPOSIT");

        System.out.println("Deposit Successful");
        System.out.println("Updated Balance : " + account.getBalance());


        // DONE: read existing account + amount; account.deposit; recordTransaction DEPOSIT
        // DONE: print updated balance
    }

    public void withdraw() {
        Account account = readExistingAccount();

        if (account == null){
            return;
        }

        double amount = readPositiveAmount("Withdraw Amount: ");

        if (account.withdraw(amount) == false){
            System.out.println("Insufficent Funds to Withdraw");
            return;
        }

        recordTransaction(account.getAccountNumber(), amount, "WITHDRAWAL");

        if (account instanceof CurrentAccount){
            System.out.println("Is a CurrentAccount");
            CurrentAccount currentAccount = (CurrentAccount) account;
            double fee = currentAccount.getTransactionFee();
            double totalDeducted = amount + fee;

            System.out.println("Withdraw: " + totalDeducted);
            System.out.println("Updated Balance : " + account.getBalance());
        } else {
            System.out.println("Withdraw: " + amount);
        }

        System.out.println("Updated Balance : " + account.getBalance());

        // DONE: read existing account + amount; account.withdraw; record on success
        // DONE: for CurrentAccount, print fee + total deducted; print updated balance
    }

    public void displayAccounts() {
        if (accountCount == 0 ){
            System.out.println("There are no accounts.");
            return;
        }

        for (int i = 0; i < accountCount; i++){
            accounts[i].displayAccount();
            System.out.println("----------------------------------");
        }
        // DONE: if empty print message; else loop displayAccount() for each
    }

    public void displayCustomers() {
        if (customerCount == 0) {
            System.out.println("No customers available.");
            return;
        }

        System.out.println("----------------------------------");
        for (int i = 0; i < customerCount; i++) {
            customers[i].display();
            System.out.println("----------------------------------");
        }
    }

    public void transferMoney() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void displayTransactionHistory() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void displayAccountsSortedByBalance() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void displayHighestBalanceCustomer() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void generateAccountSummaryReport() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    private Customer readExistingCustomer() {
        if (customerCount == 0) {
            System.out.println("Create a customer first.");
            return null;
        }

        System.out.print("Customer ID : ");
        String customerId = scanner.nextLine().trim();
        Customer customer = findCustomer(customerId);

        if (customer == null) {
            System.out.println("Customer not found.");
        }

        return customer;
    }

    private Account readExistingAccount() {
        if (accountCount == 0) {
            System.out.println("No accounts available.");
            return null;
        }

        System.out.print("Account Number : ");
        String accountNumber = scanner.nextLine().trim();
        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
        }

        return account;
    }

    private Customer findCustomer(String customerId) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId().equalsIgnoreCase(customerId)) {
                return customers[i];
            }
        }
        return null;
    }

    private Account findAccount(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    private void recordTransaction(String accountNumber, double amount, String type) {
        if (transactionCount >= MAX_TRANSACTIONS) {
            return;
        }

        String transactionId = "T" + nextTransactionNumber++;
        String date = LocalDate.now().toString();
        transactions[transactionCount++] = new Transaction(transactionId, amount, type, date, accountNumber);
    }

    private double readPositiveAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value < 0) {
                    System.out.println("Amount must not be negative.");
                    continue;
                }
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid amount. Please try again.");
            }
        }
    }
}
