import java.util.*;
public class discount{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fee = sc.nextInt();
        int discountPercent = sc.nextInt();
        int discount = (fee * discountPercent) / 100;
        int discountedFee = fee - discount;
        System.out.println("Discounted Fee: " + discountedFee);
        }
}