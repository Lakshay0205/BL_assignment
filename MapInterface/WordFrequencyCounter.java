package MapInterface;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String filename) throws IOException {
        Map<String, Integer> wordCount = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
            String[] words = line.split("\\s+");
            
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }
        reader.close();
        return wordCount;
    }
    
    public static void main(String[] args) {
        String filename = "input.txt";
        try {
            Map<String, Integer> wordFrequency = countWordFrequency(filename);
            System.out.println("Word Frequencies: " + wordFrequency);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
