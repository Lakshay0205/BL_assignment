package AdvancedProblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicateCSVEntries {
    public static void main(String[] args) {
        String filePath = "students.csv";
        detectDuplicateRecords(filePath);
    }

    private static void detectDuplicateRecords(String filePath) {
        Set<String> uniqueIds = new HashSet<>();
        Set<String> duplicateRecords = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length > 0) {
                    String id = data[0].trim();
                    if (!uniqueIds.add(id)) {
                        duplicateRecords.add(line);
                    }
                }
            }

            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate records detected:");
                duplicateRecords.forEach(System.out::println);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}