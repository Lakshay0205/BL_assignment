package Regex.AdvancedProblems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RepeatingWordsFinder {
    public static List<String> findRepeatingWords(String text) {
        List<String> repeatingWords = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return repeatingWords;
        }

        String[] words = text.toLowerCase().split("\\s+"); // Split into words, lowercase
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > 1) {
                repeatingWords.add(entry.getKey());
            }
        }

        return repeatingWords;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test. Also, test test test, and and and and!";
        List<String> repeatedWords = findRepeatingWords(text);
        for (String word : repeatedWords) {
            System.out.println(word);
        }

        text = "No repeating words here.";
        repeatedWords = findRepeatingWords(text);
        for (String word : repeatedWords){
            System.out.println(word);
        }
    }
}