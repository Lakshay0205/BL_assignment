import java.util.Scanner;
public class SimpleInterest {
	public double simpleinterest(double P, double R, double T) {
		double SI = (P * R * T) / 100;
		return SI;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double principal = sc.nextDouble();
		double rate = sc.nextDouble();
		double time = sc.nextDouble();
	
		SimpleInterest si = new SimpleInterest();
		System.out.println("Simple Interest: " + si.simpleinterest(principal, rate, time));
	}
}
