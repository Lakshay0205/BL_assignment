import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int low = 1, high = 100, guess;
        String response;

        System.out.println("Think of a number between 1 and 100. I will try to guess it!");

        while (true) {
            guess = random.nextInt(high - low + 1) + low;
            System.out.println("Is your number " + guess + "? (Enter 'high', 'low', or 'correct'):");
            response = scanner.nextLine().toLowerCase();

            if (response.equals("correct")) {
                System.out.println("Yay! I guessed your number.");
                break;
            } else if (response.equals("high")) {
                high = guess - 1;
            } else if (response.equals("low")) {
                low = guess + 1;
            } else {
                System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
            }
        }
        scanner.close();
    }
}
