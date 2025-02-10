abstract class Employee {
	private String Name;
	private int EmpId;
	private double baseSalary;
	
	public Employee(String Name, int EmpId, double baseSalary)  {
		this.Name = Name;
		this.EmpId = EmpId;
		this.baseSalary = baseSalary;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	public int getId() {
		return EmpId;
	}
	
	public void setId(int EmpId) {
		this.EmpId = EmpId;
	}
	public double getbaseSalary() {
		return baseSalary;
	}
	
	public void setbaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	abstract double calculateSalary();
	
	public void displayDetails() {
		System.out.println("Employee Name: " + Name);
		System.out.println("Employee Id: " + EmpId);
		System.out.println("Employee Salary: " + calculateSalary());
	}
}

class FulltimeEmployees extends Employee implements Department {
	private String DeapartmentName;
	public FulltimeEmployees(String Name, int empId, double baseSalary) {
		super(Name, empId, baseSalary);
	}
	
	public double calculateSalary() {
		return getbaseSalary();
	}
	public void displayDetails() {
		super.displayDetails();
	}

	public void assignDepartment(String DeapartmentName) {
		this.DeapartmentName = DeapartmentName;
	}

	public String getDepartmentDetails(){
		return DeapartmentName;
	}
}
class ParttimeEmployees extends Employee implements Department {
	int workHours;
	private String DeapartmentName;
	public ParttimeEmployees(String Name, int empId, double baseSalary, int workHours) {
		super(Name, empId, baseSalary);
		this.workHours = workHours;
	}

	public void assignDepartment(String DeapartmentName) {
		this.DeapartmentName = DeapartmentName;
	}

	public String getDepartmentDetails(){
		return DeapartmentName;
	}
	
	public double calculateSalary() {
		return getbaseSalary() * workHours;
	}

	public void displayDetails() {
		super.displayDetails();
		System.out.println("Employee Work Hours: " + workHours);
		
		System.out.println("Employee Department: " + getDepartmentDetails());
	}
}

interface Department {
	void assignDepartment(String DepartmentName);
	String getDepartmentDetails();
}

class ITDepartment implements Department {
	private String DeapartmentName;
	
	public void assignDepartment(String DeapartmentName) {
		this.DeapartmentName = DeapartmentName;
	}
	
	public String getDepartmentDetails(){
		return DeapartmentName;
	}
}

public class EmployeeManagementSystem {
	public static void main(String [] args) {
		FulltimeEmployees emp = new FulltimeEmployees("Akash Pandey", 1023, 50000.50);
        emp.assignDepartment("Software Development"); 
        emp.displayDetails();

		System.out.println("-------------------------------------------------");

        ParttimeEmployees partTimeEmp = new ParttimeEmployees("Rohan Sharma", 4567, 1000, 20);
        partTimeEmp.assignDepartment("Testing");
        partTimeEmp.displayDetails();

		System.out.println("-------------------------------------------------");

        ITDepartment itDept = new ITDepartment();
        itDept.assignDepartment("Cloud Computing");
        System.out.println("IT Department: " + itDept.getDepartmentDetails());

	}
}