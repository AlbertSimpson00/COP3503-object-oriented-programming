package unf.edu.cop3503;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * The FileHandler class is responsible for:
 * - Reading employee data from a file
 * - Reading ticket data from files
 * - Writing work order data to an output file
 * - Logging program activity
 *
 * This class acts as the main bridge between
 * file input/output and the program's data structures.
 *
 * @author Albert Simpson
 */
public class FileHandler {

    /**
     * Writes all work order data to the specified output file.
     *
     * This method:
     * - Writes a header row
     * - Iterates through all work orders
     * - Writes each work order's formatted data
     * - Logs actions to a log file
     *
     * @param workOrderFileName the name of the output file
     */
    public void writeData(String workOrderFileName){
        try {
            logger("Writing Work Order Data to File");

            // Create output file
            PrintWriter output = new PrintWriter(workOrderFileName);

            // Writes the header line
            output.println("customer_id,customer_first_name,customer_last_name,ticket_id,ticket_createdAt,workorder_createdAt,employee_id,employee_first_name,employee_last_name,clocked_in,certification");

            // Loop through all work orders and write each one
            for (int i = 0; i < Project3.workOrderList.size(); i++) {
                WorkOrder workOrder = Project3.workOrderList.get(i);

                // Write formatted work order data to file
                output.println(workOrder.getFileData());

                // Log each work order written
                logger(workOrder.getFileData());
            }

            logger("Work Orders Created. Program Exiting");

            // Close output writer to ensure data is saved
            output.close();

        } catch (Exception e) {
            System.out.println("Error writing work order data.");
        }
    }

    /**
     * Reads employee data from a CSV file and populates
     * the Project3 employee list.
     *
     * This method:
     * - Skips the header row
     * - Parses each line into fields
     * - Determines if employee is Tier 1 or Tier 2
     * - Creates appropriate Employee objects
     *
     * @param employeeFileName the employee data file
     * @throws FileNotFoundException if file cannot be found
     */
    public void readEmployeeData(String employeeFileName) throws FileNotFoundException {

        // Clear any existing employee data
        Project3.employeeList.clear();
        logger("Loading Employee Data");

        Scanner fileScnr = new Scanner(new File(employeeFileName));

        // Skips header line
        if (fileScnr.hasNextLine()) {
            fileScnr.nextLine();
        }

        // Read each line of the file
        while (fileScnr.hasNextLine()) {
            String line = fileScnr.nextLine().trim();

            // Skip empty lines
            if (line.isEmpty()) {
                continue;
            }

            // Split CSV line into parts
            String[] parts = line.split(",");

            // Extract fields from CSV
            String employeeId = parts[0].trim();
            String firstName = parts[1].trim();
            String lastName = parts[2].trim();
            String email = parts[3].trim();
            String address = parts[4].trim();
            String phoneNumber = parts[5].trim();
            String clockedIn = parts[6].trim();
            String hiredDate = parts[7].trim();
            String tier = parts[8].trim();
            String certification = parts[9].trim();

            // Create Tier2Employee if applicable
            if (tier.equalsIgnoreCase("tier2")) {
                Project3.employeeList.add(new Tier2Employee(firstName, lastName, address, phoneNumber, email, employeeId, clockedIn, hiredDate, certification));

            } else { // Otherwise create standard Employee
                Project3.employeeList.add(new Employee(firstName, lastName, address, phoneNumber, email, employeeId, clockedIn, hiredDate));
            }
        }

        // Close scanner to prevent leaks or bugs
        fileScnr.close();
    }

    /**
     * Reads ticket data from a CSV file and returns
     * a list of Ticket objects.
     *
     * This method:
     * - Skips the header row
     * - Parses each line into ticket and customer data
     * - Creates Customer and Ticket objects
     *
     * @param ticketFileName the ticket data file
     * @return a LinkedList of Ticket objects
     * @throws FileNotFoundException if file cannot be found
     */
    public LinkedList<Ticket> readTicketData(String ticketFileName) throws FileNotFoundException {
        logger("Loading Ticket Data");

        LinkedList<Ticket> ticketList = new LinkedList<>();

        Scanner fileScnr = new Scanner(new File(ticketFileName));

        // Skip header row
        if (fileScnr.hasNextLine()) {
            fileScnr.nextLine();
        }

        // Read each ticket entry
        while (fileScnr.hasNextLine()) {

            String line = fileScnr.nextLine().trim();

            // Skip empty lines
            if (line.isEmpty()) {
                continue;
            }

            // Split CSV line into parts
            String[] parts = line.split(",");

            // Extract customer + ticket fields
            String customerId = parts[0].trim();
            String firstName = parts[1].trim();
            String lastName = parts[2].trim();
            String email = parts[3].trim();
            String address = parts[4].trim();
            String phoneNumber = parts[5].trim();
            String accountNumber = parts[6].trim();
            String ticketId = parts[7].trim();
            String createdAt = parts[8].trim();

            // Create Customer object
            Customer customer = new Customer(firstName, lastName, address, phoneNumber, email, customerId, accountNumber);

            // Create Ticket object
            Ticket ticket = new Ticket(customer, createdAt, ticketId);

            // Add Ticket object to list
            ticketList.add(ticket);
        }

        // Close scanner
        fileScnr.close();

        return ticketList;
    }

    /**
     * Writes a log entry to the log.txt file.
     *
     * Each log entry includes:
     * - Timestamp
     * - Log message
     *
     * @param log the message to log
     */
    private void logger(String log) {
        try {
            // Append mode enabled so logs are not overwritten
            PrintWriter logWriter = new PrintWriter(new FileWriter("log.txt", true));

            // Format timestamp
            SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy H:mm:ss");

            // Write log entry
            logWriter.println("log: " + dateFormat.format(new Date()) + " : " + log);


            logWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing to log file.");
        }
    }
}
