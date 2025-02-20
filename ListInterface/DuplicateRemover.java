package ListInterface;
import java.util.*;

public class DuplicateRemover {

    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new LinkedHashSet<>();
        List<T> result = new ArrayList<>();

        for (T item : list) {
            if (seen.add(item)) {
                result.add(item);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>();
        inputList.add(3);
        inputList.add(1);
        inputList.add(2);
        inputList.add(2);
        inputList.add(3);
        inputList.add(4);

        List<Integer> outputList = removeDuplicates(inputList);
        System.out.println("Input list: " + inputList);
        System.out.println("Output list: " + outputList);

        List<String> inputListStr = new ArrayList<>();
        inputListStr.add("apple");
        inputListStr.add("banana");
        inputListStr.add("apple");
        inputListStr.add("orange");
        List<String> outputListStr = removeDuplicates(inputListStr);
        System.out.println("Input list: " + inputListStr);
        System.out.println("Output list: " + outputListStr);

    }
}