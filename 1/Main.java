class Animal {
    String name;
    int age;

    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Meow");
    }
}

class Bird extends Animal {
    void makeSound() {
        System.out.println("Chirp");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal bird = new Bird();

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}

