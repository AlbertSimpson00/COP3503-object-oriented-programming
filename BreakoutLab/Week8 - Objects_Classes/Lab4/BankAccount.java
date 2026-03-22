public class BankAccount {

    private String name;
    private double checkingBalance;
    private double savingsBalance;

    public BankAccount(String newName, double amt1, double amt2) {
        name = newName;
        checkingBalance = amt1;
        savingsBalance = amt2;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void setChecking(double amt) {
        checkingBalance = amt;
    }

    public double getChecking() {
        return checkingBalance;
    }

    public void setSavings(double amt) {
        savingsBalance = amt;
    }

    public double getSavings() {
        return savingsBalance;
    }

    public void depositChecking (double amt) {
        if (amt > 0) {
            checkingBalance += amt;
        }
    }

    public void depositSavings (double amt) {
        if (amt > 0) {
            savingsBalance += amt;
        }
    }

    public void withdrawChecking (double amt) {
        if (amt > 0) {
            checkingBalance -= amt;
        }
    }

    public void withdrawSavings (double amt) {
        if (amt > 0) {
            savingsBalance -= amt;
        }
    }

    public void transferToSavings(double amt) {
        if (amt > 0) {
            checkingBalance -= amt;
            savingsBalance += amt;
        }
    }
}