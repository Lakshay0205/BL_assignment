class Ticket {
    int ticketId;
    String customerName, movieName, seatNumber, bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head;

    public TicketReservationSystem() {
        this.head = null;
    }

    // Add a new ticket reservation at the end
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            head.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) return;
        Ticket temp = head, prev = null;
        do {
            if (temp.ticketId == ticketId) {
                if (temp == head && temp.next == head) {
                    head = null;
                } else {
                    if (temp == head) {
                        Ticket last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = temp.next;
                    }
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) return;
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + " | Customer: " + temp.customerName + " | Movie: " + temp.movieName + " | Seat: " + temp.seatNumber + " | Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String keyword) {
        if (head == null) return;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Found Ticket - ID: " + temp.ticketId + " | Customer: " + temp.customerName + " | Movie: " + temp.movieName);
            }
            temp = temp.next;
        } while (temp != head);
    }

    // Count total number of booked tickets
    public int countTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class OnlineTicketReservationSystem {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(101, "Aditya", "Inception", "A1", "12:00 PM");
        system.addTicket(102, "Yash", "As the Gods Will", "B2", "2:30 PM");
        system.addTicket(103, "Anirudh", "Avengers", "C3", "5:00 PM");

        System.out.println("All Ticket Reservations:");
        system.displayTickets();

        System.out.println("\nSearching for tickets booked by 'Alice Smith':");
        system.searchTicket("Alice Smith");

        System.out.println("\nTotal Tickets Booked: " + system.countTickets());
    }
}
