package BufferedReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleToFileWriter {

    public static void writeToFile(String filePath) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        FileWriter fileWriter = new FileWriter(filePath);
        String line;

        System.out.println("Enter text to write to file (type 'exit' to finish):");

        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("exit")) {
                break;
            }
            fileWriter.write(line + "\n");
        }

        fileWriter.close();
        bufferedReader.close();
    }

    public static void main(String[] args) {
        String filePath = "user_input.txt"; // Replace with your desired file path

        try {
            writeToFile(filePath);
            System.out.println("Input written to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}