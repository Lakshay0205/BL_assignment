import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String name;

    public CourseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course Type: " + name;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + ", " + courseType;
    }
}

class Department {
    private String departmentName;
    private List<Course<?>> courses = new ArrayList<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addCourse(Course<?> course) {
        courses.add(course);
    }

    public void displayCourses() {
        System.out.println("Department: " + departmentName);
        for (Course<?> course : courses) {
            System.out.println(course);
        }
    }
}

public class UniversityCourseSystem {
    public static void main(String[] args) {
        Department computerScience = new Department("Computer Science");
        computerScience.addCourse(new Course<>("Data Structures", new ExamCourse()));
        computerScience.addCourse(new Course<>("Software Engineering", new AssignmentCourse()));
        computerScience.addCourse(new Course<>("Artificial Intelligence", new ResearchCourse()));


        Department physics = new Department("Physics");
        physics.addCourse(new Course<>("Quantum Mechanics", new ExamCourse()));
        physics.addCourse(new Course<>("Electromagnetism", new AssignmentCourse()));

        computerScience.displayCourses();
        System.out.println();
        physics.displayCourses();
    }
}