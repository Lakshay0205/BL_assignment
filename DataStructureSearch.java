import java.util.*;

public class DataStructureSearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));

        System.out.println("Array contains 3? " + Arrays.stream(arr).anyMatch(x -> x == 3));
        System.out.println("HashSet contains 3? " + hashSet.contains(3));
        System.out.println("TreeSet contains 3? " + treeSet.contains(3));
    }
}
