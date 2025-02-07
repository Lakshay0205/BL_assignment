class Employee {
    String name;
    int id;
    double salary;

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    int teamSize;

    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    String schoolName;

    void displayDetails() {
        super.displayDetails();
        System.out.println("School: " + schoolName);
    }
}

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.name = "Alice";
        manager.id = 101;
        manager.salary = 80000;
        manager.teamSize = 5;

        Developer developer = new Developer();
        developer.name = "Bob";
        developer.id = 102;
        developer.salary = 60000;
        developer.programmingLanguage = "Java";

        Intern intern = new Intern();
        intern.name = "Charlie";
        intern.id = 103;
        intern.salary = 30000;
        intern.schoolName = "XYZ University";

        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
    }
}

