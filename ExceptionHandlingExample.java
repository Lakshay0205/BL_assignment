import java.util.*;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numerator = 0;
        int denominator = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter numerator: ");
                numerator = scanner.nextInt();
                System.out.print("Enter denominator: ");
                denominator = scanner.nextInt();
                validInput = true; // Input is valid if no exception occurs
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers only.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }


        try {
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } finally {
            scanner.close();
        }
    }
}