package SetInterface;

import java.util.*;
public class SetToList {
    public static void main(String[] args) {
        Set<Integer> mySet = new HashSet<>();
        mySet.add(5);
        mySet.add(3);
        mySet.add(9);
        mySet.add(1);

        List<Integer> myList = new ArrayList<>(mySet);

        Collections.sort(myList);

        System.out.println(myList);
    }
}