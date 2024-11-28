
import java.util.Scanner;

public class employeeMenu {

	public static void showMenu() {
		Scanner in = new Scanner(System.in);
				System.out.print("Select an option: ");
				System.out.print("View C)urrent Payslip or View P)ast Payslips ");
				String command = in.nextLine().toUpperCase();
				
				if(command.equals("C")) {
					System.out.print("Here is your payslip: ");
				}else if (command.equals("P")) {
					System.out.print("Here is your past payslips: ");
				}else {
					System.out.print("Option is incorrect. Logging you out.");
				
				}
		
	}
 
}
