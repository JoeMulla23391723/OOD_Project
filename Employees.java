import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Employees {
    // ArrayList of type Employee that will contain Employee objects
    private static ArrayList<Employee> employees = new ArrayList<>();
   


    // Necessary data fields
    private double netPayPerMonth;
    private LocalDate submissionDeadLine;

    // Method to read in full time employees into the ArrayList from CSV file
    public void readFullTimeEmployees(String fileName) throws FileNotFoundException {
        CSVReaders reader = new CSVReaders(fileName);
        ArrayList<FullTimeEmployee> employeeDetails = reader.readFullTimeEmployees();
        for (FullTimeEmployee employee : employeeDetails) {
            employees.add(employee);
        }
    }

    // Method to read in part-time employees into the ArrayList from CSV file
    public void readPartTimeEmployees(String fileName) throws FileNotFoundException, IllegalArgumentException {
        CSVReaders reader = new CSVReaders(fileName);
        ArrayList<PartTimeEmployee> employeeDetails = reader.readPartTimeEmployees();
        for (PartTimeEmployee employee : employeeDetails) {
            employees.add(employee);
        }
    }

    // Constructor that takes array of employee objects read in from a CSV reader
    public Employees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    // Method to return list of employee objects
    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    // Method to add a new full-time employee
    public static void addFullTimeEmployee(FullTimeEmployee ft) {
        employees.add(ft);
    }

    // Method to add a new part-time employee
    public static void addPartTimeEmployee(PartTimeEmployee pt) {
        employees.add(pt);
    }


    //Method to check if an employee exists in the system
    public boolean checkEmployeeIDExists(int employeeID) {
        boolean here = false;
        for (Employee employee : Employees.getEmployees()) {
            if (employee.getId() == employeeID) {
                here = true;
            }
        }
        return here;
    }

    //Method to get the index position of an employee in the employees array base on index position
    public static int getIndexOfEmployeeID(int employeeID) throws IllegalArgumentException {
        boolean here = false;
        for (Employee employee : getEmployees()) {
            if (employee.getId() == employeeID) {
                here = true;
            }
        }
        int index = 0;
        if (here) {
            for (int i = 0; i < getEmployees().size(); i++) {
                if (getEmployees().get(i).getId() == employeeID) {
                    index = i;
                }
            }
        } else {
            throw new IllegalArgumentException("Employee does not exist in the system");
        }
        return index;
    }

    // Method to get Employee object using index position in the array
    public static Employee getEmployeeFromIndex(int employeeID) {
        Employee e = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
        return e;
    }

    // Method to get the promotion level of a full-time employee, given its index position
    public static int getPromotionLevel(int employeeID) {
        Employee fulltime = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fulltime;
        return Integer.parseInt(fullTimeEmployee.getSalaryScalePoint());
    }
    
    
    
    
    
    
    
    
    
    
    // Part-Time specific methods  - Will maybe add to part time calculator
    //Methods to set and get the submission deadline of the pay-claim form
    public void setSubmissionDeadline(LocalDate submissionDeadline) {
        submissionDeadLine = submissionDeadline;
    }

    public LocalDate getSubmissionDeadline() {
        return submissionDeadLine;
    }
    // Method to check if an employee has been promoted this year


    // Method to check if an employee has submitted pay-claim form by
    public boolean checkIfEmployeeEligibleForPayment(int employeeID, LocalDate submissionDeadline) {
        Employee parttime = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
        PartTimeEmployee partTimeEmployee = (PartTimeEmployee) parttime;
        boolean eligibility = false;
        //Need to figure out submission deadline
        if (partTimeEmployee.getDatePayClaimSubmitted().isBefore(submissionDeadline) || partTimeEmployee.getDatePayClaimSubmitted().equals(submissionDeadline)) {
            eligibility = true;
        }
        return eligibility;
    }
}

















