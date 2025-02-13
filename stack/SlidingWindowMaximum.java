package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0]; 
        }

        int n = nums.length;
        int[] result = new int[n - k + 1]; 
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println("Nums: " + Arrays.toString(nums));
        System.out.println("Window size: " + k);
        System.out.println("Max Sliding Window: " + Arrays.toString(result));

        nums = new int[]{1, -1};
        k = 1;
        result = maxSlidingWindow(nums, k);
        System.out.println("Nums: " + Arrays.toString(nums));
        System.out.println("Window size: " + k);
        System.out.println("Max Sliding Window: " + Arrays.toString(result));

        nums = new int[]{3,8,2,5,7,6,12};
        k = 3;
        result = maxSlidingWindow(nums, k);
        System.out.println("Nums: " + Arrays.toString(nums));
        System.out.println("Window size: " + k);
        System.out.println("Max Sliding Window: " + Arrays.toString(result));


    }
}