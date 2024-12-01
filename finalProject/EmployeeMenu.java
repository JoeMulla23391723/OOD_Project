import java.util.Scanner;

/**
 * Provides functionality for the Employee Menu in the application.
 * Employees can view payslips (current or past), view their details, or log out.
 */

public class EmployeeMenu {
	
	/**
     * Displays the Employee menu and processes the user's input based on their employment type.
     * Full-time employees can view both current and past payslips, while part-time employees have limited options.
     *
     * @param employeeID The ID of the employee using the menu.
     */
	
    public static void showMenu(int employeeID) {
        Scanner in = new Scanner(System.in);
        System.out.println("Select option applies to you: ");
        System.out.println("I am a F)ull-time employee\nI am as P)art-time employee \nL)ogout ");
        String chosen = in.nextLine().toUpperCase();

        if(chosen.equals("F")) {
        	
        	/**
             * Handles options for full-time employees:
             * - View current payslip
             * - View past payslips (month-specific)
             * - View personal details
             * - Log out
             */
        	
            System.out.println("Select what payslip you would like to view: ");
            System.out.println("C)urrent Payslip \nP)ast payslips \nV)iew Details \nL)ogout ");
            String command = in.nextLine().toUpperCase();
            Payslip payslip = new Payslip();

            if(command.equals("C")) {
            	
            	 /**
                 * Prints the current payslip for the employee.
                 */
            	
                payslip.printPayslip(employeeID,0);

            }else if(command.equals("P")) {
            	
            	/**
                 * Prints a past payslip based on the selected month.
                 * Only applicable for full-time employees.
                 */
            	
                System.out.println("What months payslip would you like to view: ");
                System.out.println("O)ctober \nS)eptember \nA)ugust \nJ)uly");
                String Choosing = in.nextLine().toUpperCase();

                if (Choosing.equals("O")) {
                    payslip.printPayslip(employeeID, 1);
                } else if (Choosing.equals("S")) {
                    payslip.printPayslip(employeeID, 2);
                } else if (Choosing.equals("A")) {
                    payslip.printPayslip(employeeID, 3);
                } else if (Choosing.equals("J")) {
                    payslip.printPayslip(employeeID, 4);
                } else {
                	
                	 /**
                     * Handles invalid input for past payslip selection.
                     */
                	
                    System.out.print("The option you have entered is incorrect. Logging you out.");
                }
            }else if(command.equals("V")) {
            	
            	/**
                 * Displays the personal details of the full-time employee.
                 */
            	
                    System.out.println(Employees.getEmployeeFromIndex(employeeID).toString());
            }else if(command.equals("L")) {
            	
            	/**
                 * Logs out the full-time employee.
                 */
            	
                System.out.print("Logging out...");
            }
            else {
            	
            	/**
                 * Handles invalid input for full-time employee menu.
                 */
            	
                System.out.print("Logging out...");
            }
            
        }else if (chosen.equals("P")){
        	
        	/**
             * Handles options for part-time employees:
             * - View current payslip
             * - View personal details
             * - Log out
             */
        	
            System.out.println("C)urrent Payslip \nP)ast payslips \nV)iew Details\nL)ogout ");
            String command = in.nextLine().toUpperCase();
            Payslip payslip = new Payslip();

            if(command.equals("C")) {
            	
            	/**
                 * Prints the current payslip for the part-time employee.
                 */
            	
                payslip.printPayslip(employeeID,0);

            }else if(command.equals("P")) {
            	
            	/**
                 * Informs part-time employees that past payslips are unavailable.
                 */
            	
                System.out.print("Past payslips are not available for part-time employees.");
                
            }else if(command.equals("V")) {
            	
            	/**
                 * Displays the personal details of the part-time employee.
                 */
            	
                System.out.println(Employees.getEmployeeFromIndex(employeeID).toString());
                
            }else if(command.equals("L")) {
            	
            	/**
                 * Logs out the part-time employee.
                 */
            	
                System.out.print("Logging out...");
                
            }else {
            	
            	/**
                 * Handles invalid input for part-time employee menu.
                 */
            	
                System.out.print("Logging out...");
            }
          }
        }

    }
