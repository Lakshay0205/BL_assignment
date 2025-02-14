import java.util.Scanner;
public class CountingSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] ages = new int[n];
        System.out.println("Enter the ages of the students (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }
        countingSort(ages);
        System.out.println("Sorted Student Ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
    
    public static void countingSort(int[] arr) {
        int max = 18;
        int min = 10;
        int range = max - min + 1;
        
        int[] count = new int[range];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i + min;
                count[i]--;
            }
        }
    }
}

