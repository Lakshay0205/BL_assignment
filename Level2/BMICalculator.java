import java.util.Scanner;

public class BMICalculator {
    public static double calculateBMI(double weight, double heightInCm) {
        double heightInMeters = heightInCm / 100;
        return weight / (heightInMeters * heightInMeters);
    }

    public static String determineBMIStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        if (bmi < 24.9)
            return "Normal weight";
        if (bmi < 29.9)
            return "Overweight";
        return "Obesity";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (in kg) for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (in cm) for person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
            data[i][2] = calculateBMI(data[i][0], data[i][1]);
        }

        System.out.println("\nResults:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Person %d: Weight = %.2f kg, Height = %.2f cm, BMI = %.2f, Status = %s%n",
                    (i + 1), data[i][0], data[i][1], data[i][2], determineBMIStatus(data[i][2]));
        }
    }
}
