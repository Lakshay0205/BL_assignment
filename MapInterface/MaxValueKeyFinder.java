package MapInterface;

import java.util.*;

public class MaxValueKeyFinder {
    public static String findKeyWithMaxValue(Map<String, Integer> inputMap) {
        return Collections.max(inputMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    
    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);
        
        String maxKey = findKeyWithMaxValue(inputMap);
        System.out.println("Key with the highest value: " + maxKey);
    }
}
