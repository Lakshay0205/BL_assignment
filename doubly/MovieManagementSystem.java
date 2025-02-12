class Movie {
    String title, director;
    int year;
    double rating;
    Movie next, prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = this.prev = null;
    }
}

class MovieManagement {
    private Movie head, tail;

    public MovieManagement() {
        this.head = this.tail = null;
    }

    // Add a movie at the end
    public void addMovie(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Remove a movie by title
    public void removeMovie(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp == head) head = temp.next;
        if (temp == tail) tail = temp.prev;
    }

    // Search for a movie by director or rating
    public Movie searchMovie(String query) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(query) || String.valueOf(temp.rating).equals(query)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Update movie rating
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    // Display movies in forward order
    public void displayMoviesForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " (" + temp.year + ") - " + temp.director + " - Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display movies in reverse order
    public void displayMoviesReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " (" + temp.year + ") - " + temp.director + " - Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieManagement movies = new MovieManagement();
        movies.addMovie("Inception", "Christopher Nolan", 2010, 8.8);
        movies.addMovie("The Matrix", "Lana Wachowski, Lilly Wachowski", 1999, 8.7);
        movies.addMovie("The Pursuit of Happyness", "Gabriele Muccino", 2006, 8.0);


        System.out.println("Movies in Forward Order:");
        movies.displayMoviesForward();
        
        System.out.println("\nMovies in Reverse Order:");
        movies.displayMoviesReverse();
        
        System.out.println("\nUpdating rating of 'Train to Busan' to 7.8");
        movies.updateRating("Train to Busan", 7.8);
        movies.displayMoviesForward();

        System.out.println("\nRemoving 'Hope'");
        movies.removeMovie("Hope");
        movies.displayMoviesForward();
    }
}
