import java.util.Scanner;

public class CollinearPoints {

    // Method to check if three points are collinear using the slope formula
    public static boolean checkCollinearityUsingSlope(double x1, double y1, double x2, double y2, double x3,
            double y3) {
        // Calculate the slope between points A(x1, y1) and B(x2, y2)
        double slopeAB = (y2 - y1) / (x2 - x1);

        // Calculate the slope between points B(x2, y2) and C(x3, y3)
        double slopeBC = (y3 - y2) / (x3 - x2);

        // Calculate the slope between points A(x1, y1) and C(x3, y3)
        double slopeAC = (y3 - y1) / (x3 - x1);

        // If all slopes are equal, then the points are collinear
        return (slopeAB == slopeBC && slopeBC == slopeAC);
    }

    // Method to check if three points are collinear using the area of the triangle
    // formula
    public static boolean checkCollinearityUsingArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Calculate the area of the triangle formed by points A, B, and C
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));

        // If the area is 0, the points are collinear
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the three points (x1, y1), (x2, y2), (x3, y3)
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();
        System.out.print("Enter x3: ");
        double x3 = scanner.nextDouble();
        System.out.print("Enter y3: ");
        double y3 = scanner.nextDouble();

        // Check for collinearity using slope method
        boolean isCollinearUsingSlope = checkCollinearityUsingSlope(x1, y1, x2, y2, x3, y3);

        // Check for collinearity using area method
        boolean isCollinearUsingArea = checkCollinearityUsingArea(x1, y1, x2, y2, x3, y3);

        // Display the results
        if (isCollinearUsingSlope && isCollinearUsingArea) {
            System.out.println("The points are collinear.");
        } else {
            System.out.println("The points are not collinear.");
        }
    }
}
