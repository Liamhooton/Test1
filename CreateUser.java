import javax.swing.*;//imports all necessary javax.swing classes
import java.util.Arrays;//imports necessary class to perform array related functions

public class CreateUser {
    public static void main(String[] args) {
    String[][] registeredUsers = new String[10][4];//creates array to store user inputs
    int aCounter = 0;//counter for the array
    String continueRegistration;

    do {
        String[] Details = new String[4];//array for storing user details, stores each detail in a specified postion
        Details[0] = JOptionPane.showInputDialog("Insert your name: ");
        Details[1] = JOptionPane.showInputDialog("Insert your surname: ");
        Details[2] = JOptionPane.showInputDialog(null, "Create a Username.\n(It must be than 5 characters and contain a \"_\")");
        Details[3] = JOptionPane.showInputDialog(null, "Create a password:\nIt must be at least 8 characters long\ncontain a capital letter\ncontain a number\ncontain special character");

        String Message = LogInUser.registerUser(Details);// Calls the registerUser method from the LogInUser class and stores the returned message in the variable Message

        if (Message.startsWith("Congratulations")) {//checks if the returned message stored in Message begins with congradulations
            JOptionPane.showMessageDialog(null, Message);
            registeredUsers[aCounter][2] = Details[0]; // Store name
            registeredUsers[aCounter][3] = Details[1]; // Store surname
            registeredUsers[aCounter][0] = Details[2]; // Store username
            registeredUsers[aCounter][1] = Details[3]; // Store password
            System.out.println(Arrays.toString(registeredUsers[aCounter]));//converts values stored in array into a readable String
            aCounter++;//increments aCounter by one
        } else {
            JOptionPane.showMessageDialog(null, Message);
        }

        continueRegistration = JOptionPane.showInputDialog("Do you want to register another user? Yes/No");

    } while (continueRegistration.equalsIgnoreCase("Yes") && aCounter < registeredUsers.length);

    Object[] loginResult = LogInUser.login(registeredUsers);//returns login status of user
    LogInUser.returnLoginStatus((Boolean) loginResult[0], (String) loginResult[1], (String) loginResult[2]);// uses a boolean and two strings as arguments
}
}