package AdvancedProblems;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class Student {
    private String id;
    private String name;
    private int age;
    private double marks;
    private String grade;

    public Student(String id, String name, int age, double marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Age: %d | Marks: %.2f | Grade: %s", id, name, age, marks, grade);
    }

    public String toCSV() {
        return String.join(",", id, name, String.valueOf(age), String.format("%.2f", marks), grade);
    }
}

public class MergeCSVFiles {
    public static void main(String[] args) {
        String filePath1 = "students1.csv";
        String filePath2 = "students2.csv";
        String outputFilePath = "merged_students.csv";
        mergeCSVFiles(filePath1, filePath2, outputFilePath);
    }

    private static void mergeCSVFiles(String filePath1, String filePath2, String outputFilePath) {
        Map<String, String[]> studentDetails = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(filePath1))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br1.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 3) {
                    studentDetails.put(data[0].trim(), new String[]{data[1].trim(), data[2].trim()});
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the first file: " + e.getMessage());
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader(filePath2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            String line;
            boolean isFirstLine = true;
            while ((line = br2.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length == 3) {
                    String id = data[0].trim();
                    String[] details = studentDetails.get(id);
                    if (details != null) {
                        String name = details[0];
                        int age = Integer.parseInt(details[1]);
                        double marks = Double.parseDouble(data[1].trim());
                        String grade = data[2].trim();
                        Student student = new Student(id, name, age, marks, grade);
                        bw.write(student.toCSV());
                        bw.newLine();
                    }
                }
            }
            System.out.println("Merged student records saved to " + outputFilePath);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing the second file: " + e.getMessage());
        }
    }
}
