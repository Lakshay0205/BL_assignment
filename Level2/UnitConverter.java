public class UnitConverter {
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static void main(String[] args) {
        System.out.println("10 km in miles: " + convertKmToMiles(10));
        System.out.println("5 miles in km: " + convertMilesToKm(5));
        System.out.println("20 meters in feet: " + convertMetersToFeet(20));
        System.out.println("50 feet in meters: " + convertFeetToMeters(50));
    }
}
