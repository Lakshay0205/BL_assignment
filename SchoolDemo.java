import java.util.ArrayList;

class Course {
    private String name;
    private String instructor;
    private ArrayList<Student> enrolledStudents;

    public Course(String name, String instructor) {
        this.name = name;
        this.instructor = instructor;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void addStudent(Student student) {
        this.enrolledStudents.add(student);
        student.enrollInCourse(this); // Maintain the relationship from both sides
    }

    public void removeStudent(Student student) {
        this.enrolledStudents.remove(student);
        student.dropCourse(this); // Maintain the relationship from both sides
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void displayEnrolledStudents() {
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students are enrolled in " + name + ".");
        } else {
            System.out.println("Students enrolled in " + name + ":");
            for (Student student : enrolledStudents) {
                System.out.println(student.getName());
            }
        }
    }

    @Override
    public String toString() {
        return "Course: " + name + " (Instructor: " + instructor + ")";
    }
}

class Student {
    private String name;
    private int studentId;
    private ArrayList<Course> enrolledCourses;
    private School school; // Aggregation: Student belongs to a School

    public Student(String name, int studentId, School school) {
        this.name = name;
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
        this.school = school;
        school.addStudent(this); // Add student to the school
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public School getSchool() {
        return school;
    }

    public void enrollInCourse(Course course) {
        this.enrolledCourses.add(course);
    }

    public void dropCourse(Course course) {
        this.enrolledCourses.remove(course);
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void displayEnrolledCourses() {
        if (enrolledCourses.isEmpty()) {
            System.out.println(name + " is not enrolled in any courses.");
        } else {
            System.out.println("Courses enrolled by " + name + ":");
            for (Course course : enrolledCourses) {
                System.out.println(course.getName());
            }
        }
    }

    @Override
    public String toString() {
        return "Student: " + name + " (ID: " + studentId + ")";
    }
}

class School {
    private String name;
    private ArrayList<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public void displayStudents() {
        System.out.println("Students in " + name + " school:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public String toString() {
        return "School: " + name;
    }
}

public class SchoolDemo {
    public static void main(String[] args) {
        School mySchool = new School("Springfield High");

        Student alice = new Student("Alice", 123, mySchool);
        Student bob = new Student("Bob", 456, mySchool);
        Student charlie = new Student("Charlie", 789, mySchool);

        Course math = new Course("Mathematics", "Mr. Smith");
        Course science = new Course("Science", "Ms. Johnson");
        Course history = new Course("History", "Mr. Brown");

        alice.enrollInCourse(math);
        alice.enrollInCourse(science);
        bob.enrollInCourse(science);
        charlie.enrollInCourse(history);
        charlie.enrollInCourse(math);


        math.displayEnrolledStudents();
        science.displayEnrolledStudents();
        history.displayEnrolledStudents();

        alice.displayEnrolledCourses();
        bob.displayEnrolledCourses();
        charlie.displayEnrolledCourses();

        mySchool.displayStudents();

        //Demonstrating Aggregation: Removing a student from school doesn't delete the student or their courses
        mySchool.removeStudent(bob);
        System.out.println("\n--- After removing Bob from school ---");
        mySchool.displayStudents();
        bob.displayEnrolledCourses();// Bob still exists and is enrolled in Science

    }
}