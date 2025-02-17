import java.util.Arrays;

public class SearchComparison {
    // Linear Search (O(N))
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // Binary Search (O(log N))
    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr); // Binary search requires sorted data (O(N log N))
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 7, 9, 11, 15, 18 };
        int target = 11;

        System.out.println("Linear Search Index: " + linearSearch(arr, target));
        System.out.println("Binary Search Index: " + binarySearch(arr, target));
    }
}
