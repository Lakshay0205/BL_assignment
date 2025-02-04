public class Employee {

    private static String companyName = "Acme Corporation"; // Static variable
    private static int totalEmployees = 0; // Static variable

    private final int id; // Final variable
    private String name;
    private String designation;

    // Constructor using 'this'
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id; // Initializing the final variable
        this.designation = designation;
        totalEmployees++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getId() {
        return id;
    }


    public static void displayCompanyName() { // Static method
        System.out.println("Company Name: " + companyName);
    }

    public static void displayTotalEmployees() { // Static method
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayEmployeeDetails() {
        if (this instanceof Employee) { // Using instanceof
            System.out.println("ID: " + id); // Accessing final variable
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Not an Employee instance.");
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Akash Pandey", 101, "Software Engineer");
        Employee emp2 = new Employee("Lakshay Sharma", 102, "Data Scientist");
        Employee emp3 = new Employee("Mayank Varshney", 103, "Project Manager");

        Employee.displayCompanyName(); // Calling static method
        Employee.displayTotalEmployees();

        emp1.displayEmployeeDetails();
        System.out.println("--------------------");
        emp2.displayEmployeeDetails();
        System.out.println("--------------------");
        emp3.displayEmployeeDetails();
    }
}