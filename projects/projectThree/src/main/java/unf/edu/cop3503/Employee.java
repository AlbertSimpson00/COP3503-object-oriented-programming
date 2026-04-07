package unf.edu.cop3503;

public class Employee extends Person {
    protected String employeeId, clockedIn, hiredDate;

    public Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeId, String clockedIn, String hiredDate) {
        super(firstName, lastName, address, phoneNumber, email);
        this.employeeId = employeeId;
        this.clockedIn = clockedIn;
        this.hiredDate = hiredDate;
    }

    @Override
    public String getFileData() {
        return super.getFileData() + "E-" + employeeId + "E-" + firstName + "E-" + lastName + "E-" + clockedIn;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getClockedIn() {
        return clockedIn;
    }

    public String getHiredDate() {
        return hiredDate;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setClockedIn(String clockedIn) {
        this.clockedIn = clockedIn;
    }

    public void setHireDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }

}
