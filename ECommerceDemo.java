import java.util.ArrayList;
import java.util.List;

class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product: " + name + " (ID: " + productId + "), Price: $" + price;
    }
}

class Order {
    private int orderId;
    private Customer customer;  // Association: Order belongs to a Customer
    private List<Product> products; // Aggregation: Order contains Products

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("Total: $" + calculateTotal());
    }

    @Override
    public String toString() {
        return "Order " + orderId + " (Customer: " + customer.getName() + ")";
    }
}

class Customer {
    private int customerId;
    private String name;
    private String email;
    private List<Order> orders; // Association: Customer has Orders

    public Customer(int customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void placeOrder(Order order) {
        this.orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void displayOrderHistory() {
        System.out.println("Order history for " + name + ":");
        for (Order order : orders) {
            order.displayOrderDetails();
            System.out.println("---");
        }
    }

    @Override
    public String toString() {
        return "Customer: " + name + " (ID: " + customerId + ", Email: " + email + ")";
    }
}

public class ECommerceDemo {
    public static void main(String[] args) {
        Customer john = new Customer(1, "John Doe", "john.doe@example.com");
        Customer jane = new Customer(2, "Jane Smith", "jane.smith@example.com");

        Product laptop = new Product("P1", "Laptop", 1200);
        Product mouse = new Product("P2", "Wireless Mouse", 25);
        Product keyboard = new Product("P3", "Keyboard", 75);
        Product monitor = new Product("P4", "Monitor", 300);

        Order order1 = new Order(101, john);
        order1.addProduct(laptop);
        order1.addProduct(mouse);
        john.placeOrder(order1);


        Order order2 = new Order(102, jane);
        order2.addProduct(keyboard);
        order2.addProduct(monitor);
        jane.placeOrder(order2);

        order1.displayOrderDetails();
        System.out.println();
        order2.displayOrderDetails();

        System.out.println("\n--- Customer Order History ---");
        john.displayOrderHistory();
        System.out.println();
        jane.displayOrderHistory();


        System.out.println("\n--- Products in Order 101 ---");
        for (Product p : order1.getProducts()){
            System.out.println(p);
        }

    }
}