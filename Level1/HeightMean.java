import java.util.Scanner;
public class HeightMean {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double height [] = new double[11];
		System.out.print("Enter the height of 11 players in cm: ");

		for(int i = 0; i < height.length; i++) {
			height[i] = sc.nextDouble();
		}
		double sum = 0.0;
		for(int i = 0; i < height.length; i++) {
			sum = sum + height[i];
		}
		double mean = sum/(double)height.length;
		System.out.print("Mean: " + mean);
	}
}
