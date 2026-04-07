package unf.edu.cop3503;

public class Ticket implements Printable{
    protected Customer customer;
    protected String createdAt;
    protected String ticketId;

    public Ticket(Customer customer, String createdAt, String ticketId) {
        this.customer = customer;
        this.createdAt = createdAt;
        this.ticketId = ticketId;
    }

    @Override
    public String getFileData() {
        return customer.getFileData() + "," + ticketId + "," + createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}
