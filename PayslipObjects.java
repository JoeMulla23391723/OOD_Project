public class PayslipObjects { //constructor class to create payslip objects
    private String date;
    private String name;
    private int employeeID;
    private double usc;
    private double prsi;
    private double unionFees;
    private double healthInsurance;
    private double netTax;
    private double netPay;
    private String prsiSubClass;

    // Constructor
    public PayslipObjects(String date, String name, int employeeID, double usc, double prsi, double unionFees,
                        double healthInsurance, double netTax, double netPay, String prsiSubClass) {
        this.date = date;
        this.name = name;
        this.employeeID = employeeID;
        this.usc = usc;
        this.prsi = prsi;
        this.unionFees = unionFees;
        this.healthInsurance = healthInsurance;
        this.netTax = netTax;
        this.netPay = netPay;
        this.prsiSubClass = prsiSubClass;
    }

    //toString method
    @Override
    public String toString() {
        return "--------------------------------------------------------\n" +
                "                     Payslip                           \n" +
                "--------------------------------------------------------\n" +
                "Date:               " + date + "\n" +
                "Employee Name:      " + name + "\n" +
                "Employee ID:        " + employeeID + "\n" +
                "--------------------------------------------------------\n" +
                "Deductions:                                         \n" +
                "    USC:             €" + String.format("%.2f", usc) + "\n" +
                "    PRSI:            €" + String.format("%.2f", prsi) + "\n" +
                "    Union Fees:      €" + String.format("%.2f", unionFees) + "\n" +
                "    Health Insurance:€" + String.format("%.2f", healthInsurance) + "\n" +
                "    Net Tax:         €" + String.format("%.2f", netTax) + "\n" +
                "--------------------------------------------------------\n" +
                "PRSI Subclass:       " + prsiSubClass + "\n" +
                "Net Pay:            €" + String.format("%.2f", netPay) + "\n" +
                "--------------------------------------------------------";
    }


}
