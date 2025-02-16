package BinarySearch;

public class RotationPointFinder {

    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // To avoid potential overflow
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // Or arr[left], both will be the same
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int rotationPoint = findRotationPoint(arr);
        System.out.println("Rotation point index: " + rotationPoint);
        System.out.println("Smallest element: " + arr[rotationPoint]);

        int[] arr2 = {1,2,3,4,5};
        int rotationPoint2 = findRotationPoint(arr2);
        System.out.println("Rotation point index: " + rotationPoint2);
        System.out.println("Smallest element: " + arr2[rotationPoint2]);

        int[] arr3 = {5,1,2,3,4};
        int rotationPoint3 = findRotationPoint(arr3);
        System.out.println("Rotation point index: " + rotationPoint3);
        System.out.println("Smallest element: " + arr3[rotationPoint3]);
    }
}