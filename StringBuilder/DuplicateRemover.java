package StringBuilder;
import java.util.HashSet;

public class DuplicateRemover {

    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "bananas";
        String result = removeDuplicates(input);
        System.out.println(result);
    }
}