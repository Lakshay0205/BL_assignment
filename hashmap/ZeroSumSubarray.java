package hashmap;

import java.util.*;

class ZeroSumSubarray {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int cumulativeSum = 0;

        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];
            if (sumMap.containsKey(cumulativeSum)) {
                for (int start : sumMap.get(cumulativeSum)) {
                    result.add(new int[]{start + 1, i});
                }
            }
            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        for (int[] subarray : subarrays) {
            System.out.println("Subarray found from index " + subarray[0] + " to " + subarray[1]);
        }
    }
}