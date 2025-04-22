
package PoePart1;
import Poe.UserInfo;
import java.util.regex.Pattern;

public class logins {
 
    public UserInfo registeredUser;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return Pattern.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$", password);
    }

    public boolean checkCellPhoneNumber(String phoneNumber) {
        return Pattern.matches("^\\+27\\d{9}$", phoneNumber);
    }

    public void registerUser(String username, String password, String phoneNumber) {
        if (checkUserName(username) && checkPasswordComplexity(password) && checkCellPhoneNumber(phoneNumber)) {
            registeredUser = new UserInfo(username, password, phoneNumber);
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Registration failed: Check username, password, or phone number format.");
        }
    }

    public boolean loginUser(String username, String password) {
        return registeredUser != null && registeredUser.getUsername().equals(username) && registeredUser.getPassword().equals(password);
    }

    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome, " + username + "! Login successful.";
        }
        return "Login failed. Please try again.";
    }
}

