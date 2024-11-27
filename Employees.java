import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Employees {
    // ArrayList of type Employee that will contain Employee objects
    private static ArrayList<Employee> employees;

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
    public void addFullTimeEmployee(FullTimeEmployee ft){
        employees.add(ft);
    }

    // Method to add a new part-time employee
    public void addPartTimeEmployee(PartTimeEmployee pt){
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
    public static int getIndexOfEmployeeID(int employeeID) throws IllegalArgumentException{
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
        }
        else {
            throw new IllegalArgumentException("Employee does not exist in the system");
        }
        return index;
    }

    // Method to get Employee object using index position in the array
    public static Employee getEmployeeFromIndex(int employeeID){
       Employee e = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
        return e;
    }

    // Full-time employee specific methods

    // Method to get the promotion level of a full-time employee, given its index position
    public int getPromotionLevel(int employeeID) {
        Employee fulltime = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fulltime;
        return Integer.parseInt(fullTimeEmployee.getSalaryScalePoint());
    }

    // Method to get the salary of a full-time employee before deductions are applied
    public double getEmployeeSalaryWithoutDeductions(int employeeID) {
        int salary = 0;
        Payscale payscale = new Payscale();
        int[] salaryScales = payscale.getPayscaleByProfession((getIndexOfEmployeeID(employeeID)));
        salary = payscale.getSalaryWithoutDeductions(salaryScales, getPromotionLevel(getIndexOfEmployeeID(employeeID)));
        return salary;
    }

    // Method to get the salary of a full-time employee after deductions are applied
    public double calculateFullTimeNetPay(int employeeID) throws IllegalArgumentException {
        Employee employee = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
        if (employee instanceof FullTimeEmployee) {
            FullTimeDeductionsCalculator deductions = new FullTimeDeductionsCalculator();
            netPayPerMonth = (getEmployeeSalaryWithoutDeductions(employeeID) / 12) - (deductions.calculateUscPaid(employeeID) + deductions.calculatePrsiPaid(employeeID) +
                    deductions.calculateNettTax(employeeID) + deductions.calculateNettTax(employeeID) + deductions.calculateUnionFees(employeeID) + deductions.calculateHeathInsurance(employeeID));
        }
        else{
            throw new IllegalArgumentException("Employee is not employed on a full-time basis");
        }
        return netPayPerMonth;
    }

    // Method to change employee profession based on time served at top of scale and reset salary point to 1

    public void changeJobTitle(int employeeID, String jobTitle) {
        Employee fulltime = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fulltime;
        fullTimeEmployee.setJobTitle(jobTitle);
        fullTimeEmployee.setSalaryScalePoint("0");
    }

    // Method to change employee salary point
    public void incrementSalaryScalePoint(int employeeID, String salaryScalePoint) {
        Employee fullTime = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fullTime;
        fullTimeEmployee.setSalaryScalePoint(salaryScalePoint);
    }

    // Method to check if an employee is at the top of their salary scale

    // Method to promote an employee
    public void promoteEmployeeBasedOnTime(int employeeID, String salaryScalePoint) throws IllegalArgumentException {
        Employee fullTime = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fullTime;
        int currentMonth = LocalDate.now().getMonthValue();
        if (currentMonth >= 10) {
            if () {
                incrementSalaryScalePoint(employeeID, salaryScalePoint);
            }
        }
    }


    // Part-Time specific methods

    //Methods to set and get the submission deadline of the pay-claim form
    public void setSubmissionDeadline(LocalDate submissionDeadline) {
        submissionDeadLine = submissionDeadline;
    }

    public LocalDate getSubmissionDeadline() {
        return submissionDeadLine;
    }

    // Method to check if an employee has submitted pay-claim form by
    public boolean checkIfEmployeeEligibleForPayment(int employeeID, LocalDate submissionDeadline) {
        Employee partTime = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
        PartTimeEmployee partTimeEmployee = (PartTimeEmployee) partTime;
        boolean eligibility = false;
        //Need to figure out submission deadline
        if (partTimeEmployee.getDatePayClaimSubmitted().isBefore(submissionDeadline) || partTimeEmployee.getDatePayClaimSubmitted().equals(submissionDeadline)) {
            eligibility = true;
        }
        return eligibility;
    }

    // Method to calculate monthly net pay of a part time employee
    public double calculatePartTimeNetPay(int employeeID, LocalDate submissionDeadline) {
        if (checkIfEmployeeEligibleForPayment(employeeID, submissionDeadline)) {
            Employee employee = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
            if (employee instanceof PartTimeEmployee) {
                PartTimeEmployee partTimeEmployee = (PartTimeEmployee) employee;
                PartTimeDeductionsCalculator deductions = new PartTimeDeductionsCalculator();
                double hoursWorked = partTimeEmployee.getHoursWorkedThisPayPeriod();
                double hourlyRateOfPay = partTimeEmployee.getHourlyRate();
                double temp = hoursWorked * hourlyRateOfPay;
                netPayPerMonth = temp - (deductions.calculateUscPaid(employeeID) + deductions.calculatePrsiPaid(employeeID) +
                        deductions.calculateNettTax(employeeID) + deductions.calculateUnionFees(employeeID)
                        + deductions.calculateHeathInsuranceCost(employeeID));
            } else {
                throw new IllegalArgumentException("Employee is not employed on a part time basis");
            }
        } else {
            throw new IllegalArgumentException("employee is not eligible for pay this period: pay claim form was not submitted");
        }
        return netPayPerMonth;
    }
}


















