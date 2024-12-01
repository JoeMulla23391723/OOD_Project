/**
 * Represents an Admin user with credentials and functionality to validate login.
 */

public class AdminUser{
    private static String adminID = "1234";
    private static String password = "admin_pass";
    
    /**
     * Constructor for AdminUser.
     *
     * @param AdminID   The admin's ID.
     * @param password  The admin's password.
     */

    public AdminUser(String AdminID, String password) {
        this.adminID = AdminID;
        this.password = password;
    }
    
    /**
     * Retrieves the Admin ID.
     *
     * @return The Admin ID.
     */

    public static String getAdminID() {
        return adminID;
    }

    /**
     * Retrieves the Admin password.
     *
     * @return The Admin password.
     */
    
    public static String getPassword() {
        return password;
    }

    /**
     * Validates the provided password against the stored password.
     *
     * @param inputPassword The password to validate.
     * @return True if the input password matches the stored password, false otherwise.
     */
    
    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

}
