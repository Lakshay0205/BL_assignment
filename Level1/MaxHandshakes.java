import java.util.*;
public class MaxHandshakes {
	public int maxHandshakes(int n) {
		int handshakes = (n * (n - 1)) / 2;
		return handshakes;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		MaxHandshakes obj = new MaxHandshakes();
		System.out.print("Maximum number of handshakes: " + obj.maxHandshakes(n));
	}
}