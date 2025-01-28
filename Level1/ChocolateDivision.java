import java.util.Scanner;

public class ChocolateDivision {

    public static int chocolatesPerChild(int numberOfChocolates, int numberOfChildren) {
        return numberOfChocolates / numberOfChildren;
    }

    public static int remainingChocolates(int numberOfChocolates, int numberOfChildren) {
        return numberOfChocolates % numberOfChildren;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of chocolates:");
        int numberOfChocolates = sc.nextInt();

        System.out.println("Enter the number of children:");
        int numberOfChildren = sc.nextInt();

        if (numberOfChildren <= 0) {
            System.out.println("Number of children must be greater than zero.");
        } else {
            int chocolatesEach = chocolatesPerChild(numberOfChocolates, numberOfChildren);
            int remaining = remainingChocolates(numberOfChocolates, numberOfChildren);

            System.out.println("Each child will get " + chocolatesEach + " chocolates.");
            System.out.println("Remaining chocolates: " + remaining);
        }
    }
}