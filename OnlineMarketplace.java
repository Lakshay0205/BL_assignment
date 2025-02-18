import java.util.ArrayList;
import java.util.List;

interface ProductCategory {}

class BookCategory implements ProductCategory {}
class ClothingCategory implements ProductCategory {}
class GadgetCategory implements ProductCategory {}

class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: $" + price + ", Category: " + category.getClass().getSimpleName();
    }
}

class ProductCatalog {
    List<Product<?>> products = new ArrayList<>();

    public void addProduct(Product<?> product) {
        products.add(product);
    }

    public <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
    }

    public void displayProducts() {
        for (Product<?> product : products) {
            System.out.println(product);
        }
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        catalog.addProduct(new Product<>("The Lord of the Rings", 25.00, new BookCategory()));
        catalog.addProduct(new Product<>("T-Shirt", 15.00, new ClothingCategory()));
        catalog.addProduct(new Product<>("Laptop", 1200.00, new GadgetCategory()));

        System.out.println("Original Prices:");
        catalog.displayProducts();

        catalog.applyDiscount(catalog.products.get(0), 10);
        catalog.applyDiscount(catalog.products.get(1), 20);
        catalog.applyDiscount(catalog.products.get(2), 5);

        System.out.println("\nDiscounted Prices:");
        catalog.displayProducts();
    }
}