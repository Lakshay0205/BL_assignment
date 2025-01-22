import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base of the triangle in inches: ");
        double baseInch = sc.nextDouble();
        System.out.println("Enter the height of the triangle in inches: ");
        double heightInch = sc.nextDouble();
        double areaInch = 0.5 * baseInch * heightInch;
        System.out.println("The area of the triangle in square inches is: "+areaInch);
        System.out.println("Enter the base of the triangle in centimeters: ");
        double baseCm = sc.nextDouble();
        System.out.println("Enter the height of the triangle in centimeters: ");
        double heightCm = sc.nextDouble();
        double areaCm = 0.5 * baseCm * heightCm;
        System.out.println("The area of the triangle in square centimeters is: "+areaCm
        );
        }
}