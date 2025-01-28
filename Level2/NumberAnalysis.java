import java.util.Scanner;

public class NumberAnalysis {
    public static boolean isPositive(int number) {
        return number > 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compareNumbers(int num1, int num2) {
        if (num1 > num2)
            return 1;
        if (num1 < num2)
            return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            if (isPositive(numbers[i])) {
                System.out.print("Number " + numbers[i] + " is Positive");
                if (isEven(numbers[i])) {
                    System.out.println(" and Even.");
                } else {
                    System.out.println(" and Odd.");
                }
            } else {
                System.out.println("Number " + numbers[i] + " is Negative.");
            }
        }

        int comparison = compareNumbers(numbers[0], numbers[numbers.length - 1]);
        if (comparison > 0) {
            System.out.println("The first number is greater than the last number.");
        } else if (comparison < 0) {
            System.out.println("The first number is less than the last number.");
        } else {
            System.out.println("The first and last numbers are equal.");
        }
    }
}
