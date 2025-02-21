import java.util.Scanner;

public class FinallyBlockExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        } finally {
            System.out.println("Operation completed.");
            scanner.close();
        }
    }
}