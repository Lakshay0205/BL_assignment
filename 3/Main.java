class Vehicle {
    int maxSpeed;
    String fuelType;

    void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
    }
}

class Car extends Vehicle {
    int seatCapacity;

    void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    double loadCapacity;

    void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity);
    }
}

class Motorcycle extends Vehicle {
    boolean hasSidecar;

    void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + hasSidecar);
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        Car car = new Car();
        car.maxSpeed = 180;
        car.fuelType = "Petrol";
        car.seatCapacity = 5;

        Truck truck = new Truck();
        truck.maxSpeed = 120;
        truck.fuelType = "Diesel";
        truck.loadCapacity = 2000;

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.maxSpeed = 160;
        motorcycle.fuelType = "Petrol";
        motorcycle.hasSidecar = false;

        vehicles[0] = car;
        vehicles[1] = truck;
        vehicles[2] = motorcycle;

        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            System.out.println("---------------");
        }
    }
}

