import java.util.Scanner;

public class EmployeeMenu {
	public static void showMenu(int employeeID) {
		Scanner in = new Scanner(System.in);
		System.out.print("Select option: ");
		System.out.println("C)urrent Payslip, P)ast payslips , G)et Index of Employee L)ogout "); 
		String command = in.nextLine().toUpperCase(); 
		
		Payslip payslip = new Payslip(); 
		
		if(command.equals("C")) {
			
			payslip.printPayslip(employeeID);
			
		}else if(command.equals("P")) {
			System.out.print("Here are your past payslips"); 
			 
		}else if(command.equals("G")) {
			System.out.print(Employees.getIndexOfEmployeeID(employeeID)); 
		}
		
		else {
			
			System.out.print("Logging out...");
				
		}
	}

}

