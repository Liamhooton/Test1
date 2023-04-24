import javax.swing.*;//imports all necessary javax.swing classes

public class LogInUser {
    public static boolean checkUserName(String username) {// This method checks if the given username is valid by ensuring it has a length of 5 characters or less and contains "_"
       return username.length() <= 5 && username.contains("_");
}

public static boolean checkPasswordComplexity(String password) {    // This method checks if the given password is valid by ensuring it has a length of 8 or more, contains at least one uppercase letter, one digit, and one special character

    if (password.length() < 8) {
        return false;
    }

    boolean hasUpperCase = false;
    boolean hasDigit = false;
    boolean hasSpecialChar = false;

    String specialCharacters = "!@#$%^&*()'+,->/<=>?[]^_{|}";

    for (int i = 0; i < password.length(); i++) {
        char currentChar = password.charAt(i);

        if (Character.isUpperCase(currentChar)) {
            hasUpperCase = true;
        }
        if (Character.isDigit(currentChar)) {
            hasDigit = true;
        }
        if (specialCharacters.contains(Character.toString(currentChar))) {
            hasSpecialChar = true;
        }
        if (hasUpperCase && hasDigit && hasSpecialChar) {
            return true;
        }
    }

    return false;
}
    public static String registerUser(String[] Details) {//prompts the user and checks if inputs are valid and provides the appropriate feedback

String name = Details[0];
String surname = Details[1];
String userName = Details[2];
String passWord = Details[3];//stores details in specified array postion


        if (!checkUserName(userName)) {//checks if user name is not correctly formated
           String a = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";

            return a;
        }

        if (!checkPasswordComplexity(passWord)) {
            String b = "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";

            return b;
        }

        String message = "Congratulations! Your details have been filled in correctly:" + "\nName: " + name + "\nSurname: " + surname + "\nUsername: " + userName + "\nPassword: " + passWord;
        return message;//appropriate message is returned correct format
    }


    public static Object[] login(String[][] registeredUsers) {
    JOptionPane.showMessageDialog(null, "Please input your LogIn details");
    String userNameLogin = JOptionPane.showInputDialog("Please enter your username: ");
    String passWordLogin = JOptionPane.showInputDialog("Please enter your password: "); //prompts user to login

    for (String[] user : registeredUsers) { //uses a for each loop to check if details entered are contained in registeredUsers[]
        if (user[0] != null && user[0].equals(userNameLogin) && user[1].equals(passWordLogin)) { //sets the condition used to check if the entered values are equal to the ones stored in registeredUsers[]
            return new Object[]{true, user[2], user[3]}; //returns true if a match is found and includes the name and surname
    }
    }
    return new Object[]{false, null, null}; //returns false if a match is not found and null values for name and surname

}

    public static void returnLoginStatus(boolean isLoggedIn, String name, String surname) {
    if (isLoggedIn) {
        JOptionPane.showMessageDialog(null, "Welcome " + name + " " + surname + " it is great to see you again.");//displays relevant message to user for successful login
    } else {
        JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again");//displays relevant message to user for a failed login
    }
}
}

