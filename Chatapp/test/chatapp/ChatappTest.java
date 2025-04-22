package chatapp;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import PoePart1.logins; // Ensure correct package reference

public class ChatappTest {
    private logins loginSystem;

    @Before
    public void setUp() {
        loginSystem = new logins();
    }

    @After
    public void tearDown() {
        loginSystem = null;
    }

    @Test
    public void testCheckUserName_Valid() {
        assertTrue("Username should be valid.", loginSystem.checkUserName("user_"));
    }

    @Test
    public void testCheckUserName_Invalid_MissingUnderscore() {
        assertFalse("Username should be invalid (missing underscore).", loginSystem.checkUserName("user"));
    }

    @Test
    public void testCheckUserName_Invalid_TooLong() {
        assertFalse("Username should be invalid (too long).", loginSystem.checkUserName("user123"));
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        assertTrue("Password should meet complexity requirements.", loginSystem.checkPasswordComplexity("StrongP@ss1"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_NoCapital() {
        assertFalse("Password should be invalid (missing uppercase letter).", loginSystem.checkPasswordComplexity("strongp@ss1"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_NoNumber() {
        assertFalse("Password should be invalid (missing number).", loginSystem.checkPasswordComplexity("StrongPass@"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_NoSpecialCharacter() {
        assertFalse("Password should be invalid (missing special character).", loginSystem.checkPasswordComplexity("StrongPass1"));
    }

    @Test
    public void testCheckCellPhoneNumber_Valid() {
        assertTrue("Phone number should be valid.", loginSystem.checkCellPhoneNumber("+27123456789"));
    }

    @Test
    public void testCheckCellPhoneNumber_Invalid_NoCountryCode() {
        assertFalse("Phone number should be invalid (missing +27 country code).", loginSystem.checkCellPhoneNumber("0123456789"));
    }

    @Test
    public void testCheckCellPhoneNumber_Invalid_WrongFormat() {
        assertFalse("Phone number should be invalid (wrong digit count).", loginSystem.checkCellPhoneNumber("+278765432"));
    }

    @Test
    public void testLoginUser_Success() {
        loginSystem.registerUser("user_", "StrongP@ss1", "+27123456789");
        assertTrue("Login should succeed with correct credentials.", loginSystem.loginUser("user_", "StrongP@ss1"));
    }

    @Test
    public void testLoginUser_Fail_WrongPassword() {
        loginSystem.registerUser("user_", "StrongP@ss1", "+27123456789");
        assertFalse("Login should fail with incorrect password.", loginSystem.loginUser("user_", "WrongPass123"));
    }

    @Test
    public void testLoginUser_Fail_UnregisteredUser() {
        assertFalse("Login should fail for an unregistered user.", loginSystem.loginUser("unknown_", "SomePass1!"));
    }

    @Test
    public void testReturnLoginStatus_Success() {
        loginSystem.registerUser("user_", "StrongP@ss1", "+27123456789");
        assertEquals("Welcome, user_! Login successful.", loginSystem.returnLoginStatus("user_", "StrongP@ss1"));
    }

    @Test
    public void testReturnLoginStatus_Fail() {
        loginSystem.registerUser("user_", "StrongP@ss1", "+27123456789");
        assertEquals("Login failed. Please try again.", loginSystem.returnLoginStatus("user_", "WrongPass123"));
    }
}
