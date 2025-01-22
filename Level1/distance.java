import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the distance in feets");
        int feets = sc.nextInt();
        int yards = feets / 3;
        int miles = yards / 1760;
        System.out.println("Distance in yards is "+yards);
        System.out.println("Distance in miles is "+miles);
        }
}