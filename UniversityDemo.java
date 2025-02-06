import java.util.ArrayList;

class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Faculty: " + name + " (" + specialization + ")";
    }
}

class Department {
    private String name;
    private ArrayList<Faculty> facultyMembers; // Aggregation

    public Department(String name) {
        this.name = name;
        this.facultyMembers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addFaculty(Faculty faculty) {
        this.facultyMembers.add(faculty);
    }

    public void removeFaculty(Faculty faculty) {
        this.facultyMembers.remove(faculty);
    }

    public ArrayList<Faculty> getFacultyMembers() {
        return facultyMembers;
    }

    public void displayFaculty() {
        System.out.println("Faculty in " + name + " department:");
        for (Faculty faculty : facultyMembers) {
            System.out.println(faculty);
        }
    }

    // For composition demonstration (clearing faculty before department deletion)
    public void clearFaculty() {
        this.facultyMembers.clear();
        System.out.println("All faculty removed from " + name + " department.");
    }

    @Override
    public String toString() {
        return "Department: " + name;
    }
}

class University {
    private String name;
    private ArrayList<Department> departments; // Composition

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public void removeDepartment(Department department) {
        this.departments.remove(department);
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }


    public void displayUniversityDetails() {
        System.out.println("University: " + name);
        for (Department department : departments) {
            System.out.println(department);
            department.displayFaculty();
            System.out.println(); // Separator for clarity
        }
    }

    // Crucial for composition: Deleting university deletes departments
    public void clearAll() {
        for (Department d : departments) {
            d.clearFaculty(); // Remove faculty from departments first (aggregation demo)
        }
        departments.clear(); // Remove all departments (composition)
        System.out.println("All departments removed from " + name + ".");
    }

    @Override
    public String toString() {
        return "University: " + name;
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        University myUniversity = new University("Oxford University");

        Department scienceDept = new Department("Science");
        Department artsDept = new Department("Arts");

        myUniversity.addDepartment(scienceDept);
        myUniversity.addDepartment(artsDept);

        Faculty profSmith = new Faculty("Dr. Smith", "Physics");
        Faculty profJones = new Faculty("Prof. Jones", "Literature");
        Faculty profLee = new Faculty("Dr. Lee", "Chemistry"); // Independent faculty

        scienceDept.addFaculty(profSmith);
        scienceDept.addFaculty(profLee);
        artsDept.addFaculty(profJones);

        myUniversity.displayUniversityDetails();

        System.out.println("\n--- Demonstrating Composition (Deleting University) ---");
        myUniversity.clearAll(); // Delete the university

        myUniversity.displayUniversityDetails(); // Departments are gone

        System.out.println("\n--- Demonstrating Aggregation (Faculty Independence) ---");
        System.out.println(profLee); // Prof. Lee still exists even after university and science department are deleted.

        //Illustrate adding the faculty to another department
        Department engineeringDept = new Department("Engineering");
        myUniversity.addDepartment(engineeringDept);
        engineeringDept.addFaculty(profLee);
        myUniversity.displayUniversityDetails();
    }
}