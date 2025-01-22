import java.lang.Math;
public class earthvolume {
    public static void main(String[] args) {
        double radius = 6378;
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);
        double kmToMiles = 0.621371;
        double volumeMi3 = volumeKm3 * Math.pow(kmToMiles, 3);
        System.out.printf("Volume of Earth in km³: %.2f km³%n", volumeKm3);
        System.out.printf("Volume of Earth in miles³: %.2f miles³%n", volumeMi3);
    }
}
