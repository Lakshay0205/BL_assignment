package BinarySearch;

public class MatrixSearch {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int midVal = matrix[row][col];

            if (midVal == target) {
                return true;
            } else if (target < midVal) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11},
                {10, 13, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));

        target = 13;
        System.out.println(searchMatrix(matrix, target));

        int[][] matrix2 = {{1}};
        target = 1;
        System.out.println(searchMatrix(matrix2, target));

        int[][] matrix3 = {{1,2}};
        target = 2;
        System.out.println(searchMatrix(matrix3, target));

        int[][] matrix4 = {};
        target = 2;
        System.out.println(searchMatrix(matrix4, target));

    }
}