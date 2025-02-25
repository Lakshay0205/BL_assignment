package AdvancedProblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String id;
    private String name;
    private int age;
    private double marks;

    public Student(String id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Age: %d | Marks: %.2f", id, name, age, marks);
    }
}

public class ConvertCSVToStudentObjects {
    public static void main(String[] args) {
        String filePath = "students.csv";
        List<Student> students = readStudentsFromCSV(filePath);
        students.forEach(System.out::println);
    }

    private static List<Student> readStudentsFromCSV(String filePath) {
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 4) {
                    String id = data[0].trim();
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    double marks = Double.parseDouble(data[3].trim());
                    studentList.add(new Student(id, name, age, marks));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
        return studentList;
    }
}