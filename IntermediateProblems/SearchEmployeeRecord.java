package IntermediateProblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployeeRecord {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String nameToSearch = scanner.nextLine().trim();
        searchEmployeeByName(filePath, nameToSearch);
        scanner.close();
    }

    private static void searchEmployeeByName(String filePath, String nameToSearch) {
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 4 && data[1].trim().equalsIgnoreCase(nameToSearch)) {
                    System.out.printf("Department: %s | Salary: %s%n",
                            data[2].trim(), data[3].trim());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}