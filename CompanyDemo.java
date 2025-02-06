import java.util.ArrayList;

class Employee {
    private String name;
    private String departmentName; // Added department name for clarity

    public Employee(String name, String departmentName) {
        this.name = name;
        this.departmentName = departmentName;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "Employee: " + name + " (Department: " + departmentName + ")";
    }
}

class Department {
    private String name;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void displayEmployees() {
        System.out.println("Employees in " + name + " department:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // Method to explicitly clear employees (for demonstration)
    public void clearEmployees() {
        this.employees.clear();
        System.out.println("All employees removed from " + name + " department.");
    }

    @Override
    public String toString() {
        return "Department: " + name;
    }
}

class Company {
    private String name;
    private ArrayList<Department> departments;

    public Company(String name) {
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

    public void displayDepartmentsAndEmployees() {
        System.out.println("Company: " + name);
        for (Department department : departments) {
            System.out.println(department);
            department.displayEmployees();
            System.out.println(); // Add a separator for clarity
        }
    }



    //Crucially, a company owns departments so when a company is deleted, its departments and employees should be deleted as well.
    public void clearAll(){
        for(Department d : departments){
            d.clearEmployees(); //remove all employees from each department
        }
        departments.clear(); //remove all departments
        System.out.println("All departments and employees removed from " + name + ".");
    }

    @Override
    public String toString() {
        return "Company: " + name;
    }
}

public class CompanyDemo {
    public static void main(String[] args) {
        Company myCompany = new Company("Acme Corporation");

        Department sales = new Department("Sales");
        Department marketing = new Department("Marketing");

        myCompany.addDepartment(sales);
        myCompany.addDepartment(marketing);

        sales.addEmployee(new Employee("Alice", "Sales"));
        sales.addEmployee(new Employee("Bob", "Sales"));
        marketing.addEmployee(new Employee("Charlie", "Marketing"));

        myCompany.displayDepartmentsAndEmployees();

        System.out.println("\n--- Demonstrating Composition (Deleting the company) ---");
        myCompany.clearAll();  // Delete the company (and its parts)

        myCompany.displayDepartmentsAndEmployees(); //Nothing will be printed because the company is deleted.
    }
}