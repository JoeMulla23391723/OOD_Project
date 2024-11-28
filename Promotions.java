
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
        Employee fulltime = Employees.getEmployeeFromIndex(employeeID);
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fulltime;
        fullTimeEmployee.setJobTitle(jobTitle);
        fullTimeEmployee.setSalaryScalePoint("0");
    }

    // Method to check if an employee is at the top of their salary scale
    public boolean isEmployeeAtTop(int employeeID) {
        boolean value = false;
        Payscale payscale = new Payscale();
        double[] salaryScales = payscale.getPayscaleByProfession((Employees.getIndexOfEmployeeID(employeeID)));
        double maxPointOnScale = salaryScales[salaryScales.length - 1];
        int employeePromotionLevel = Employees.getPromotionLevel(employeeID);
        if (employeePromotionLevel > maxPointOnScale) {
            value = true;
        }
        return value;
    }

    // Method to change employee salary point if emplpoyee is not at the top of their salary scale
    public void incrementSalaryScalePoint(int employeeID, String salaryScalePoint) throws IllegalArgumentException {
        if (!isEmployeeAtTop(employeeID)) {
                    Employee fulltime = Employees.getEmployeeFromIndex(employeeID);
                    FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fulltime;
                    fullTimeEmployee.setSalaryScalePoint(salaryScalePoint);
                    promotions.add(new Promotions(employeeID, LocalDate.now()));
                } else {
                    throw new IllegalArgumentException("Employee cannot be promoted further");
                }
            }


    // Method to promote an employee every october if they have not been promoted already that month
    public void promoteEmployeeBasedOnTime(int employeeID, String salaryScalePoint) throws IllegalArgumentException {
        int currentMonth = LocalDate.now().getMonthValue();
        if (currentMonth == 10) {
            for (Promotions promotion : promotions) {
                if (promotion.getEmployeeID() == employeeID && promotion.getNow().getMonthValue() == now.getMonthValue()) {
                    incrementSalaryScalePoint(employeeID, salaryScalePoint);
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





