package JUnit.AdvancedProblems;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds or invalid amount");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountTest {
    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance(), 0.001);
    }

    @Test
    public void testInsufficientFunds() {
        BankAccount account = new BankAccount(50.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100.0));
    }

    @Test
    public void testInitialBalance() {
        BankAccount account = new BankAccount(200.0);
        assertEquals(200.0, account.getBalance(), 0.001);
    }

    @Test
    public void testZeroDeposit() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(0);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void testNegativeDeposit() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(-10);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void testZeroWithdraw() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
    }

    @Test
    public void testNegativeWithdraw() {
        BankAccount account = new BankAccount(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10));
    }
}