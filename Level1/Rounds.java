import java.util.Scanner;
public class Rounds {
	public int noOfRounds(int s1, int s2, int s3) {
		int perimeter = s1+s2+s3;
		int totalRounds = 5000 / perimeter; // convert 5km into 5000 m.
		return totalRounds;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int side1 = sc.nextInt();
		int side2 = sc.nextInt();
		int side3 = sc.nextInt();
		
		Rounds obj = new Rounds();
		System.out.print("Total no. of rounds: " + obj.noOfRounds(side1,side2,side3));
	}
}