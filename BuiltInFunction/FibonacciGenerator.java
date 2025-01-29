import java.util.Scanner;

public class FibonacciGenerator {
    public static void generateFibonacci(int terms) {
        int a = 0, b = 1, next;
        System.out.print("Fibonacci Sequence: " + a + " " + b);
        for (int i = 2; i < terms; i++) {
            next = a + b;
            System.out.print(" " + next);
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int terms = scanner.nextInt();
        generateFibonacci(terms);
        scanner.close();
    }
}
