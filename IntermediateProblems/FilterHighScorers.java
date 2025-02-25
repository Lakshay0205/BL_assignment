package IntermediateProblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterHighScorers {
    public static void main(String[] args) {
        String filePath = "students.csv";
        filterStudentsWithHighMarks(filePath);
    }

    private static void filterStudentsWithHighMarks(String filePath) {
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
                    int marks = Integer.parseInt(data[3].trim());
                    if (marks > 80) {
                        System.out.printf("ID: %s | Name: %s | Age: %s | Marks: %s%n",
                                data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in marks field: " + e.getMessage());
        }
    }
}