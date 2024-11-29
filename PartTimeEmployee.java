import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PartTimeEmployee extends Employee{
    private double hourlyRate;
    private boolean payClaimSubmitted;
    private LocalDate datePayClaimSubmitted;
    private double hoursWorkedThisPayPeriod;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");;


    public PartTimeEmployee(String[] employeeDetails){
        super(employeeDetails);
        this.hourlyRate = Double.parseDouble(employeeDetails[18]);
        this.payClaimSubmitted = Boolean.parseBoolean(employeeDetails[19]);
        this.datePayClaimSubmitted = LocalDate.parse(employeeDetails[20], DATE_FORMAT);
        this.hoursWorkedThisPayPeriod = Double.parseDouble(employeeDetails[21]);
    }

    public PartTimeEmployee(String name, int id, String jobTitle, String pps, String email, String address, String phoneNum, int age, boolean medicalCard, boolean healthInsurance, String status, String[] taxCredits, String password, int numIncomes, boolean higherEarner, String[] unions, String healthPlan, String healthPlanType, double hourlyRate, boolean payClaimSubmitted, double hoursWorkedThisPayPeriod) {
        super(name, id, jobTitle, pps, email, address, phoneNum, age, medicalCard, healthInsurance, status, taxCredits, password, numIncomes, higherEarner, unions, healthPlan, healthPlanType);
        this.hourlyRate = hourlyRate;
        this.payClaimSubmitted = payClaimSubmitted;
        this.hoursWorkedThisPayPeriod = hoursWorkedThisPayPeriod;
    }

    LocalDate secondFriday;
    public boolean validSubmissionDate(LocalDate datePayClaimSubmitted){

        int year = datePayClaimSubmitted.getYear();
        int month = datePayClaimSubmitted.getMonthValue();

        secondFriday = LocalDate.of(year,month, 1);

        while(secondFriday.getDayOfWeek() != DayOfWeek.FRIDAY){
            secondFriday = secondFriday.plusDays(1);
        }
        secondFriday = secondFriday.plusDays(7);

        return datePayClaimSubmitted.isBefore(secondFriday);



    }


    //Getter and Setter Methods
    public double getHourlyRate(){
        return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate){
        this.hourlyRate = hourlyRate;
    }
    
    public boolean getPayClaimSubmitted(){
        return payClaimSubmitted;
    }
    public void setPayClaimSubmitted (boolean payClaimSubmitted){
        this.payClaimSubmitted = payClaimSubmitted;
    }
    public LocalDate getDatePayClaimSubmitted(){
        return datePayClaimSubmitted;
    }
    public void setDatePayClaimSubmitted (LocalDate datePayClaimSubmitted){
        this.datePayClaimSubmitted = datePayClaimSubmitted;
    }
    
    public double getHoursWorkedThisPayPeriod() {
        return hoursWorkedThisPayPeriod;
    }

    public void setHoursWorkedThisPeriod (double hoursWorkedThisPeriod){
        this.hoursWorkedThisPayPeriod = hoursWorkedThisPeriod;
    }
    
    public String toString(){
        return super.toString() + "Hourly Rate: " + getHourlyRate()
                + "\n Pay Claim Submitted: " + getPayClaimSubmitted()
                + "\n Date Pay Claim Submitted: " + getDatePayClaimSubmitted()
                + "\n Hours Worked This Pay Period: " + getHoursWorkedThisPayPeriod();
    }

}
