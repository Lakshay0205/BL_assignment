import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map.Entry;

public class PrintJsonKeysValues {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("data.json"));
        printJson(root);
    }

    static void printJson(JsonNode node) {
        if (node.isObject()) {
            Iterator<Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Entry<String, JsonNode> field = fields.next();
                System.out.println("Key: " + field.getKey() + ", Value: " + field.getValue());
                printJson(field.getValue());
            }
        } else if (node.isArray()) {
            for (JsonNode arrayNode : node) {
                printJson(arrayNode);
            }
        }
    }
}