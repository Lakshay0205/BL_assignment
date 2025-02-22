package Regex.AdvancedProblems;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SSNValidator {
    public static boolean isValidSSN(String ssn) {
        if (ssn == null || ssn.isEmpty()) {
            return false;
        }

        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ssn);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testSSNs = {
                "123-45-6789",
                "123456789",
                "123-45-678",
                "123-45-67890",
                "12345-67-89",
                "123-456-789",
                "abc-dd-efgh",
                "123-45-678a",
                "123-45-678 ",
                " 123-45-6789",
                "123-45-6789 ",
                " 123-45-6789 ",
        };

        for (String ssn : testSSNs) {
            System.out.println(ssn + ": " + isValidSSN(ssn));
        }
    }
}