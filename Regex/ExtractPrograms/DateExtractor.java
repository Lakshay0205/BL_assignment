package Regex.ExtractPrograms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DateExtractor {
    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return dates;
        }

        String regex = "\\d{2}/\\d{2}/\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            dates.add(matcher.group());
        }

        return dates;
    }

    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020. Also 01/01/1999 and some incorrect format 1/1/2000.";
        List<String> extractedDates = extractDates(text);
        for (String date : extractedDates) {
            System.out.println(date);
        }
    }
}