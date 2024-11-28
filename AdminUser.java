

public class AdminUser{
	private static String adminID = "1234";
	private static String password = "admin_pass";

	public AdminUser(String AdminID, String password) {
		this.adminID = AdminID;
		this.password = password;
	}
	
	public static String getAdminID() {
		return adminID;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public boolean validatePassword(String inputPassword) {
		return this.password.equals(inputPassword);
	}

}
