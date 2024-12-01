/**
 * Calculates all the deductions of a full-time employee
 */
public class FullTimeSalaryCalculator {
    private double uscToPayPerMonth;
    private String prsiSubClass;
    private double prsiEmployerContribution;
    private double prsiToPayPerMonth;
    private double grossTax;
    private double grossTaxPerMonth;
    private double totalTaxRelief;
    private double totalUnionFees;
    private double totalUnionFeesPerMonth;
    private double healthInsuranceCost;
    private double healthInsuranceCostPerMonth;
    double incomeTax;


    /**
     * Default constructor for FullTimeSalaryCalculator
     */
    public FullTimeSalaryCalculator(){
    }


    /**
     * Calculates USC mount to pay per month
     * The rates are based on a number of parameters such as
     * Whether the employee is over, does the employee have a medical card and the employees yearly salary
     * @param employeeID The employees ID number
     * @return uscToPayPerMonth
     */

    public double calculateUscPaid(int employeeID) {
        Employee fullTime = Employees.getEmployeeFromIndex(employeeID);
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fullTime;
        double temp = fullTimeEmployee.getSalary(); //making a variable because to alter the amount each time
        double uscToPay=0;
        double age = fullTimeEmployee.getAge();
        boolean medicalCard= fullTimeEmployee.hasMedicalCard();
        if (temp<13000) { // can earn up to 13000 without paying USC
            uscToPay=0;
            System.out.println("Doesn't reach the threshold to pay USC.");
        }else if(age>=70 && temp<60000) { // Reduced rate for over 70s that earn less than 60,000
            if(temp>12012) { // checking if the balance is above 12012
                uscToPay= (temp-12012) * 0.02;  // making (balance x 2%) the initial amount of USC to be paid
                temp=12012;  // changing the value of the temp grossPay for the next band rate
            }
            if(temp<=12012) { //
                uscToPay = uscToPay + (temp * 0.005);
            }
        }else if(medicalCard==true && temp<60000) {
            if(temp>12012) {
                uscToPay= (temp-12012) * 0.02;
                temp=12012;
            }
            if(temp<=12012) {
                uscToPay = uscToPay + (temp * 0.005);
            }
        }else{
            if(temp>70044) {
                uscToPay=(temp-70044)*0.08;
                temp=70044;
            }
            if(temp>25760) {
                uscToPay= uscToPay + ((temp-25760) * 0.04);
                temp=25760;
            }
            if(temp>12012) {
                uscToPay= uscToPay + ((temp-12012) * 0.02);
                temp=12012;
            }
            if(temp<=12012) {
                uscToPay = uscToPay + (temp * 0.005);
            }
        }
        uscToPayPerMonth= uscToPay/12; //The usc to be paid calculated at this point is per year, it is divided by 12 to get usc paid per month
        return uscToPayPerMonth;
    }

    public double getUscToPayPerMonth() {
        return uscToPayPerMonth;
    }

    /**
     * Gets the prsi subclass for the employee
     * @return prsiSubClass
     */

    public String getPrsiSubClass() {
        return prsiSubClass;
    }

    /**
     * Sets the prsi subclass
     * @param prsiSubClass
     */
    public void setPrsiSubClass(String prsiSubClass) {
        this.prsiSubClass=prsiSubClass;
    }

    /**
     * Gets the Employers prsi contribution per month
     * @return prsiEmployerContribution per month
     */
    public double getPrsiEmployerContribution() {
        return (prsiEmployerContribution*52)/12;
    }

    /**
     * Sets the Employers prsi contribution per month
     * @param prsiEmployerContribution
     */
    public void setPrsiEmployerContribution(double prsiEmployerContribution ) {
        this.prsiEmployerContribution=prsiEmployerContribution;
    }


    /**
     * Calculates the prsi an employee pays per month
     * @param employeeID The ID of the employee
     * @return prsiToPayPerMonth
     */
    public double calculatePrsiPaid(int employeeID) {
        Employee fullTime = Employees.getEmployeeFromIndex(employeeID); //Retrieves an Employee object from Employees based on the employees ID and names that object fullTime
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fullTime; //casts the Employee object to a more specific type FullTimeEmployee
        double temp = (fullTimeEmployee.getSalary())/52;//calculating weekly pay as a temp variable
        double prsiToPayPerWeek=0;
        double prsiToPayPerYear;
        if(temp<=352){      //when the employee earns less than 352€ per week they dont pay prsi
            System.out.println("Doesn't reach threshold to pay PRSI.");
            setPrsiSubClass("A0"); //sets the prsi subclass
            setPrsiEmployerContribution(((temp * 0.089)*52)/12); //calculates the employer prsi contribution based on the weekly earnings of the employee
            // the amount per month is calculated by multiplying by 52 and diving by 12 as every quarter is a 5 week month
        }else {
            if(temp>=496.01) {                   //if an employee earns over 496.01 per month then
                prsiToPayPerWeek= temp * 0.041;	 //then the prsi the pay is calculated by their weekly earnings*0.041
                setPrsiSubClass("A1");
                setPrsiEmployerContribution(((temp *0.1115)*52)/12);
            }else if (temp>=424.01) {
                prsiToPayPerWeek =  temp * 0.041;
                setPrsiSubClass("AL");
                setPrsiEmployerContribution(((temp * 0.089)*52)/12);
            }else if(temp>=352.01) {
                prsiToPayPerWeek = temp * 0.041;
                setPrsiSubClass("Ax");
                setPrsiEmployerContribution(((temp *0.089)*52)/12);
            }
        }
        prsiToPayPerYear = prsiToPayPerWeek * 52; //can't multiply by 4 to get monthly, as ever quarter is a 5-week month.
        prsiToPayPerMonth = prsiToPayPerYear/12;
        return prsiToPayPerMonth;
    }

    public double getPrsiToPayPerMonth() {
        return prsiToPayPerMonth;
    }

    /**
     * Calculates an employees gross tax per month
     * @param employeeID employees ID
     * @return grossTaxPerMonth
     */
    public double calculateGrossTax(int employeeID) {
        Employee fullTime = Employees.getEmployeeFromIndex(employeeID); //Retrieves an Employee object from Employees based on the employees ID and names that object fullTime
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fullTime; //casts the Employee object to a more specific type FullTimeEmployee
        double temp = fullTimeEmployee.getSalary(); //Gets the salary of the employee of a certain ID
        String status = fullTimeEmployee.getStatus(); //Gets the status of the employee based on the employeeID
        int numOfIncomes = fullTimeEmployee.getNumIncomes(); //Gets the number of incomes in a family were status is "Married couple/civil partners"
        boolean higherEarner = fullTimeEmployee.isHigherEarner(); //If number of incomes is 2 this gets whether or not the employee is the higherEarner in the family
        if(status.equals("Single person")) {
            if(temp>42000) {
                grossTax=(temp-42000)*0.4; //grossTax is calculating the gross tax per year
                temp=42000;
            }if(temp>=0) {
                grossTax=grossTax +(temp * 0.2);
            }
        }else if(status.equals("Lone parent")) {
            if(temp>46000) {
                grossTax=(temp-46000)*0.4;
                temp=46000;
            }if(temp>=0) {
                grossTax=grossTax +(temp *0.2);
            }
        }else if(status.equals("Married couple/civil partners") && numOfIncomes==1) {
            if(temp>51000) {
                grossTax=(temp-51000)*0.4;
                temp=51000;
            }if(temp>=0) {
                grossTax=grossTax + (temp*0.2);
            }
        }else{
            if(higherEarner==true) {
                if(temp>51000) {
                    grossTax=(temp-51000)*0.4;
                    temp=51000;
                }if(temp>=0) {
                    grossTax=grossTax + (temp*0.2);
                }
            }else{
                if(temp>33000) {
                    grossTax=(temp-33000)*0.4;
                    temp=33000;
                }if(temp>=0) {
                    grossTax=grossTax + (temp*0.2);
                }
            }
        }
        grossTaxPerMonth= grossTax/12; //calculates the gross tax per month
        return grossTaxPerMonth;
    }



    /**
     * Calculates the total tax relief an employee is entitled to
     * @param employeeID
     * @return totalTaxReliefPerMonth
     */
    public double calculateTaxRelief(int employeeID) {
        Employee fullTime = Employees.getEmployeeFromIndex(employeeID); //Retrieves an employee object from Employees based on employeeID and names it fullTime
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fullTime; //Casts the object fullTime to a more specific type FullTimeEmployee and calls it fullTimeEmployee

        double temp = fullTimeEmployee.getSalary(); //Retrieves the salary of the employee and makes it a temp variable
        String[] taxCredits = fullTimeEmployee.getTaxCredits(); //Retrieves the array of the employees tax credits
        for (String typeOfCredit :  taxCredits){ //Searches through the array taxCredits naming each element each time it searches typeOfCredit
            if (typeOfCredit.equals("Employee Tax Credit")) { //if ""Employee Tax Credit" exists in the array then
                if(temp<9375) {			//it checks whether the salary per year is less 9375€
                    totalTaxRelief = totalTaxRelief + (temp *0.2); //if it is the total tax relief the employee is entitled to is 20% of the total earnings of the employee per year
                }else {
                    totalTaxRelief= totalTaxRelief + 1875;  // otherwise 1875€ is added to an employees tax relief per year
                }
            }
            if(typeOfCredit.equals("Single Person Child Carer Credit")) {
                totalTaxRelief=totalTaxRelief + 1650;  //by adding to the totalTaxRelief if the credit applies to them it allows an employee to have more than one type of credit
            }
            if(typeOfCredit.equals("Incapacitated Child Tax Credit")) {
                totalTaxRelief= totalTaxRelief + 3300;
            }
            if(typeOfCredit.equals("Dependent Relative Tax Credit")) {
                totalTaxRelief = totalTaxRelief +245;
            }
            if(typeOfCredit.equals("Age Tax Credit")){
                totalTaxRelief=totalTaxRelief + 245;
            }
            if(typeOfCredit.equals("Tuition Fees Tax Credit")) {
                totalTaxRelief = totalTaxRelief +800;
            }
            if(typeOfCredit.equals("Rent Tax Credit")) {
                totalTaxRelief= totalTaxRelief + 500;
            }
            if(typeOfCredit.equals("Blind Person's Tax Credit")) {
                totalTaxRelief = totalTaxRelief + 1650;
            }
            if(typeOfCredit.equals("Disability Tax Credit")) {
                totalTaxRelief = totalTaxRelief + 1775;
            }
        }
        //tax relief
        double totalTaxReliefPerMonth = totalTaxRelief / 12;  //calculates the total tax relief an employee is entitled to per month
        return totalTaxReliefPerMonth;
    }

    /**
     * Calculates the Net tax an employee pays.
     * This is calculated by GrossTax - TaxRelief
     * @param employeeID
     * @return incomeTax
     */
    public double calculateNetTax(int employeeID) {
        incomeTax = calculateGrossTax(employeeID)-calculateTaxRelief(employeeID);
        return incomeTax;
    }

    /**
     * Returns the income tax to be used in other methods
     * @return incomeTax
     */
    public double getIncomeTax() {
        return incomeTax;
    }

    /**
     * Calculates the total union fees an employee pays per month
     * @param employeeID
     * @return totalUnionFeesPerMonth
     */

    public double calculateUnionFees(int employeeID) {
        Employee fullTime = Employees.getEmployeeFromIndex(employeeID); //Retrieves an employee object from Employees based on employeeID and names it fullTime
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fullTime; //Casts the object fullTime to a more specific type FullTimeEmployee and calls it fullTimeEmployee
        double temp = fullTimeEmployee.getSalary();
        String[] unions= fullTimeEmployee.getUnions(); // Gets the array of the unions an employee is member of and calls it unions
        for (String nameOfUnion: unions ) {
            if (nameOfUnion.equals("Unite")) {   //if an employee is a member of "Unite"
                totalUnionFees = totalUnionFees +228; //228€ is added to the total union fees an employee pays per year
            }
            if(nameOfUnion.equals("Irish Federation of University Teachers")) {  // The fees for "Irish Federation of University Teachers" is based on salary earnings
                if(temp<=10000) {
                    totalUnionFees = totalUnionFees + 75;
                }else if(temp<=15000) {
                    totalUnionFees= totalUnionFees + 111;
                }else if(temp<=20000) {
                    totalUnionFees = totalUnionFees + 150;
                }else if(temp<=25000) {
                    totalUnionFees = totalUnionFees + 187.56;
                }else if(temp<=30000) {
                    totalUnionFees = totalUnionFees + 225;
                }else if (temp<=35000) {
                    totalUnionFees = totalUnionFees + 262.32;
                }else if (temp<=40000) {
                    totalUnionFees = totalUnionFees + 300;
                }else if(temp<=45000) {
                    totalUnionFees = totalUnionFees + 337.56;
                }else if(temp<=50000) {
                    totalUnionFees = totalUnionFees + 375;
                }else if(temp<=55000) {
                    totalUnionFees = totalUnionFees + 412.56;
                }else {
                    totalUnionFees = totalUnionFees + 420;
                }
            }
            if(nameOfUnion.equals("Services, Industrial, Professional, and Technical Union")){
                if(temp<=20000) {
                    totalUnionFees = totalUnionFees + 60;
                }else if (temp<=40000) {
                    totalUnionFees = totalUnionFees + 120;
                }else {
                    totalUnionFees = totalUnionFees + 180;
                }
            }
        }
        totalUnionFeesPerMonth=totalUnionFees/12;  //calculates the total unions fees per month
        return totalUnionFeesPerMonth;
    }

    /**
     * Returns the union fees to be used in other methods
     * @return
     */
    public double getTotalUnionFeesPerMonth() {
        return totalUnionFeesPerMonth;
    }

    /**
     * Calculate the total cost of health insurance per month
     * @param employeeID
     * @return healthInsuranceCostPerMonth
     */
    public double calculateHeathInsurance(int employeeID) {
        Employee fullTime = Employees.getEmployeeFromIndex(employeeID);
        boolean healthInsurance = fullTime.hasHealthInsurance();
        String healthPlan = fullTime.getHealthPlan();
        String healthPlanType = fullTime.getHealthPlanType();
        if(healthInsurance==true) {
            if(healthPlan.equals("VHI One Plan 250")){
                if(healthPlanType.equals("Single") ){
                    healthInsuranceCost = 1440;
                }else { //(healthPlanType=="Family")
                    healthInsuranceCost=3600; //allows for family plans
                }
            }else if(healthPlan.equals("VHI HealthPlus Extra")) {
                if(healthPlanType.equals("Single")) {
                    healthInsuranceCost =2040;
                }else {
                    healthInsuranceCost=5400;
                }
            }else if (healthPlan.equals( "VHI Company Plan Extra")) {
                if(healthPlanType.equals("Single") ){
                    healthInsuranceCost= 4200;
                }else {
                    healthInsuranceCost= 12000;
                }
            }else{ //(healthPlan == "VHI PMI Plans")
                if(healthPlanType.equals("Single") ){
                    healthInsuranceCost=3000;
                }else {
                    healthInsuranceCost=7800;
                }
            }
        }

        double healthInsuranceCompanyDiscountRate = 0.15;
        double healthInsuranceCompanyDiscount = healthInsuranceCost * healthInsuranceCompanyDiscountRate;
        healthInsuranceCost = healthInsuranceCost - healthInsuranceCompanyDiscount;
        healthInsuranceCostPerMonth= healthInsuranceCost/12;
        return healthInsuranceCostPerMonth;
    }

    /**
     * Returns the health insurance fees to be used in other methods
     * @return healthInsuranceCost
     */
    public double getHealthInsuranceCostPerMonth() {
        return healthInsuranceCostPerMonth;
    }

    /**
     * Gets the salary of a full time employee before deductions are applied
     * @param employeeID
     * @return fullTimeEmployee.getSalary()
     */
    public double getEmployeeSalaryWithoutDeductions(int employeeID) {
        Employee employee = Employees.getEmployeeFromIndex(employeeID);
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) employee;
        return fullTimeEmployee.getSalary();
    }


    /**
     * Calculates the Net Pay of a full time employee by adding up all the deductions and taking the, away from the (salary/12) to get the monthly net pay
     * @param employeeID
     * @return fullTimeNetPayPerMonth
     * @throws IllegalArgumentException
     */
    public double calculateFullTimeNetPay(int employeeID) throws IllegalArgumentException {
        double fullTimeNetPayPerMonth;
        Employee employee = Employees.getEmployeeFromIndex(employeeID);
        if (employee instanceof FullTimeEmployee) {  // if the employee is a full time employee
            FullTimeSalaryCalculator deductions = new FullTimeSalaryCalculator(); // creates an object deductions of type FullTimeSalaryCalculator
            fullTimeNetPayPerMonth = (getEmployeeSalaryWithoutDeductions(employeeID) / 12) - (getUscToPayPerMonth() + getPrsiToPayPerMonth() +
                    getIncomeTax() + getTotalUnionFeesPerMonth() + getHealthInsuranceCostPerMonth());
        }
        else{
            throw new IllegalArgumentException("Employee is not employed on a full-time basis");
        }
        return fullTimeNetPayPerMonth;
    }
}
