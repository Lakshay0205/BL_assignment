
import java.util.*;

class BankAccount {
    public String accNo;
    protected String accHolder;
    private double bal;

    public double gBal() {
        return bal;
    }

    public void sBal(double bal) {
        this.bal = bal;
    }
}

class SavingsAccount extends BankAccount {
    void dD() {
        System.out.println("Account Number: " + accNo);
        System.out.println("Account Holder: " + accHolder);
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        SavingsAccount sA = new SavingsAccount();
        
        sA.accNo = sc.nextLine();
        sA.accHolder = sc.nextLine();
        sA.sBal(sc.nextDouble());

        sA.dD();
        System.out.println(sA.gBal());
    }
}
