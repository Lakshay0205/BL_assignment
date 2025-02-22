package Regex.BasicProblems;
class HexColorValidator {
    public static boolean isValidHexColor(String hexColor) {
        if (hexColor == null || hexColor.length() != 7 || hexColor.charAt(0) != '#') {
            return false;
        }
        for (int i = 1; i < 7; i++) {
            char c = hexColor.charAt(i);
            if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidHexColor("#FFA500"));
        System.out.println(isValidHexColor("#ff4500"));
        System.out.println(isValidHexColor("#123"));
        System.out.println(isValidHexColor("FFA500"));
        System.out.println(isValidHexColor("#FFA50G"));
        System.out.println(isValidHexColor("#1234567"));
        System.out.println(isValidHexColor("#12345a"));

    }
}