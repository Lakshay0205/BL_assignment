import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import java.util.Set;

public class EmailValidation {

    public static boolean validateEmail(String email) {
        try {
            String schemaJson = "{\"$schema\": \"http://json-schema.org/draft-07/schema#\", \"type\": \"object\", \"properties\": {\"email\": {\"type\": \"string\", \"format\": \"email\"}}, \"required\": [\"email\"]}";
            String json = "{\"email\": \"" + email + "\"}";

            ObjectMapper mapper = new ObjectMapper();
            JsonNode schemaNode = mapper.readTree(schemaJson);
            JsonNode jsonNode = mapper.readTree(json);

            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionDraft7);
            JsonSchema schema = factory.getSchema(schemaNode);

            Set<ValidationMessage> errors = schema.validate(jsonNode);
            return errors.isEmpty();

        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String validEmail = "test@example.com";
        String invalidEmail = "invalid-email";

        System.out.println(validEmail + " is valid: " + validateEmail(validEmail));
        System.out.println(invalidEmail + " is valid: " + validateEmail(invalidEmail));
    }
}