package AdvancedProblems;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

class Student {
    private String id;
    private String name;
    private int age;
    private String email;
    private String salary;

    public Student() {}

    public Student(String id, String name, int age, String email, String salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.salary = salary;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getSalary() { return salary; }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Age: %d | Email: %s | Salary: %s",
                id, name, age, email, salary);
    }
}

public class EncryptDecryptCSV {
    private static final String JSON_FILE = "students.json";
    private static final String CSV_FILE = "students_encrypted.csv";
    private static final String DECRYPTED_JSON_FILE = "students_decrypted.json";
    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = "1234567890123456".getBytes();

    public static void main(String[] args) {
        jsonToEncryptedCSV(JSON_FILE, CSV_FILE);
        encryptedCSVToJSON(CSV_FILE, DECRYPTED_JSON_FILE);
    }

    private static void jsonToEncryptedCSV(String jsonFilePath, String csvFilePath) {
        ObjectMapper mapper = new ObjectMapper();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
            List<Student> students = mapper.readValue(new File(jsonFilePath), new TypeReference<List<Student>>() {});
            writer.write("ID,Name,Age,Email,Salary");
            writer.newLine();

            for (Student student : students) {
                writer.write(String.join(",",
                        student.getId(),
                        student.getName(),
                        String.valueOf(student.getAge()),
                        encrypt(student.getEmail()),
                        encrypt(student.getSalary())));
                writer.newLine();
            }
            System.out.println("JSON converted to encrypted CSV successfully: " + csvFilePath);
        } catch (IOException | GeneralSecurityException e) {
            System.err.println("Error converting JSON to encrypted CSV: " + e.getMessage());
        }
    }

    private static void encryptedCSVToJSON(String csvFilePath, String jsonFilePath) {
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
                if (data.length == 5) {
                    students.add(new Student(
                            data[0].trim(),
                            data[1].trim(),
                            Integer.parseInt(data[2].trim()),
                            decrypt(data[3].trim()),
                            decrypt(data[4].trim())));
                }
            }
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFilePath), students);
            System.out.println("Encrypted CSV converted to JSON successfully: " + jsonFilePath);
        } catch (IOException | GeneralSecurityException e) {
            System.err.println("Error converting encrypted CSV to JSON: " + e.getMessage());
        }
    }

    private static String encrypt(String data) throws GeneralSecurityException {
        SecretKey secretKey = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    private static String decrypt(String encryptedData) throws GeneralSecurityException {
        SecretKey secretKey = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted);
    }
}