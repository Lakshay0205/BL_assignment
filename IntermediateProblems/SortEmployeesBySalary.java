package IntermediateProblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortEmployeesBySalary {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        sortAndPrintTopPaidEmployees(filePath);
    }

    private static void sortAndPrintTopPaidEmployees(String filePath) {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 4) {
                    records.add(data);
                }
            }

            records.sort(Comparator.comparingDouble((String[] record) -> Double.parseDouble(record[3].trim())).reversed());

            System.out.println("Top 5 Highest-Paid Employees:");
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                String[] record = records.get(i);
                System.out.printf("ID: %s | Name: %s | Department: %s | Salary: %s%n",
                        record[0].trim(), record[1].trim(), record[2].trim(), record[3].trim());
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}