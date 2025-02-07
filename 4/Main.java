class Book {
    String title;
    int publicationYear;

    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    String name;
    String bio;

    void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class Main {
    public static void main(String[] args) {
        Author author = new Author();
        author.title = "The Great Gatsby";
        author.publicationYear = 1925;
        author.name = "F. Scott Fitzgerald";
        author.bio = "An American novelist and short story writer, widely regarded as one of the greatest American writers of the 20th century.";

        author.displayInfo();
    }
}

