package Regex.ReplaceAndModify;
class SpaceNormalizer {
    public static String normalizeSpaces(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        String input = "This  is   an    example     with      multiple       spaces.";
        String output = normalizeSpaces(input);
        System.out.println(output);
        input = "   Leading and trailing spaces   ";
        output = normalizeSpaces(input).trim();
        System.out.println(output);
        input = "No extra spaces";
        output = normalizeSpaces(input);
        System.out.println(output);
    }
}