import java.io.*;

public class UppercaseToLowercase {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))) {

            int c;
            while ((c = reader.read()) != -1) {
                char ch = (char) c;
                if (Character.isUpperCase(ch)) {
                    writer.write(Character.toLowerCase(ch));
                } else {
                    writer.write(ch);
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}