package Regex.AdvancedProblems;
class CreditCardValidator {
    public static boolean isValidCreditCard(String cardNumber) {
        if (cardNumber == null || cardNumber.isEmpty()) {
            return false;
        }

        cardNumber = cardNumber.replaceAll("\\s+", ""); // Remove spaces
        if (!cardNumber.matches("\\d+")) { // Check if all digits
            return false;
        }

        int length = cardNumber.length();
        if (length != 16) {
            return false;
        }

        char firstDigit = cardNumber.charAt(0);
        if (firstDigit == '4') { // Visa
            return true;
        } else if (firstDigit == '5') { // MasterCard
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] testCards = {
                "4123456789012345",
                "5123456789012345",
                "6123456789012345",
                "4123 4567 8901 2345",
                "512345678901234",
                "412345678901234a",
                "41234567890123456",
                "412345678901234 ",
                " 4123456789012345",
                "4123456789012345 ",
                " 4123456789012345 ",
        };

        for (String card : testCards) {
            System.out.println(card + ": " + isValidCreditCard(card));
        }
    }
}