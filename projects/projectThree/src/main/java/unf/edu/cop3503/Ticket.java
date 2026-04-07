package unf.edu.cop3503;

public class Ticket {
    protected Customer customer;
    protected String createdAt, ticketId;

    public Ticket(Customer customer, String createdAt, String ticketId) {
        this.customer = customer;
        this.createdAt = createdAt;
        this.ticketId = ticketId;
    }

    // public getFiledata();
}
