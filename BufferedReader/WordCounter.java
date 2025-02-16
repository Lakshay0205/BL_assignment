package BufferedReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {

    public static int countWordOccurrences(String filePath, String targetWord) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int count = 0;
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.toLowerCase().split("[\\s\\p{Punct}]+"); // Split by spaces and punctuation
            for (String word : words) {
                if (word.equals(targetWord.toLowerCase())) { // Case-insensitive comparison
                    count++;
                }
            }
        }

        bufferedReader.close();
        return count;
    }

    public static void main(String[] args) {
        String filePath = "my_file.txt"; // Replace with your file path
        String targetWord = "the"; // Replace with the word you want to count

        try {
            int occurrences = countWordOccurrences(filePath, targetWord);
            System.out.println("The word '" + targetWord + "' appears " + occurrences + " times in the file.");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}