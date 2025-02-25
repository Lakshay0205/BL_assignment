package BasicProblems;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        writeCSV(filePath);
    }

    private static void writeCSV(String filePath) {
        String[] records = {
                "1,John Doe,Engineering,75000",
                "2,Jane Smith,Marketing,68000",
                "3,Michael Brown,Finance,72000",
                "4,Linda Johnson,HR,65000",
                "5,William Davis,IT,70000"
        };

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String record : records) {
                bw.write(record);
                bw.newLine();
            }
            System.out.println("Employee records written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}