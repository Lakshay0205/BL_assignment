package Regex.ExtractPrograms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LinkExtractor {
    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return links;
        }

        String regex = "(https?://(?:www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b(?:[-a-zA-Z0-9()@:%_\\+.~#?&//=]*))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            links.add(matcher.group());
        }

        return links;
    }

    public static void main(String args) {
        String text = "Visit https://www.google.com and http://example.org for more info. Also, check out ftp://example.com/file.txt and a malformed link example.com";
        List<String> extractedLinks = extractLinks(text);
        for (String link: extractedLinks) {
            System.out.println(link);
        }
    }
}