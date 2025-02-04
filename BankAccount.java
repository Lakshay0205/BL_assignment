public class BankAccount {
    private static String bankName = "ICICI Bank";
    private static int totalAccounts = 0;

    private final String accountNumber;
    private String accountHolder;
    private double balance;

    // constructor using this to resolve ambiguity
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    public String getAccountNumber() {
        return accountNumber;
    }// getter for accountNumber

    public String getAccountHolder() {
        return accountHolder;
    }// getter for accountHolder

    public double getBalance() {
        return balance;
    }// getter for balance

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }// setter for accountHolder

    public void deposit(double amount) {
        balance += amount;
    }// method to deposit money

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }// method to withdraw money

    public static String getBankName() {
        return bankName;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
    public void displayAccountDetails() {
        if( this instanceof BankAccount){
            System.out.println("Bank Name: " + getBankName());
            System.out.println("Account Holder: " + getAccountHolder());
            System.out.println("Account Number: " + getAccountNumber());
            System.out.println("Balance: " + getBalance());
        }
    }// method to display account details

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Akash Pandey", "123456", 5000.50);
        BankAccount account2 = new BankAccount("Aditya Vardhan Singh", "789445", 10000.87);

        account1.displayAccountDetails();
        System.out.println("--------------------");
        account2.displayAccountDetails();

        System.out.println("--------------------");
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
        System.out.println("Bank Name: " + BankAccount.getBankName());

        account1.deposit(500);
        account1.displayAccountDetails();
        account1.withdraw(12000);
        account1.displayAccountDetails();
    }


}