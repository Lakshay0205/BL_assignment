import java.util.Scanner;
public class positiveAndNegativeArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Ente five numbers in array whether it's positive or negative"); 
		int [] arr = new int [5];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 0) {
				System.out.print(arr[i] + " is a +ve number found at index " + i);
			}
			else if (arr[i] < 0) {
				System.out.print(arr[i] + " is a -ve number found at index " + i);
			}
			else
				System.out.print("0 found at index " + i);
		}
	}
}
