import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseName;
    private String courseId;
    private Professor professor; // Association: Course has a Professor
    private List<Student> enrolledStudents; // Association: Course has Students

    public Course(String courseName, String courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        professor.addCourse(this); // Bidirectional association
    }

    public void enrollStudent(Student student) {
        this.enrolledStudents.add(student);
        student.addCourse(this); // Bidirectional association
    }

    public void removeStudent(Student student) {
        this.enrolledStudents.remove(student);
        student.removeCourse(this); // Bidirectional association
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName + " (ID: " + courseId + ")");
        if (professor != null) {
            System.out.println("Professor: " + professor.getName());
        } else {
            System.out.println("Professor: Not assigned yet");
        }
        System.out.println("Enrolled Students:");
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled yet.");
        } else {
            for (Student student : enrolledStudents) {
                System.out.println("- " + student.getName());
            }
        }
    }

    @Override
    public String toString() {
        return "Course: " + courseName + " (ID: " + courseId + ")";
    }
}

class Professor {
    private String name;
    private String professorId;
    private String specialization;
    private List<Course> coursesTaught; // Association: Professor teaches Courses

    public Professor(String name, String professorId, String specialization) {
        this.name = name;
        this.professorId = professorId;
        this.specialization = specialization;
        this.coursesTaught = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getProfessorId() {
        return professorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void addCourse(Course course) {
        this.coursesTaught.add(course);
    }

    public void removeCourse(Course course) {
        this.coursesTaught.remove(course);
    }

    public void displayProfessorInfo() {
        System.out.println("Professor Name: " + name + " (ID: " + professorId + "), Specialization: " + specialization);
        System.out.println("Courses Taught:");
        if (coursesTaught.isEmpty()) {
            System.out.println("No courses assigned yet.");
        } else {
            for (Course course : coursesTaught) {
                System.out.println("- " + course.getCourseName());
            }
        }
    }

    @Override
    public String toString() {
        return "Professor: " + name + " (ID: " + professorId + ")";
    }
}

class Student {
    private String name;
    private String studentId;
    private List<Course> enrolledCourses; // Association: Student enrolls in Courses

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void addCourse(Course course) {
        this.enrolledCourses.add(course);
    }

    public void removeCourse(Course course) {
        this.enrolledCourses.remove(course);
    }

    public void displayStudentInfo() {
        System.out.println("Student Name: " + name + " (ID: " + studentId + ")");
        System.out.println("Enrolled Courses:");
        if (enrolledCourses.isEmpty()) {
            System.out.println("Not enrolled in any courses yet.");
        } else {
            for (Course course : enrolledCourses) {
                System.out.println("- " + course.getCourseName());
            }
        }
    }

    @Override
    public String toString() {
        return "Student: " + name + " (ID: " + studentId + ")";
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        Professor profJohn = new Professor("John Doe", "P001", "Computer Science");
        Professor profJane = new Professor("Jane Smith", "P002", "Mathematics");

        Course dataStructures = new Course("Data Structures and Algorithms", "CS101");
        Course calculus = new Course("Calculus I", "MA101");

        Student alice = new Student("Alice", "S001");
        Student bob = new Student("Bob", "S002");
        Student charlie = new Student("Charlie", "S003");

        dataStructures.assignProfessor(profJohn);
        calculus.assignProfessor(profJane);

        alice.addCourse(dataStructures);
        bob.addCourse(dataStructures);
        alice.addCourse(calculus);
        charlie.addCourse(calculus);

        dataStructures.displayCourseInfo();
        System.out.println();
        calculus.displayCourseInfo();
        System.out.println();

        profJohn.displayProfessorInfo();
        System.out.println();
        profJane.displayProfessorInfo();
        System.out.println();

        alice.displayStudentInfo();
        System.out.println();
        bob.displayStudentInfo();
        System.out.println();
        charlie.displayStudentInfo();

        System.out.println("\n--- Removing Bob from Data Structures ---");
        dataStructures.removeStudent(bob);
        dataStructures.displayCourseInfo();
        bob.displayStudentInfo();

        System.out.println("\n--- Removing Data Structures from Alice ---");
        alice.removeCourse(dataStructures);
        alice.displayStudentInfo();
        dataStructures.displayCourseInfo();


    }
}