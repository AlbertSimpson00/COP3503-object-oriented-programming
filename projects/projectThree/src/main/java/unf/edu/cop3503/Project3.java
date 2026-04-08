package unf.edu.cop3503;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Project3 {
    public String employeeFileName;
    public String tier1TicketFileName;
    public String tier2TicketFileName;
    public String workOrderFileName;

    public static ArrayList<Employee> employeeList = new ArrayList<>();
    public static Queue<Ticket> tier1TicketFile = new LinkedList<>();
    public static Queue<Ticket> tier2TicketFile = new LinkedList<>();
    public static ArrayList<WorkOrder> workOrderList = new ArrayList<>();

    public Project3() {
        employeeFileName = "employee_data.csv";
        tier1TicketFileName = "tier1_ticket_data.csv";
        tier2TicketFileName = "tier2_ticket_data.csv";
        workOrderFileName = "workorder_data.csv";

        employeeList = new ArrayList<>();
        tier1TicketFile = new LinkedList<>();
        tier2TicketFile = new LinkedList<>();
        workOrderList = new ArrayList<>();
    }

    public static void main(String[] args) {
        Project3 project = new Project3();
        FileHandler fileHandler = new FileHandler();

        System.out.println("Project 3 Work Order Generator");
        System.out.println();

        try {
            System.out.println("Loading Employee Data");
            fileHandler.readEmployeeData(project.employeeFileName);

            System.out.println("Loading Ticket Data");
            tier1TicketFile = fileHandler.readTicketData(project.tier1TicketFileName);
            tier2TicketFile = fileHandler.readTicketData(project.tier2TicketFileName);

            System.out.println("Creating Work Orders");
            createWorkOrders();

            System.out.println("Writing Work Order Data to File");
            fileHandler.writeData(project.workOrderFileName);

            System.out.println("Work Orders Created. Program Exiting");

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Error: " + e.getMessage());
        }
    }

    public static void createWorkOrders() {
        ArrayList<Employee> tier1Employees = new ArrayList<>();
        ArrayList<Employee> tier2Employees = new ArrayList<>();

        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);

            if (employee instanceof Tier2Employee) {
                tier2Employees.add(employee);
            } else {
                tier1Employees.add(employee);
            }
        }

        int t1Index = 0;
        int t2Index = 0;

        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy H:mm:ss");

        while (!tier1TicketFile.isEmpty()) {
            Ticket ticket = tier1TicketFile.poll();
            Employee employee = tier1Employees.get(t1Index);
            String time = dateFormat.format(System.currentTimeMillis());

            WorkOrder workOrder = new WorkOrder(employee, ticket, time);

            workOrderList.add(workOrder);

            t1Index++;

            if (t1Index >= tier1Employees.size()) {
                t1Index = 0;
            }
        }

        while (!tier2TicketFile.isEmpty()) {
            Ticket ticket = tier2TicketFile.poll();
            Employee employee = tier2Employees.get(t2Index);
            String time = dateFormat.format(System.currentTimeMillis());

            WorkOrder workOrder = new WorkOrder(employee, ticket, time);

            workOrderList.add(workOrder);

            t2Index++;

            if (t2Index >= tier2Employees.size()) {
                t2Index = 0;
            }
        }
    }
}