import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The CSVWriter class writes the employee data into two seperate CSV files 
 * based on whether an employee is a full time or part time employee
 */
public class CSVWriters {

    private PrintWriter fullTimeWriter;
    private PrintWriter partTimeWriter;

    /**
     * Initialises CSVWriters with filenames for part time and full time employees
     * @param fullTimeFilename  Name of file for CSV file for full time employees
     * @param partTimeFilename  Name of file for CSV file for part time employees
     * @throws FileNotFoundException If the files cannot be created 
     */
    
    public CSVWriters(String fullTimeFilename , String partTimeFilename) throws FileNotFoundException {
        fullTimeWriter = new PrintWriter(fullTimeFilename);
        partTimeWriter = new PrintWriter(partTimeFilename);
    }

   /**
    * Writes the headers for the columns in the full time employee CSV file. 
    */
    public void writeHeaderFullTimeEmployee() {
        fullTimeWriter.println("Name,Id,Job Title,PPS Number,Email,Address,Phone Number,Age,Medical Card Holder,Health Insurance Holder,Status,Tax Credits,Password,Number of Household Incomes,Household Higher Earner,Unions,Health Plan Name,Health Plan Type,Salary Scale Point,Department,Salary");
    }
    /**
     * Writes the headers for the columns in the part time employee CSV file
     */

    public void writeHeaderPartTimeEmployee() {
        partTimeWriter.println("Name,Id,Job Title,PPS Number,Email,Address,Phone Number,Age,Medical Card Holder,Health Insurance Holder,Status,Tax Credits,Password,Number of Household Incomes,Household Higher Earner,Unions,Health Plan Name,Health Plan Type,Hourly Rate Of Pay, Pay Claim Submitted,Date Pay Claim Form Submitted,Hours Worked This Pay Period");
    }


    /**
     * Writes the data for a full time employee to the full time employee CSV
     * @param employee
     */
    public void writeEmployeeFullEmployee(Employee employee) {
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) employee;
        String row = String.format("%s,%d,%s,%s,%s,%s,%s,%d,%b,%b,%s,%s,%s,%d,%b,%s,%s,%s,%s,%s,%.2f",
                fullTimeEmployee.getName(),                     // Name
                fullTimeEmployee.getId(),                       // Id
                fullTimeEmployee.getJobTitle(),                 // Job Title
                fullTimeEmployee.getPps(),                      // PPS Number
                fullTimeEmployee.getEmail(),                    // Email
                fullTimeEmployee.getAddress(),                  // Address
                fullTimeEmployee.getPhoneNum(),                 // Phone Number
                fullTimeEmployee.getAge(),                      // Age
                fullTimeEmployee.hasMedicalCard(),              // Medical Card Holder
                fullTimeEmployee.hasHealthInsurance(),          // Health Insurance Holder
                fullTimeEmployee.getStatus(),                   // Status
                String.join(";", fullTimeEmployee.getTaxCredits()), // Tax Credits
                fullTimeEmployee.getPassword(),                 // Password
                fullTimeEmployee.getNumIncomes(),               // Number of Household Incomes
                fullTimeEmployee.isHigherEarner(),              // Household Higher Earner
                String.join(";", fullTimeEmployee.getUnions()), // Unions
                fullTimeEmployee.getHealthPlan(),               // Health Plan Name
                fullTimeEmployee.getHealthPlanType(),           // Health Plan Type
                fullTimeEmployee.getSalaryScalePoint(),         // Salary Scale Point
                fullTimeEmployee.getDepartment(),               // Department
                fullTimeEmployee.getSalary()                	// Salary

        );

        fullTimeWriter.println(row);
    }
    /**
     * Writes the data of the part time employee to the part time CSV file 
     * @param employee
     */
    public void writeEmployeePartTimeEmployee(Employee employee) {
        PartTimeEmployee partTimeEmployee = (PartTimeEmployee) employee;
        String row = String.format(
                "%s,%d,%s,%s,%s,%s,%s,%d,%b,%b,%s,%s,%s,%d,%b,%s,%s,%s,%.2f,%b,%s,%.2f",
                partTimeEmployee.getName(),                       // Name
                partTimeEmployee.getId(),                         // Id
                partTimeEmployee.getJobTitle(),                   // Job Title
                partTimeEmployee.getPps(),                        // PPS Number
                partTimeEmployee.getEmail(),                      // Email
                partTimeEmployee.getAddress(),                    // Address
                partTimeEmployee.getPhoneNum(),                   // Phone Number
                partTimeEmployee.getAge(),                        // Age
                partTimeEmployee.hasMedicalCard(),                // Medical Card Holder
                partTimeEmployee.hasHealthInsurance(),            // Health Insurance Holder
                partTimeEmployee.getStatus(),                     // Status
                String.join(";", partTimeEmployee.getTaxCredits()), // Tax Credits
                partTimeEmployee.getPassword(),                   // Password
                partTimeEmployee.getNumIncomes(),                 // Number of Household Incomes
                partTimeEmployee.isHigherEarner(),                // Household Higher Earner
                String.join(";", partTimeEmployee.getUnions()),   // Unions
                partTimeEmployee.getHealthPlan(),                 // Health Plan Name
                partTimeEmployee.getHealthPlanType(),             // Health Plan Type
                partTimeEmployee.getHourlyRate(),                 // Hourly Rate Of Pay
                partTimeEmployee.getPayClaimSubmitted(),           // Pay Claim Submitted
                partTimeEmployee.getDatePayClaimSubmitted().toString(), // Date Pay Claim Form Submitted
                partTimeEmployee.getHoursWorkedThisPayPeriod()    // Hours Worked This Pay Period
        );

        partTimeWriter.println(row);
    }
    

    /**
     * Write all employees to the correct CSV file based on whether they are a part time or full time employee
     * @param employees
     */
    public void writeEmployeesToCSV(ArrayList<Employee> employees) {
        writeHeaderFullTimeEmployee();
        writeHeaderPartTimeEmployee();
        for (Employee employeeInfo : employees) {
            if(employeeInfo instanceof FullTimeEmployee) {
                writeEmployeeFullEmployee(employeeInfo);
            }else if(employeeInfo instanceof PartTimeEmployee) {
                writeEmployeePartTimeEmployee(employeeInfo);
            }

        }
        fullTimeWriter.close();
        partTimeWriter.close();
    }
}
