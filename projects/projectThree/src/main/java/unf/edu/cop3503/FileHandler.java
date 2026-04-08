package unf.edu.cop3503;

import java.io.PrintWriter;
import java.util.ArrayList;

public class FileHandler {
    private ArrayList<Employee> employeeList;
    private ArrayList<WorkOrder> workOrderList;

    public FileHandler(ArrayList<Employee> employeeList, ArrayList<WorkOrder> workOrderList) {
        this.employeeList = employeeList;
        this.workOrderList = workOrderList;
    }

    public void writeData(String workOrderFileName){
        try {
            // Create output file
            PrintWriter output = new PrintWriter(workOrderFileName);

            // Writes the header line
            output.println("customer_id,customer_first_name,customer_last_name,ticket_id,ticket_createdAt,workorder_createdAt,employee_id,employee_first_name,employee_last_name,clocked_in,certification");

            // Loop to write each road section inside output file
            for(int i = 0; i < workOrderList.size(); i++) {
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

    public void readEmployee(String employeeFileName) {
        // TODO: Implement readImployee() logic
    }

    
}
