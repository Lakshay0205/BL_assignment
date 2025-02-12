class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head;

    // Insert a student at the beginning
    public void addStudentAtBeginning(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Insert a student at the end
    public void addStudentAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Insert a student at a specific position (1-based index)
    public void addStudentAtPosition(int position, int rollNumber, String name, int age, char grade) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            addStudentAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete a student by roll number
    public void deleteStudent(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student not found");
            return;
        }
        temp.next = temp.next.next;
    }

    // Search for a student by roll number
    public Student searchStudent(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Update a student's grade by roll number
    public void updateStudentGrade(int rollNumber, char newGrade) {
        Student student = searchStudent(rollNumber);
        if (student != null) {
            student.grade = newGrade;
        } else {
            System.out.println("Student not found");
        }
    }

    // Display all student records
    public void displayStudents() {
        if (head == null) {
            System.out.println("No student records available");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecord {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();
        list.addStudentAtEnd(101, "Aditya", 21, 'A');
        list.addStudentAtEnd(102, "Yash", 21, 'B');
        list.addStudentAtBeginning(103, "Anirudh", 21, 'C');
        list.addStudentAtPosition(2, 104, "Adarsh", 21, 'B');
        
        System.out.println("All students:");
        list.displayStudents();
        
        System.out.println("\nUpdating grade of Roll No 102");
        list.updateStudentGrade(102, 'A');
        list.displayStudents();
        
        System.out.println("\nDeleting student with Roll No 103");
        list.deleteStudent(103);
        list.displayStudents();
    }
}
