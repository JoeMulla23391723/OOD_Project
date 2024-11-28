public class FullTimeDeductionsCalculator {
    private double uscToPayPerMonth; //usc
    private String prsiSubClass; //prsi
    private double prsiEmployerContribution;//prsi
    private double prsiToPayPerMonth; //prsi
    private double grossTax; //income tax
    private double grossTaxPerMonth; //income tax
    private double totalTaxRelief; //tax relief
    private double totalUnionFees; //unions
    private double totalUnionFeesPerMonth; //unions
    private double healthInsuranceCost; //health insurance Cost
    private double healthInsuranceCostPerMonth; //health

    // No argument constructor for FullTimeDeductionsCalculator
    public FullTimeDeductionsCalculator(){
    }

    // Calculate and set methods for USC deductions
    public void setUscPaid(double uscToPayPerMonth) {
        this.uscToPayPerMonth=uscToPayPerMonth;
    }


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
        uscToPayPerMonth= uscToPay/12;
        return uscToPayPerMonth;
    }

    //Set and calculate methods for PRSI to pay

    public String getPrsiSubClass() {
        return prsiSubClass;
    }
    public void setPrsiSubClass(String prsiSubClass) {
        this.prsiSubClass=prsiSubClass;
    }
    public double getPrsiEmployerContribution() {
        return (prsiEmployerContribution*52)/12;
    }
    public void setPrsiEmployerContribution(double prsiEmployerContribution ) {
        this.prsiEmployerContribution=prsiEmployerContribution;
    }
    public void setPrsiPaid(double prsiToPayPerMonth) {
        this.prsiToPayPerMonth= prsiToPayPerMonth;
    }
    public double calculatePrsiPaid(int employeeID) {
        Employee fullTime = Employees.getEmployeeFromIndex(employeeID);
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fullTime;
        double temp = fullTimeEmployee.getSalary();//calculating weekly pay as a temp variable
        double prsiToPayPerWeek=0;
        double prsiToPayPerYear;
        if(temp<=352){
            System.out.println("Doesn't reach threshold to pay PRSI.");
            setPrsiSubClass("A0");
            setPrsiEmployerContribution(  temp * 0.089);
        }else {
            if(temp>=496.01) {
                prsiToPayPerWeek= temp * 0.041;
                setPrsiSubClass("A1");
                setPrsiEmployerContribution(temp *0.1115);
            }else if (temp>=424.01) {
                prsiToPayPerWeek =  temp * 0.041;
                setPrsiSubClass("AL");
                setPrsiEmployerContribution(temp * 0.089);
            }else if(temp>=352.01) {
                prsiToPayPerWeek = temp * 0.041;
                setPrsiSubClass("Ax");
                setPrsiEmployerContribution(temp *0.089);
            }
        }
        prsiToPayPerYear = prsiToPayPerWeek * 52; //can't multiply by 4 to get monthly, as ever quarter is a 5 week month.
        prsiToPayPerMonth = prsiToPayPerYear/12;
        return prsiToPayPerMonth;
    }


    //Set and calculate methods for tax

    public void setGrossTax(double grossTaxPerMonth) {
        this.grossTaxPerMonth=grossTaxPerMonth;
    }

    public double calculateGrossTax(int employeeID) {
        Employee fullTime = Employees.getEmployeeFromIndex(employeeID);
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fullTime;
        double temp = fullTimeEmployee.getSalary();
        String status = fullTimeEmployee.getStatus();
        int numOfIncomes = fullTimeEmployee.getNumIncomes();
        boolean higherEarner = fullTimeEmployee.isHigherEarner();
        if(status.equals("Single person")) {
            if(temp>42000) {
                grossTax=(temp-42000)*0.4;
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
        grossTaxPerMonth= grossTax/12;
        return grossTaxPerMonth;
    }

    public void setTaxRelief(double totalTaxRelief) {
        this.totalTaxRelief=totalTaxRelief;
    }
    public double calculateTaxRelief(int employeeID) {
        Employee fullTime = Employees.getEmployeeFromIndex(employeeID);
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fullTime;
        // we need to make an arrayList that allows us to add tax credits
        double temp = fullTimeEmployee.getSalary();
        String[] taxCredits = fullTimeEmployee.getTaxCredits();
        for (String typeOfCredit :  taxCredits){
            if (typeOfCredit.equals("Employee Tax Credit")) {
                if(temp<9375) {
                    totalTaxRelief = totalTaxRelief + (temp *0.2);
                }else {
                    totalTaxRelief= totalTaxRelief + 1875;
                }
            }
            if(typeOfCredit.equals("Single Person Child Carer Credit")) {
                totalTaxRelief=totalTaxRelief + 1650;
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
        double totalTaxReliefPerMonth = totalTaxRelief / 12;
        return totalTaxReliefPerMonth;
    }

    public double calculateNetTax(int employeeID) {
        return calculateGrossTax(employeeID)-calculateTaxRelief(employeeID);
    }

    //
    public void setUnionFees(double totalUnionFeesPerMonth) {
        this.totalUnionFeesPerMonth=totalUnionFeesPerMonth;
    }

    //Set and calculate for union fees
    public double calculateUnionFees(int employeeID) {
        Employee fullTime = Employees.getEmployeeFromIndex(employeeID);
        FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) fullTime;
        double temp = fullTimeEmployee.getSalary();
        String[] unions= fullTimeEmployee.getUnions();
        for (String nameOfUnion: unions ) {
            if (nameOfUnion.equals("Unite")) {
                totalUnionFees = totalUnionFees +228;
            }
            if(nameOfUnion.equals("Irish Federation of University Teachers")) {
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
        totalUnionFeesPerMonth=totalUnionFees/12;
        return totalUnionFeesPerMonth;
    }


    //Set and calculate health insurance methods
    public void setHealthInsuranceCost(double healthInsuranceCostPerMonth) {
        this.healthInsuranceCostPerMonth=healthInsuranceCostPerMonth;
    }
    public double calculateHeathInsurance(int employeeID) {
        Employee fullTime = Employees.getEmployeeFromIndex(employeeID);
        boolean healthInsurance = fullTime.hasHealthInsurance();
        String healthPlan = fullTime.getHealthPlan();
        String healthPlanType = fullTime.getHealthPlanType();
        if(healthInsurance==true) {
            if(healthPlan == "VHI One Plan 250") {
                if(healthPlanType=="Single") {
                    healthInsuranceCost = 1440;
                }else { //(healthPlanType=="Family")
                    healthInsuranceCost=3600; //allows for family plans
                }
            }else if(healthPlan == "VHI HealthPlus Extra") {
                if(healthPlanType=="Single") {
                    healthInsuranceCost =2040;
                }else {
                    healthInsuranceCost=5400;
                }
            }else if (healthPlan == "VHI Company Plan Extra") {
                if(healthPlanType=="Single") {
                    healthInsuranceCost= 4200;
                }else {
                    healthInsuranceCost= 12000;
                }
            }else{ //(healthPlan == "VHI PMI Plans")
                if(healthPlanType == "Single") {
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

    // Method to get the salary of a full-time employee before deductions are applied
    public double getEmployeeSalaryWithoutDeductions(int employeeID) {
        double salary = 0;
        Payscale payscale = new Payscale();
        int[] salaryScales = payscale.getPayscaleByProfession((Employees.getIndexOfEmployeeID(employeeID)));
        salary = payscale.getSalaryWithoutDeductions(salaryScales, Employees.getPromotionLevel(employeeID));
        return salary;
    }

    // Method to get the salary of a full-time employee after deductions are applied
    public double calculateFullTimeNetPay(int employeeID) throws IllegalArgumentException {
        double fullTimeNetPayPerMonth;
        Employee employee = Employees.getEmployeeFromIndex(employeeID);
        if (employee instanceof FullTimeEmployee) {
            FullTimeDeductionsCalculator deductions = new FullTimeDeductionsCalculator();
            fullTimeNetPayPerMonth = (getEmployeeSalaryWithoutDeductions(employeeID) / 12) - (deductions.calculateUscPaid(employeeID) + deductions.calculatePrsiPaid(employeeID) +
                    deductions.calculateNetTax(employeeID) + deductions.calculateNetTax(employeeID) + deductions.calculateUnionFees(employeeID) + deductions.calculateHeathInsurance(employeeID));
        }
        else{
            throw new IllegalArgumentException("Employee is not employed on a full-time basis");
        }
        return fullTimeNetPayPerMonth;
    }


}

