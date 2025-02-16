package BufferedReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ByteToCharacterConverter {

    public static void convertAndPrint(String filePath, String charsetName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charsetName);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }

    public static void main(String[] args) {
        String filePath = "my_binary_file.txt"; // Replace with your file path
        String charsetName = StandardCharsets.UTF_8.name();//"UTF-8"; // Replace with the correct charset

        try {
            convertAndPrint(filePath, charsetName);
        } catch (IOException e) {
            System.err.println("Error converting file: " + e.getMessage());
        }
    }
}