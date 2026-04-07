package unf.edu.cop3503;

public class WorkOrder implements Printable {
    protected Employee employee;
    protected Ticket ticket;
    protected String createdAt;

    public WorkOrder(Employee employee, Ticket ticket, String createdAt) {
        this.employee = employee;
        this.ticket = ticket;
        this.createdAt = createdAt;
    }

    @Override
    public String getFileData() {
        return ticket.getFileData() + "," + createdAt + "," + employee.getFileData();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
