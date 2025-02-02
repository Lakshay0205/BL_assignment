public class CarRental {

    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate; // Added daily rate

    // Default Constructor
    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Unknown";
        this.rentalDays = 0;
        this.dailyRate = 50.0; // Default daily rate
    }

    // Parameterized Constructor
    public CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }

    // Copy Constructor
    public CarRental(CarRental other) {
        this.customerName = other.customerName;
        this.carModel = other.carModel;
        this.rentalDays = other.rentalDays;
        this.dailyRate = other.dailyRate;
    }

    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    @Override
    public String toString() {
        return "CarRental{" +
                "customerName='" + customerName + '\'' +
                ", carModel='" + carModel + '\'' +
                ", rentalDays=" + rentalDays +
                ", dailyRate=" + dailyRate +
                ", totalCost=" + calculateTotalCost() + // Added total cost to toString
                '}';
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental(); // Default
        System.out.println(rental1);

        CarRental rental2 = new CarRental("Alice", "Honda Civic", 5, 75.0); // Parameterized
        System.out.println(rental2);

        CarRental rental3 = new CarRental(rental2); // Copy
        System.out.println(rental3);

        rental2.setRentalDays(3); //Demonstrating that it is a separate copy
        System.out.println(rental2);
        System.out.println(rental3);


    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }
}