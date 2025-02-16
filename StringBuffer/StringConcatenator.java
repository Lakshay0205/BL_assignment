package StringBuffer;
public class StringConcatenator {

    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"hello", " ", "world", "!"};
        String concatenatedString = concatenateStrings(strings);
        System.out.println(concatenatedString); // Output: hello world!
    }
}