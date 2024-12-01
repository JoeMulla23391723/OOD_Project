
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Provides functionality for the HR Menu in the application.
 * HR personnel can promote employees or log out.
 */

public class HRMenu {
	
	/**
     * Displays the HR menu and processes the user's input.
     * The HR user can promote employees (full-time or part-time) or log out.
     *
     * @throws FileNotFoundException if an error occurs while writing to a CSV file.
     */
	
    public static void showMenu() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Select an option: ");
        System.out.print("P)romote an Employee \nL)ogout ");
        String command = in.nextLine().toUpperCase();

        if(command.equals("P")) {
        	
        	/**
             * Handles the promotion of an employee based on their type (full-time or part-time).
             */
        	
            System.out.println("What type of employee would you like to promote: ");
            System.out.println("F)ull time employee \nP)art time employee ");
            String choosing = in.nextLine().toUpperCase();

            if (choosing.equals("F")) {
            	
            	/**
                 * Promotes a full-time employee by updating their job title.
                 */
            	
                System.out.print("Enter the employees ID number: ");
                int IDNumber = Integer.parseInt(in.nextLine());

                if(Employees.getEmployeeFromIndex(IDNumber) instanceof FullTimeEmployee) {
                    String currentJobTitle = Employees.getEmployeeFromIndex(IDNumber).getJobTitle();
                    System.out.print("Current job title:  " + currentJobTitle );
                    System.out.println("Select what option  ");
                    System.out.print("E)xecute annual promotion \nN)ew promotion");
                    String chosen = in.nextLine().toUpperCase();
                    Promotions promotion = new Promotions(IDNumber, LocalDate.now());

                    if(chosen.equals("E")) {
                    	
                    	/**
                         * Promotes the employee based on their annual eligibility and updates their job title.
                         */
                    	
                        System.out.println("What is the employees new job title: ");
                        String jobTitle = in.nextLine();
                        promotion.promoteEmployeeBasedOnTime(IDNumber, jobTitle);
                        System.out.println("Employee has been promoted to " + jobTitle);
                        CSVWriters csvWriters = new CSVWriters("src/fulltimeemployees.csv","src/parttimeemployees.csv");
                        csvWriters.writeEmployeesToCSV(Employees.getEmployees());
                        
                    }else if(chosen.equals("N")) {
                    	
                    	/**
                         * Promotes the employee to a custom-defined new role.
                         */
                    	
                        System.out.println("What is the employees new job title: ");
                        String jobTitle = in.nextLine();
                        promotion.changeJobTitle(IDNumber, jobTitle);
                        System.out.println("Employee has been promoted to " + jobTitle);
                        CSVWriters csvWriters = new CSVWriters("src/fulltimeemployees.csv","src/parttimeemployees.csv");
                        csvWriters.writeEmployeesToCSV(Employees.getEmployees());
                        
                    }else {
                    	
                    	/**
                         * Handles invalid input during full-time employee promotion.
                         */
                    	
                        	System.out.println("Incorrect entry.Logging you out.");
                    }

                }else {
                	
                	/**
                     * Handles cases where the provided ID does not belong to a full-time employee.
                     */
                	
                    System.out.println("EmployeeID input is not a full-time employee.");
                }

            }else if (command.equals("P")) {
            	/**
                 * Promotes a part-time employee by updating their job title.
                 */
            	
                System.out.print("Enter the employees ID number: ");
                int IDNumber = Integer.parseInt(in.nextLine());
                
                if(Employees.getEmployeeFromIndex(IDNumber) instanceof PartTimeEmployee) {
                    System.out.println("Select what option  ");
                    System.out.print("N)ew promotion \nL)ogout");
                    String chosen = in.nextLine().toUpperCase();
                    Promotions promotion = new Promotions(IDNumber, LocalDate.now());
                    
                    if(chosen.equals("N")) {
                    	
                    	/**
                         * Promotes the employee to a custom-defined new role.
                         */
                    	
                        System.out.println("What is the employees new job title: ");
                        String jobTitle = in.nextLine();
                        promotion.changeJobTitle(IDNumber, jobTitle);
                        System.out.println("Employee has been promoted to " + jobTitle);
                        CSVWriters csvWriters = new CSVWriters("src/fulltimeemployees.csv","src/parttimeemployees.csv");
                        csvWriters.writeEmployeesToCSV(Employees.getEmployees());
                        
                    }else {
                    	
                    	/**
                        * Handles invalid input during part-time employee promotion.
                        */
                    	
                        System.out.print("The option you have entered is incorrect. Logging you out.");
                    }

                }else {
                	
                	/**
                     * Handles cases where the provided ID does not belong to a part-time employee.
                     */
                	
                    System.out.println("EmployeeID input is not a part-time employee.");
                }

            }

            else {
            	
            	/**
                * Handles invalid input when selecting employee type.
                */
                
                System.out.print("The option you have entered is incorrect. Logging you out.");
            }
        }
    }
}
