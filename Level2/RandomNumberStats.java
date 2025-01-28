import java.util.Random;

public class RandomNumberStats {
    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = 1000 + random.nextInt(9000);
        }
        return numbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int number : numbers) {
            sum += number;
            if (number < min)
                min = number;
            if (number > max)
                max = number;
        }

        double average = (double) sum / numbers.length;
        return new double[] { average, min, max };
    }

    public static void main(String[] args) {
        int[] randomNumbers = generate4DigitRandomArray(5);
        System.out.print("Generated Numbers: ");
        for (int number : randomNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        double[] stats = findAverageMinMax(randomNumbers);
        System.out.println("Average: " + stats[0]);
        System.out.println("Minimum: " + stats[1]);
        System.out.println("Maximum: " + stats[2]);
    }
}
