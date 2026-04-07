package unf.edu.cop3503;

public class Customer extends Person {
    String customerId, accountNumber;

    public Customer(String firstName, String lastName, String address, String phoneNumber, String email, String customerId, String accountNumber) {
        super(firstName, lastName, phoneNumber, address, email);
        this.customerId = customerId;
        this.accountNumber = accountNumber;
    }


    @Override
    public String getFileData() {
        return super.getFileData() + "C-" + customerId + "C-" + firstName + "C-" + lastName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
