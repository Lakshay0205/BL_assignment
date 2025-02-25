package AdvancedProblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSVData {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");

    public static void main(String[] args) {
        String filePath = "employees.csv";
        validateCSVData(filePath);
    }

    private static void validateCSVData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 6) {
                    String email = data[4].trim();
                    String phone = data[5].trim();
                    boolean validEmail = EMAIL_PATTERN.matcher(email).matches();
                    boolean validPhone = PHONE_PATTERN.matcher(phone).matches();

                    if (!validEmail || !validPhone) {
                        System.out.printf("Invalid data at line %d: %s%n", lineNumber, line);
                        if (!validEmail) {
                            System.out.println("Error: Invalid email format -> " + email);
                        }
                        if (!validPhone) {
                            System.out.println("Error: Phone number must contain exactly 10 digits -> " + phone);
                        }
                    }
                } else {
                    System.out.printf("Invalid row structure at line %d: %s%n", lineNumber, line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}