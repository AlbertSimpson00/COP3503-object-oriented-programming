package unf.edu.cop3503;

/**
 * The Ticket class represents a support ticket in the system.
 * It stores the customer associated with the ticket, the date
 * the ticket was created, and the ticket ID.
 *
 * This class implements the Printable interface so ticket
 * information can be formatted for file output.
 *
 * @author Albert Simpson
 */
public class Ticket implements Printable{

    // Customer connected to this ticket
    protected Customer customer;

    // Date/time the ticket was created
    protected String createdAt;

    // Unique ticket identifier
    protected String ticketId;

    /**
     * Constructs a Ticket object with its customer,
     * creation date, and ticket ID.
     *
     * @param customer the customer associated with the ticket
     * @param createdAt the date and time the ticket was created
     * @param ticketId the unique ticket ID
     */
    public Ticket(Customer customer, String createdAt, String ticketId) {

        // Store ticket-related values
        this.customer = customer;
        this.createdAt = createdAt;
        this.ticketId = ticketId;
    }

    /**
     * Returns formatted ticket data for file output.
     *
     * This includes customer data followed by ticket-specific data.
     *
     * @return formatted ticket data string
     */
    @Override
    public String getFileData() {
        return customer.getFileData() + "," + ticketId + "," + createdAt;
    }

    /**
     * Gets the customer associated with this ticket.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer associated with this ticket.
     *
     * @param customer the new customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets the ticket creation date and time.
     *
     * @return the createdAt value
     */

    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the ticket creation date and time.
     *
     * @param createdAt the new creation date and time
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the ticket ID.
     *
     * @return the ticket ID
     */
    public String getTicketId() {
        return ticketId;
    }

    /**
     * Sets the ticket ID.
     *
     * @param ticketId the new ticket ID
     */
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}
