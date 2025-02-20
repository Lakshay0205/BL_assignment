import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices;
    private LinkedHashMap<String, Integer> cart;

    public ShoppingCart() {
        productPrices = new HashMap<>();
        cart = new LinkedHashMap<>();
    }

    public void addProductPrice(String product, double price) {
        productPrices.put(product, price);
    }

    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void displayCart() {
        System.out.println("Shopping Cart:");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " x " + entry.getValue() + " @ " + productPrices.get(entry.getKey()) + " each");
        }
    }

    public void displaySortedByPrice() {
        TreeMap<Double, List<String>> sortedProducts = new TreeMap<>();
        for (String product : cart.keySet()) {
            double price = productPrices.get(product);
            sortedProducts.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
        }

        System.out.println("Products sorted by price:");
        for (Map.Entry<Double, List<String>> entry : sortedProducts.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " - " + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProductPrice("Apple", 1.5);
        cart.addProductPrice("Banana", 0.8);
        cart.addProductPrice("Cherry", 2.0);
        
        cart.addToCart("Apple", 2);
        cart.addToCart("Banana", 3);
        cart.addToCart("Cherry", 1);
        
        cart.displayCart();
        cart.displaySortedByPrice();
    }
}
