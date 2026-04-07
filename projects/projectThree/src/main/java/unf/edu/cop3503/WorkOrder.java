package unf.edu.cop3503;

public class WorkOrder /*implements Printable*/{
    protected Employee employee;
    protected Ticket ticket;
    protected String createdAt;

    public WorkOrder(Employee employee, Ticket ticket, String createdAt) {
        this.employee = employee;
        this.ticket = ticket;
        this.createdAt = createdAt;
    }

    // public getFileData();
}
