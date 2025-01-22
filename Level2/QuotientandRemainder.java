package Level2;
import java.util.*;
public class QuotientandRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dividend = sc.nextInt();
        int divisor = sc.nextInt();

        // calculate quotient and remainder
        int quotient = dividend / divisor;
        int remainder = dividend % divisor;
        System.out.println("Quotient: " + quotient + "Remainder: "+remainder);

    }
}
