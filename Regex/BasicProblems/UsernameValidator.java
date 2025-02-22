package Regex.BasicProblems;
class UsernameValidator {
    public static boolean isValidUsername(String username) {
        if (username == null || username.length() < 5 || username.length() > 15) {
            return false;
        }
        if (!Character.isLetter(username.charAt(0))) {
            return false;
        }
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidUsername("user_123"));
        System.out.println(isValidUsername("123user"));
        System.out.println(isValidUsername("us"));
        System.out.println(isValidUsername("ValidUsername"));
        System.out.println(isValidUsername("invalid!name"));
    }
}