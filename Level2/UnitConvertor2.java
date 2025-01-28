public class UnitConvertor2 {

    // Temperature Conversions
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Weight Conversions
    public static double poundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double kilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    // Volume Conversions
    public static double gallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double litersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {
        double celsius = UnitConvertor2.fahrenheitToCelsius(77); 
        System.out.println("77 Fahrenheit in Celsius: " + celsius);

        double pounds = UnitConvertor2.kilogramsToPounds(10);
        System.out.println("10 Kilograms in Pounds: " + pounds);
    }
}