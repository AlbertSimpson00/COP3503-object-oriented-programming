package unf.edu.cop3503;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The Project3 class is the main driver for the Work Order Generator program.
 *
 * This class is responsible for:
 * - Storing input and output file names
 * - Holding program-wide data structures
 * - Loading employee and ticket data
 * - Creating work orders
 * - Writing work order data to an output file
 *
 * The program reads employee and ticket information from CSV files,
 * assigns tickets to employees, creates work orders, and writes the
 * final results to a work order output file.
 *
 * @author Albert Simpson
 */
public class Project3 {

    // File names used by the program
    public String employeeFileName;
    public String tier1TicketFileName;
    public String tier2TicketFileName;
    public String workOrderFileName;

    // Stores all employees loaded from the employee data file
    public static ArrayList<Employee> employeeList = new ArrayList<>();

    // Queue of Tier 1 tickets
    public static Queue<Ticket> tier1TicketFile = new LinkedList<>();

    // Queue of Tier 2 tickets
    public static Queue<Ticket> tier2TicketFile = new LinkedList<>();

    // Stores all created work orders
    public static ArrayList<WorkOrder> workOrderList = new ArrayList<>();

    /**
     * Constructs a Project3 object and initializes
     * file names and program data structures.
     */
    public Project3() {

        // Set default file names
        employeeFileName = "employee_data.csv";
        tier1TicketFileName = "tier1_ticket_data.csv";
        tier2TicketFileName = "tier2_ticket_data.csv";
        workOrderFileName = "workorder_data.csv";

        // Initialize collections used by the program
        employeeList = new ArrayList<>();
        tier1TicketFile = new LinkedList<>();
        tier2TicketFile = new LinkedList<>();
        workOrderList = new ArrayList<>();
    }

    /**
     * Main method that runs the Work Order Generator program.
     *
     * This method:
     * - Creates the main Project3 object
     * - Creates a FileHandler object
     * - Loads employee data
     * - Loads ticket data
     * - Creates work orders
     * - Writes output to the work order file
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Create project and file handler objects
        Project3 project = new Project3();
        FileHandler fileHandler = new FileHandler();

        System.out.println("Project 3 Work Order Generator");
        System.out.println();

        try {
            System.out.println("Loading Employee Data");
            fileHandler.readEmployeeData(project.employeeFileName);

            System.out.println("Loading Ticket Data");

            // Load Tier 2 tickets first
            tier2TicketFile = fileHandler.readTicketData(project.tier2TicketFileName);

            // Load Tier 1 tickets second
            tier1TicketFile = fileHandler.readTicketData(project.tier1TicketFileName);

            System.out.println("Creating Work Orders");
            createWorkOrders();

            System.out.println("Writing Work Order Data to File");
            fileHandler.writeData(project.workOrderFileName);

            System.out.println("Work Orders Created. Program Exiting");

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Error: " + e.getMessage());
        }
    }

    /**
     * Creates work orders by assigning tickets to employees.
     *
     * This method:
     * - Separates employees into Tier 1 and Tier 2 lists
     * - Assigns Tier 2 tickets to Tier 2 employees
     * - Assigns Tier 1 tickets to Tier 1 employees
     * - Uses round-robin assignment so work is distributed evenly
     * - Creates a timestamp for each work order
     */
    public static void createWorkOrders() {

        // Store separated employee groups
        ArrayList<Employee> tier1Employees = new ArrayList<>();
        ArrayList<Employee> tier2Employees = new ArrayList<>();

        // Separate employees based on whether they are Tier2Employee objects
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);

            // instanceof checks if the object is a Tier2Employee
            if (employee instanceof Tier2Employee) {
                tier2Employees.add(employee);
            } else {
                tier1Employees.add(employee);
            }
        }

        // Index values used for the two while loops
        int t1Index = 0;
        int t2Index = 0;

        // Formatter for work order creation timestamps
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy H:mm:ss");

        // Process all Tier 2 tickets
        while (!tier2TicketFile.isEmpty()) {

            // Remove the next ticket from the queue
            Ticket ticket = tier2TicketFile.poll();

            // Get the next Tier 2 employee
            Employee employee = tier2Employees.get(t2Index);

            // Create current timestamp
            String time = dateFormat.format(System.currentTimeMillis());

            // Build work order and store it
            WorkOrder workOrder = new WorkOrder(employee, ticket, time);
            workOrderList.add(workOrder);

            t2Index++;

            // Reset index if end of list is reached
            if (t2Index >= tier2Employees.size()) {
                t2Index = 0;
            }
        }

        // Process all Tier 1 tickets
        while (!tier1TicketFile.isEmpty()) {

            // Remove the next ticket from the queue
            Ticket ticket = tier1TicketFile.poll();

            // Get the next Tier 1 employee
            Employee employee = tier1Employees.get(t1Index);

            // Create current timestamp
            String time = dateFormat.format(System.currentTimeMillis());

            // Build work order and store it
            WorkOrder workOrder = new WorkOrder(employee, ticket, time);
            workOrderList.add(workOrder);

            t1Index++;

            // Reset index if end of list is reached
            if (t1Index >= tier1Employees.size()) {
                t1Index = 0;
            }
        }
    }
}