class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankAccountSystem {

    private double balance;

    public BankAccountSystem(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
    }

    public static void main(String[] args) {
        BankAccountSystem account = new BankAccountSystem(1000);

        try {
            account.withdraw(500);
            System.out.println("Withdrawal successful, new balance: " + account.balance);

            account.withdraw(700); // This will throw InsufficientBalanceException
            System.out.println("Withdrawal successful, new balance: " + account.balance);

            account.withdraw(-100); // This will throw IllegalArgumentException

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}