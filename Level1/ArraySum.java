import java.util.Scanner;
public class ArraySum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double num [] = new double[10];
		double total = 0.0;
		int i = 0;

		while(true) {
			System.out.print("Enter the number 0 or -ve to stop the loop.");
			double input = sc.nextDouble();

			if(input <= 0) {
				break;
			}
			if(i < 10) {
				num[i] = input;
				i++;
			}
			else
				break;
		}
		for(int j = 0; j <= i; j++) {
			total = total + num[j];
		}
		System.out.print("Sum: " + total);
	}
}
			
