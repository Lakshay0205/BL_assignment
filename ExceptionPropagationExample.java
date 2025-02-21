public class ExceptionPropagationExample {

    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive.");
        }
        return amount * rate * years; // Simple interest calculation
    }

    public static void main(String args) {
        try {
            double amount = 1000;
            double rate = 0.05;
            int years = 5;

            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated interest: " + interest);

            // Example of invalid input:
            double invalidAmount = -100;
            double invalidRate = -0.02;
            int invalidYears = 5;

            double invalidInterest = calculateInterest(invalidAmount, invalidRate, invalidYears); // This line will throw an exception
            System.out.println("Calculated interest (invalid): " + invalidInterest); // This line will not be reached

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage()); // Catch and handle the exception
        }
    }
}