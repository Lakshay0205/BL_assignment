import java.util.*;
public class SumNaturalNumber {
	public int sum(int n) {
		if( n == 0 || n < 0)
			System.out.print("Number should be greater than 0");
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int number  = sc.nextInt();
		
		SumNaturalNumber obj = new SumNaturalNumber();
		System.out.print("The sum of natural number: " + obj.sum(number));
	}
}