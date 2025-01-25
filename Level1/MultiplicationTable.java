import java.util.Scanner;
public class MultiplicationTable{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num = sc.nextInt();
		// create a table array
		int [] table = new int [10];
		for(int i = 0; i < table.length; i++) {
			table[i] = num * (i+1);
		}
		for(int i = 0; i < table.length; i ++ ) {
			System.out.print(table[i] + " ");

		}
	}
}
