public class PartTimeDeductionsCalculator {
    private double uscToPayPerMonth; //usc
    private String prsiSubClass; //prsi
    private double prsiEmployerContribution;//prsi
    private double prsiToPayPerMonth; //prsi
    private double grossTax; //income tax
    private double grossTaxPerMonth; //income tax
    private double totalTaxRelief; //tax relief
    private double totalTaxReliefPerMonth; //tax relief
    private double totalUnionFees; //unions
    private double totalUnionFeesPerMonth; //unions
    private double healthInsuranceCost; //health insurance Cost
    private double healthInsuranceCompanyDiscount; //health
    private double healthInsuranceCompanyDiscountRate = 0.15; //health
    private double healthInsuranceCostPerMonth; //health

    // No argument constructor for FullTimeDeductionsCalculator
    public PartTimeDeductionsCalculator(){
    }

    //Set and calculate methods for usc
    public void setUscPaid(double uscToPayPerMonth) {
        this.uscToPayPerMonth = uscToPayPerMonth;
    }

    public double calculateUscPaid(int employeeID) {
        Employee partTime = Employees.getEmployeeFromIndex(employeeID);
        int age = partTime.getAge();
        boolean medicalCard = partTime.hasMedicalCard();
        PartTimeEmployee partTimeEmployee = (PartTimeEmployee) partTime;
        double temp = partTimeEmployee.getHoursWorkedThisPayPeriod()*partTimeEmployee.getHourlyRate();//making a variable because to alter the amount each time
        double uscToPay = 0;
        if (temp < (13000 / 12)) { // can earn up to 13000 without paying USC
            uscToPay = 0;
            System.out.println("Doesn't reach the threshold to pay USC.");
        } else if (age >= 70 && temp < (60000 / 12)) { // Reduced rate for over 70s that earn less than 60,000
            if (temp > (12012 / 12)) { // checking if the balance is above 12012
                uscToPay = (temp - (12012 / 12)) * 0.02;  // making (balance x 2%) the initial amount of USC to be paid
                temp = (12012 / 12);
            }
            if (temp <= (12012 / 12)) { //
                uscToPay = uscToPay + (temp * 0.005);
            }
        } else if (medicalCard == true && temp < (60000 / 12)) {
            if (temp > (12012 / 12)) {
                uscToPay = (temp - (12012 / 12)) * 0.02;
                temp = (12012 / 12);
            }
            if (temp <= (12012 / 12)) {
                uscToPay = uscToPay + (temp * 0.005);
            }
        } else {
            if (temp > (70044 / 12)) {
                uscToPay = (temp - (70044 / 12)) * 0.08;
                temp = (70044 / 12);
            }
            if (temp > (25760 / 12)) {
                uscToPay = uscToPay + ((temp - (25760 / 12)) * 0.04);
                temp = (25760 / 12);
            }
            if (temp > (12012 / 12)) {
                uscToPay = uscToPay + ((temp - (12012 / 12)) * 0.02);
                temp = (12012 / 12);
            }
            if (temp <= (12012 / 12)) {
                uscToPay = uscToPay + (temp * 0.005);
            }
        }
        uscToPayPerMonth = uscToPay;
        return uscToPayPerMonth;
    }

    //Set and calculate methods for prsi
    public String getPrsiSubClass() {
        return prsiSubClass;
    }

    public void setPrsiSubClass(String prsiSubClass) {
        this.prsiSubClass = prsiSubClass;
    }

    public double getPrsiEmployerContribution() {
        return (prsiEmployerContribution * 52) / 12;
    }

    public void setPrsiEmployerContribution(double prsiEmployerContribution) {
        this.prsiEmployerContribution = prsiEmployerContribution;
    }

    public void setPrsiPaid(double prsiToPayPerMonth) {
        this.prsiToPayPerMonth = prsiToPayPerMonth;
    }

    public double calculatePrsiPaid(int employeeID) {
        Employee partTime = Employees.getEmployeeFromIndex(employeeID);
        PartTimeEmployee partTimeEmployee = (PartTimeEmployee) partTime;
        double hoursWorked = partTimeEmployee.getHoursWorkedThisPayPeriod();
        double hourlyRateOfPay = partTimeEmployee.getHourlyRate();
        double temp = ((hoursWorked * hourlyRateOfPay) * 12) / 52;//calculating weekly pay as a temp variable
        double prsiToPayPerWeek = 0;
        double prsiToPayPerYear;
        if (temp <= 352) {
            System.out.println("Doesn't reach threshold to pay PRSI.");
            setPrsiSubClass("A0");
            setPrsiEmployerContribution(temp * 0.089);
        } else {
            if (temp >= 496.01) {
                prsiToPayPerWeek = temp * 0.041;
                setPrsiSubClass("A1");
                setPrsiEmployerContribution(temp * 0.1115);
            } else if (temp >= 424.01) {
                prsiToPayPerWeek = temp * 0.041;
                setPrsiSubClass("AL");
                setPrsiEmployerContribution(temp * 0.089);
            } else if (temp >= 352.01) {
                prsiToPayPerWeek = temp * 0.041;
                setPrsiSubClass("Ax");
                setPrsiEmployerContribution(temp * 0.089);
            }
        }
        prsiToPayPerYear = prsiToPayPerWeek * 52; //can't multiply by 4 to get monthly, as ever quarter is a 5 week month.
        prsiToPayPerMonth = prsiToPayPerYear / 12;
        return prsiToPayPerMonth;
    }


    //Set and calculate methods for tax
    public void setGrossTax(double grossTaxPerMonth) {
        this.grossTaxPerMonth = grossTaxPerMonth;
    }

    public double calculateGrossTax(int employeeID) {
        Employee partTime = Employees.getEmployeeFromIndex(employeeID);
        String status = partTime.getStatus();
        int numOfIncomes = partTime.getNumIncomes();
        boolean higherEarner = partTime.isHigherEarner();
        PartTimeEmployee partTimeEmployee = (PartTimeEmployee) partTime;
        double hoursWorked = partTimeEmployee.getHoursWorkedThisPayPeriod();
        double hourlyRateOfPay = partTimeEmployee.getHourlyRate();
        double temp = (hoursWorked * hourlyRateOfPay);
        if (status.equals("Single person")) {
            if (temp > (42000 / 12)) {
                grossTax = (temp - (42000 / 12)) * 0.4;
                temp = (42000 / 12);
            }
            if (temp >= 0) {
                grossTax = grossTax + (temp * 0.2);
            }
        } else if (status.equals("Lone parent")) {
            if (temp > (46000 / 12)) {
                grossTax = (temp - (46000 / 12)) * 0.4;
                temp = (46000 / 12);
            }
            if (temp >= 0) {
                grossTax = grossTax + (temp * 0.2);
            }
        } else if (status.equals("Married couple/civil partners") && numOfIncomes == 1) {
            if (temp > (51000 / 12)) {
                grossTax = (temp - (51000 / 12)) * 0.4;
                temp = (51000 / 12);
            }
            if (temp >= 0) {
                grossTax = grossTax + (temp * 0.2);
            }
        } else {
            if (higherEarner == true) {
                if (temp > (51000 / 12)) {
                    grossTax = (temp - (51000 / 12)) * 0.4;
                    temp = (51000 / 12);
                }
                if (temp >= 0) {
                    grossTax = grossTax + (temp * 0.2);
                }
            } else {
                if (temp > (33000 / 12)) {
                    grossTax = (temp - (33000 / 12)) * 0.4;
                    temp = (33000 / 12);
                }
                if (temp >= 0) {
                    grossTax = grossTax + (temp * 0.2);
                }
            }
        }
        grossTaxPerMonth = grossTax;
        return grossTaxPerMonth;
    }

    public void setTaxRelief(double totalTaxRelief) {
        this.totalTaxRelief = totalTaxRelief;
    }

    public double calculateTaxRelief(int employeeID) { // we need to make an arrayList that allows us to add tax credits
        Employee partTime = Employees.getEmployeeFromIndex(employeeID);
        PartTimeEmployee partTimeEmployee = (PartTimeEmployee) partTime;
        double hoursWorked = partTimeEmployee.getHoursWorkedThisPayPeriod();
        double hourlyRateOfPay = partTimeEmployee.getHourlyRate();
        String[] taxCredits = partTimeEmployee.getTaxCredits();
        double temp = (hoursWorked * hourlyRateOfPay);
        for (String typeOfCredit : taxCredits) {
            if (typeOfCredit.equals("Employee Tax Credit")) {
                if (temp < (9375 / 12)) {
                    totalTaxRelief = totalTaxRelief + (temp * 0.2);
                } else {
                    totalTaxRelief = totalTaxRelief + (1875 / 12);
                }
            }
            if (typeOfCredit.equals("Single Person Child Carer Credit")) {
                totalTaxRelief = totalTaxRelief + (1650 / 12);
            }
            if (typeOfCredit.equals("Incapacitated Child Tax Credit")) {
                totalTaxRelief = totalTaxRelief + (3300 / 12);
            }
            if (typeOfCredit.equals("Dependent Relative Tax Credit")) {
                totalTaxRelief = totalTaxRelief + (245 / 12);
            }
            if (typeOfCredit.equals("Age Tax Credit")) {
                totalTaxRelief = totalTaxRelief + (245 / 12);
            }
            if (typeOfCredit.equals("Tuition Fees Tax Credit")) {
                totalTaxRelief = totalTaxRelief + (800 / 12);
            }
            if (typeOfCredit.equals("Rent Tax Credit")) {
                totalTaxRelief = totalTaxRelief + (500 / 12);
            }
            if (typeOfCredit.equals("Blind Person's Tax Credit")) {
                totalTaxRelief = totalTaxRelief + (1650 / 12);
            }
            if (typeOfCredit.equals("Disability Tax Credit")) {
                totalTaxRelief = totalTaxRelief + (1775 / 12);
            }
        }
        totalTaxReliefPerMonth = totalTaxRelief;
        return totalTaxReliefPerMonth;
    }

    public double calculateNettTax(int employeeID) {
        return calculateGrossTax(employeeID)-calculateTaxRelief(employeeID);
    }
    public void setUnionFees(double totalUnionFeesPerMonth) {
        this.totalUnionFeesPerMonth=totalUnionFeesPerMonth;
    }

    //Set and calculate methods for union fees
    public double calculateUnionFees(int employeeID) {
        Employee partTime = Employees.getEmployeeFromIndex(employeeID);
        String[] unions = partTime.getUnions();
        PartTimeEmployee partTimeEmployee = (PartTimeEmployee) partTime;
        double hoursWorked = partTimeEmployee.getHoursWorkedThisPayPeriod();
        double hourlyRateOfPay = partTimeEmployee.getHourlyRate();
        double temp = (hoursWorked * hourlyRateOfPay);
        for (String nameOfUnion: unions) {
            if (nameOfUnion.equals("Unite")) {
                totalUnionFees = totalUnionFees +(228/12);
            }
            if(nameOfUnion.equals("Irish Federation of University Teachers")) {
                if(temp<=(10000/12)) {
                    totalUnionFees = totalUnionFees + (75/12);
                }else if(temp<=(15000/12)) {
                    totalUnionFees= totalUnionFees + (111/12);
                }else if(temp<=(20000/12)) {
                    totalUnionFees = totalUnionFees + (150/12);
                }else if(temp<=(25000/12)) {
                    totalUnionFees = totalUnionFees + (187.56/12);
                }else if(temp<=(30000/12)) {
                    totalUnionFees = totalUnionFees + (225/12);
                }else if (temp<=(35000/12)) {
                    totalUnionFees = totalUnionFees + (262.32/12);
                }else if (temp<=(40000/12)) {
                    totalUnionFees = totalUnionFees + (300/12);
                }else if(temp<=(45000/12)) {
                    totalUnionFees = totalUnionFees + (337.56/12);
                }else if(temp<=(50000/12)) {
                    totalUnionFees = totalUnionFees + (375/12);
                }else if(temp<=(55000/12)) {
                    totalUnionFees = totalUnionFees + (412.56/12);
                }else {
                    totalUnionFees = totalUnionFees + (420/12);
                }
            }
            if(nameOfUnion.equals("Services, Industrial, Professional, and Technical Union")){
                if(temp<=(20000/12)) {
                    totalUnionFees = totalUnionFees + (60/12);
                }else if (temp<=(40000/12)) {
                    totalUnionFees = totalUnionFees + (120/12);
                }else {
                    totalUnionFees = totalUnionFees + (180/12);
                }
            }
        }
        totalUnionFeesPerMonth=totalUnionFees;
        return totalUnionFeesPerMonth;
    }

    //Calculate and set methods for health insurance
    public void setHealthInsuranceCost(double healthInsuranceCostPerMonth) {
        this.healthInsuranceCostPerMonth=healthInsuranceCostPerMonth;
    }
    public double calculateHeathInsuranceCost(int employeeID) {
        Employee partTime = Employees.getEmployeeFromIndex(employeeID);
        boolean healthInsurance = partTime.hasHealthInsurance();
        String healthPlan = partTime.getHealthPlan();
        String healthPlanType = partTime.getHealthPlanType();
        if(healthInsurance==true) {
            if(healthPlan == "VHI One Plan 250") {
                if(healthPlanType=="Single") {
                    healthInsuranceCost = (1440/12);
                }else { //(healthPlanType=="Family")
                    healthInsuranceCost=(3600/12); //allows for family plans
                }
            }else if(healthPlan == "VHI HealthPlus Extra") {
                if(healthPlanType=="Single") {
                    healthInsuranceCost =(2040/12);
                }else {
                    healthInsuranceCost=(5400/12);
                }
            }else if (healthPlan == "VHI Company Plan Extra") {
                if(healthPlanType=="Single") {
                    healthInsuranceCost= (4200/12);
                }else {
                    healthInsuranceCost= (12000/12);
                }
            }else{ //(healthPlan == "VHI PMI Plans")
                if(healthPlanType == "Single") {
                    healthInsuranceCost=(3000/12);
                }else {
                    healthInsuranceCost=(7800/12);
                }
            }
        }
        healthInsuranceCompanyDiscount = healthInsuranceCost * healthInsuranceCompanyDiscountRate;
        healthInsuranceCost = healthInsuranceCost - healthInsuranceCompanyDiscount;
        healthInsuranceCostPerMonth= healthInsuranceCost;
        return healthInsuranceCostPerMonth;
    }

    //method to calculate actual pay of the part-time employee
    public double calculateNetPay(int employeeID){
        Employee partTime = Employees.getEmployeeFromIndex(employeeID);
        PartTimeEmployee partTimeEmployee = (PartTimeEmployee) partTime;
        double hoursWorked = partTimeEmployee.getHoursWorkedThisPayPeriod();
        double hourlyRateOfPay = partTimeEmployee.getHourlyRate();
        double temp = hoursWorked * hourlyRateOfPay;
        double partTimeNetPayPerMonth = temp - (calculateUscPaid(employeeID) + calculatePrsiPaid(employeeID) +
                calculateNetTax(employeeID) + calculateUnionFees(employeeID)
                + calculateHeathInsuranceCost(employeeID));
        return partTimeNetPayPerMonth;
    }
}
