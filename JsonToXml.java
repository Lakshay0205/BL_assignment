import org.json.JSONObject;
import org.json.XML;

public class JsonToXml {

    public static String convertJsonToXml(String jsonString) {
        try {
            JSONObject json = new JSONObject(jsonString);
            return XML.toString(json);
        } catch (org.json.JSONException e) {
            return "Invalid JSON";
        }
    }

    public static void main(String[] args) {
        String json = "{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"}";
        String xml = convertJsonToXml(json);
        System.out.println(xml);

        String jsonArray = "{\"people\": [{\"name\": \"Alice\", \"age\": 25}, {\"name\": \"Bob\", \"age\": 35}]}";
        String xmlArray = convertJsonToXml(jsonArray);
        System.out.println(xmlArray);

        String invalidJson = "{invalid}";
        String invalidXml = convertJsonToXml(invalidJson);
        System.out.println(invalidXml);
    }
}