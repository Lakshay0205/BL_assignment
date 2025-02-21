import java.io.*;
import java.util.*;

public class WordCount {

    public static void main(String[] args) {
        String filename = "input.txt"; // Replace with your file path

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            Map<String, Integer> wordCounts = new HashMap<>();
            String line;

            while ((line = br.readLine()) != null) {
                //Basic word splitting.  You might want to improve this for punctuation, etc.
                String[] words = line.toLowerCase().split("[\\s\\p{Punctuation}]+"); // Split by whitespace and punctuation

                for (String word : words) {
                    if (!word.isEmpty()) { // Check for empty strings after splitting
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort by frequency (descending)
            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCounts.entrySet());
            sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            // Display top 5
            System.out.println("Top 5 words:");
            int count = 0;
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                count++;
                if (count >= 5) {
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}