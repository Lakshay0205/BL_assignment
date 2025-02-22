package Regex.BasicProblems;
class LicensePlateValidator {
    public static boolean isValidLicensePlate(String licensePlate) {
        if (licensePlate == null || licensePlate.length() != 6) {
            return false;
        }
        for (int i = 0; i < 2; i++) {
            if (!Character.isUpperCase(licensePlate.charAt(i))) {
                return false;
            }
        }
        for (int i = 2; i < 6; i++) {
            if (!Character.isDigit(licensePlate.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidLicensePlate("AB1234"));
        System.out.println(isValidLicensePlate("A12345"));
        System.out.println(isValidLicensePlate("ab1234"));
        System.out.println(isValidLicensePlate("ABC123"));
        System.out.println(isValidLicensePlate("AB123456"));
        System.out.println(isValidLicensePlate("ABabcd"));
    }
}