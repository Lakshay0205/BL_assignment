import java.util.Arrays;

public class NumberChecker1 {

    public static int countDigits(int number) {
        if (number == 0) {
            return 1; // Special case for zero
        }
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static int[] getDigitsArray(int number) {
        int digitCount = countDigits(number);
        int[] digits = new int[digitCount];
        for (int i = digitCount - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sumOfDigits = sumOfDigits(digits);
        return number % sumOfDigits == 0;
    }

    public static int[][] getDigitFrequencies(int[] digits) {
        int[][] frequencies = new int[10][2]; // 10 possible digits (0-9)

        for (int i = 0; i < digits.length; i++) {
            frequencies[digits[i]][0] = digits[i]; // Store the digit
            frequencies[digits[i]][1]++; // Increment frequency
        }

        // Remove entries with zero frequency
        int[][] filteredFrequencies = new int[countNonZeroFrequencies(frequencies)][2];
        int index = 0;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i][1] > 0) {
                filteredFrequencies[index][0] = frequencies[i][0];
                filteredFrequencies[index][1] = frequencies[i][1];
                index++;
            }
        }
        return filteredFrequencies;
    }

    private static int countNonZeroFrequencies(int[][] frequencies) {
        int count = 0;
        for (int[] row : frequencies) {
            if (row[1] > 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int number = 12345;
        int[] digits = getDigitsArray(number);

        System.out.println("Number: " + number);
        System.out.println("Digit Count: " + countDigits(number));
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Sum of Digits: " + sumOfDigits(digits));
        System.out.println("Sum of Squares of Digits: " + sumOfSquaresOfDigits(digits));
        System.out.println("Is Harshad Number: " + isHarshadNumber(number, digits));
        System.out.println("Digit Frequencies:");
        int[][] frequencies = getDigitFrequencies(digits);
        for (int[] row : frequencies) {
            System.out.println("Digit: " + row[0] + ", Frequency: " + row[1]);
        }
    }
}