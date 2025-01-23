import java.util.Scanner;
public class SumOfNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int number;

        System.out.println("Enter numbers (enter 0 to stop):");

        do {
            number = sc.nextInt();
            total += number;
        } while (number != 0);

        System.out.println("Sum of entered numbers: " + total);

        sc.close();
    }
}