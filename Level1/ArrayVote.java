import java.util.Scanner;
public class ArrayVote{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Enter the age of 10 students
		int [] arr = new int [10];
		for(int i = 0;  i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] >= 18) {
				count++;
			}
		}
		System.out.print(count + " students is available for voting");
	}
}
