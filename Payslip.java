import java.util.ArrayList;

public class Payslip {
    /*  payslip has to display date, name, employee id, Hours worked, gross pay(hours * rate),
    individual deductions: usc, prsi, Net tax(gross tax - tax relief), union fees, healthInsurance,
     Net Pay(gross pay - deductions), prsi subclass
*/
    int month = 11; //counter for months in full time payslips
    ArrayList<PayslipObjects> payslipArrayList; //to create an array list of payslip objects


    //method that should see if an employee is either part-time or full-time, then prints the relevant payslip.
    public void printPayslip(int employeeID, int index) {
        Employee employee = Employees.getEmployeeFromIndex(employeeID);
        PartTimeSalaryCalculator partTimeCalculator = new PartTimeSalaryCalculator();
        FullTimeSalaryCalculator fullTimeCalculator = new FullTimeSalaryCalculator();
        if (employee instanceof PartTimeEmployee) { //part-time payslips only show current months based on one hoursWorked value
            PartTimeEmployee partTimeEmployee = (PartTimeEmployee) employee;
            if(partTimeEmployee.validSubmissionDate(partTimeEmployee.getDatePayClaimSubmitted())){
                System.out.println("--------------------------------------------------------");
                System.out.println("                     Payslip                           ");
                System.out.println("--------------------------------------------------------");
                System.out.println("Employee Name: " + partTimeEmployee.getName());
                System.out.println("Employee ID:   " + partTimeEmployee.getId());
                System.out.println(("Employee PPS:  " + partTimeEmployee.getPps()));
                System.out.println("Date:          " + "25/" + month + "/2024");
                System.out.println("--------------------------------------------------------");
                System.out.println("Hours Worked:        " + partTimeEmployee.getHoursWorkedThisPayPeriod());
                System.out.println("Gross Pay:           €" + (partTimeEmployee.getHoursWorkedThisPayPeriod() * partTimeEmployee.getHourlyRate()));
                System.out.println("--------------------------------------------------------");
                System.out.println("Deductions:");
                System.out.printf("    USC:             €%.2f%n", partTimeCalculator.calculateUscPaid(employeeID));
                System.out.printf("    PRSI:            €%.2f%n", partTimeCalculator.calculatePrsiPaid(employeeID));
                System.out.printf("    Union Fees:      €%.2f%n", partTimeCalculator.calculateUnionFees(employeeID));
                System.out.printf("    Health Insurance:€%.2f%n", partTimeCalculator.calculateHeathInsuranceCost(employeeID));
                System.out.printf("    Income Tax:         €%.2f%n", partTimeCalculator.calculateNetTax(employeeID));
                System.out.println("--------------------------------------------------------");
                System.out.printf("PRSI Subclass:       %s%n", partTimeCalculator.getPrsiSubClass());
                System.out.printf("Net Pay:            €%.2f%n", partTimeCalculator.calculateNetPay(employeeID));
                System.out.println("--------------------------------------------------------");
            } else if (!partTimeEmployee.validSubmissionDate(partTimeEmployee.getDatePayClaimSubmitted())) {
                System.out.println("No Payslip Available: Payslip Submitted Too Late");
            }
        }

        else if (employee instanceof FullTimeEmployee) { //Creates a full-time payslip object that is then stored in an arraylist
            this.payslipArrayList = new ArrayList<>();
            for ( month = 11; month >= 6; month--) {
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
                payslipArrayList.add(payslip); //can later bring up a specific payslip, doesn't show it on method call.
                System.out.println(payslipArrayList.get(index));
            }
        }   else{
            System.out.println("No payslip to be printed");
        }

    }


}
