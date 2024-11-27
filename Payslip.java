import java.util.ArrayList;

public class Payslip {
    /*  payslip has to display date, name, employee id, Hours worked, gross pay(hours * rate),
    individual deductions: usc, prsi, Net tax(gross tax - tax relief), union fees, healthInsurance,
     Net Pay(gross pay - deductions), prsi subclass
*/
    int month = 11; //counter for months in full time payslips
    ArrayList<PayslipObjects> payslipArrayList; //to create an array list of payslip objects


    //method that should see if an employee is either part-time or full-time, then prints the relevant payslip.
    public void printPayslip(int employeeID) {
        Employee employee = Employees.getEmployeeFromIndex(employeeID);
        PartTimeDeductionsCalculator partTimeCalculator = new PartTimeDeductionsCalculator();
        FullTimeDeductionsCalculator fullTimeCalculator = new FullTimeDeductionsCalculator();
        if (employee instanceof PartTimeEmployee) { //part-time payslips only show current months based on one hoursWorked value
            PartTimeEmployee partTimeEmployee = (PartTimeEmployee) employee;

            System.out.println("--------------------------------------------------------");
            System.out.println("                     Payslip                           ");
            System.out.println("--------------------------------------------------------");
            System.out.println("Employee Name: " + partTimeEmployee.getName());
            System.out.println("Employee ID:   " + partTimeEmployee.getId());
            System.out.println("Date:          " + "25/" + month + "/2024");
            System.out.println("--------------------------------------------------------");
            System.out.println("Hours Worked:        " + partTimeEmployee.getHoursWorkedThisPayPeriod());
            System.out.println("Gross Pay:           €" + (partTimeEmployee.getHoursWorkedThisPayPeriod() * partTimeEmployee.getHourlyRate()));
            System.out.println("--------------------------------------------------------");
            System.out.println("Deductions:");
            System.out.println("    USC:             €" + partTimeCalculator.calculateUscPaid(employeeID));
            System.out.println("    PRSI:            €" + partTimeCalculator.calculatePrsiPaid(employeeID));
            System.out.println("    Union Fees:      €" + partTimeCalculator.calculateUnionFees(employeeID));
            System.out.println("    Health Insurance:€" + partTimeCalculator.calculateHeathInsuranceCost(employeeID));
            System.out.println("    Net Tax:         €" + partTimeCalculator.calculateNetTax(employeeID));
            System.out.println("--------------------------------------------------------");
            System.out.println("PRSI Subclass:       " + partTimeCalculator.getPrsiSubClass());
            System.out.println("Net Pay:            €" + partTimeCalculator.calculateNetPay(employeeID));
            System.out.println("--------------------------------------------------------");

        }

        else if (employee instanceof FullTimeEmployee) { //Creates a full-time payslip object that is then stored in an arraylist
            payslipArrayList = new ArrayList<>();
            for (int i = 6; i <= 11; i++) {
                FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) employee;
                fullTimeEmployee.setSalary(employeeID);
                PayslipObjects payslip = new PayslipObjects(
                        "25/" + i + "/2024",
                        fullTimeEmployee.getName(),
                        fullTimeEmployee.getId(),
                        fullTimeCalculator.calculateUscPaid(employeeID),
                        fullTimeCalculator.calculatePrsiPaid(employeeID),
                        fullTimeCalculator.calculateUnionFees(employeeID),
                        fullTimeCalculator.calculateHeathInsurance(employeeID),
                        fullTimeCalculator.calculateNetTax(employeeID),
                        fullTimeCalculator.calculateFullTimeNetPay(employeeID),
                        fullTimeCalculator.getPrsiSubClass()
                );
                payslipArrayList.add(payslip); //can later bring up a specific payslip, doesn't show it on method call.
            }
        }
    }
}
