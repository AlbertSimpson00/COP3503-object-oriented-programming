package unf.edu.cop3503;

/**
 * The Tier2Employee class represents a Tier 2 employee.
 * It extends the Employee class and adds certification
 * information specific to Tier 2 employees.
 *
 * This class overrides getFileData() to include
 * certification details in the output.
 *
 * @author Albert Simpson
 */
public class Tier2Employee extends Employee {

    // Certification held by Tier 2 employee
    protected String certification;

    /**
     * Constructs a Tier2Employee object using both
     * personal and employee-specific information.
     *
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param address the employee's home address
     * @param phoneNumber the employee's phone number
     * @param email the employee's email address
     * @param employeeId the employee ID
     * @param clockedIn the employee's clock-in status
     * @param hiredDate the employee's hired date
     * @param Certification the certification held by the employee
     */
    public Tier2Employee(String firstName, String lastName, String address,
                         String phoneNumber, String email, String employeeId,
                         String clockedIn, String hiredDate, String Certification) {

        // Call parent constructor to initialize employee fields
        super(firstName, lastName, address, phoneNumber, email, employeeId, clockedIn, hiredDate);

        // Assign certification field
        this.certification = Certification;
    }

    /**
     * Returns formatted Tier 2 employee data
     * including certification information.
     *
     * @return formatted Tier 2 employee data string
     */
    @Override
    public String getFileData() {
        return super.getFileData() + "," + certification;
    }

    /**
     * Gets the certification value.
     *
     * @return the certification
     */
    public String getCertification() {
        return certification;
    }

    /**
     * Sets the certification value.
     *
     * @param certification the new certification
     */
    public void setCertification(String certification) {
        this.certification = certification;
    }
}
