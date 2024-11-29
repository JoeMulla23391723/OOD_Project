

import java.util.Scanner;

public class EmployeeMenu {
	public static void showMenu(int employeeID) {
		Scanner in = new Scanner(System.in);
		System.out.println("Select option applies to you: ");
		System.out.println("I am a F)ull-time employee\nI am as P)art-time employee \nL)ogout ");
		String chosen = in.nextLine().toUpperCase();

		if(chosen.equals("F")) {
			System.out.println("Select what payslip you would like to view: ");
			System.out.println("C)urrent Payslip \nP)ast payslips \nL)ogout ");
			String command = in.nextLine().toUpperCase();
			Payslip payslip = new Payslip();

			if(command.equals("C")) {
				payslip.printPayslip(employeeID,0);

			}else if(command.equals("P")) {
				System.out.println("What months payslip would you like to view: ");
				System.out.println("O)ctober \nS)eptember \nA)ugust \nJ)uly");
				String Choosing = in.nextLine().toUpperCase();
				
				if (Choosing.equals("O")) {
					payslip.printPayslip(employeeID,1);
				}else if(Choosing.equals("S")) {
					payslip.printPayslip(employeeID,2);
				}else if(Choosing.equals("A")) {
					payslip.printPayslip(employeeID,3);
				}else if(Choosing.equals("J")) {
					payslip.printPayslip(employeeID,4);
				}
				else
					System.out.print("The option you have entered is incorrect. Logging you out.");

			}else if(command.equals("L")) {
				System.out.print("Logging out...");
			}

			else {

				System.out.print("Logging out...");

			}
		}else {
			System.out.println("C)urrent Payslip, P)ast payslips L)ogout ");
			String command = in.nextLine().toUpperCase();
			Payslip payslip = new Payslip();

			if(command.equals("C")) {
				System.out.print("Here is your current payslip: ");
				payslip.printPayslip(employeeID,0);

			}else if(command.equals("P")) {
				System.out.print("Past payslips are not available for part-time employees.");

			}else if(command.equals("L")) {
				System.out.print("Logging out...");
			}

			else {

				System.out.print("Logging out...");
			}
		}

	}
}
