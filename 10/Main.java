interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;
}

class Chef extends Person implements Worker {
    String specialty;

    public void performDuties() {
        System.out.println("Chef is cooking and preparing meals.");
    }
}

class Waiter extends Person implements Worker {
    String section;

    public void performDuties() {
        System.out.println("Waiter is serving food and attending customers.");
    }
}

public class Main {
    public static void main(String[] args) {
        Chef chef = new Chef();
        chef.name = "Gordon Ramsay";
        chef.id = 101;
        chef.specialty = "French Cuisine";

        Waiter waiter = new Waiter();
        waiter.name = "John Doe";
        waiter.id = 102;
        waiter.section = "VIP Section";

        System.out.println(chef.name + " (Chef) - Specialty: " + chef.specialty);
        chef.performDuties();
        System.out.println();

        System.out.println(waiter.name + " (Waiter) - Section: " + waiter.section);
        waiter.performDuties();
    }
}

