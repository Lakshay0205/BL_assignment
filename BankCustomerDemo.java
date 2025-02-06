import java.util.ArrayList;

class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void openAccount(Customer customer, int accountNumber, double initialDeposit) {
        customer.openAccount(this, accountNumber, initialDeposit); // Delegate to Customer
        this.customers.add(customer); // Add customer to bank's list
    }

    public void closeAccount(Customer customer, int accountNumber) {
        customer.closeAccount(accountNumber);
        this.customers.remove(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }


    @Override
    public String toString() {
        return "Bank: " + name;
    }
}

class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void openAccount(Bank bank, int accountNumber, double initialDeposit) {
        Account newAccount = new Account(bank, accountNumber, initialDeposit);
        this.accounts.add(newAccount);
        System.out.println(name + " opened account " + accountNumber + " at " + bank.getName() + " with initial deposit " + initialDeposit);
    }

    public void closeAccount(int accountNumber) {
        accounts.removeIf(account -> account.getAccountNumber() == accountNumber);
        System.out.println(name + " closed account " + accountNumber);
    }

    public double viewBalance(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account.getBalance();
            }
        }
        System.out.println("Account " + accountNumber + " not found for " + name);
        return -1; // Or throw an exception
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "Customer: " + name;
    }
}

class Account {
    private Bank bank;
    private int accountNumber;
    private double balance;

    public Account(Bank bank, int accountNumber, double initialDeposit) {
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
    }

    public Bank getBank() {
        return bank;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}



public class BankCustomerDemo {
    public static void main(String[] args) {
        Bank myBank = new Bank("My Bank");

        Customer john = new Customer("John Doe");
        Customer jane = new Customer("Jane Smith");

        myBank.openAccount(john, 12345, 1000);
        myBank.openAccount(john, 67890, 500); // John has two accounts
        myBank.openAccount(jane, 11223, 2000);

        System.out.println("John's balance in account 12345: " + john.viewBalance(12345));
        System.out.println("John's balance in account 67890: " + john.viewBalance(67890));

        john.getAccounts().get(0).deposit(500);
        System.out.println("John's balance in account 12345 after deposit: " + john.viewBalance(12345));

        john.getAccounts().get(1).withdraw(200);
        System.out.println("John's balance in account 67890 after withdrawal: " + john.viewBalance(67890));


        myBank.closeAccount(john, 12345);
        System.out.println("John's balance in account 12345 after closing: " + john.viewBalance(12345)); // Account should be gone

        System.out.println(myBank.getCustomers());

    }
}