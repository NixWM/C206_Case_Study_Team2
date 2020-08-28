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
		user = new User("John", "456", "John456@gmail.com", "Member");
		user2 = new User("May", "123", "May123@gmail.com", "Member");
		userList = new ArrayList<User>();
	}

	@After
	public void tearDown() throws Exception {
		user = null;
		user2 = null;
		userList = null;
	}

	@Test
	public void AddUserTest() {
		// fail("Not yet implemented");

		// Test userList is NOT null (before having new = ArrayList<User>(); in UserDB)
		assertNotNull("Test userList is NOT null", userList);

		// Test size of userList is empty before adding into the user list.
		assertEquals("Test size of userList is empty before adding into the user list.", 0, userList.size());

		// Test size of userList is 1 after adding a user.
		UserDB.addUser(userList, user);
		assertEquals("Test size of userList is 1 after adding a user.", 1, userList.size());

		// Test the first element in userList is the same as what was added.
		assertSame("Test the first element in userList is the same as what was added.", user, userList.get(0));
	}

	@Test
	public void ViewUserTest() {

		// Test if size of userList is 0 before viewing the users
		assertEquals("Test if size of userList is 0 before viewing the users", 0, userList.size());

		//Test if the list of user retrieved is empty
		UserDB.userList.add(user);
		UserDB.userList.add(user2);
		assertEquals("Test that user arraylist size is 2", 2, UserDB.userList.size());
		String allUser = UserDB.viewAllUser(UserDB.userList);
		String testOutput = "";
		assertEquals("Test if the list of user retrieved is 2",testOutput, allUser);

	}

	@Test
	public void delUserTest() {
		userList.add(user);
		// Test if user list size is 1 before deleting the user
		assertEquals("Test if user list size is 1 before deleting the user", 1, userList.size());
		System.out.println(String.format("%-1s %-1s %-1s %-1s", userList.get(0).getName(),
				userList.get(0).getPassword(), userList.get(0).getEmail(), userList.get(0).getRole()));
		;
			// Test if user list is 0
		userList.remove(0);
		assertEquals("Test if user list is 0", 0, userList.size());
		System.out.println(userList);

	}

	@Test
	public void searchUserTest() {
		// Test if the user list is not null
		assertNotNull(userList);
		// Given an empty list, after adding 2 users, test if the users is inside the
		// list.
		userList.add(user);
		userList.add(user2);
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(String.format("%-1s %-1s %-1s %-1s", userList.get(i).getName(),
					userList.get(i).getPassword(), userList.get(i).getEmail(), userList.get(i).getRole()));
		}
		assertEquals("Test that user arraylist size is 2", 2, userList.size());
		// Test if user search by email
		String search = Helper.readString("Search user based on email > ");
		UserDB.searchUser(search, userList);
	}

	@Test
	public void updateUserTest() {
		// Test if the user list is not null
		assertNotNull(userList);
		// Test if user able to retreive their name and password and update the
		// accordingly to the user input.
		userList.add(user);
		UserDB.updateUser(userList);
	}

}
