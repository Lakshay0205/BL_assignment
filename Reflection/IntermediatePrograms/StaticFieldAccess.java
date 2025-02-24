package Reflection.IntermediatePrograms;
import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "default_key";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class StaticFieldAccess {

    public static void main(String[] args) {
        try {
            Field apiKeyField = Configuration.class.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true);

            System.out.println("Original API Key: " + Configuration.getApiKey());

            apiKeyField.set(null, "new_api_key"); // null for static fields

            System.out.println("Modified API Key: " + Configuration.getApiKey());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}