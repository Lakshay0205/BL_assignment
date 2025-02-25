package BasicProblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "students.csv";
        readAndPrintCSV(filePath);
    }

    private static void readAndPrintCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    System.out.printf("ID: %s | Name: %s | Age: %s | Marks: %s%n",
                            data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}