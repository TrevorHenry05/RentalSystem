/**
 * 
 */
package modeltests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import model.Registration;
import model.User;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Trevor henry
 * @version 1.0
 */
public class RegistrationTest {
    
    /**
     * Private User object to be tested.
     */
    private User myUser1;
    /**
     * Private Registration object to be tested.
     */
    private Registration myRegistration1;
    /**
    * User list to be tested.
    */
    private Map<String, User> myUserList;

    
    /**
     * Setup for User object, Registration object, and myUserList.
     */
    @Before
    public void setUp() {
        myUser1 = new User("husky5556667777", "123456", true); 
        myRegistration1 = new Registration();
        myUserList = myRegistration1.getMyUserList();
    }
    
    /**
     * Test method for {@link model.Registration#Registration()}.
     */
    @Test
    public void testRegistration() {
        assertEquals("Registration() failed", myUserList, new Registration().getMyUserList());
    }
    
    /**
     * Test method for {@link model.Registration#getMyUserList()}.
     */
    @Test
    public void testGetMyUserList() {
        assertEquals("GetMyUserList() failed", myUserList, myRegistration1.getMyUserList());
    }

    /**
     * Test method for {@link model.Registration#login(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testLogin() {
        assertTrue("Login() failed", myRegistration1.login("thenry", "1234"));
    }
    
    /**
     * Test method for {@link model.Registration#login(java.lang.String, java.lang.String)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testLoginIllegalUsernameArgument() {
        myRegistration1.login("", "1234");
    }
    
    /**
     * Test method for {@link model.Registration#login(java.lang.String, java.lang.String)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testLoginIllegalPasswordArgument() {
        myRegistration1.login("thenry", "");
    }
    
    /**
     * Test method for {@link model.Registration#login(java.lang.String, java.lang.String)}.
     */
    @Test(expected = NullPointerException.class)
    public void testLoginUsernameNull() {
        myRegistration1.login(null, "1234");
    }
    
    /**
     * Test method for {@link model.Registration#login(java.lang.String, java.lang.String)}.
     */
    @Test(expected = NullPointerException.class)
    public void testLoginPasswordNull() {
        myRegistration1.login("thenry", null);
    }

    /**
     * Test method for {@link model.Registration#register(model.User)}.
     */
    @Test
    public void testRegister() {
        assertTrue("Register failed", myRegistration1.register(myUser1));
    }
    
    /**
     * Test method for {@link model.Registration#register(model.User)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testRegisterIllegalUsernameArgument() {
        myUser1 = new User("", "1234");
        myRegistration1.register(myUser1);
    }
    
    /**
     * Test method for {@link model.Registration#register(model.User)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testRegisterIllegalPasswordArgument() {
        myUser1 = new User("senry", "");
        myRegistration1.register(myUser1);
    }
    
    /**
     * Test method for {@link model.Registration#register(model.User)}.
     */
    @Test(expected = NullPointerException.class)
    public void testRegisterUsernameNull() {
        myUser1 = new User(null, "12345");
        myRegistration1.register(myUser1);
    }
    
    /**
     * Test method for {@link model.Registration#register(model.User)}.
     */
    @Test(expected = NullPointerException.class)
    public void testRegisterPasswordNull() {
        myUser1 = new User("senry", null);
        myRegistration1.register(myUser1);
    }
    /**
     * Test method for {@link model.Registration#clear()}.
     */
    @Test
    public void testClear() {
        final Map<String, User> ul1 = new HashMap<String, User>();
        myUserList.clear();
        assertEquals("clear() failed", ul1, myUserList);
    }

    /**
     * Test method for {@link model.Registration#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("toString() failed", myRegistration1.toString(), new Registration().toString());
    }

}
