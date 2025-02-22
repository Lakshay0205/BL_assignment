package Regex.ExtractPrograms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CapitalizedWordsExtractor {
    public static List<String> extractCapitalizedWords(String text) {
        List<String> capitalizedWords = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return capitalizedWords;
        }

        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        return capitalizedWords;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York. Also, Test Word.";
        List<String> extractedWords = extractCapitalizedWords(text);
        for (String word : extractedWords) {
            System.out.println(word);
        }
    }
}