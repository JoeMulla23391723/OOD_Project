public class Employee { //superclass of all employees
    private String name; //Name of employee
    private int id; //int id number of the employee
    private String jobTitle; //Job Title of the employee
    private String pps; //PPS number of the employee
    private String email;//employee's email address
    private String address;//employee's address
    private String phoneNum;//employee's phone number
    private int age;//employee's age
    private boolean medicalCard;//boolean to check whether the employee has a medical card or not
    private boolean healthInsurance;//boolean to check whether the employee has an insurance card or not
    private String status;//String of the employee's status eg "Married"/"Single"/"Single Parent"...
    private String[] taxCredits;//an array to include how many tax credits an employee has, based on various factors such as status
    private String password; //String containing the employee's password for them to login
    private int numIncomes;//integer value to represent how many incomes the employees household has
    private boolean higherEarner;//checks if they are the higher earner or not
    private String[] unions;//array to include which unions an employee might be a part of
    private String healthPlan; //Health Plan name
    private String healthPlanType; //type of health plan that.


    //Constructor that creates an employee object from information read from a CSV file
    public Employee(String[] employeeDetails) {

        this.name = employeeDetails[0];
        this.id = Integer.parseInt(employeeDetails[1]);
        this.jobTitle = employeeDetails[2];
        this.pps = employeeDetails[3];
        this.email = employeeDetails[4];
        this.address = employeeDetails[5];
        this.phoneNum = employeeDetails[6];
        this.age = Integer.parseInt(employeeDetails[7]);
        this.medicalCard = Boolean.parseBoolean(employeeDetails[8]);
        this.healthInsurance = Boolean.parseBoolean(employeeDetails[9]);
        this.status = employeeDetails[10];
        this.taxCredits = employeeDetails[11].split(",");
        this.password = employeeDetails[12];
        this.numIncomes = Integer.parseInt(employeeDetails[13]);
        this.higherEarner = Boolean.parseBoolean(employeeDetails[14]);
        this.unions = employeeDetails[15].split(",");
        this.healthPlan = employeeDetails[16];
        this.healthPlanType = employeeDetails[17];
    }


    //Constructor that creates an employee object using paramaters passed
    public Employee(String name, int id, String jobTitle, String pps, String email, String address, String phoneNum, int age, boolean medicalCard, boolean healthInsurance, String status, String[] taxCredits, String password, int numIncomes, boolean higherEarner, String[] unions, String healthPlan, String healthPlanType) {
        this.name = name;
        this.id = id;
        this.jobTitle = jobTitle;
        this.pps = pps;
        this.email = email;
        this.address = address;
        this.phoneNum = phoneNum;
        this.age = age;
        this.medicalCard = medicalCard;
        this.healthInsurance = healthInsurance;
        this.status = status;
        this.taxCredits = taxCredits;
        this.password = password;
        this.numIncomes = numIncomes;
        this.higherEarner = higherEarner;
        this.unions = unions;
        this.healthPlan = healthPlan;
        this.healthPlanType = healthPlanType;
    }


//needed for full-time employee override

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for jobTitle
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    // Getter and Setter for pps
    public String getPps() {
        return pps;
    }

    public void setPps(String pps) {
        this.pps = pps;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for address
    public String getAddress() {
        return address;
    }

    public String getOffice() {
        return null;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter for phoneNum
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and Setter for medicalCard
    public boolean hasMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(boolean medicalCard) {
        this.medicalCard = medicalCard;
    }

    // Getter and Setter for healthInsurance
    public boolean hasHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(boolean healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and Setter for taxCredits
    public String[] getTaxCredits() {
        return taxCredits;
    }

    public void setTaxCredits(String[] taxCredits) {
        this.taxCredits = taxCredits;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for numIncomes
    public int getNumIncomes() {
        return numIncomes;
    }

    public void setNumIncomes(int numIncomes) {
        this.numIncomes = numIncomes;
    }

    // Getter and Setter for higherEarner
    public boolean isHigherEarner() { //
        return higherEarner;
    }

    public void setHigherEarner(boolean higherEarner) {
        this.higherEarner = higherEarner;
    }

    // Getter and Setter for unions
    public String[] getUnions() {
        return unions;
    }

    public void setUnions(String[] unions) {
        this.unions = unions;
    }

    // Getter and Setter for healthPlan
    public String getHealthPlan() {
        return healthPlan;
    }

    public void setHealthPlan(String healthPlan) {
        this.healthPlan = healthPlan;
    }

    // Getter and Setter for healthPlanType
    public String getHealthPlanType() {
        return healthPlanType;
    }

    public void setHealthPlanType(String healthPlanType) {
        this.healthPlanType = healthPlanType;
    }

}
