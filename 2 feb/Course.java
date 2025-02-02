import java.util.*;

class Course {
    String cN;
    int dur;
    double f;

    static String iN = "ABC Institute";

    Course(String cN, int dur, double f) {
        this.cN = cN;
        this.dur = dur;
        this.f = f;
    }

    void dC() {
        System.out.println(cN + ": " + dur + " months, Fee: " + f + ", Institute: " + iN);
    }

    static void uIN(String newIN) {
        iN = newIN;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String n = sc.nextLine();
        int d = sc.nextInt();
        double fee = sc.nextDouble();
        Course c1 = new Course(n, d, fee);

        sc.nextLine();
        String ni = sc.nextLine();
        Course.uIN(ni);

        c1.dC();
    }
}
