public class HotelBooking {

    private String guestName;
    private String roomType;
    private int nights;

    // Default Constructor
    public HotelBooking() {
        this.guestName = "Unknown";
        this.roomType = "Standard";
        this.nights = 1;
    }

    // Parameterized Constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy Constructor
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    @Override
    public String toString() {
        return "HotelBooking{" +
                "guestName='" + guestName + '\'' +
                ", roomType='" + roomType + '\'' +
                ", nights=" + nights +
                '}';
    }

    public static void main(String[] args) {
        // Using the default constructor
        HotelBooking booking1 = new HotelBooking();
        System.out.println("Booking 1 (Default): " + booking1);

        // Using the parameterized constructor
        HotelBooking booking2 = new HotelBooking("Akash Pandey", "Deluxe", 3);
        System.out.println("Booking 2 (Parameterized): " + booking2);

        // Using the copy constructor
        HotelBooking booking3 = new HotelBooking(booking2);
        System.out.println("Booking 3 (Copy): " + booking3);

        // Modifying booking2 to show that booking3 is a separate copy
        booking2.guestName = "Aditya Vardhan Singh";
        booking2.roomType = "Standard";
        booking2.nights = 5;
        System.out.println("Booking 2 (Modified): " + booking2);
        System.out.println("Booking 3 (Copy - Unchanged): " + booking3);


         //Demonstrating another way to use the copy constructor
        HotelBooking booking4 = new HotelBooking(new HotelBooking("Ayush Pratap Singh", "Suite", 2)); //Copy of a new object
        System.out.println("Booking 4 (Copy of a new object): " + booking4);

    }
}