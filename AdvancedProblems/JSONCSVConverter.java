package AdvancedProblems;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String id;
    private String name;
    private int age;
    private double marks;

    public Student() {}

    public Student(String id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Age: %d | Marks: %.2f", id, name, age, marks);
    }
}

public class JSONCSVConverter {
    private static final String JSON_FILE = "students.json";
    private static final String CSV_FILE = "students.csv";

    public static void main(String[] args) {
        jsonToCSV(JSON_FILE, CSV_FILE);
        csvToJSON(CSV_FILE, "converted_students.json");
    }

    private static void jsonToCSV(String jsonFilePath, String csvFilePath) {
        ObjectMapper mapper = new ObjectMapper();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
            List<Student> students = mapper.readValue(new File(jsonFilePath), new TypeReference<List<Student>>() {});
            writer.write("ID,Name,Age,Marks");
            writer.newLine();

            for (Student student : students) {
                writer.write(String.join(",",
                        student.getId(),
                        student.getName(),
                        String.valueOf(student.getAge()),
                        String.format("%.2f", student.getMarks())));
                writer.newLine();
            }
            System.out.println("JSON converted to CSV successfully: " + csvFilePath);
        } catch (IOException e) {
            System.err.println("Error converting JSON to CSV: " + e.getMessage());
        }
    }

    private static void csvToJSON(String csvFilePath, String jsonFilePath) {
        ObjectMapper mapper = new ObjectMapper();
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 4) {
                    students.add(new Student(
                            data[0].trim(),
                            data[1].trim(),
                            Integer.parseInt(data[2].trim()),
                            Double.parseDouble(data[3].trim())));
                }
            }
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFilePath), students);
            System.out.println("CSV converted to JSON successfully: " + jsonFilePath);
        } catch (IOException e) {
            System.err.println("Error converting CSV to JSON: " + e.getMessage());
        }
    }
}