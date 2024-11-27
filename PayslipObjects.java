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
    public String toString() {
        return "Date: " + date + "\nName: " + name + "\nEmployee ID: " + employeeID +
                "\nUSC: " + usc + "\nPRSI: " + prsi + "\nUnion Fees: " + unionFees +
                "\nHealth Insurance: " + healthInsurance + "\nNet Tax: " + netTax +
                "\nNet Pay: " + netPay + "\nPRSI Subclass: " + prsiSubClass;
    }
}
