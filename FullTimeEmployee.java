public class FullTimeEmployee extends Employee {
    //subclass of employee for a full-time employee
    private String salaryScalePoint; //int to represent the point of the salary scale the employee is at
    private String department;// department name of the employee
    private double salary;//yearly salary of the employee//



    public FullTimeEmployee(String[] employeeDetails) {
        super(employeeDetails);
        this.salaryScalePoint = employeeDetails[17];
        this.department = employeeDetails[18];
        this.salary = Double.parseDouble(employeeDetails[19]);

    }

    public FullTimeEmployee(String name, int id, String jobTitle, String pps, String email, String address, String phoneNum, int age, boolean medicalCard, boolean healthInsurance, String status, String[] taxCredits, String password, int numIncomes, boolean higherEarner, String[] unions, String healthPlan, String healthPlanType, String salaryScalePoint, String department, int salary) {
        super(name, id, jobTitle, pps, email, address, phoneNum, age, medicalCard, healthInsurance, status, taxCredits, password, numIncomes, higherEarner, unions, healthPlan, healthPlanType);
        this.salaryScalePoint = salaryScalePoint;
        this.department = department;
        this.salary = salary;
    }

    // Getter and Setter for salaryScalePoint
    public String getSalaryScalePoint() {
        return salaryScalePoint;
    }


    public void setSalaryScalePoint(String salaryScalePoint) {
        this.salaryScalePoint = salaryScalePoint;
    }

    // Getter and Setter for office
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public void setSalary(int employeeId) {
        FullTimeDeductionsCalculator salaryCalc = new FullTimeDeductionsCalculator();
        this.salary = salaryCalc.getEmployeeSalaryWithoutDeductions(employeeId);
    }

    // Getter and Setter for professional category
    public double getSalary() {
        return salary;
    }


}
