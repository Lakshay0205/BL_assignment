import java.util.*;
class LargestAndSMax {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int number = sc.nextInt();
		int count = 0;
		int original = number;
		while(number != 0) {
			count++;
			number = number / 10;
		}

		int [] arr = new int [count];
		for(int i = 0; i < count; i++) {
			arr[i] = original % 10;
		}
		int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < count; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } 
			else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

		System.out.print("Largest element: " + largest + "\n Second Largest element: "+ secondLargest);
	}
}
