import java.util.*; 
public class Multiplication_6To9 {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int number  = sc.nextInt();
		int [] result = new int [4];
		for(int i = 6; i <= 9; i++) {
			result[i-6] = number * i;
		}
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
