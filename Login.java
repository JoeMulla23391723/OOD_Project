package OOD;

import java.util.Scanner;

public class Login{
   public static void main(String[] args) {
	   FullTimeEmployee employee = new FullTimeEmployee(
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
	   "p",                 // Password
	   1,                               // Number of Incomes
	   false,                           // Higher Earner
	   new String[]{"Unite"},           // Unions
	   "VHI One Plan 250",              // Health Plan
	   "Single",                        // Health Plan Type
	   "5",                             // Salary Scale Point
	   "library",                       // Department
	   50000                               // Salary

   );
	   Employees.addFullTimeEmployee(employee);

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

       


           

        
         
    	   
      
