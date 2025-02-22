package Regex.ExtractPrograms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EmailExtractor {
    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return emails;
        }

        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            emails.add(matcher.group());
        }

        return emails;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org. Also test.test@sub.domain.co";
        List<String> extractedEmails = extractEmails(text);
        for (String email : extractedEmails) {
            System.out.println(email);
        }
    }
}