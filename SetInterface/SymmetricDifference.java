package SetInterface;

import java.util.*;

public class SymmetricDifference {
    public static Set<Integer> findSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        
        result.removeAll(intersection);
        
        return result;
    }
    
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        
        Set<Integer> symmetricDifference = findSymmetricDifference(set1, set2);
        
        System.out.println("Symmetric Difference: " + symmetricDifference);
    }
}
