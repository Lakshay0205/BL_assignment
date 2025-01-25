import java.util.Scanner;

public class LargestSecondLargest1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int temp = number;
        int count = 0;

        while (temp > 0) {
            temp /= 10;
            count++;
        }

        // Initialize the array with a reasonable size
        int maxDigit = count * 2;
        int[] arr = new int[maxDigit]; 

        // Extract digit and store them in the array
        int index = 0;
        while (number > 0) {
            arr[index++] = number % 10;
            number /= 10;

            // Increase array size if necessary
            if (index == maxDigit) {
                maxDigit += 10; // Increase size by 10
                int[] tempDigits = new int[maxDigit];
                System.arraycopy(arr, 0, tempDigits, 0, index);
                arr = tempDigits;
            }
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < index; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

		System.out.print("Largest element: " + largest + " \n Second Largest element: "+ secondLargest);
    }
}