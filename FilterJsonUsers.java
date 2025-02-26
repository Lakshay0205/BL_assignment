import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilterJsonUsers {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("users.json"));

        List<JsonNode> filteredUsers = new ArrayList<>();
        if (root.isArray()) {
            for (JsonNode user : root) {
                if (user.has("age") && user.get("age").asInt() > 25) {
                    filteredUsers.add(user);
                }
            }
        }

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredUsers));
    }
}