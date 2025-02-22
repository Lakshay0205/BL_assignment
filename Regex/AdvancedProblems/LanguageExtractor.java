package Regex.AdvancedProblems;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LanguageExtractor {
    public static List<String> extractLanguages(String text) {
        List<String> languages = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return languages;
        }

        String regex = "\\b(Java|Python|JavaScript|Go|C\\+\\+|C#|Ruby|Swift|Kotlin|PHP|Rust|TypeScript)\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            languages.add(matcher.group());
        }

        return languages;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go, c++, or C# yet. I also like Ruby and Swift. and php, and Rust.";
        List<String> extractedLanguages = extractLanguages(text);
        for (String language : extractedLanguages) {
            System.out.println(language);
        }
        text = "This text contains no programming languages.";
        extractedLanguages = extractLanguages(text);
        for(String language : extractedLanguages){
            System.out.println(language);
        }
    }
}