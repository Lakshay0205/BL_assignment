import java.io.*;

public class FileReadComparison {
    public static void main(String[] args) throws IOException {
        String filePath = "largeFile.txt"; // Ensure this file exists

        // FileReader
        long start = System.nanoTime();
        FileReader fr = new FileReader(filePath);
        while (fr.read() != -1) {
        }
        fr.close();
        System.out.println("FileReader: " + (System.nanoTime() - start) / 1e6 + " ms");

        // InputStreamReader
        start = System.nanoTime();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
        while (isr.read() != -1) {
        }
        isr.close();
        System.out.println("InputStreamReader: " + (System.nanoTime() - start) / 1e6 + " ms");
    }
}
