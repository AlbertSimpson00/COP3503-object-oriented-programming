public class Calculator {
   
  /* Type your code here. */
    private double value;

    public Calculator() {
        value = 0.0;
    }

    public void add(double val) {
        value += val;
    }

    public void subtract(double val) {
        value -= val;
    }

    public void multiply(double val) {
        value *= val;
    }

    public void divide(double val) {
        value /= val;
    }

    public void clear() {
        value = 0.0;
    }

    public double getValue() {
        return value;
    }
}
