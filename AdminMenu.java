
import java.util.Scanner;

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
					int ppsnNum = Integer.parseInt(in.nextLine());
					
					System.out.println("Enter the employee's email: ");
					String email = in.nextLine();
					
					System.out.println("Enter the employee's address: ");
					String address = in.nextLine();
					
					System.out.println("Enter the employee's phone number: ");
					int phoneNum = Integer.parseInt(in.nextLine());
					
					System.out.println("Enter the employee's age: ");
					int age = Integer.parseInt(in.nextLine());
					
					System.out.println("Does the employee have a medical card: ");
					boolean hasMedicalCard = Boolean.parseBoolean(in.nextLine());
					
					System.out.println("Does the employee have health insurance: ");
					boolean hasHealthInsurance = Boolean.parseBoolean(in.nextLine());
					
					System.out.println("Enter the employee's status: ");
					String status = in.nextLine();
					
					System.out.println("Enter the employee's tax credits: ");
					double taxCredits = Double.parseDouble(in.nextLine());
					
					System.out.println("Enter the employee's password: ");
					String password = in.nextLine();
					
					System.out.println("Enter the employee's number of incomes: ");
					int numberOfIncomes = Integer.parseInt(in.nextLine());
					
					System.out.println("Is the employee the highest earner: ");
					boolean isHighestEarner = Boolean.parseBoolean(in.nextLine());
					
					System.out.println("Is the employee in any unions: ");
					boolean inUnion = Boolean.parseBoolean(in.nextLine());
					
					System.out.println("Does the employee have a health plan: ");
					boolean hasHealthPlan = Boolean.parseBoolean(in.nextLine());
					
					System.out.println("Does the employee have a health plan type: ");
					String healthPlanType = in.nextLine();
					
					System.out.println("Enter the employee's hourly rate: ");
					double hourlyRate = Double.parseDouble(in.nextLine());
					
					
				}
				else if(choice.equals("P")) {
					System.out.println("Enter the employee's name: ");
					String name = in.nextLine();
					
					System.out.println("Enter the employee's ID: ");
					int id = Integer.parseInt(in.nextLine());
					
					System.out.println("Enter the employee's job title: ");
					String jobTitle = in.nextLine();
					
					System.out.println("Enter the employee's pps number: ");
					int ppsnNum = Integer.parseInt(in.nextLine());
					
					System.out.println("Enter the employee's email: ");
					String email = in.nextLine();
					
					System.out.println("Enter the employee's address: ");
					String address = in.nextLine();
					
					System.out.println("Enter the employee's phone number: ");
					int phoneNum = Integer.parseInt(in.nextLine());
					
					System.out.println("Enter the employee's age: ");
					int age = Integer.parseInt(in.nextLine());
					
					System.out.println("Enter the employee's hourly rate: ");
					double hourlyRate = Double.parseDouble(in.nextLine());
					
					System.out.println("Enter the employee's status: ");
					String status = in.nextLine();
					
				}
			}else if (command.equals("L")) {
				System.out.print("Logging you out.");
			}else {
				System.out.print("The option you have tried is incorrect. Logging you out.");
		}
	}
}
//FullTimeEmployee e = new FullTimeEmployee(name, id, jobTitle, ppsnNum, email, address, phoneNum, age, hasMedicalCard, hasHealthInsurance, status, taxCredits, password, numberOfIncomes, isHighestEarner, isUnion, hasHealthPlan, healthPlanType, hourlyRate);
//Employees.addFullTimeEmployee(e);
//PartTimeEmployee e = new PartTimeEmployee(name, id, jobTitle, ppsnNum, email, address, phoneNum, age, hourlyRate, status);
//Employees.addPartTimeEmployee(e);
