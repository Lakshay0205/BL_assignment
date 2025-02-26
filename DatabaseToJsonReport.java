import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseToJsonReport {

    public static String generateJsonReport(String dbUrl, String dbUser, String dbPassword, String sqlQuery) throws SQLException, Exception {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode jsonArray = mapper.createArrayNode();

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                ObjectNode jsonObject = mapper.createObjectNode();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = resultSet.getObject(i);
                    jsonObject.putPOJO(columnName, columnValue);
                }
                jsonArray.add(jsonObject);
            }
        }
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);
    }

    public static void main(String[] args) {
        String dbUrl = "jdbc:your_db_type://your_host:your_port/your_database"; // Replace with your database URL
        String dbUser = "your_username"; // Replace with your database username
        String dbPassword = "your_password"; // Replace with your database password
        String sqlQuery = "SELECT * FROM your_table"; // Replace with your SQL query

        try {
            String jsonReport = generateJsonReport(dbUrl, dbUser, dbPassword, sqlQuery);
            System.out.println(jsonReport);
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e){
            System.err.println("General Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}