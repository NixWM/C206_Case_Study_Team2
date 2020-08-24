import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User user;
	private User user2;
	private ArrayList<User> userList;
	
	@Before
	public void setUp() throws Exception {
		user = new User("John","456","John456@gmail.com","Member");
		user2 = new User("May","123","May123@gmail.com","Member");
		userList= new ArrayList<User>();
	}

	@After
	public void tearDown() throws Exception {
		user = null;
		user2 = null;
		userList = null;
	}

	@Test
	public void AddUserTest() {
		//fail("Not yet implemented");
		
		//Test userList is NOT null (before having new = ArrayList<User>(); in UserDB)
		assertNotNull("Test userList is NOT null",userList);
		
		//Test size of userList is empty before adding into the user list.
		assertEquals("Test size of userList is empty before adding into the user list.", 0, userList.size());
		
		//Test size of userList is 1 after adding a user.
		UserDB.addUser(userList, user);
		assertEquals("Test size of userList is 1 after adding a user.", 1, userList.size());
		
		//Test the first element in userList is the same as what was added.
		assertSame("Test the first element in userList is the same as what was added.", user, userList.get(0));
	}
	@Test
	public void ViewUserTest() {
		
		// Test if user list is not null but empty -boundary
		//assertNotNull("Test if there is valid user arraylist to retrieve user", UserDB.userList);
		
		//Test if size of userList is 0 before viewing the users
		assertEquals("Test if size of userList is 0 before viewing the users",0, userList.size());
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		userList.add(new User("doggy","dog","dogcat@.com","Member"));
		userList.add(new User("catty","cat","catdog@.com","Member"));
		
		assertEquals("Test that user arraylist size is 2", 2, userList.size());

	}
	@Test
	public void delUserTest() {
		userList.add(new User("doggy","dog","dogcat@.com","Member"));
		//Test if user list size is 1 before deleting the user
		assertEquals("Test if user list size is 1 before deleting the user", 1,userList.size());
		System.out.println(userList); //test 1
		//Test if user list is 0
		userList.remove(0);
		assertEquals("Test if user list is 0",0,userList.size());
		System.out.println(userList); //test 0
		
		
			
	}

}
