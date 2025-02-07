class Person {
    String name;
    int age;

    void displayRole() {
        System.out.println("Person");
    }
}

class Teacher extends Person {
    String subject;

    void displayRole() {
        System.out.println("Teacher");
        System.out.println("Subject: " + subject);
    }
}

class Student extends Person {
    String grade;

    void displayRole() {
        System.out.println("Student");
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person {
    String department;

    void displayRole() {
        System.out.println("Staff");
        System.out.println("Department: " + department);
    }
}

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.name = "Mr. Smith";
        teacher.age = 35;
        teacher.subject = "Math";

        Student student = new Student();
        student.name = "Alice";
        student.age = 16;
        student.grade = "10th";

        Staff staff = new Staff();
        staff.name = "John";
        staff.age = 40;
        staff.department = "Administration";

        teacher.displayRole();
        student.displayRole();
        staff.displayRole();
    }
}

