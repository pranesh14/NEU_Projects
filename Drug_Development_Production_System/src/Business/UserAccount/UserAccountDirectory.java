/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import java.util.ArrayList;

/**
 *
 * @author PRPC
 */
public class UserAccountDirectory {

    private ArrayList<UserAccount> userAccountDirectory;

    public UserAccountDirectory() {
        userAccountDirectory = new ArrayList<>();
    }

    public UserAccount createUserAccount() {
        UserAccount userAccount = new UserAccount();
        userAccountDirectory.add(userAccount);
        return userAccount;
    }

    public void disableUserAccount(UserAccount userAccount) {
        userAccountDirectory.remove(userAccount);
    }

    public boolean modifyUserAccount(UserAccount userAccount, String password) {
        if (!userAccount.getPasswordHistory().contains(password)) {
            userAccount.setPassword(password);
            return true;
        } else {
            return false;
        }
    }

    public UserAccount authenticateUser(String userName, String password) {
        for (UserAccount userAccount : userAccountDirectory) {
            if (userAccount.getUsername().equalsIgnoreCase(userName) && userAccount.getPassword().equalsIgnoreCase(password)) {
                return userAccount;
            }
        }
        return null;
    }

    public ArrayList<UserAccount> getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public boolean checkIfUsernameIsUnique(String username) {
        for (UserAccount ua : userAccountDirectory) {
            if (ua.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
    
}
