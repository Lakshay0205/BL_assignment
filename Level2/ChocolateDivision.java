package Level2;

import java.util.Scanner;

public class ChocolateDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of chocolates and children
        System.out.print("Enter the total number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();

        // Calculate chocolates per child and remaining chocolates
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;

        // Output the results
        System.out.println("The number of chocolates each child gets is " + chocolatesPerChild +
                " and the number of remaining chocolates are " + remainingChocolates);
    }
}
