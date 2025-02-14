import java.util.Scanner;
public class HeapSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of job applicants: ");
        int n = scanner.nextInt();
        int[] salaries = new int[n];
        System.out.println("Enter the salary demands of job applicants:");
        for (int i = 0; i < n; i++) {
            salaries[i] = scanner.nextInt();
        }
        heapSort(salaries);
        System.out.println("Sorted Salary Demands:");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
    }
    
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}

