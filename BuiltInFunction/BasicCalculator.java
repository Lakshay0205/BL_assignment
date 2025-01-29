import java.util.Scanner;

public class BasicCalculator {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return b != 0 ? a / b : Double.NaN;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        double a = scanner.nextDouble(), b = scanner.nextDouble();
        System.out.print("Choose operation (+, -, *, /): ");
        char op = scanner.next().charAt(0);

        double result = switch (op) {
            case '+' -> add(a, b);
            case '-' -> subtract(a, b);
            case '*' -> multiply(a, b);
            case '/' -> divide(a, b);
            default -> Double.NaN;
        };

        System.out.println("Result: " + result);
        scanner.close();
    }
}
