
import java.time.LocalDate;
import java.util.*;
import java.time.LocalDateTime;

public class Promotions {
    private int employeeID;
    private LocalDate now = LocalDate.now();
    private static ArrayList<Promotions> promotions = new ArrayList<Promotions>();

    // Constructor
    public Promotions(int employeeID, LocalDate now) {
        this.employeeID = employeeID;
        this.now = LocalDate.now();
    }

    // Method to change employee profession and reset salary point to 1
    public void changeJobTitle(int employeeID, String jobTitle) {
       Employee employee = Employees.getEmployeeFromIndex(employeeID);
        employee.setJobTitle(jobTitle);
    }

    // Method to promote an employee every october if they have not been promoted already that month
    public void promoteEmployeeBasedOnTime(int employeeID) throws IllegalArgumentException {
        int currentMonth = LocalDate.now().getMonthValue();
        if (currentMonth == 10) {
            for (Promotions promotion : promotions) {
                if (promotion.getEmployeeID() == employeeID && promotion.getNow().getMonthValue() == now.getMonthValue()) {
                    promotions.add(new Promotions(employeeID, LocalDate.now()));
                }
                else { throw new IllegalArgumentException("Employee has already been promoted"); }
            }
        }
        else {
            throw new IllegalArgumentException("Employee cannot be promoted this month"); }
    }
    
            //Getter and setter methods for data fields
            public int getEmployeeID () {
                return employeeID;
            }

            public void setEmployeeID ( int employeeID){
                this.employeeID = employeeID;
            }

            public LocalDate getNow () {
                return now;
            }
}





