package hashmap;

import java.util.HashMap;
import java.util.Map;

public class PairSum {

    public static boolean hasPairWithSum(int[] arr, int target) {
        if (arr == null || arr.length < 2) {
            return false;
        }

        Map<Integer, Boolean> seen = new HashMap<>(); 

        for (int num : arr) {
            int complement = target - num;

            if (seen.containsKey(complement)) {
                return true;
            }

            seen.put(num, true); 
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        boolean found = hasPairWithSum(arr, target);
        System.out.println("Has pair with sum " + target + "? " + found); 

        arr = new int[]{1, 2, 3, 4, 5};
        target = 10;
        found = hasPairWithSum(arr, target);
        System.out.println("Has pair with sum " + target + "? " + found); 
        arr = new int[]{1, 2, 3, 4, 5};
        target = 7;
        found = hasPairWithSum(arr, target);
        System.out.println("Has pair with sum " + target + "? " + found); 

        arr = new int[]{1, 2, 3, 4, 5};
        target = 2;
        found = hasPairWithSum(arr, target);
        System.out.println("Has pair with sum " + target + "? " + found); 

        arr = new int[]{};
        target = 2;
        found = hasPairWithSum(arr, target);
        System.out.println("Has pair with sum " + target + "? " + found);


        arr = null;
        target = 2;
        found = hasPairWithSum(arr, target);
        System.out.println("Has pair with sum " + target + "? " + found);
    }
}