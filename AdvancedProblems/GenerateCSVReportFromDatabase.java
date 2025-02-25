package AdvancedProblems;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenerateCSVReportFromDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";
    private static final String OUTPUT_CSV_FILE = "employee_report.csv";

    public static void main(String[] args) {
        generateCSVReport();
    }

    private static void generateCSVReport() {
        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_CSV_FILE))) {

            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            while (resultSet.next()) {
                String id = resultSet.getString("employee_id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");
                writer.write(String.join(",", id, name, department, String.format("%.2f", salary)));
                writer.newLine();
            }

            System.out.println("CSV report generated successfully: " + OUTPUT_CSV_FILE);
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("File writing error: " + e.getMessage());
        }
    }
}
