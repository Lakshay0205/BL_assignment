import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

public class JsonValidation {

    public static boolean validateJson(String json, String schemaJson) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(json);
            JsonNode schemaNode = mapper.readTree(schemaJson);
            JsonSchema schema = mapper.readValue(schemaNode.toString(), JsonSchema.class);
            return schema.validate(jsonNode).isSuccess();
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String json = "{\"name\":\"John\", \"age\":30}";
        String schemaJson = "{\"type\":\"object\", \"properties\":{\"name\":{\"type\":\"string\"}, \"age\":{\"type\":\"integer\"}}, \"required\":[\"name\", \"age\"]}";

        boolean isValid = validateJson(json, schemaJson);
        System.out.println("JSON is valid: " + isValid);

        String invalidJson = "{\"name\":\"John\", \"age\":\"abc\"}";
        boolean isInvalidValid = validateJson(invalidJson, schemaJson);
        System.out.println("JSON is valid: " + isInvalidValid);

    }
}