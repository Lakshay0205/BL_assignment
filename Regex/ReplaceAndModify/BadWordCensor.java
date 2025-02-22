package Regex.ReplaceAndModify;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class BadWordCensor {
    public static String censorBadWords(String text, Set<String> badWords) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        String[] words = text.split("\\s+");
        StringBuilder censoredText = new StringBuilder();

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase(); // Clean word for comparison
            if (badWords.contains(cleanWord)) {
                censoredText.append("****");
            } else {
                censoredText.append(word);
            }
            censoredText.append(" ");
        }

        return censoredText.toString().trim();
    }

    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        Set<String> badWords = new HashSet<>(Arrays.asList("damn", "stupid"));

        String censoredText = censorBadWords(text, badWords);
        System.out.println(censoredText);

        text = "Another sentence with a different bad word, and more punctuation: Hello, you jerk!";
        badWords = new HashSet<>(Arrays.asList("jerk"));
        censoredText = censorBadWords(text, badWords);
        System.out.println(censoredText);

        text = "Clean sentence.";
        badWords = new HashSet<>(Arrays.asList("damn", "stupid","jerk"));
        censoredText = censorBadWords(text, badWords);
        System.out.println(censoredText);
    }
}