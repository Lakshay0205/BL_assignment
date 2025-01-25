import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;
        int count = 0;
        while (temp > 0) {
            temp /= 10;
            count++;
        }

        // Create an array to store the digits
        int[] digits = new int[count];

        // Extract digits and store them in the array
        int index = 0;
        while (number > 0) {
            digits[index] = number % 10;
            number /= 10;
            index++;
        }

        // Display the digits in reverse order
        System.out.print("Reversed number: ");
        for (int i = count - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}