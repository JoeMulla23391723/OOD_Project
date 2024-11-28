package OOD;

import java.util.Scanner;

public class EmployeeMenu {
	public static void showMenu(int employeeID) {
		Scanner in = new Scanner(System.in);
		System.out.println("Select option applies to you: ");
		System.out.println("I am a F)ull-time employye\nI am as P)art-time employee L)ogout "); 
		String chosen = in.nextLine().toUpperCase(); 
		
		if(chosen.equals("F")) {
			System.out.println("Select option applies to you: ");
			System.out.println("C)urrent Payslip\n P)ast payslips L)ogout "); 
			String command = in.nextLine().toUpperCase(); 
			
			Payslip payslip = new Payslip(); 
			
			if(command.equals("C")) {
				System.out.print("Here is your current payslip: "); 
				payslip.printPayslip(employeeID);
				
			}else if(command.equals("P")) {
				System.out.print("Here are your past payslips: "); 
				 
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
				payslip.printPayslip(employeeID);
			
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
