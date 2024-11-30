import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class CSVWriters {

    private PrintWriter fullTimeWriter;
    private PrintWriter partTimeWriter;

    //initialize the writer
    public CSVWriters(String fullTimeFilename , String partTimeFilename ) throws FileNotFoundException {
        fullTimeWriter = new PrintWriter(fullTimeFilename);
        partTimeWriter = new PrintWriter(partTimeFilename);
    }

    // write the headers of the columns of the CSV file
    public void writeHeaderFullTimeEmployee() {
        fullTimeWriter.println("Name,Id,Job Title,PPS Number,Email,Address,Phone Number,Age,Medical Card Holder,Health Insurance Holder,Status,Tax Credits,Password,Number of Household Incomes,Household Higher Earner,Unions,Health Plan Name,Health Plan Type,Salary Scale Point,Department,Salary");
    }

    public void writeHeaderPartTimeEmployee() {
        partTimeWriter.println("Name,Id,Job Title,PPS Number,Email,Address,Phone Number,Age,Medical Card Holder,Health Insurance Holder,Status,Tax Credits,Password,Number of Household Incomes,Household Higher Earner,Unions,Health Plan Name,Health Plan Type,Hourly Rate Of Pay, Pay Claim Submitted,Date Pay Claim Form Submitted,Hours Worked This Pay Period");
    }


    // Method to write data for a single employee
    public void writeEmployeeFullEmployee(Employee employee) {
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) employee;
        String row = String.format("%s,%d,%s,%s,%s,%s,%s,%d,%b,%b,%s,%s,%s,%d,%b,%s,%s,%s,%s,%s,%.2f",
                fullTimeEmployee.getName(),                     
                fullTimeEmployee.getId(),                       
                fullTimeEmployee.getJobTitle(),                 
                fullTimeEmployee.getPps(),                      
                fullTimeEmployee.getEmail(),                    
                fullTimeEmployee.getAddress(),                  
                fullTimeEmployee.getPhoneNum(),                 
                fullTimeEmployee.getAge(),                      
                fullTimeEmployee.hasMedicalCard(),              
                fullTimeEmployee.hasHealthInsurance(),          
                fullTimeEmployee.getStatus(),                   
                String.join(";", fullTimeEmployee.getTaxCredits()), 
                fullTimeEmployee.getPassword(),                 
                fullTimeEmployee.getNumIncomes(),               
                fullTimeEmployee.isHigherEarner(),              
                String.join(";", fullTimeEmployee.getUnions()), 
                fullTimeEmployee.getHealthPlan(),               
                fullTimeEmployee.getHealthPlanType(),           
                fullTimeEmployee.getSalaryScalePoint(),         
                fullTimeEmployee.getDepartment(),               
                fullTimeEmployee.getSalary()                	

        );

        fullTimeWriter.println(row);
    }

    public void writeEmployeePartTimeEmployee(Employee employee) {
        PartTimeEmployee partTimeEmployee = (PartTimeEmployee) employee;
        String row = String.format(
                "%s,%d,%s,%s,%s,%s,%s,%d,%b,%b,%s,%s,%s,%d,%b,%s,%s,%s,%.2f,%b,%s,%.2f",
                partTimeEmployee.getName(),                       
                partTimeEmployee.getId(),                         
                partTimeEmployee.getJobTitle(),                  
                partTimeEmployee.getPps(),                        
                partTimeEmployee.getEmail(),                    
                partTimeEmployee.getAddress(),                    
                partTimeEmployee.getPhoneNum(),                   
                partTimeEmployee.getAge(),                        
                partTimeEmployee.hasMedicalCard(),                
                partTimeEmployee.hasHealthInsurance(),            
                partTimeEmployee.getStatus(),                    
                String.join(";", partTimeEmployee.getTaxCredits()), 
                partTimeEmployee.getPassword(),                   
                partTimeEmployee.getNumIncomes(),                 
                partTimeEmployee.isHigherEarner(),                
                String.join(";", partTimeEmployee.getUnions()),   
                partTimeEmployee.getHealthPlan(),                 
                partTimeEmployee.getHealthPlanType(),             
                partTimeEmployee.getHourlyRate(),                 
                partTimeEmployee.getPayClaimSubmitted(),          
                partTimeEmployee.getDatePayClaimSubmitted().toString(), 
                partTimeEmployee.getHoursWorkedThisPayPeriod()   
        );

        partTimeWriter.println(row);
    }
    private void writeHeaders() {
        fullTimeWriter.println("Name, Id, Job Title, PPS Number, Email, Address, Phone Number, Age, Medical Card Holder, Health Insurance Holder, Status, Tax Credits, Password, Number of Household Incomes, Household Higher Earner, Unions, Health Plan Name, Health Plan Type, Salary Scale Point, Department, Salary, Years At Top Of Scale, Professional Category");
        partTimeWriter.println("Name, Id, Job Title, PPS Number, Email, Address, Phone Number, Age, Medical Card Holder, Health Insurance Holder, Status, Tax Credits, Password, Number of Household Incomes, Household Higher Earner, Unions, Health Plan Name, Health Plan Type, Hourly Rate Of Pay, Pay Claim Submitted, Date Pay Claim Form Submitted, Hours Worked This Pay Period");
    }


    // Method to write all employees to the CSV file
    public void writeEmployeesToCSV(ArrayList<Employee> employees) {
        writeHeaders();
        for (Employee employeeInfo : employees) {
            if(employeeInfo instanceof FullTimeEmployee) {
                writeEmployeeFullEmployee(employeeInfo);
            }else {
                writeEmployeePartTimeEmployee(employeeInfo);
            }

        }
        fullTimeWriter.close();
        partTimeWriter.close();
    }
}
