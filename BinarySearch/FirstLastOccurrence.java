package BinarySearch;

public class FirstLastOccurrence {

    public static int[] findFirstLastOccurrence(int[] arr, int target) {
        int first = -1;
        int last = -1;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1; // Search left for first occurrence
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1; // Search right for last occurrence
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 5, 5, 6, 8, 8, 9};
        int target = 5;
        int[] result = findFirstLastOccurrence(arr, target);
        System.out.println("First occurrence: " + result[0]);
        System.out.println("Last occurrence: " + result[1]);

        int[] arr2 = {1,2,3,4,5};
        int target2 = 6;
        int[] result2 = findFirstLastOccurrence(arr2, target2);
        System.out.println("First occurrence: " + result2[0]);
        System.out.println("Last occurrence: " + result2[1]);

        int[] arr3 = {1,1,1,1,1};
        int target3 = 1;
        int[] result3 = findFirstLastOccurrence(arr3, target3);
        System.out.println("First occurrence: " + result3[0]);
        System.out.println("Last occurrence: " + result3[1]);


    }
}