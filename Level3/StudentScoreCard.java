import java.util.Random;
import java.util.Scanner;

public class StudentScoreCard {

    // Method to generate random scores for Physics, Chemistry, and Math
    public static int[][] generateScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3]; // 2D array for students' scores in PCM

        for (int i = 0; i < numStudents; i++) {
            // Generate random marks between 50 and 99 (2-digit scores)
            scores[i][0] = 50 + rand.nextInt(50); // Physics
            scores[i][1] = 50 + rand.nextInt(50); // Chemistry
            scores[i][2] = 50 + rand.nextInt(50); // Math
        }

        return scores;
    }

    // Method to calculate total, average, and percentage for each student
    public static double[][] calculateResults(int[][] scores, int numStudents) {
        double[][] results = new double[numStudents][4]; // 2D array for total, average, percentage

        for (int i = 0; i < numStudents; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Store total, average, and percentage rounded to 2 decimal places
            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0; // rounding to 2 decimal places
            results[i][2] = Math.round(percentage * 100.0) / 100.0; // rounding to 2 decimal places
        }

        return results;
    }

    // Method to display the scorecard in a tabular format
    public static void displayScoreCard(int[][] scores, double[][] results, int numStudents) {
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Student", "Physics", "Chemistry", "Math", "Total",
                "Average", "Percentage");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-10d%-10d%-10d%-10d%-10.2f%-10.2f%-10.2f\n", i + 1, scores[i][0], scores[i][1],
                    scores[i][2], results[i][0], results[i][1], results[i][2]);
        }
        System.out.println("------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        // Scanner for input to get the number of students
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Generate random scores for the students
        int[][] scores = generateScores(numStudents);

        // Calculate total, average, and percentage for each student
        double[][] results = calculateResults(scores, numStudents);

        // Display the scorecard
        displayScoreCard(scores, results, numStudents);
    }
}
