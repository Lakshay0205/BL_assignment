import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.println(str + " is " + (isPalindrome(str) ? "a palindrome." : "not a palindrome."));
        scanner.close();
    }
}
