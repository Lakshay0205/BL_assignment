import java.util.Scanner;

public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the main string: ");
        String mainString = scanner.nextLine();
        System.out.print("Enter the substring: ");
        String subString = scanner.nextLine();
        scanner.close();
        int count = countOccurrences(mainString, subString);
        System.out.println("Occurrences of substring: " + count);
    }

    public static int countOccurrences(String mainString, String subString) {
        int count = 0;
        int index = 0;
        while ((index = mainString.indexOf(subString, index)) != -1) {
            count++;
            index += subString.length();
        }
        return count;
    }
}