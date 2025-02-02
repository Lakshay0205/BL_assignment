import java.util.*;

class Book {
    public String ISBN;
    protected String t;
    private String a;

    public String gA() {
        return a;
    }

    public void sA(String a) {
        this.a = a;
    }
}

class EBook extends Book {
    void dD() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + t);
    }
}

public class Library2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        EBook eB = new EBook();
        
        eB.ISBN = sc.nextLine();
        eB.t = sc.nextLine();
        eB.sA(sc.nextLine());

        eB.dD();
        System.out.println(eB.gA());
    }
}
