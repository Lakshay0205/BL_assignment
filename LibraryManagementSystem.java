import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    public abstract int getLoanDuration();
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book " + getTitle() + " has been reserved.");
        } else {
            System.out.println("Book " + getTitle() + " is not available for reservation.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Magazine " + getTitle() + " has been reserved.");
        } else {
            System.out.println("Magazine " + getTitle() + " is not available for reservation.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("DVD " + getTitle() + " has been reserved.");
        } else {
            System.out.println("DVD " + getTitle() + " is not available for reservation.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

class LibraryManagementSystem {
    public static void manageLibraryItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem();
                System.out.println("Availability: " + ((Reservable) item).checkAvailability());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        items.add(new Magazine("M001", "National Geographic", "Various"));
        items.add(new DVD("D001", "Inception", "Christopher Nolan"));

        manageLibraryItems(items);
    }
}