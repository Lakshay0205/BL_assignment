import java.util.ArrayList;
import java.util.List;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }

    public abstract double calculateTotalPrice();
}

interface Discountable {
    void applyDiscount(double discountPercentage);
    String getDiscountDetails();
}

class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double additionalCharge;
    private double discountPercentage;

    public NonVegItem(String itemName, double price, int quantity, double additionalCharge) {
        super(itemName, price, quantity);
        this.additionalCharge = additionalCharge;
        this.discountPercentage = 0;
    }

    public double calculateTotalPrice() {
        double total = (getPrice() + additionalCharge) * getQuantity();
        if (discountPercentage > 0) {
            total -= total * (discountPercentage / 100);
        }
        return total;
    }

    public void applyDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getDiscountDetails() {
        return "Discount applied: " + discountPercentage + "%";
    }
}

class OnlineFoodDeliverySystem {
    public static void processOrder(List<FoodItem> foodItems) {
        for (FoodItem item : foodItems) {
            System.out.println(item.getItemDetails());
            double totalPrice = item.calculateTotalPrice();
            System.out.println("Total Price: " + totalPrice);
            if (item instanceof Discountable) {
                ((Discountable) item).applyDiscount(10);
                System.out.println(((Discountable) item).getDiscountDetails());
                totalPrice = item.calculateTotalPrice();
                System.out.println("Total Price after discount: " + totalPrice);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(new VegItem("Paneer Tikka", 200, 2));
        foodItems.add(new NonVegItem("Chicken Biryani", 300, 1, 50));

        processOrder(foodItems);
    }
}