package BufferedReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLineReader {

    public static void readFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }

    public static void main(String[] args) {
        String filePath = "my_file.txt"; // Replace with your file path
        try {
            readFile(filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}