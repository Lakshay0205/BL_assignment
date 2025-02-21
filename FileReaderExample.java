import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        try {
            File file = new File("data.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}