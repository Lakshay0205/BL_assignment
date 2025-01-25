import java.util.Scanner;

public class BMICalculator2DArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();

        // 2D array to store height, weight, and BMI
        double[][] personData = new double[numPersons][3]; 
        String[] weightStatus = new String[numPersons];

        for (int i = 0; i < numPersons; i++) {
            double weight, height;

            do {
                System.out.print("Enter weight (kg) for person " + (i + 1) + " (positive value): ");
                weight = scanner.nextDouble();
            } while (weight <= 0); 

            do {
                System.out.print("Enter height (meters) for person " + (i + 1) + " (positive value): ");
                height = scanner.nextDouble();
            } while (height <= 0);

            // Store weight and height in the array
            personData[i][0] = weight;
            personData[i][1] = height;

            // Calculate BMI
            personData[i][2] = weight / (height * height);

            // Determine weight status
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] >= 18.5 && personData[i][2] < 25) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] >= 25 && personData[i][2] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\nHeight\tWeight\tBMI\tStatus");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s\n", 
                    personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }

        scanner.close();
    }
}