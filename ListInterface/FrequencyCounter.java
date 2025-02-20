package ListInterface;
import java.util.*;public class FrequencyCounter {

    public static Map<String, Integer> countFrequencies (List<String> strings) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String str: strings) {
                frequencyMap.put(str, frequencyMap.getOrDefault(str,0) + 1);
        }
        return frequencyMap;
    }
    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana","apple","orange","orange","banana","watermelon"); 

        Map <String, Integer> frequency = countFrequencies(list);
        System.out.println(frequency);
    }
}
