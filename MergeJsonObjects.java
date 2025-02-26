import org.json.JSONObject;

public class MergeJsonObjects {

    public static JSONObject merge(JSONObject obj1, JSONObject obj2) {
        JSONObject merged = new JSONObject(obj1.toString());
        obj2.keySet().forEach(key -> merged.put(key, obj2.get(key)));
        return merged;
    }

    public static void main(String[] args) {
        JSONObject obj1 = new JSONObject("{\"name\":\"Alice\",\"age\":30}");
        JSONObject obj2 = new JSONObject("{\"city\":\"New York\",\"email\":\"alice@example.com\"}");
        JSONObject merged = merge(obj1, obj2);
        System.out.println(merged.toString());
    }
}