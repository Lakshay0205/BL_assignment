import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) /
        2;
        System.out.println("The maximum number of handshakes is: " + maxHandshakes
        );
        }
        }