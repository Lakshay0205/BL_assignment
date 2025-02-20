package MapInterface;

import java.util.*;

public class MergeMaps {
    public static Map<String, Integer> mergeTwoMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1);
        
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        
        return mergedMap;
    }
    
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        
        Map<String, Integer> mergedMap = mergeTwoMaps(map1, map2);
        System.out.println("Merged Map: " + mergedMap);
    }
}
