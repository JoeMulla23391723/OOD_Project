package OOD;

public class HrUsers {
	private static String HRID = "5678";
	private static String password = "hr_pass";
	
	public HrUsers(String HRID, String password) {
		this.HRID = HRID;
		this.password = password;
	}
	
	public static String getHRID() {
		return HRID;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public boolean validatePassword(String inputPassword) {
		return this.password.equals(inputPassword);
	}
	
}
