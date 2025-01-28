import java.util.Scanner;
import java.lang.Math;
class WindChill {
	public double calculateWindChill(double temperature, double windSpeed) {
		double windChill = 35.74 + 0.6215 *temperature + (0.4275*temperature - 35.75) * Math.pow(windSpeed, 0.16);
		
		return windChill;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double temp = sc.nextDouble();
		double windSpeed = sc.nextDouble();
		WindChill obj = new WindChill();
		System.out.print("windChill: " + obj.calculateWindChill(temp, windSpeed));
	}
}