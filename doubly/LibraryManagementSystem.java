class Book {
    String title, author, genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    public Book(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = this.prev = null;
    }
}

class Library {
    private Book head, tail;
    private int bookCount;

    public Library() {
        this.head = this.tail = null;
        this.bookCount = 0;
    }

    // Add a book at the end
    public void addBook(int bookId, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
    }

    // Remove a book by Book ID
    public void removeBook(int bookId) {
        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp == head) head = temp.next;
        if (temp == tail) tail = temp.prev;
        bookCount--;
    }

    // Search for a book by title or author
    public Book searchBook(String query) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(query) || temp.author.equalsIgnoreCase(query)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Update book availability status
    public void updateAvailability(int bookId, boolean isAvailable) {
        Book book = searchBookById(bookId);
        if (book != null) {
            book.isAvailable = isAvailable;
        }
    }

    private Book searchBookById(int bookId) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Display books in forward order
    public void displayBooksForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.bookId + " - " + temp.title + " by " + temp.author);
            temp = temp.next;
        }
    }

    // Display books in reverse order
    public void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.bookId + " - " + temp.title + " by " + temp.author);
            temp = temp.prev;
        }
    }

    // Count total books
    public int getTotalBooks() {
        return bookCount;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(101, "Tempest", "Willian Shakespeare", "Novel", true);
        library.addBook(102, "1984", "George Orwell", "Dystopian", true);
        library.addBook(103, "To Kill a Mockingbird", "Harper Lee", "Classic", false);

        System.out.println("All Books in Forward Order:");
        library.displayBooksForward();
        
        System.out.println("\nAll Books in Reverse Order:");
        library.displayBooksReverse();
        
        System.out.println("\nTotal Books: " + library.getTotalBooks());

        System.out.println("\nSearching for '1984':");
        Book foundBook = library.searchBook("1984");
        if (foundBook != null) {
            System.out.println("Found: " + foundBook.title + " by " + foundBook.author);
        } else {
            System.out.println("Book not found");
        }

        System.out.println("\nUpdating availability of '1984' to false");
        library.updateAvailability(102, false);
        
        System.out.println("\nRemoving 'The Great Gatsby'");
        library.removeBook(101);
        library.displayBooksForward();
    }
}
