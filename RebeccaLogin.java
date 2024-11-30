package OOD;

import java.time.LocalDate;
import java.util.Scanner;

public class Login{
   public static void main(String[] args) {
	   
	   
	   PartTimeEmployee employee = new PartTimeEmployee(
			   "Alice Johnson",                 // Name
			   1,                             // ID
			   "library_attendant",            // Job Title
			   "1234567B",                      // PPS
			   "alice.johnson@example.com",     // Email
			   "456 Elm Street",                // Address
			   "555-5678",                      // Phone Number
			   35,                              // Age
			   true,                            // Medical Card
			   true,                            // Health Insurance
			   "Single",                        // Status
			   new String[]{"Employee Tax Credit", "Rent Tax Credit"},  // Tax Credits
			   "p",                             // Password
			   1,                               // Number of Incomes
			   false,                           // Higher Earner
			   new String[]{"Unite"},           // Unions
			   "VHI One Plan 250",              // Health Plan
			   "Single",                        // Health Plan Type
			   15,                              // hourly rate
			   true, 
			   LocalDate.of(2024, 11, 01),
			   120);
	   
			   Employees.addPartTimeEmployee(employee);

       Scanner in = new Scanner(System.in); // Scanner for user input
       System.out.println("Select your role:");
       System.out.println("E)mployee \nH)R \nA)dmin ");
       String command = in.nextLine().toUpperCase();

       if (command.equals("E")) { // Use .equals() for string comparison
           System.out.print("Enter ID: ");
           int employeeID;
               employeeID = Integer.parseInt(in.nextLine()); // Parse employee ID

           System.out.print("Enter password: ");
           String storedPassword = Employees.getEmployeeFromIndex(employeeID).getPassword();

           // Password validation loop
           for (int attempts = 0; attempts < 3; attempts++) {
               String passwordCheck = in.nextLine();
               if (passwordCheck.equals(storedPassword)) {
                   System.out.println("Access granted!");
                   EmployeeMenu.showMenu(employeeID);
                   return; 
               } else if (attempts < 2) {
                   System.out.println("Incorrect password. Try again.");
               } else {
                   System.out.println("Maximum attempts reached. Access denied.");
               }
           }
         
       } else if (command.equals("H")) {
    	   System.out.print("Enter ID: ");
           String id_inputted = in.nextLine(); 
           
    	   if (id_inputted.equals(HrUsers.getHRID())) {
    		   System.out.print("Enter password: ");
    		   String id_inputted1 = in.nextLine();
    		   
    		   if(id_inputted1.equals(HrUsers.getPassword())) {
    			   System.out.println("Access granted!");
                   HrMenu.showMenu();
                   return;
             } else {
                   System.out.println("Incorrect password.");
             }
    	   }
       } else if (command.equals("A")) {
    	   System.out.print("Enter ID: ");
           String id_inputted = in.nextLine(); 
           
    	   if (id_inputted.equals(AdminUser.getAdminID())) {
    		   System.out.print("Enter password: ");
    		   String id_inputted1 = in.nextLine();
    		   
    		   if(id_inputted1.equals(AdminUser.getPassword())) {
    			   System.out.println("Access granted!");
                   AdminMenu.showMenu();
                   return;
             } else {
                   System.out.println("Incorrect password.");
             }
    	   }
       }
   }
}

       

import java.util.Scanner;
import java.time.LocalDate;

public class AdminMenu {
    public static void showMenu() {
        Scanner in = new Scanner(System.in);
        System.out.print("Select an option: ");
        System.out.print("A)dd an employee or L)ogout ");
        String command = in.nextLine().toUpperCase();

        if(command.equals("A")) {
            System.out.print("Select an option: ");
            System.out.print("Add a F)ull time employee or add a P)art time employee ");
            String choice = in.nextLine().toUpperCase();

            if (choice.equals("F")) {
                System.out.println("Enter the employee's name: ");
                String name = in.nextLine();

                System.out.println("Enter the employee's ID: ");
                int id = Integer.parseInt(in.nextLine());

                System.out.println("Enter the employee's job title: ");
                String jobTitle = in.nextLine();

                System.out.println("Enter the employee's pps number: ");
                String ppsnNum = in.nextLine();

                System.out.println("Enter the employee's email: ");
                String email = in.nextLine();

                System.out.println("Enter the employee's address: ");
                String address = in.nextLine();

                System.out.println("Enter the employee's phone number: ");
                String phoneNum = in.nextLine();

                System.out.println("Enter the employee's age: ");
                int age = Integer.parseInt(in.nextLine());

                System.out.println("Does the employee have a medical card: ");
                boolean hasMedicalCard = Boolean.parseBoolean(in.nextLine());

                System.out.println("Does the employee have health insurance: ");
                boolean hasHealthInsurance = Boolean.parseBoolean(in.nextLine());

                System.out.println("Enter the employee's status: ");
                String status = in.nextLine();

                System.out.println("Enter the employee's tax credits: ");
                String[] taxCredits = in.nextLine().split(",");

                System.out.println("Enter the employee's password: ");
                String password = in.nextLine();

                System.out.println("Enter the employee's number of incomes: ");
                int numberOfIncomes = Integer.parseInt(in.nextLine());

                System.out.println("Is the employee the highest earner: ");
                boolean isHighestEarner = Boolean.parseBoolean(in.nextLine());

                System.out.println("Is the employee in any unions. If so, please add them here: ");
                String unions[] = in.nextLine().split(",");

                System.out.println("Does the employee have a health plan: ");
                boolean hasHealthPlan = Boolean.parseBoolean(in.nextLine());

                System.out.println("Does the employee have a health plan type: ");
                String healthPlanType = in.nextLine();

                System.out.println("Enter the employee's salary scale point: ");
                double scalePoint = Double.parseDouble(in.nextLine());

                System.out.println("Enter the employee's department: ");
                String department = in.nextLine();

                System.out.println("Enter the employee's salary: ");
                double salary = Double.parseDouble(in.nextLine());


                FullTimeEmployee e = new FullTimeEmployee(name, id, jobTitle, ppsnNum, email, address, phoneNum, age, hasMedicalCard, hasHealthInsurance, status, taxCredits, password, numberOfIncomes, isHighestEarner, unions, hasHealthPlan, healthPlanType, scalePoint, department, salary);
                Employees.addFullTimeEmployee(e);
            }

            else if(choice.equals("P")) {
                System.out.print("Select an option: ");
                System.out.print("Add a F)ull time employee or add a P)art time employee ");
                String choice = in.nextLine().toUpperCase();

                if (choice.equals("F")) {
                    System.out.println("Enter the employee's name: ");
                    String name = in.nextLine();

                    System.out.println("Enter the employee's ID: ");
                    int id = Integer.parseInt(in.nextLine());

                    System.out.println("Enter the employee's job title: ");
                    String jobTitle = in.nextLine();

                    System.out.println("Enter the employee's pps number: ");
                    String ppsnNum = in.nextLine();

                    System.out.println("Enter the employee's email: ");
                    String email = in.nextLine();

                    System.out.println("Enter the employee's address: ");
                    String address = in.nextLine();

                    System.out.println("Enter the employee's phone number: ");
                    String phoneNum = in.nextLine();

                    System.out.println("Enter the employee's age: ");
                    int age = Integer.parseInt(in.nextLine());

                    System.out.println("Does the employee have a medical card: ");
                    boolean hasMedicalCard = Boolean.parseBoolean(in.nextLine());

                    System.out.println("Does the employee have health insurance: ");
                    boolean hasHealthInsurance = Boolean.parseBoolean(in.nextLine());

                    System.out.println("Enter the employee's status: ");
                    String status = in.nextLine();

                    System.out.println("Enter the employee's tax credits: ");
                    String[] taxCredits = in.nextLine().split(",");

                    System.out.println("Enter the employee's password: ");
                    String password = in.nextLine();

                    System.out.println("Enter the employee's number of incomes: ");
                    int numberOfIncomes = Integer.parseInt(in.nextLine());

                    System.out.println("Is the employee the highest earner: ");
                    boolean isHighestEarner = Boolean.parseBoolean(in.nextLine());

                    System.out.println("Is the employee in any unions. If so, please add them here: ");
                    String unions[] = in.nextLine().split(",");

                    System.out.println("Does the employee have a health plan: ");
                    boolean hasHealthPlan = Boolean.parseBoolean(in.nextLine());

                    System.out.println("Does the employee have a health plan type: ");
                    String healthPlanType = in.nextLine();

                    System.out.println("Does the employee have a health plan type: ");
                    double hourlyRate = Double.parseDouble(in.nextLine());

                    System.out.println("Has the employee submitted a pay claim: ");
                    boolean payClaimSubmitted = Boolean.parseBoolean(in.nextLine());

                    System.out.println("On what date did the employee submit the pay claim?:");
                    LocalDate datePayClaimSubmitted = LocalDate.parse(in.nextLine());

                    System.out.println("How many hours did the employee work this pay period: ");
                    double hoursWorked = Double.parseDouble(in.nextLine());


                    PartTimeEmployee e = new PartTimeEmployee(name, id, jobTitle, ppsnNum, email, address, phoneNum, age, hasMedicalCard, hasHealthInsurance, status, taxCredits, password, numberOfIncomes, isHighestEarner, unions, hasHealthPlan, healthPlanType, hourlyRate, payClaimSubmitted, datePayClaimSubmitted, hoursWorked);
                    Employees.addPartTimeEmployee(e);
                }
            }else if (command.equals("L")) {
                System.out.print("Logging you out.");
            }else {
                System.out.print("The option you have tried is incorrect. Logging you out.");
            }
        }
    }
}

           

        
         
    	   
      
