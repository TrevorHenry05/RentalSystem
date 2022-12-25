
/*
 * This file is the registration class for the Vehicle Rental System.
 * 
 * TCSS 305 - Rentz
 */

package model;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import utility.FileLoader;

/**
 * Represents User Sign-in Object.
 * 
 * Methods of this class throw NullPointerException if required parameters are null.
 * 
 * @author thenry04
 * @version Fall 2019
 */

public class Registration {
    
    /**
     * Global scanner object.
     */
    public static final Scanner INPUT = new Scanner(System.in);
    
    /**
     * User Storage File.
     */
    public static final String USERFILE_NAME = "./resources/registeredusers.txt";
    
    /**
     * The registered user list for sign-in.
     */
    private final Map<String, User> myUserList;

    
    
    /**
     * Constructs a sign-in/registration system.
     * 
     * 
     */
    public Registration() {
        myUserList = FileLoader.readItemsFromFile(USERFILE_NAME);
    }

    /**
     * getter for myUserList.
     * 
     * @return myUserList
     */
    public Map<String, User> getMyUserList() {
        return myUserList;
    }

    /**
     * display sign-in or registration options.
     * 
     * @return sign-in success.
     */
    public boolean printSignin() {

        boolean result = false;
        
        System.out.print("Enter 1 or 2 (1. New Registration 2. Login):");
        final int answer = INPUT.nextInt();
        System.out.println();
        
        final String string = "**********************\nEnter Details\n**********************";
        final String string1 = "Username:";
        final String string2 = "Password:";
        
        if (answer == 1) {
            System.out.println("You entered option 1");
            System.out.println();
            
            System.out.println(string);
 
            System.out.print(string1);
            final String username = INPUT.next();
            System.out.println();
            
            System.out.print(string2);
            final String password = INPUT.next();
            System.out.println();
            
            System.out.print("isVIP(true/false): ");
            final boolean vipStatus = INPUT.nextBoolean();
            System.out.println();
            
            
            final User registerUser = new User(username, password, vipStatus);
            
            if (register(registerUser)) {
                System.out.println("Registration Succesful");
            }            
        } else {
            System.out.println("You entered option 2");
            System.out.println();
            
            System.out.println(string); 
           
            System.out.print(string1);
            final String username = INPUT.next();
            System.out.print(string2);
            final String password = INPUT.next();
            System.out.println();
            
            if (login(username, password)) {
                System.out.println("Login Succesful");
                result = true;
            }    
            
        }
        
        return result;
    }

    /**
     * Verify Sign-in procedure.
     * 
     * @param theUsername username for sign-in
     * @param thePassword password for signin
     * @return sign-in success
     */
    public boolean login(final String theUsername, final String thePassword) {
        
        final Map<String, User> userList = getMyUserList();
        
        final String string = "Username: ";
        final String string1 = "Password: ";
        final String string2 = "Wrong Credentials";      
                
        final String username = Objects.requireNonNull(theUsername, "Name must not be Null");
        final String password = Objects.requireNonNull(thePassword, "Password must not be Null");

        if (username.isEmpty() || password.isEmpty()) {
            INPUT.close();
            throw new IllegalArgumentException();
        }
        
        if (!userList.containsKey(username)) {
            System.out.println(string2);
            System.out.print(string);
            final String newUsername = INPUT.next();
            System.out.print(string1);
            final String newPassword = INPUT.next();
            System.out.println();
            login(newUsername, newPassword);
            
        }
        
        if (userList.containsKey(username) && !(userList.get(username).getMyPassword().equals(password))) {            
            System.out.println(string2);
            System.out.print(string);
            final String newUsername = INPUT.next();
            System.out.print(string1);
            final String newPassword = INPUT.next();
            System.out.println();
            login(newUsername, newPassword);      
        }
        
        return true;
    }

    /**
     * Adds a user to the registered user list.
     * 
     * @param theUser an order to add to this shopping cart
     * @return true/false returns if registration is successful
     */
    public boolean register(final User theUser) {
        
        final Scanner input = new Scanner(System.in);
        
        final Map<String, User> userList = getMyUserList();
        
        final String username = Objects.requireNonNull(theUser.getMyName(), "Name can not be Null");
        final String password = Objects.requireNonNull(theUser.getMyPassword(), "Password can not be Null");
        
        if (username.isEmpty() || password.isEmpty()) {
            input.close();
            throw new IllegalArgumentException();
        }
        
        if (userList.containsKey(username)) {
            System.out.print("User already exists, enter different user name: ");
            final String newUsername = input.next();
            System.out.println();
                
            final User registerUser = new User(newUsername, password, theUser.getMyVIPStatus());
            register(registerUser);
        }
       
        if (!userList.containsKey(username)) {
            FileLoader.writeUserToFile(USERFILE_NAME, theUser);
        }
        
        input.close();
        
        return true;
    }

    /**
     * Empties the user list.
     */
    public void clear() {
        myUserList.clear();
    }

    @Override
    /**
     * String representation of the object
     * 
     */
    public String toString() {

        final StringBuilder sb = new StringBuilder();
        
        final Map<String, User> userList = getMyUserList();
        final Set<String> keys = userList.keySet();
        final Iterator<String> itr = keys.iterator();
        
        sb.append("Registered UserList { ");
        
        while (itr.hasNext()) {
            final String key = itr.next();
            sb.append(key);
            sb.append(" = ");
            sb.append(userList.get(key).toString());
            if (itr.hasNext()) {
                sb.append(",");   
            }
        }   
        sb.append(" }");
        
        return sb.toString();
    }

}
