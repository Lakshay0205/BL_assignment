package Level2;

import java.util.*;
public class TriangularPark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the lengths of the sides of the triangular park
        System.out.println("Enter the length of the first side of the park (in meters):");
        double side1 = scanner.nextDouble();

        System.out.println("Enter the length of the second side of the park (in meters):");
        double side2 = scanner.nextDouble();

        System.out.println("Enter the length of the third side of the park (in meters):");
        double side3 = scanner.nextDouble();

        // Calculate the perimeter of the triangular park
        double perimeter = side1 + side2 + side3;

        // Convert the target distance (5 km) to meters
        double targetDistance = 5000; // 5 km = 5000 meters

        // Calculate the number of rounds required
        int rounds = (int) Math.ceil(targetDistance / perimeter);

        // Output the result
        System.out.println("The athlete needs to complete " + rounds + " rounds to cover 5 km.");

        scanner.close();
    }
}
