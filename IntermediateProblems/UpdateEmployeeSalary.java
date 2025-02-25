package IntermediateProblems;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateEmployeeSalary {
    public static void main(String[] args) {
        String inputFilePath = "employees.csv";
        String outputFilePath = "updated_employees.csv";
        updateITDepartmentSalaries(inputFilePath, outputFilePath);
    }

    private static void updateITDepartmentSalaries(String inputFilePath, String outputFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    bw.write(line);
                    bw.newLine();
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 4) {
                    if (data[2].trim().equalsIgnoreCase("IT")) {
                        double salary = Double.parseDouble(data[3].trim());
                        salary = salary + (salary * 0.10);
                        data[3] = String.format("%.2f", salary);
                    }
                    bw.write(String.join(",", data));
                    bw.newLine();
                }
            }
            System.out.println("Updated employee records saved to " + outputFilePath);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}