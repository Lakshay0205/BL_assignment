import java.io.*;

public class StudentDataStorage {

    public static void main(String[] args) {
        String filename = "student_data.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {

            dos.writeInt(123);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);

            dos.writeInt(456);
            dos.writeUTF("Bob");
            dos.writeDouble(3.5);

        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }


        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {

            int roll1 = dis.readInt();
            String name1 = dis.readUTF();
            double gpa1 = dis.readDouble();

            int roll2 = dis.readInt();
            String name2 = dis.readUTF();
            double gpa2 = dis.readDouble();

            System.out.println("Student 1: Roll=" + roll1 + ", Name=" + name1 + ", GPA=" + gpa1);
            System.out.println("Student 2: Roll=" + roll2 + ", Name=" + name2 + ", GPA=" + gpa2);

        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}