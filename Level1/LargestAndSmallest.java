import java.util.Scanner;
import java.lang.Math;
public class LargestAndSmallest {
	public int[] findSmallestAndLargest(int number1, int number2, int number3) {
			int smallest = Math.min(Math.min(number1, number2), number3);
			int largest = Math.max(Math.max(number1, number2), number3);
			
			return new int[]{smallest, largest};
		}
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			
			LargestAndSmallest obj = new LargestAndSmallest();
			int [] result = obj.findSmallestAndLargest(n1,n2,n3);
		System.out.println("The smallest number is " + result[0]);
		System.out.print("The largest number is " + result[1]);
	}
}