import java.util.*;

class Employee {
    public String empID;
    protected String dept;
    private double sal;

    public void mSal(double sal) {
        this.sal = sal;
    }

    public double gSal() {
        return sal;
    }
}

class Manager extends Employee {
    void dD() {
        System.out.println("Employee ID: " + empID);
        System.out.println("Department: " + dept);
    }
}

public class Company {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Manager m = new Manager();
        
        m.empID = sc.nextLine();
        m.dept = sc.nextLine();
        m.mSal(sc.nextDouble());

        m.dD();
        System.out.println(m.gSal());
    }
}
