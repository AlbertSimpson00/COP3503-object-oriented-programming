package unf.edu.cop3503;

public class Tier2Employee extends Employee {
    protected String certification;

    public Tier2Employee(String firstName, String lastName, String address,
                         String phoneNumber, String email, String employeeId,
                         String clockedIn, String hiredDate, String Certification) {
        super(firstName, lastName, address, phoneNumber, email, employeeId, clockedIn, hiredDate);
        this.certification = Certification;
    }

    @Override
    public String getFileData() {
        return super.getFileData() + "E-" + certification;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }
}
