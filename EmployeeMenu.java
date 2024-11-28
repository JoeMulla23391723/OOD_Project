import java.util.Scanner;

public class EmployeeMenu {
	public static void showMenu(int employeeID) {
		Scanner in = new Scanner(System.in);
		System.out.print("Select option: ");
		System.out.println("C)urrent Payslip, P)ast payslips , L)ogout "); 
		String command = in.nextLine().toUpperCase(); 
		
		Payslip payslip = new Payslip(); 
		
		if(command.equals("C")) {
			payslip.printPayslip(employeeID);
			
		}else if(command.equals("P")) {
			System.out.print("Here are your past payslips"); 
			 
		}else {
			
			System.out.print("Logging out...");
				
		}
	}

}
