
import java.util.ArrayList;

public class Payslip {
    /*  payslip has to display date, name, employee id, Hours worked, gross pay(hours * rate),
    individual deductions: usc, prsi, Net tax(gross tax - tax relief), union fees, healthInsurance,
     Net Pay(gross pay - deductions), prsi subclass
    */

    int month = 11;//month counter
    ArrayList<PayslipObjects> payslipArrayList;//initialising arraylist to store fulltime payslips


    /**
     * Method to create a payslip
     * First checks if the employee we are logged in as is full-time or part-time
     * If they are part-time it first checks if a payclaim has been submitted and if was submitted in time
     * It then creates a current payslip only
     * If they are full-time, it creates 6 different payslips, which can later be printed
     * based on a specific month
     *
     * @param employeeID employeeID of the employee
     * @param index which payslip to generate for the full-time employee
     *
     */
    public void printPayslip(int employeeID, int index) {
        Employee employee = Employees.getEmployeeFromIndex(employeeID);
        PartTimeSalaryCalculator partTimeCalculator = new PartTimeSalaryCalculator();
        FullTimeSalaryCalculator fullTimeCalculator = new FullTimeSalaryCalculator();
        if (employee instanceof PartTimeEmployee) {
            PartTimeEmployee partTimeEmployee = (PartTimeEmployee) employee;
            if (partTimeEmployee.validSubmissionDate(partTimeEmployee.getDatePayClaimSubmitted()) && (partTimeEmployee.getPayClaimSubmitted())) {
                System.out.println("--------------------------------------------------------");
                System.out.println("                     Payslip                           ");
                System.out.println("--------------------------------------------------------");
                System.out.println("Employee Name: " + partTimeEmployee.getName());
                System.out.println("Employee ID:   " + partTimeEmployee.getId());
                System.out.println(("Employee PPS:  " + partTimeEmployee.getPps()));
                System.out.println("Date:          " + "25/" + month + "/2024");
                System.out.println("--------------------------------------------------------");
                System.out.println("Hours Worked:        " + partTimeEmployee.getHoursWorkedThisPayPeriod());
                System.out.println(("Hourly Rate:        " + partTimeEmployee.getHourlyRate()));
                System.out.println("Gross Pay:           €" + (partTimeEmployee.getHoursWorkedThisPayPeriod() * partTimeEmployee.getHourlyRate()));
                System.out.println("--------------------------------------------------------");
                System.out.println("Deductions:");
                System.out.printf("    USC:             €%.2f%n", partTimeCalculator.calculateUscPaid(employeeID));
                System.out.printf("    PRSI:            €%.2f%n", partTimeCalculator.calculatePrsiPaid(employeeID));
                System.out.printf("    Union Fees:      €%.2f%n", partTimeCalculator.calculateUnionFees(employeeID));
                System.out.printf("    Health Insurance:€%.2f%n", partTimeCalculator.calculateHeathInsuranceCost(employeeID));
                System.out.printf("    Income Tax:      €%.2f%n", partTimeCalculator.calculateNetTax(employeeID));
                System.out.println("--------------------------------------------------------");
                System.out.printf("PRSI Subclass:       %s%n", partTimeCalculator.getPrsiSubClass());
                System.out.printf("Net Pay:             €%.2f%n", partTimeCalculator.calculateNetPay(employeeID));
                System.out.println("--------------------------------------------------------");
            } else if (!partTimeEmployee.getPayClaimSubmitted()) {
                System.out.println("No Payslip Available: Payslip Not Submitted");
            }else if (!partTimeEmployee.validSubmissionDate(partTimeEmployee.getDatePayClaimSubmitted())) {
                System.out.println("No Payslip Available: Payslip Submitted Too Late");
            }
        }

        else if (employee instanceof FullTimeEmployee) { //Creates a full-time payslip object that is then stored in an arraylist
            this.payslipArrayList = new ArrayList<>();
            for (month = 11; month >= 6; month--) {
                FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) employee;
                fullTimeEmployee.setSalary(employeeID);
                PayslipObjects payslip = new PayslipObjects(
                        "25/" + month + "/2024",
                        fullTimeEmployee.getName(),
                        fullTimeEmployee.getId(),
                        fullTimeEmployee.getPps(),
                        fullTimeCalculator.calculateUscPaid(employeeID),
                        fullTimeCalculator.calculatePrsiPaid(employeeID),
                        fullTimeCalculator.calculateUnionFees(employeeID),
                        fullTimeCalculator.calculateHeathInsurance(employeeID),
                        fullTimeCalculator.calculateNetTax(employeeID),
                        fullTimeCalculator.calculateFullTimeNetPay(employeeID),
                        fullTimeCalculator.getPrsiSubClass()
                );
                payslipArrayList.add(payslip); //added to an array list
            }
            System.out.println(payslipArrayList.get(index));//prints the specified months payslip.
        }   else{
            System.out.println("No payslip to be printed");
        }

    }


}
