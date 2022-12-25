/**
 * 
 */
package modeltests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Objects;
import model.User;
import org.junit.Before;
import org.junit.Test;



/**
 * @author trevor henry
 * @version 1.0
 */
public class UserTest {

    /**
     * 2 Private User objects to be tested.
     */
    private User myUser1;
    /**
     * 2 Private User objects to be tested.
     */
    private User myUser2;
    
    /**
     * Setup for User objects to be tested.
     */
    @Before
    public void setUp() {
        myUser1 = new User("thenry", "1234"); 
        myUser2 = new User("henry04", "123", true);
    }
    
    /**
     * Test method for {@link model.User#hashCode()}.
     */
    @Test
    public void testHashCode() {
        assertEquals("hashCode() failed", Objects.hash(myUser1.getMyName(), myUser1.getMyPassword(), myUser1.getMyVIPStatus()), myUser1.hashCode());
        
        final User u2 = new User("henry04", "123", true);
        
        assertEquals("hashCode() failed", myUser2.hashCode(), u2.hashCode());
    }

    /**
     * Test method for {@link model.User#User(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testUserStringString() {
        assertNotNull("The object is null", myUser1);
        
        assertEquals("2 parameter, Parameterized constructor failed", "thenry", myUser1.getMyName());
        assertEquals("2 parameter, Parameterized constructor failed", "1234", myUser1.getMyPassword());
        assertEquals("2 parameter, Parameterized constructor failed", false, myUser1.getMyVIPStatus());
    }
    
    /**
     * Test method for {@link model.User#User(java.lang.String, java.lang.String)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPointStringStringIllegalUsernameArgument() {
        myUser1 = new User("", "1234");
    }
    
    /**
     * Test method for {@link model.User#User(java.lang.String, java.lang.String)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPointStringStringIllegalPasswordArgument() {
        myUser1 = new User("thenry", "");
    }
    
    /**
     * Test method for {@link model.User#User(java.lang.String, java.lang.String)}.
     */
    @Test(expected = NullPointerException.class)
    public void testPointStringStringUsernameNull() {
        myUser1 = new User(null, "1234");
    }
    
    /**
     * Test method for {@link model.User#User(java.lang.String, java.lang.String)}.
     */
    @Test(expected = NullPointerException.class)
    public void testPointStringStringPasswordNull() {
        myUser1 = new User("thenry", null);
    }

    /**
     * Test method for {@link model.User#User(java.lang.String, java.lang.String, boolean)}.
     */
    @Test
    public void testUserStringStringBoolean() {
        assertNotNull("The object is null", myUser2);
        
        assertEquals("3 parameter, Parameterized constructor failed", "henry04", myUser2.getMyName());
        assertEquals("3 parameter, Parameterized constructor failed", "123", myUser2.getMyPassword());
        assertEquals("3 parameter, Parameterized constructor failed", true, myUser2.getMyVIPStatus());
    }
    
    /**
     * Test method for {@link model.User#User(java.lang.String, java.lang.String, boolean)}.
     */
    @Test(expected = NullPointerException.class)
    public void testPointStringStringBooleanUsernameNull() {
        myUser2 = new User(null, "1234", true);
    }
    
    /**
     * Test method for {@link model.User#User(java.lang.String, java.lang.String, boolean)}.
     */
    @Test(expected = NullPointerException.class)
    public void testPointStringStringBooleanPasswordNull() {
        myUser2 = new User("thenry", null, true);
    }

    /**
     * Test method for {@link model.User#getMyName()}.
     */
    @Test
    public void testGetMyName() {
        assertNotNull("The object is null", myUser1);
        assertNotNull("The object is null", myUser2);
        
        assertEquals("GetMyName Failed", "thenry", myUser1.getMyName());
        assertEquals("GetMyName Failed", "henry04", myUser2.getMyName());
    }

    /**
     * Test method for {@link model.User#getMyPassword()}.
     */
    @Test
    public void testGetMyPassword() {
        assertNotNull("The object is null", myUser1);
        assertNotNull("The object is null", myUser2);
        
        assertEquals("GetMyPassword Failed", "1234", myUser1.getMyPassword());
        assertEquals("GetMyPassword Failed", "123", myUser2.getMyPassword());
    }

    /**
     * Test method for {@link model.User#getMyVIPStatus()}.
     */
    @Test
    public void testGetMyVIPStatus() {
        assertNotNull("The object is null", myUser1);
        assertNotNull("The object is null", myUser2);
        
        assertEquals("GetMyVIPStatus Failed", false, myUser1.getMyVIPStatus());
        assertEquals("GetMyVIPStatus Failed", true, myUser2.getMyVIPStatus());
    }

    /**
     * Test method for {@link model.User#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("toString() failed", "User (thenry, 1234, false)", myUser1.toString());
        assertEquals("toString() failed", "User (henry04, 123, true)", myUser2.toString());
    }

    /**
     * Test method for {@link model.User#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectPositive() {
        final User u1 = new User("henry04", "123", true);
        assertEquals("equals() failed", u1, myUser2);
        assertEquals("equals() failed", myUser2, myUser2);
    }
    
    /**
     * Test method for {@link model.User#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectNegative() {
        assertNotEquals("equals() failed", myUser2, myUser1);
        assertNotEquals("equals() failed", myUser2, null);
        assertNotEquals("equals() failed", myUser2, new ArrayList<Object>());
    }

}

