import java.util.Scanner;

public class TemperatureConverter {
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        double temp = scanner.nextDouble();
        System.out.print("Convert to (C/F)? ");
        char choice = scanner.next().charAt(0);

        if (choice == 'C' || choice == 'c') {
            System.out.println("Temperature in Celsius: " + fahrenheitToCelsius(temp));
        } else if (choice == 'F' || choice == 'f') {
            System.out.println("Temperature in Fahrenheit: " + celsiusToFahrenheit(temp));
        } else {
            System.out.println("Invalid choice.");
        }
        scanner.close();
    }
}
