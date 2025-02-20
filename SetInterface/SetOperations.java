package SetInterface;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {

    public static Set<Object> union(Set<Object> set1, Set<Object> set2) {
        if (set1 == null && set2 == null) {
            return new HashSet<>(); // Or null, depending on your preference
        }
        if (set1 == null) return set2;
        if (set2 == null) return set1;

        Set<Object> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    public static Set<Object> intersection(Set<Object> set1, Set<Object> set2) {
        if (set1 == null || set2 == null) {
            return new HashSet<>(); // Or null, depending on your preference
        }

        Set<Object> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        return intersectionSet;
    }

    public static void main(String[] args) {
        Set<Object> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Object> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Object> unionSet = union(set1, set2);
        Set<Object> intersectionSet = intersection(set1, set2);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Union: " + unionSet);
        System.out.println("Intersection: " + intersectionSet);

        Set<Object> set3 = new HashSet<>();
        set3.add("apple");
        set3.add("banana");

        Set<Object> set4 = new HashSet<>();
        set4.add("banana");
        set4.add("orange");

        Set<Object> unionSetStr = union(set3, set4);
        Set<Object> intersectionSetStr = intersection(set3, set4);

        System.out.println("Set 3: " + set3);
        System.out.println("Set 4: " + set4);
        System.out.println("Union: " + unionSetStr);
        System.out.println("Intersection: " + intersectionSetStr);

        Set<Object> set5 = null;
        Set<Object> set6 = new HashSet<>();
        System.out.println("Union of null and set: " + union(set5, set6));
        System.out.println("Intersection of null and set: " + intersection(set5, set6));

    }
}