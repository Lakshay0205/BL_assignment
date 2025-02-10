import java.util.ArrayList;
import java.util.List;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    public void applyForLoan(double amount) {
        System.out.println("Loan of " + amount + " applied for Savings Account " + getAccountNumber());
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 1000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double calculateInterest() {
        return 0;
    }

    public void applyForLoan(double amount) {
        System.out.println("Loan of " + amount + " applied for Current Account " + getAccountNumber());
    }

    public boolean calculateLoanEligibility() {
        return getBalance() + overdraftLimit >= 5000;
    }
}

class BankingSystem {
    public static void processAccounts(List<BankAccount> accounts) {
        for (BankAccount account : accounts) {
            double interest = account.calculateInterest();
            System.out.println("Interest for account " + account.getAccountNumber() + ": " + interest);
            if (account instanceof Loanable) {
                ((Loanable) account).applyForLoan(2000);
                System.out.println("Loan eligibility for account " + account.getAccountNumber() + ": " + ((Loanable) account).calculateLoanEligibility());
            }
        }
    }

    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SA001", "Alice", 1500, 0.04));
        accounts.add(new CurrentAccount("CA001", "Bob", 3000, 2000));

        processAccounts(accounts);
    }
}