public class Payslip {
    /*  payslip has to display date, name, employee id, Hours worked, gross pay(hours * rate),
    individual deductions: usc, prsi, Net tax(gross tax - tax relief), union fees, healthInsurance,
     Net Pay(gross pay - deductions), prsi subclass
*/

    if(employee_id instanceof PartTimeEmployee){
        System.out.println("Date" + date);
        System.out.println("Name" + name);
        System.out.println("Employee ID: " + employee_id);
        System.out.println("Hours worked this period: " + hoursWorked);
        System.out.println("Gross Pay: " + grossPay);
        System.out.println("USC: " + uscToPayPerMonth);
        System.out.println("PRSI: " + prsiToPayPerMonth);
        System.out.println("Union Fees: " + totalUnionFeesPerMonth);
        System.out.println("Health Insurance: " + healthInsuranceCostPerMonth);
        System.out.println("Net Tax: " + getNetTax);
        System.out.println("Net Pay: " + netPayPerMonth);
        System.out.println("Prsi Subclass: " + prsiSubClass);
    }

    if(employee_id instanceof FullTimeEmployee){
        System.out.println("Date" + date);
        System.out.println("Name" + name);
        System.out.println("Employee ID: " + employee_id);
        System.out.println("Hours worked this period: " + hoursWorked);
        System.out.println("Gross Pay: " + grossPay);
        System.out.println("USC: " + uscToPayPerMonth);
        System.out.println("PRSI: " + prsiToPayPerMonth);
        System.out.println("Union Fees: " + totalUnionFeesPerMonth);
        System.out.println("Health Insurance: " + healthInsuranceCostPerMonth);
        System.out.println("Net Tax: " + getNetTax);
        System.out.println("Net Pay: " + netPayPerMonth);
        System.out.println("Prsi Subclass: " + prsiSubClass);
    }
}
