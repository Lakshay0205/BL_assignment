interface Refuelable {
    void refuel();
}

class Vehicle {
    int maxSpeed;
    String model;
}

class ElectricVehicle extends Vehicle {
    int batteryCapacity;

    void charge() {
        System.out.println("Charging the electric vehicle.");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    double fuelCapacity;

    public void refuel() {
        System.out.println("Refueling the petrol vehicle.");
    }
}

public class Main {
    public static void main(String[] args) {
        ElectricVehicle electricCar = new ElectricVehicle();
        electricCar.maxSpeed = 150;
        electricCar.model = "Tesla Model S";
        electricCar.batteryCapacity = 100;

        PetrolVehicle petrolCar = new PetrolVehicle();
        petrolCar.maxSpeed = 180;
        petrolCar.model = "BMW 320i";
        petrolCar.fuelCapacity = 50;

        System.out.println(electricCar.model + " - Max Speed: " + electricCar.maxSpeed + " km/h");
        electricCar.charge();
        System.out.println();

        System.out.println(petrolCar.model + " - Max Speed: " + petrolCar.maxSpeed + " km/h");
        petrolCar.refuel();
    }
}

