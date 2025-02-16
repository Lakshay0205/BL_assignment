package StringBuilder;
public class StringReverser {

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "hello world";
        String[] words = input.split("\\s+");
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {
            reversedString.append(reverseString(word)).append(" ");
        }

        System.out.println(reversedString.toString().trim());
    }
}