package unf.edu.cop3503;

import com.sun.jdi.ClassType;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class FileHandler {
    private ArrayList<Employee> employeeList;
    private ArrayList<WorkOrder> workOrderList;

    public FileHandler(ArrayList<Employee> employeeList, ArrayList<WorkOrder> workOrderList) {
        this.employeeList = employeeList;
        this.workOrderList = workOrderList;
    }

    public void writeData(String workOrderFileName){
        try {
            logger("Writing Work Order Data to File");

            // Create output file
            PrintWriter output = new PrintWriter(workOrderFileName);

            // Writes the header line
            output.println("customer_id,customer_first_name,customer_last_name,ticket_id,ticket_createdAt,workorder_createdAt,employee_id,employee_first_name,employee_last_name,clocked_in,certification");

            // Loop to write each road section inside output file
            for (int i = 0; i < workOrderList.size(); i++) {
                WorkOrder workOrder = workOrderList.get(i);
                output.println(workOrder.getFileData());
                logger(workOrder.getFileData());
            }

            // Close output writer
            output.close();
        } catch (Exception e) {
            System.out.println("Error writing work order data.");
        }
    }

    public void readEmployeeData(String employeeFileName) throws FileNotFoundException {
        employeeList.clear();
        logger("Loading Employee Data");

        Scanner fileScnr = new Scanner(new File(employeeFileName));

        if (fileScnr.hasNextLine()) {
            fileScnr.nextLine();
        }

        while (fileScnr.hasNextLine()) {
            String line = fileScnr.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(",");

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

            if (tier.equalsIgnoreCase("tier2")) {
                employeeList.add(new Tier2Employee(firstName, lastName, address, phoneNumber, email, employeeId, clockedIn, hiredDate, certification));
            } else {
                employeeList.add(new Employee(firstName, lastName, address, phoneNumber, email, employeeId, clockedIn, hiredDate));
            }
        }

        fileScnr.close();
    }

    public LinkedList<Ticket> readTicketData(String ticketFileName) throws FileNotFoundException {
        logger("Loading Ticket Data");

        LinkedList<Ticket> ticketList = new LinkedList<>();

        Scanner fileScnr = new Scanner(new File(ticketFileName));

        if (fileScnr.hasNextLine()) {
            fileScnr.nextLine();
        }

        while (fileScnr.hasNextLine()) {

            String line = fileScnr.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(",");

            String customerId = parts[0].trim();
            String firstName = parts[1].trim();
            String lastName = parts[2].trim();
            String email = parts[3].trim();
            String address = parts[4].trim();
            String phoneNumber = parts[5].trim();
            String accountNumber = parts[6].trim();
            String ticketId = parts[7].trim();
            String createdAt = parts[8].trim();

            Customer customer = new Customer(firstName, lastName, address, phoneNumber, email, customerId, accountNumber);

            Ticket ticket = new Ticket(customer, createdAt, ticketId);

            ticketList.add(ticket);
        }

        fileScnr.close();

        return ticketList;
    }

    private void logger(String log) {
        try {
            PrintWriter logWriter = new PrintWriter(new FileWriter("log.txt", true));
            SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy H:mm:ss");

            logWriter.println("log: " + dateFormat.format(new Date()) + " : " + log);


            logWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing to log file.");
        }
    }

    
}
