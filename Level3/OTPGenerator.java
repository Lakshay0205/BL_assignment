import java.util.HashSet;

public class OTPGenerator {

    // Method to generate a 6-digit OTP
    public static String generateOTP() {
        return String.format("%06d", (int) (Math.random() * 1000000));
    }

    // Method to generate 10 OTPs and save them in an array
    public static String[] generateMultipleOTPs(int count) {
        String[] otps = new String[count];
        for (int i = 0; i < count; i++) {
            otps[i] = generateOTP();
        }
        return otps;
    }

    // Method to check if all OTPs are unique
    public static boolean areOTPsUnique(String[] otps) {
        HashSet<String> uniqueOTPs = new HashSet<>();
        for (String otp : otps) {
            uniqueOTPs.add(otp);
        }
        return uniqueOTPs.size() == otps.length;
    }

    public static void main(String[] args) {
        int count = 10;
        String[] otps = generateMultipleOTPs(count);

        // Display generated OTPs
        System.out.println("Generated OTPs:");
        for (String otp : otps) {
            System.out.println(otp);
        }

        // Validate uniqueness of OTPs
        boolean unique = areOTPsUnique(otps);
        System.out.println("\nAre all OTPs unique? " + unique);
    }
}
