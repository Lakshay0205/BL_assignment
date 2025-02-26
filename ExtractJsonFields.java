import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExtractJsonFields {

    public static void main(String[] args) {
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("data.json")));
            JSONObject json = new JSONObject(jsonString);
            String name = json.getString("name");
            String email = json.getString("email");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}