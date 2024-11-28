package Project;

import java.util.Scanner;

public class hrMenu {

	public static void showMenu() {
		System.out.print("Select an option: ");
		System.out.print("P)romote an Employee or L)ogout ");
		String command = in.nextLine().toUpperCase();
				
			if(command.equals("P")) {
				System.out.println("What type of employee would you like to promote: ");	
				System.out.println("F)ull time employee or P)art time employee ");
				String choosing = in.nextLine().toUpperCase();
				if (choosing.equals("F")) {
					System.out.print("");	
					
				}
			}else if (command.equals("P")) {
				System.out.print("");	
				
			}else {
				System.out.print("The option you have tried is incorrect. Logging you out.");
				
			}
		
	    }
		
	}
	

