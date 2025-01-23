import java.util.*;
public class leapyear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year = sc.nextInt();
        sc.close();
        if (year < 1582) {
            System.out.println("The year is not in the Gregorian calendar");
            } else if (year % 4 == 0 && year % 100 != 0 ) {
                System.out.println("The year is a Leap Year");
                } else if (year % 400 == 0) {
                    System.out.println("The year is a Leap Year");
                    } else {
                        System.out.println("The year is not a Leap Year");
                        }
                        }
}
