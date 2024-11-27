package Project;
import java.util.Scanner;

public class Login{
   public static void main(String[] args) {
    FullTimeEmployee employee = new FullTimeEmployee(
   "John Doe",                 // Name
   101,                        // ID
   "Software Engineer",        // Job Title
   "1234567A",                 // PPS
   "johndoe@example.com",      // Email
   "123 Main Street",          // Address
   "555-1234",                 // Phone Number
   30,                         // Age
   true,                       // Medical Card
   false,                      // Health Insurance
   "Single",                   // Status
   new String[]{"50", "100"},  // Tax Credits
   "password123",              // Password
   1,                          // Number of Incomes
   false,                      // Higher Earner
   new String[]{"Union1"},     // Unions
   "HealthPlanA",              // Health Plan
   "TypeA",                    // Health Plan Type
   "5",                        // Salary Scale Point
   "IT Department",            // Department
   60000                       // Salary
);

    Employees.addFullTimeEmployee(employee);

       Scanner in = new Scanner(System.in); // Scanner for user input
       System.out.println("Select your role:");
       System.out.println("E)mployee H)R A)dmin ");
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
                   System.out.print("C)urrent Payslips , P)ast Payslips , L)ogout");
                   return; 
               } else if (attempts < 2) {
                   System.out.println("Incorrect password. Try again.");
               } else {
                   System.out.println("Maximum attempts reached. Access denied.");
               }
           }
       } else {
           System.out.println("Invalid role selection. Exiting.");
       }
   }
}
