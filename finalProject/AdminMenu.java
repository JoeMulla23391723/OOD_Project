import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * Provides functionality for the Admin Menu in the application.
 * Admins can add employees (full-time or part-time) or log out.
 */

public class AdminMenu {
	
	/**
     * Displays the Admin menu and processes the user's input.
     * Allows admins to add employees or log out.
     *
     * @throws FileNotFoundException if an error occurs while writing to a CSV file.
     */
	
    public static void showMenu() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Select an option: ");
        System.out.print("A)dd an employee or L)ogout ");
        String command = in.nextLine().toUpperCase();

        if(command.equals("A")) {
            System.out.print("Select an option: ");
            System.out.print("Add a F)ull time employee or add a P)art time employee ");
            String choice = in.nextLine().toUpperCase();

            if (choice.equals("F")) {
            	
            	 /**
                 * Adds a new full-time employee to the system by collecting
                 * the necessary details from the admin.
                 */
            	
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

                System.out.println("Does the employee have a medical card, please answer true or false: ");
                boolean hasMedicalCard = Boolean.parseBoolean(in.nextLine());

                System.out.println("Does the employee have health insurance, please answer true or false: ");
                boolean hasHealthInsurance = Boolean.parseBoolean(in.nextLine());

                System.out.println("Enter the employee's status: ");
                String status = in.nextLine();

                System.out.println("Enter the employee's tax credits: ");
                String[] taxCredits = in.nextLine().split(",");

                System.out.println("Enter the employee's password: ");
                String password = in.nextLine();

                System.out.println("Enter the employee's number of incomes: ");
                int numberOfIncomes = Integer.parseInt(in.nextLine());

                System.out.println("Is the employee the highest earner, please answer true or false: ");
                boolean isHighestEarner = Boolean.parseBoolean(in.nextLine());

                System.out.println("Is the employee in any unions. If so, please add them here: ");
                String unions[] = in.nextLine().split(",");

                System.out.println(("Enter health plan name:"));
                String healthPlan = in.nextLine();

                System.out.println("Does the employee have a health plan type: ");
                String healthPlanType = in.nextLine();

                System.out.println("Enter the employee's salary scale point: ");
                int scalePoint = Integer.parseInt(in.nextLine());

                System.out.println("Enter the employee's department: ");
                String department = in.nextLine();

                System.out.println("Enter the employee's salary: ");
                double salary = Double.parseDouble(in.nextLine());


                FullTimeEmployee e = new FullTimeEmployee(name, id, jobTitle, ppsnNum, email, address, phoneNum, age, hasMedicalCard, hasHealthInsurance, status, taxCredits, password, numberOfIncomes, isHighestEarner, unions, healthPlan, healthPlanType, scalePoint, department, salary);
                Employees.addFullTimeEmployee(e);

                CSVWriters csvWriters = new CSVWriters("src/fulltimeemployees.csv","src/parttimeemployees.csv");
                csvWriters.writeEmployeesToCSV(Employees.getEmployees());

            }

            else if(choice.equals("P")) {
            	
            	/**
                 * Adds a new part-time employee to the system by collecting
                 * the necessary details from the admin.
                 */
            	
                System.out.println("Enter the employee's name: ");
                String name = in.nextLine();

                System.out.println("Enter the employee's ID: ");
                int id = Integer.parseInt(in.nextLine());

                System.out.println("Enter the employee's job title: ");
                String jobTitle = in.nextLine();

                System.out.println("Enter the employee's pps number: ");
                String ppsNum = in.nextLine();

                System.out.println("Enter the employee's email: ");
                String email = in.nextLine();

                System.out.println("Enter the employee's address: ");
                String address = in.nextLine();

                System.out.println("Enter the employee's phone number: ");
                String phoneNum = in.nextLine();

                System.out.println("Enter the employee's age: ");
                int age = Integer.parseInt(in.nextLine());

                System.out.println("Does the employee have a medical card, please answer true or false: ");
                boolean hasMedicalCard = Boolean.parseBoolean(in.nextLine());

                System.out.println("Does the employee have health insurance, please answer true or false: ");
                boolean hasHealthInsurance = Boolean.parseBoolean(in.nextLine());

                System.out.println("Enter the employee's status: ");
                String status = in.nextLine();

                System.out.println("Enter the employee's tax credits: ");
                String[] taxCredits = in.nextLine().split(",");

                System.out.println("Enter the employee's password: ");
                String password = in.nextLine();

                System.out.println("Enter the employee's number of incomes: ");
                int numberOfIncomes = Integer.parseInt(in.nextLine());

                System.out.println("Is the employee the highest earner, please answer true or false: ");
                boolean isHighestEarner = Boolean.parseBoolean(in.nextLine());

                System.out.println("Is the employee in any unions. If so, please add them here: ");
                String unions[] = in.nextLine().split(",");

                System.out.println(("Enter health plan name:"));
                String healthPlan = in.nextLine();

                System.out.println("Does the employee have a health plan type: ");
                String healthPlanType = in.nextLine();

                System.out.println("Enter the employee's hourly rate:");
                double hourlyRate = Double.parseDouble(in.nextLine());

                System.out.println("Has the employee submitted a pay claim, please answer true or false: ");
                boolean payClaimSubmitted = Boolean.parseBoolean(in.nextLine());

                System.out.println("On what date did the employee submit the pay claim?:");
                LocalDate datePayClaimSubmitted = LocalDate.parse(in.nextLine());

                System.out.println("How many hours did the employee work this pay period: ");
                double hoursWorked = Double.parseDouble(in.nextLine());
                PartTimeEmployee e = new PartTimeEmployee(name, id, jobTitle, ppsNum, email, address, phoneNum, age, hasMedicalCard, hasHealthInsurance, status, taxCredits, password, numberOfIncomes, isHighestEarner, unions, healthPlan, healthPlanType, hourlyRate, payClaimSubmitted, datePayClaimSubmitted, hoursWorked);
                Employees.addPartTimeEmployee(e);

                CSVWriters csvWriters = new CSVWriters("src/fulltimeemployees.csv","src/parttimeemployees.csv");
                csvWriters.writeEmployeesToCSV(Employees.getEmployees());

            }
            }else if (command.equals("L")) {
                System.out.print("Logging you out.");
                
                /**
                 * Logs out the admin and terminates the session.
                 */
                
            }else {
            	
            	/**
                 * Handles invalid input by logging the admin out.
                 */
            	
                System.out.print("The option you have tried is incorrect. Logging you out.");
            }
        }
    }
