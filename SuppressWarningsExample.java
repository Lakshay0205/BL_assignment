import java.util.ArrayList;

public class SuppressWarningsExample {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList myList = new ArrayList(); // No generics, causes unchecked warning
        myList.add("Hello");
        myList.add(123);

        for (Object item : myList) {
            System.out.println(item);
        }
    }
}