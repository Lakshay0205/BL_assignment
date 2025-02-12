class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    private Item head;

    // Add item at the beginning
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add item at the end
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Remove item by ID
    public void removeItem(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found");
            return;
        }
        temp.next = temp.next.next;
    }

    // Update quantity by item ID
    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // Search item by ID or name
    public Item searchItem(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public Item searchItem(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Calculate total inventory value
    public double calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        return totalValue;
    }

    // Display inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("No items in inventory");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println("Item Name: " + temp.itemName + ", ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();
        inventory.addItemAtEnd("Laptop", 101, 5, 800.0);
        inventory.addItemAtEnd("Mouse", 102, 10, 20.0);
        inventory.addItemAtBeginning("Keyboard", 103, 8, 30.0);
        
        System.out.println("All items:");
        inventory.displayInventory();
        
        System.out.println("\nUpdating quantity of Item ID 102");
        inventory.updateQuantity(102, 15);
        inventory.displayInventory();
        
        System.out.println("\nTotal Inventory Value: " + inventory.calculateTotalValue());
        
        System.out.println("\nRemoving item with ID 103");
        inventory.removeItem(103);
        inventory.displayInventory();
    }
}
