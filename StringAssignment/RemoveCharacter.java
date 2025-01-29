import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.print("Enter the character to remove: ");
        char charToRemove = scanner.next().charAt(0);
        scanner.close();

        String result = removeCharacter(input, charToRemove);
        System.out.println("String after removal: " + result);
    }

    public static String removeCharacter(String str, char ch) {
        StringBuilder sb = new StringBuilder();

        for (char currentChar : str.toCharArray()) {
            if (currentChar != ch) {
                sb.append(currentChar);
            }
        }

        return sb.toString();
    }
}
