import java.util.*;

class Product {
    String pN;
    double p;

    static int tP = 0;

    Product(String pN, double p) {
        this.pN = pN;
        this.p = p;
        tP++;
    }

    void dP() {
        System.out.println(pN + ": " + p);
    }

    static void dTP() {
        System.out.println("Total Products Created: " + tP);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String name = sc.nextLine();
        double price = sc.nextDouble();
        Product p1 = new Product(name, price);

        sc.nextLine(); 
        name = sc.nextLine();
        price = sc.nextDouble();
        Product p2 = new Product(name, price);

        p1.dP();
        p2.dP();

        Product.dTP();
    }
}
