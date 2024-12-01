public class PayslipObjects { //constructor class to create payslip objects
    private String date;
    private String name;
    private String pps;
    private int employeeID;
    private double usc;
    private double prsi;
    private double unionFees;
    private double healthInsurance;
    private double netTax;
    private double netPay;
    private String prsiSubClass;

    /**
     * Constructor for a full-time payslip object
     * parameters will be filled using values found in salarycalculators
     * is called upon in Payslip
     * @param date Date of payslip printed
     * @param name Name of the employee
     * @param employeeID ID number of the employee
     * @param pps PPS number of the employee
     * @param usc USC to be paid by the employee
     * @param prsi PRSI to be paid by the employee
     * @param unionFees Union Fees to be paid by the employee
     * @param healthInsurance Health Insurance costs to be paid
     * @param netTax Income tax of the employee, seperate from the other deductions
     * @param netPay Employee's net pay
     * @param prsiSubClass String of the employee's prsi subclass
     */
    public PayslipObjects(String date, String name, int employeeID, String pps, double usc, double prsi, double unionFees,
                          double healthInsurance, double netTax, double netPay, String prsiSubClass) {
        this.date = date;
        this.name = name;
        this.pps = pps;
        this.employeeID = employeeID;
        this.usc = usc;
        this.prsi = prsi;
        this.unionFees = unionFees;
        this.healthInsurance = healthInsurance;
        this.netTax = netTax;
        this.netPay = netPay;
        this.prsiSubClass = prsiSubClass;
    }

    /**
     * toString() method for a full-time payslip object
     * @return
     */
    @Override
    public String toString() {
        return "--------------------------------------------------------\n" +
                "                     Payslip                           \n" +
                "--------------------------------------------------------\n" +
                "Date:               " + date + "\n" +
                "Employee Name:      " + name + "\n" +
                "Employee ID:        " + employeeID + "\n" +
                "Employee PPS:       " + pps + "\n"+
                "--------------------------------------------------------\n" +
                "Deductions:                                         \n" +
                "    USC:             €" + String.format("%.2f", usc) + "\n" +
                "    PRSI:            €" + String.format("%.2f", prsi) + "\n" +
                "    Union Fees:      €" + String.format("%.2f", unionFees) + "\n" +
                "    Health Insurance:€" + String.format("%.2f", healthInsurance) + "\n" +
                "    Income Tax:      €" + String.format("%.2f", netTax) + "\n" +
                "--------------------------------------------------------\n" +
                "PRSI Subclass:       " + prsiSubClass + "\n" +
                "Net Pay:            €" + String.format("%.2f", netPay) + "\n" +
                "--------------------------------------------------------";
    }


}