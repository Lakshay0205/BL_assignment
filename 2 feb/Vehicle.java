import java.util.*;

class Vehicle {
    String oN;
    String vT;

    static double rF = 1000.0;

    Vehicle(String oN, String vT) {
        this.oN = oN;
        this.vT = vT;
    }

    void dV() {
        System.out.println("Owner: " + oN + ", Vehicle Type: " + vT + ", Registration Fee: " + rF);
    }

    static void uRF(double newRF) {
        rF = newRF;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String o = sc.nextLine();
        String v = sc.nextLine();
        Vehicle v1 = new Vehicle(o, v);

        double newFee = sc.nextDouble();
        Vehicle.uRF(newFee);

        v1.dV();
    }
}
