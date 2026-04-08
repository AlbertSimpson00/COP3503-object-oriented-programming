package unf.edu.cop3503;

/**
 * The Employee class represents an employee in the system.
 * It extends the Person class and adds employee-specific
 * information such as employee ID, clock-in status, and
 * hired date.
 *
 * This class overrides getFileData() to provide formatted
 * employee data for file output.
 *
 * @author Albert Simpson
 */
public class Employee extends Person {

    // Employee-specific fields
    protected String employeeId;
    protected String clockedIn;
    protected String hiredDate;

    /**
     * Constructs an Employee object with personal and
     * employee-specific information.
     *
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param address the employee's home address
     * @param phoneNumber the employee's phone number
     * @param email the employee's email address
     * @param employeeId the employee ID
     * @param clockedIn the employee's clock-in status
     * @param hiredDate the employee's hired date
     */
    public Employee(String firstName, String lastName, String address,
                    String phoneNumber, String email, String employeeId,
                    String clockedIn, String hiredDate) {

        // Call the parent constructor to initialize shared person data
        super(firstName, lastName, address, phoneNumber, email);

        // Assign employee-specific fields
        this.employeeId = employeeId;
        this.clockedIn = clockedIn;
        this.hiredDate = hiredDate;
    }

    /**
     * Returns formatted employee data for file output.
     *
     * This method combines the inherited file data
     * with employee-specific values.
     *
     * @return formatted employee data string
     */
    @Override
    public String getFileData() {
        return super.getFileData() + employeeId + "," + firstName + "," + lastName + "," + clockedIn;
    }

    /**
     * Gets the employee ID.
     *
     * @return the employee ID
     */

    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Gets the employee's clock-in status.
     *
     * @return the clock-in status
     */
    public String getClockedIn() {
        return clockedIn;
    }

    /**
     * Gets the hired date.
     *
     * @return the hired date
     */
    public String getHiredDate() {
        return hiredDate;
    }

    /**
     * Sets the employee ID.
     *
     * @param employeeId the new employee ID
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Sets the clock-in status.
     *
     * @param clockedIn the new clock-in status
     */
    public void setClockedIn(String clockedIn) {
        this.clockedIn = clockedIn;
    }

    /**
     * Sets the hired date.
     *
     * @param hiredDate the new hired date
     */
    public void setHireDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }

}
