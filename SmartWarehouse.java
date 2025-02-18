import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String id;

    public WarehouseItem(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Item ID: " + id;
    }
}

class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String id, String brand) {
        super(id);
        this.brand = brand;
    }

    @Override
    public String toString() {
        return super.toString() + ", Electronics Brand: " + brand;
    }
}

class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String id, String expiryDate) {
        super(id);
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Groceries Expiry: " + expiryDate;
    }
}

class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String id, String material) {
        super(id);
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() + ", Furniture Material: " + material;
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public void displayItems() {
        displayAllItems(items);
    }


    private void displayAllItems(List<? extends WarehouseItem> itemsToDisplay) {
        for (WarehouseItem item : itemsToDisplay) {
            System.out.println(item);
        }
    }
}

public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("E001", "Samsung"));
        electronicsStorage.addItem(new Electronics("E002", "LG"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("G001", "2024-12-31"));
        groceriesStorage.addItem(new Groceries("G002", "2025-01-15"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("F001", "Wood"));
        furnitureStorage.addItem(new Furniture("F002", "Metal"));

        System.out.println("Electronics:");
        electronicsStorage.displayItems();

        System.out.println("\nGroceries:");
        groceriesStorage.displayItems();

        System.out.println("\nFurniture:");
        furnitureStorage.displayItems();

    }
}