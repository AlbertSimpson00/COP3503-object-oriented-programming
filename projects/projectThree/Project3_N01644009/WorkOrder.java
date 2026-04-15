package unf.edu.cop3503;

/**
 * The WorkOrder class represents a completed work assignment
 * created from a ticket and assigned to an employee.
 *
 * Each WorkOrder connects:
 * - An Employee
 * - A Ticket
 * - A Work Order creation timestamp
 *
 * This class implements the Printable interface so that
 * work order data can be written to the output file.
 *
 * @author Albert Simpson
 */
public class WorkOrder implements Printable {

    // Employee assigned to handle the work order
    protected Employee employee;

    // Ticket associated with this work order
    protected Ticket ticket;

    // Date/time when the work order was created
    protected String createdAt;

    /**
     * Constructs a WorkOrder using an assigned employee,
     * ticket information, and creation timestamp.
     *
     * @param employee the employee assigned to this work order
     * @param ticket the ticket associated with this work order
     * @param createdAt the date/time the work order was created
     */
    public WorkOrder(Employee employee, Ticket ticket, String createdAt) {

        // Store assigned employee
        this.employee = employee;

        // Store associated ticket
        this.ticket = ticket;

        // Store creation timestamp
        this.createdAt = createdAt;
    }

    /**
     * Returns formatted work order data for file output.
     *
     * This combines:
     * - Ticket data
     * - Work order creation time
     * - Employee data
     *
     * @return formatted work order data string
     */
    @Override
    public String getFileData() {
        return ticket.getFileData() + "," + createdAt + "," + employee.getFileData();
    }

    /**
     * Gets the assigned employee.
     *
     * @return the employee assigned to this work order
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets the assigned employee.
     *
     * @param employee the new assigned employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Gets the associated ticket.
     *
     * @return the ticket linked to this work order
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * Sets the associated ticket.
     *
     * @param ticket the new ticket
     */
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * Gets the work order creation time.
     *
     * @return the creation timestamp
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the work order creation time.
     *
     * @param createdAt the new creation timestamp
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
