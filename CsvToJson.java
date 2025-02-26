import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CsvToJson {

    public static String convertCsvToJson(String csvFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode jsonArray = mapper.createArrayNode();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            String[] headers = br.readLine().split(",");

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                ObjectNode jsonObject = mapper.createObjectNode();

                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i].trim(), values[i].trim());
                }
                jsonArray.add(jsonObject);
            }
        }
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);
    }

    public static void main(String[] args) {
        String csvFilePath = "data.csv"; // Replace with your CSV file path

        try {
            String json = convertCsvToJson(csvFilePath);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}