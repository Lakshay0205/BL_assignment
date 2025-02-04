public class Library {
    private static String LibraryName = " Central Library";
    private static int totalBooks = 0;

    private String author;
    private String bookName;
    private final int bookId;

    // constructor using this to resolve ambiguity
    public Library(String author, String bookName, int bookId) {
        this.author = author;
        this.bookName = bookName;
        this.bookId = bookId;
        totalBooks++;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public static String getLibraryName() {
        return LibraryName;
    }

    public static int getTotalBooks() {
        return totalBooks;
    }

    public void displayBookDetails() {
        if (this instanceof Library) {
            System.out.println("Library Name: " + getLibraryName());
            System.out.println("Author: " + getAuthor());
            System.out.println("Book Name: " + getBookName());
            System.out.println("Book ID: " + getBookId());
        }
    }

    public static void main(String[] args) {
        Library library1 = new Library("William Shakespeare", "Merchant of Venice", 123);
        Library library2 = new Library("Akira Toriyama", "Dragon Ball", 456);

        System.out.println("Total books in the library: " + getTotalBooks());
        System.out.println("-----------------------------");
        System.out.println("Book1 details:");
        library1.displayBookDetails();
        System.out.println("-----------------------------");
        System.out.println("Book2 details:");
        library2.displayBookDetails();
        
    }


}