import java.util.ArrayList;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

class Library {
    private ArrayList<Book> books;
    private String name; // Added a name for the library

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Books in " + name + " Library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public ArrayList<Book> getBooks() {
        return books; // Added getter for books (useful for other operations)
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        // Create some books
        Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien");
        Book book2 = new Book("Pride and Prejudice", "Jane Austen");
        Book book3 = new Book("1984", "George Orwell");
        Book book4 = new Book("To Kill a Mockingbird", "Harper Lee");

        // Create libraries
        Library centralLibrary = new Library("Central");
        Library cityLibrary = new Library("City");


        // Add books to libraries
        centralLibrary.addBook(book1);
        centralLibrary.addBook(book2);
        cityLibrary.addBook(book3);
        cityLibrary.addBook(book1); // book1 is now in both libraries! (Aggregation)

        // Display books in libraries
        centralLibrary.displayBooks();
        System.out.println(); // Add a separator for clarity
        cityLibrary.displayBooks();

        // Demonstrate book existing independently
        System.out.println("\n--- Demonstrating independent existence of a book ---");
        System.out.println("Book1 details: " + book1); // Book1 exists even though it's in the libraries

        // Remove book from a library (doesn't destroy the book itself)
        centralLibrary.removeBook(book1);
        System.out.println("\n--- After removing Book1 from Central Library ---");
        centralLibrary.displayBooks();
        System.out.println("Book1 details: " + book1); // Book1 still exists!
        cityLibrary.displayBooks(); // Book1 is still in the city library

        //Illustrate getting the books from the library
        ArrayList<Book> booksInCity = cityLibrary.getBooks();
        System.out.println("\n--- Books in City Library (using getter) ---");
        for(Book b : booksInCity) {
            System.out.println(b);
        }
    }
}