package SetInterface;

import java.util.HashSet;
import java.util.Set;

public class SetEqualityChecker {

    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        if (set1 == null || set2 == null) {
            return set1 == set2; 
        }

        if (set1.size() != set2.size()) {
            return false;
        }

        return set1.equals(set2);
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        System.out.println("Sets are equal: " + areSetsEqual(set1, set2));
    }
}
