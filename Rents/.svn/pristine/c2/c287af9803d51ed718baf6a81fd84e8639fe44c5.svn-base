
package model;

import java.util.Objects;

/**
 * Represents a single user for registration or sign-in. User is an immutable object.
 * 
 * Constructors and methods of this class throw NullPointerException if required parameters are
 * null.
 * 
 * @author thenry04
 * @version Fall 2019
 */
public final class User {
    
    /** The name of the user. */
    private final String myName; 

    /** Password for the user. */
    private final  String myPassword;
    
    /** The status for whether the user is a VIP or not. */
    private final boolean myVIPStatus;
    
    
    /**
     * Constructs a User using the provided name and password.
     * 
     * @param theName The name to assign to this User.
     * @param thePassword The password to assign to this User.
     */
    public User(final String theName, final String thePassword) {
        
        if (theName.isEmpty() || thePassword.isEmpty()) {
            throw new IllegalArgumentException();
        }
        
        this.myName = Objects.requireNonNull(theName, "Name can not be Null");
        this.myPassword = Objects.requireNonNull(thePassword, "Password can not be Null");
        this.myVIPStatus = false;      
    } 
    
    /**
     * Constructs a User using the provided name, password, and VIP status.
     * 
     * @param theName The name to assign to this User.
     * @param thePassword The password to assign to this User.
     * @param theVIPStatus The VIP status to assign to this User.
     */
    public User(final String theName, final String thePassword, final boolean theVIPStatus) {
        this.myName = Objects.requireNonNull(theName, "Name must not be Null");
        this.myPassword = Objects.requireNonNull(thePassword, "Password must not be Null");
        this.myVIPStatus = theVIPStatus; 
    }
    
    /**
     * What is the name?
     * 
     * @return the name
     */
    public String getMyName() {
        return myName;
    }

    /**
     * What is the password?
     * 
     * @return the password
     */
    public String getMyPassword() {
        return myPassword;
    }

    /**
     * What is the VIP status?
     * 
     * @return the VIP status
     */
    public boolean getMyVIPStatus() {
        return myVIPStatus;
    }
    
    /**
     * Returns a String containing the variables : User(myName, myPassword, myVipStatus).
     * 
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        
        final String comma = ", ";
        sb.append(" (");
        sb.append(myName);
        sb.append(comma);
        sb.append(myPassword);
        sb.append(comma);
        sb.append(myVIPStatus);
        sb.append(')');
        
        return sb.toString();
    }
    
    /**
     * This method compares the myName, myPassword, and myVipStatus values to determine the equality of User objects.
     * 
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object theOtherUser) {
    
        boolean result = true;
      
        if (this == theOtherUser) {
            result = true;
        } else if (theOtherUser == null) {
            result = false;
        } else if (getClass() != theOtherUser.getClass()) {
            result = false;
        } else {
            final User otherObject = (User) theOtherUser;
            result = this.myName.equals(otherObject.myName)
                && this.myPassword.equals(otherObject.myPassword)
                && this.myVIPStatus == otherObject.myVIPStatus;
             
        }
      
        return result;
    }
    
    /**
     * This method returns the hash code of the User object.
     * 
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(myName, myPassword, myVIPStatus);
    }
}
