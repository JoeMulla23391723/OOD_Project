
public class FullTimeEmployee extends Employee {
    //subclass of employee for a full-time employee
    private String salaryScalePoint; //int to represent the point of the salary scale the employee is at
    private String department;// department name of the employee
    private int salary;//yearly salary of the employee
    private String professionalCategory;//Employee's professional category eg (Academic/Administrative/IT/Technical etc...)


    public FullTimeEmployee(String[] employeeDetails) {
        super(employeeDetails);
        this.salaryScalePoint = employeeDetails[17];
        this.department = employeeDetails[18];
        this.salary = Integer.parseInt(employeeDetails[19]);
        this.professionalCategory = employeeDetails[20];
    }

    public FullTimeEmployee(String name, int id, String jobTitle, String pps, String email, String address, String phoneNum, int age, boolean medicalCard, boolean healthInsurance, String status, String[] taxCredits, String password, int numIncomes, boolean higherEarner, String[] unions, String healthPlan, String healthPlanType, String salaryScalePoint, String department, int salary, int yearsAtTopOfScale, String professionalCategory) {
        super(name, id, jobTitle, pps, email, address, phoneNum, age, medicalCard, healthInsurance, status, taxCredits, password, numIncomes, higherEarner, unions, healthPlan, healthPlanType);
        this.salaryScalePoint = salaryScalePoint;
        this.department = department;
        this.salary = salary;
        this.professionalCategory = professionalCategory;
    }

    // Getter and Setter for salaryScalePoint
    public String getSalaryScalePoint() {
        return salaryScalePoint;
    }


    public void setSalaryScalePoint(String salaryScalePoint) {
        this.salaryScalePoint = salaryScalePoint;
    }

    // Getter and Setter for office
    public String getOffice() {
        return department;
    }



    public void setOffice(String office) {
        this.department = office;
    }

    // Getter and Setter for salary
    @Override
    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    // Getter and Setter for professionalCategory
    public String getProfessionalCategory() {
        return professionalCategory;
    }

    public void setProfessionalCategory(String professionalCategory) {
        this.professionalCategory = professionalCategory;
    }

}