import java.util.Scanner;

public class NestedTryCatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter array size: ");
            int size = scanner.nextInt();
            int[] arr = new int[size];

            System.out.println("Enter array elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.print("Enter index: ");
            int index = scanner.nextInt();

            System.out.print("Enter divisor: ");
            int divisor = scanner.nextInt();

            try {
                int element = arr[index];
                int result = element / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        } finally {
            scanner.close();
        }
    }
}