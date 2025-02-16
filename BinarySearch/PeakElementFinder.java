package BinarySearch;

public class PeakElementFinder {

    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) { // Important: <= for handling edge cases
            int mid = left + (right - left) / 2;

            // Handle edge cases where mid might be 0 or arr.length - 1
            int leftVal = (mid > 0) ? arr[mid - 1] : Integer.MIN_VALUE;
            int rightVal = (mid < arr.length - 1) ? arr[mid + 1] : Integer.MIN_VALUE;


            if (arr[mid] > leftVal && arr[mid] > rightVal) {
                return mid;
            } else if (arr[mid] < leftVal) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1; // Should not reach here if array has at least one peak
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);

        int[] arr2 = {1, 2, 1, 3, 5, 6, 4};
        int peakIndex2 = findPeakElement(arr2);
        System.out.println("Peak element index: " + peakIndex2);
        System.out.println("Peak element value: " + arr2[peakIndex2]);

        int[] arr3 = {1,2,3,4,5};
        int peakIndex3 = findPeakElement(arr3);
        System.out.println("Peak element index: " + peakIndex3);
        System.out.println("Peak element value: " + arr3[peakIndex3]);

        int[] arr4 = {5,4,3,2,1};
        int peakIndex4 = findPeakElement(arr4);
        System.out.println("Peak element index: " + peakIndex4);
        System.out.println("Peak element value: " + arr4[peakIndex4]);

        int[] arr5 = {1};
        int peakIndex5 = findPeakElement(arr5);
        System.out.println("Peak element index: " + peakIndex5);
        System.out.println("Peak element value: " + arr5[peakIndex5]);

    }
}