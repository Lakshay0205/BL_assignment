public class Student {

    private static String universityName = "Example University"; // Static variable
    private static int totalStudents = 0; // Static variable

    private final int rollNumber; // Final variable
    private String name;
    private char grade;

    // Constructor using 'this'
    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber; // Initializing the final variable
        this.grade = grade;
        totalStudents++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public static void displayUniversityName() { // Static method
        System.out.println("University Name: " + universityName);
    }

    public static void displayTotalStudents() { // Static method
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayStudentDetails() {
        if (this instanceof Student) { // Using instanceof
            System.out.println("Roll Number: " + rollNumber); // Accessing final variable
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Not a Student instance.");
        }
    }


    public void updateGrade(char newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated successfully for " + name);
        } else {
            System.out.println("Not a Student instance. Cannot update grade.");
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Akash Pandey", 101, 'A');
        Student student2 = new Student("Aditya Vardhan Singh", 102, 'B');
        Student student3 = new Student("Mayank Varshney", 103, 'C');

        Student.displayUniversityName(); // Calling static method
        Student.displayTotalStudents();

        student1.displayStudentDetails();
        System.out.println("--------------------");
        student2.displayStudentDetails();
        System.out.println("--------------------");
        student3.displayStudentDetails();

        student2.updateGrade('A');
        student2.displayStudentDetails();

    }
}