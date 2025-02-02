public class Library {

    private String title;
    private String author;
    private double price;
    private boolean availability; // True if available, false if borrowed

    public Library(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = true; // Initially, all books are available
    }

    public boolean borrowBook() {
        if (availability) {
            availability = false;
            System.out.println(title + " by " + author + " has been borrowed.");
            return true; // Successful borrow
        } else {
            System.out.println(title + " by " + author + " is currently unavailable.");
            return false; // Unsuccessful borrow
        }
    }

    public void returnBook() {
        availability = true;
        System.out.println(title + " by " + author + " has been returned.");
    }

    @Override
    public String toString() {
        return "Library{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                '}';
    }

    public static void main(String[] args) {
        Library book1 = new Library("The Lord of the Rings", "J.R.R. Tolkien", 25.99);
        Library book2 = new Library("Pride and Prejudice", "Jane Austen", 19.99);

        System.out.println(book1);
        System.out.println(book2);

        book1.borrowBook(); 
        System.out.println(book1); 

        book2.borrowBook(); 
        System.out.println(book2); 
        book2.borrowBook(); 

        book1.returnBook();  
        System.out.println(book1); 
    }
}