import java.util.Scanner;
public class PosNegZero {
	public int posnegzero(int n) {
		if(n > 0)
			return 1;
		else if(n < 0)
			return -1;
		else
			return 0;
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PosNegZero obj = new PosNegZero();
		System.out.print("The number: "+ obj.posnegzero(n));
	}
}