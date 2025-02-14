import java.util.Scanner;
public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of product prices: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        quickSort(prices, 0, n - 1);
        System.out.println("Sorted Product Prices:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

