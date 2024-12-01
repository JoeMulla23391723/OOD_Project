
import java.io.FileNotFoundException;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/**
 * The entry point of the application.
 * This class handles user login and role-based menu navigation.
 * Users can select from Employee, HR, or Admin roles and access their respective menus.
 */

public class Main {
	
	/**
     * The main method serves as the entry point of the application.
     * It manages user authentication and directs users to the appropriate menu based on their role.
     *
     * @param args Command-line arguments (not used in this application).
     * @throws FileNotFoundException if the required CSV files are not found.
     */
	
        public static void main(String[] args) throws FileNotFoundException {

            //Load Employees From CSV
            Employees.readFullTimeEmployees("src/fulltimeemployees.csv");
            Employees.readPartTimeEmployees("src/parttimeemployees.csv");


            Scanner in = new Scanner(System.in); // Scanner for user input
            System.out.println("Select your role:");
            System.out.println("E)mployee \nH)R \nA)dmin ");
            String command = in.nextLine().toUpperCase();

            if (command.equals("E")) { // Use .equals() for string comparison
            	
            	/**
                 * Handles Employee login.
                 * Prompts the user for an ID and password. Validates the credentials.
                 * Grants access to the Employee Menu upon successful login.
                 */
            	
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
            }
          else if (command.equals("H")) {
        	  
        	  /**
               * Handles HR login.
               * Prompts the user for an ID and password. Validates the credentials.
               * Grants access to the HR Menu upon successful login.
               */
        	  
                    System.out.print("Enter ID: ");
                    String id_inputted = in.nextLine();

                    if (id_inputted.equals(HRUser.getHRID())) {
                        System.out.print("Enter password: ");
                        String id_inputted1 = in.nextLine();

                        if(id_inputted1.equals(HRUser.getPassword())) {
                            System.out.println("Access granted!");
                            HRMenu.showMenu();
                            return;
                        } else {
                            System.out.println("Logging you out. Incorrect password.");
                        }
                    }else {
                    	System.out.println("Logging you out. Incorrect password.");
                    }

            } else if (command.equals("A")) {
            	
            	/**
                 * Handles Admin login.
                 * Prompts the user for an ID and password. Validates the credentials.
                 * Grants access to the Admin Menu upon successful login.
                 */
            	
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
                        System.out.println("Incorrect password.Logging you out.");
                    }
                }else {
                	System.out.println("Incorrect entry.Logging you out.");
                }
            }else {
            	
            	/**
                 * Handles invalid role selection.
                 * Logs the user out and terminates the session.
                 */
            	
            	System.out.println("Incorrect entry.Logging you out.");
            }
        }
    }





