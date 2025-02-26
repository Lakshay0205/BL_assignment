import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class ListToJsonArray2 {

    static class Item {
        String name;
        int quantity;

        public Item(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    public static void main(String[] args) throws Exception {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Apple", 10));
        items.add(new Item("Banana", 5));
        items.add(new Item("Orange", 8));

        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = mapper.writeValueAsString(items);
        System.out.println(jsonArray);
    }
}