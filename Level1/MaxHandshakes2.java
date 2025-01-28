import java.util.*;
public class MaxHandshakes2 {
	public int maxHandshakes(int n) {
		int handshakes = (n * (n - 1)) / 2;
		return handshakes;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		MaxHandshakes2 obj = new MaxHandshakes2();
		System.out.print("Maximum number of handshakes: " + obj.maxHandshakes(n));
	}
}