package unf.edu.cop3503;

/**
 * The Person class represents a general person in the system.
 * It stores basic personal information such as name, address,
 * phone number, and email.
 *
 * This class implements the Printable interface and is extended
 * by Customer and Employee classes.
 *
 * @author Albert Simpson
 */
public class Person implements Printable {

    // Basic personal information fields
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String phoneNumber;
    protected String email;

    /**
     * Constructs a Person object with the provided personal details.
     *
     * @param firstName the person's first name
     * @param lastName the person's last name
     * @param address the person's home address
     * @param phoneNumber the person's phone number
     * @param email the person's email address
     */
    public Person(String firstName, String lastName,
                  String address, String phoneNumber, String email){

        // Assign constructor values to instance variables
        this.firstName = firstName;
        this.lastName = lastName;

        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Returns formatted data for file output.
     *
     * This base version returns an empty string and is
     * intended to be overridden by child classes.
     *
     * @return an empty string in the Person class
     */
    @Override
    public String getFileData() {
        return "";
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     *
     * @param phoneNumber the new phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the email address.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     *
     * @param email the new email address
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
