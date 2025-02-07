class BankAccount {
    String accountNumber;
    double balance;

    void displayAccountType() {
        System.out.println("Bank Account");
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    void displayAccountType() {
        System.out.println("Savings Account");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    void displayAccountType() {
        System.out.println("Checking Account");
    }
}

class FixedDepositAccount extends BankAccount {
    int tenure;

    void displayAccountType() {
        System.out.println("Fixed Deposit Account");
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount();
        savings.accountNumber = "SA12345";
        savings.balance = 5000;
        savings.interestRate = 3.5;

        CheckingAccount checking = new CheckingAccount();
        checking.accountNumber = "CA12345";
        checking.balance = 2000;
        checking.withdrawalLimit = 1500;

        FixedDepositAccount fd = new FixedDepositAccount();
        fd.accountNumber = "FD12345";
        fd.balance = 10000;
        fd.tenure = 5;

        savings.displayAccountType();
        checking.displayAccountType();
        fd.displayAccountType();
    }
}

