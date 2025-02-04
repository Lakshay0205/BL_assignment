public class Vehicle {

    private static double registrationFee = 100.0; // Static variable

    private final String registrationNumber; // Final variable
    private String ownerName;
    private String vehicleType;

    private static int nextRegistrationNumber = 1000; // To generate unique registration numbers

    // Constructor using 'this'
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = String.valueOf(nextRegistrationNumber++); // Assign unique ID and increment
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public static double getRegistrationFee() {
        return registrationFee;
    }

    public static void updateRegistrationFee(double newFee) { // Static method
        if (newFee >= 0) { // Valid fee (cannot be negative)
            registrationFee = newFee;
        } else {
            System.out.println("Invalid registration fee. Must be non-negative.");
        }
    }

    public void displayRegistrationDetails() {
        if (this instanceof Vehicle) { // Using instanceof
            System.out.println("Registration Number: " + registrationNumber); // Accessing final variable
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.out.println("Not a Vehicle instance.");
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Akash Pandey", "Car");
        Vehicle vehicle2 = new Vehicle("Lakshay Sharma", "Motorcycle");
        Vehicle vehicle3 = new Vehicle("Mayank Varshney", "Truck");


        Vehicle.updateRegistrationFee(150.0); // Updating the registration fee

        vehicle1.displayRegistrationDetails();
        System.out.println("--------------------");
        vehicle2.displayRegistrationDetails();
        System.out.println("--------------------");
        vehicle3.displayRegistrationDetails();

        Vehicle.updateRegistrationFee(-50.0); //invalid fee

    }
}