public class Product {

    private static double discount = 0.0; // Static variable (discount percentage)

    private final int productID; // Final variable
    private String productName;
    private double price;
    private int quantity;

    private static int nextProductId = 1; // To generate unique product IDs

    // Constructor using 'this'
    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = nextProductId++; // Assign unique ID and increment
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public static double getDiscount() {
        return discount;
    }

    public static void updateDiscount(double newDiscount) { // Static method
        if (newDiscount >= 0 && newDiscount <= 100) { // Valid discount range
            discount = newDiscount;
        } else {
            System.out.println("Invalid discount percentage. Must be between 0 and 100.");
        }
    }

    public double calculateDiscountedPrice() {
        return price * (1 - (discount / 100));
    }

    public void displayProductDetails() {
        if (this instanceof Product) { // Using instanceof
            System.out.println("Product ID: " + productID); // Accessing final variable
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Discounted Price: $" + calculateDiscountedPrice());

        } else {
            System.out.println("Not a Product instance.");
        }
    }

    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1200.00, 1);
        Product product2 = new Product("Mouse", 25.00, 3);
        Product product3 = new Product("Keyboard", 75.00, 2);

        Product.updateDiscount(10); // Setting 10% discount

        product1.displayProductDetails();
        System.out.println("--------------------");
        product2.displayProductDetails();
        System.out.println("--------------------");
        product3.displayProductDetails();

        Product.updateDiscount(150); //invalid discount


    }
}