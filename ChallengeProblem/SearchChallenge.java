package ChallengeProblem;
import java.util.Arrays;

public class SearchChallenge {

    public static int findMissingPositiveLinear(int[] nums) {
        int n = nums.length;
        boolean[] present = new boolean[n + 1]; // To track positive numbers

        for (int num : nums) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return n + 1; // All numbers from 1 to n are present
    }

    public static int findTargetIndexBinary(int[] nums, int target) {
        Arrays.sort(nums); // Sort for binary search
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int missingPositive = findMissingPositiveLinear(nums);
        System.out.println("First missing positive (Linear): " + missingPositive);

        int target = 4;
        int targetIndex = findTargetIndexBinary(nums, target);
        System.out.println("Target index (Binary): " + targetIndex);

        int[] nums2 = {7,8,9,11,12};
        int missingPositive2 = findMissingPositiveLinear(nums2);
        System.out.println("First missing positive (Linear): " + missingPositive2);

        int target2 = 11;
        int targetIndex2 = findTargetIndexBinary(nums2, target2);
        System.out.println("Target index (Binary): " + targetIndex2);

        int[] nums3 = {1,2,0};
        int missingPositive3 = findMissingPositiveLinear(nums3);
        System.out.println("First missing positive (Linear): " + missingPositive3);

        int target3 = 2;
        int targetIndex3 = findTargetIndexBinary(nums3, target3);
        System.out.println("Target index (Binary): " + targetIndex3);

        int[] nums4 = {1,2,3};
        int missingPositive4 = findMissingPositiveLinear(nums4);
        System.out.println("First missing positive (Linear): " + missingPositive4);

        int target4 = 4;
        int targetIndex4 = findTargetIndexBinary(nums4, target4);
        System.out.println("Target index (Binary): " + targetIndex4);

    }
}