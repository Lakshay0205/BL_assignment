package Regex.AdvancedProblems;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CurrencyExtractor {
    public static List<String> extractCurrencyValues(String text) {
        List<String> currencyValues = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return currencyValues;
        }

        String regex = "(\\$?\\d+(\\.\\d+)?)"; // Matches both $45.99 and 10.50
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        return currencyValues;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50. Also, a price of 100 and $1000.00. But not a value like abc.";
        List<String> extractedCurrencyValues = extractCurrencyValues(text);
        for (String value : extractedCurrencyValues) {
            System.out.println(value);
        }
    }
}