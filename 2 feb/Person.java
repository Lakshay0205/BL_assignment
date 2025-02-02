import java.util.Scanner;

public class Person {

    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
        this.address = other.address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for Person 1:");
        System.out.print("Name: ");
        String name1 = scanner.nextLine();
        System.out.print("Age: ");
        int age1 = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Address: ");
        String address1 = scanner.nextLine();

        Person person1 = new Person(name1, age1, address1);
        System.out.println("Person 1: " + person1);


        Person person2 = new Person(person1); // Copy
        System.out.println("Person 2 (Copy): " + person2);

        System.out.println("\nEnter new details for Person 1 (to show copy is independent):");
        System.out.print("Name: ");
        person1.name = scanner.nextLine();
        System.out.print("Age: ");
        person1.age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Address: ");
        person1.address = scanner.nextLine();


        System.out.println("Person 1 (Modified): " + person1);
        System.out.println("Person 2 (Copy - Unchanged): " + person2);

    }
}