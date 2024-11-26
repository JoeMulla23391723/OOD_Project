import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;


    
public class Employees {
    //Static as it belongs to this class not to instances of the class
    private static ArrayList<Employee> employees;
    private double nettPayPerMonth;
    private LocalDate submissionDeadLine;

    //Constructor that takes array of employee objects
    public Employees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    //Return list of employee objects
    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    //Adds existing full time employee to the employees array from the CSV file
    public void readFullTimeEmployees(String fileName) throws FileNotFoundException {
        CSVReaders reader = new CSVReaders(fileName);
        ArrayList<FullTimeEmployee> employeeDetails = reader.readFullTimeEmployees();

        for (FullTimeEmployee employee : employeeDetails) {
            employees.add(employee);
        }
    }

    //Adds existing full time employee to the employees array from the CSV file//HR can do this
    public void readPartTimeEmployees(String fileName) throws FileNotFoundException {
        CSVReaders reader = new CSVReaders(fileName);
        ArrayList<PartTimeEmployee> employeeDetails = reader.readPartTimeEmployees();
        for (PartTimeEmployee employee : employeeDetails) {
            employees.add(employee);
        }
    }

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
    public int getIndexOfEmployeeID(int employeeID) {
        boolean here = false;
        for (Employee employee : Employees.getEmployees()) {
            if (employee.getId() == employeeID) {
                here = true;
            }
        }
        int index = 0;
        if (here) {
            for (int i = 0; i < Employees.getEmployees().size(); i++) {
                if (Employees.getEmployees().get(i).getId() == employeeID) {
                    index = i;
                }
            }
        }
        return index;
    }

    //Full-Time Employee Only
    //Method to get the promotion level of a full-time employee, given its index position
    public int getPromotionLevel(int employeeID) {
        Employee fulltime = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fulltime;
        return Integer.parseInt(fullTimeEmployee.getSalaryScalePoint());
    }

    //Full-Time Salary Calculations
    public double getEmployeeSalaryWithoutDeductions(int employeeID) {
        int salary = 0;
        Payscale payscale = new Payscale();
        int[] salaryScales = payscale.getPayscaleByProfession((getIndexOfEmployeeID(employeeID)));
        salary = payscale.getSalaryWithoutDeductions(salaryScales, getPromotionLevel(getIndexOfEmployeeID(employeeID)));
        return salary;
    }

    public double calculateFullTimeNettPay(int employeeID) {
        FullTimeDeductionsCalculator deductions = new FullTimeDeductionsCalculator();
        nettPayPerMonth = (getEmployeeSalaryWithoutDeductions(employeeID) / 12) - (deductions.calculateUscPaid(employeeID) + deductions.calculatePrsiPaid(employeeID) +
                deductions.calculateNettTax(employeeID) + deductions.calculateNettTax(employeeID) + deductions.calculateUnionFees(employeeID) + deductions.calculateHeathInsurance(employeeID));
        return nettPayPerMonth;
    }

    //Methods to change employees salary - controlled by HR - Promotion
    //Method to change employee profession based on time served at top of scale and change salary point to 1
    public void changeJobTitle(int employeeID, String jobTitle) {
        Employee fulltime = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fulltime;
        fullTimeEmployee.setJobTitle(jobTitle);
        fullTimeEmployee.setSalaryScalePoint("0");
    }

    //Method to change employee salary point
    public void incrementSalaryScalePoint(int employeeID, String salaryScalePoint) {
        Employee fulltime = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fulltime;
        fullTimeEmployee.setSalaryScalePoint(salaryScalePoint);
    }

    public void promoteEmployeeBasedOnTime(int employeeID, String salaryScalePoint) {
        Employee fulltime = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fulltime;
        int currentMonth = LocalDate.now().getMonthValue();
        if (currentMonth >= 10) {
            incrementSalaryScalePoint(employeeID, salaryScalePoint);
        }
    }



    //Part-Time Salary Calculations
    public void setSubmissionDeadline(LocalDate submissionDeadline) {
        submissionDeadLine = submissionDeadline;
    }

    public LocalDate getSubmissionDeadline() {
        return submissionDeadLine;
    }

    public boolean checkIfEmployeeEligibleForPayment(int employeeID, LocalDate submissionDeadline) {
        Employee parttime = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
        PartTimeEmployee partTimeEmployee = (PartTimeEmployee) parttime;
        boolean eligibility = false;
        //Need to figure out submission deadline
        if (partTimeEmployee.getDatePayClaimSubmitted().isBefore(submissionDeadline) || partTimeEmployee.getDatePayClaimSubmitted().equals(submissionDeadline)){
            eligibility = true;
        }
        return eligibility;
    }

    public double calculatePartTimeNettPay(int employeeID, LocalDate submissionDeadline) {
        if (checkIfEmployeeEligibleForPayment(employeeID, submissionDeadline)) {
            Employee parttime = Employees.getEmployees().get(getIndexOfEmployeeID(employeeID));
            PartTimeEmployee partTimeEmployee = (PartTimeEmployee) parttime;
            PartTimeDeductionsCalculator deductions = new PartTimeDeductionsCalculator();
            double hoursWorked = partTimeEmployee.getHoursWorkedThisPayPeriod();
            double hourlyRateOfPay = partTimeEmployee.getHourlyRate();
            double temp = hoursWorked * hourlyRateOfPay;
            nettPayPerMonth = temp - (deductions.calculateUscPaid(employeeID) + deductions.calculatePrsiPaid(employeeID) +
                    deductions.calculateNettTax(employeeID) + deductions.calculateUnionFees(employeeID)
                    + deductions.calculateHeathInsuranceCost(employeeID));
        } else {
            throw new IllegalArgumentException("Employee not eligible for Pay");
        }
        return nettPayPerMonth;
    }
}


















