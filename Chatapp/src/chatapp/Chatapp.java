
package chatapp;
import PoePart1.logins;
import java.util.Scanner;



public class Chatapp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logins loginSystem = new logins();

        System.out.println(" User Registration ");
        System.out.println("Username Requirements:");
        System.out.println("- Must contain an underscore (_)");
        System.out.println("- Must be at most 5 characters long");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (loginSystem.checkUserName(username)) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
        }

        System.out.println("\nPassword Requirements:");
        System.out.println("- Must be **at least** 8 characters long");
        System.out.println("- Must contain at least one uppercase letter");
        System.out.println("- Must include at least one number");
        System.out.println("- Must have at least one special character (@, #, $, etc.)");
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (loginSystem.checkPasswordComplexity(password)) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }

        System.out.println("\nPhone Number Requirements:");
        System.out.println("- Must start with +27");
        System.out.println("- Must have exactly 9 digits after +27");
        System.out.print("Enter South African phone number: ");
        String phoneNumber = scanner.nextLine();

        if (loginSystem.checkCellPhoneNumber(phoneNumber)) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
        }

        loginSystem.registerUser(username, password, phoneNumber);

        System.out.println("\n=== Login ===");
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        
        String loginMessage = loginSystem.returnLoginStatus(loginUsername, loginPassword);
        System.out.println(loginMessage);

        if (loginSystem.loginUser(loginUsername, loginPassword)) {
            System.out.println("Welcome " + loginUsername + ", it is great to see you again.");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }

        scanner.close();
    }
}
//GeeksforGeeks (2024). Scope of a variable. [online] GeeksforGeeks. Available at: https://www.geeksforgeeks.org/scope-of-a-variable/.
//GeeksforGeeks. (2017). How to store a password in database? [online] Available at: https://www.geeksforgeeks.org/store-password-database/.
//GeeksforGeeks. (2024). Logical Operators in Programming. [online] Available at: https://www.geeksforgeeks.org/logical-operators-in-programming/.
//Diljot Jawanda (2016). If Statements and Usernames/Password. [online] Stack Overflow. Available at: https://stackoverflow.com/questions/36392749/if-statements-and-usernames-password.
//W3schools.com. (2025). W3Schools.com. [online] Available at: https://www.w3schools.com/Java/java_ref_scanner.asp [Accessed 22 Apr. 2025].
‌
‌
‌
‌
