import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilterJsonByAge {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("data.json"));

        List<JsonNode> filteredRecords = new ArrayList<>();
        if (root.isArray()) {
            for (JsonNode node : root) {
                if (node.has("age") && node.get("age").asInt() > 25) {
                    filteredRecords.add(node);
                }
            }
        }

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredRecords));
    }
}