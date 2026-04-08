package unf.edu.cop3503;

/**
 * The Printable interface defines a method that
 * returns formatted data for file output.
 *
 * Any class that implements this interface must
 * provide its own version of getFileData().
 *
 * Classes implementing this interface include:
 * Person, Customer, Employee, Ticket, and WorkOrder.
 *
 * This allows different object types to be written
 * to files using a consistent method.
 *
 * @author Albert Simpson
 */
public interface Printable {
    /**
     * Returns formatted object data as a string
     * suitable for writing to an output file.
     *
     * @return formatted file data string
     */
    String getFileData();

}
