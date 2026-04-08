package unf.edu.cop3503;

/**
 * The Customer class represents a customer in the system.
 * It extends the Person class and adds customer-specific
 * information such as customer ID and account number.
 *
 * This class overrides getFileData() to provide formatted
 * output specific to customer records.
 *
 * @author Albert Simpson
 */
public class Customer extends Person {

    // Unique identifiers for customer records
    String customerId;
    String accountNumber;

    /**
     * Constructs a Customer object using provided personal
     * and customer-specific information.
     *
     * @param firstName the customer's first name
     * @param lastName the customer's last name
     * @param address the customer's home address
     * @param phoneNumber the customer's phone number
     * @param email the customer's email address
     * @param customerId the unique customer ID
     * @param accountNumber the customer's account number
     */

    public Customer(String firstName, String lastName, String address,
                    String phoneNumber, String email, String customerId, String accountNumber) {

        // Call the parent (Person) constructor
        super(firstName, lastName, address, phoneNumber, email);

        // Assign customer-specific fields
        this.customerId = customerId;
        this.accountNumber = accountNumber;
    }

    /**
     * Returns formatted customer data for file output.
     *
     * This method builds on the parent class output
     * and adds customer-specific fields.
     *
     * @return formatted customer data string
     */
    @Override
    public String getFileData() {
        return super.getFileData() + customerId + "," + firstName + "," + lastName;
    }

    /**
     * Gets the customer ID.
     *
     * @return the customer ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID.
     *
     * @param customerId the new customer ID
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the account number.
     *
     * @return the account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number.
     *
     * @param accountNumber the new account number
     */

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
