package MapInterface;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    String department;
    
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    
    @Override
    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(e -> e.department));
    }
    
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );
        
        Map<String, List<Employee>> groupedEmployees = groupByDepartment(employees);
        System.out.println("Employees grouped by department: " + groupedEmployees);
    }
}
