import java.util.Scanner;

public class DigitFrequency {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Calculate the number of digits
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

        // Create an array to store the frequency of each digit
        int[] frequency = new int[10]; // Array size 10 for digits 0-9

        // Calculate the frequency of each digit
        for (int i = 0; i < count; i++) {
            frequency[digits[i]]++; 
        }

        // Display the frequency of each digit
        System.out.println("Digit\tFrequency");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + "\t" + frequency[i]);
            }
        }
    }
}