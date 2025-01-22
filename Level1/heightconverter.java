import java.util.*;
public class heightconverter{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your height in centimeters");
        double height = sc.nextDouble();
        double feet = height / 30.48;
        double inches = (height % 30.48) / 2.54;
        System.out.println(height + " cm is equal to " + feet + " feet and " +
        inches + " inches");
        }
}