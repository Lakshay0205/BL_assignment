import java.util.Scanner;

public class EuclideanDistance {

    // Method to calculate Euclidean distance between two points (x1, y1) and (x2,
    // y2)
    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to calculate the equation of the line passing through two points (x1,
    // y1) and (x2, y2)
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double[] equation = new double[2]; // First element: slope, second element: y-intercept

        // Calculate the slope (m)
        double m = (y2 - y1) / (x2 - x1);

        // Calculate the y-intercept (b)
        double b = y1 - m * x1;

        // Store the slope and y-intercept in the array
        equation[0] = m;
        equation[1] = b;

        return equation;
    }

    // Method to display the equation of the line
    public static void displayLineEquation(double[] equation) {
        double m = equation[0];
        double b = equation[1];
        System.out.println("The equation of the line is: y = " + m + "x + " + b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input points (x1, y1) and (x2, y2)
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        // Calculate Euclidean distance
        double distance = calculateEuclideanDistance(x1, y1, x2, y2);
        System.out.println("Euclidean distance between the points: " + distance);

        // Calculate the equation of the line
        double[] equation = findLineEquation(x1, y1, x2, y2);

        // Display the equation of the line
        displayLineEquation(equation);
    }
}
