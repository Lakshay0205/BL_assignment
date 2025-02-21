import java.io.*;

public class LargeFileErrorFilter {

    public static void main(String[] args) {
        String filename = "large_file.txt"; // Replace with your file path

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}