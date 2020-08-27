
import java.util.ArrayList;

public class C206_CaseStudy {
	
	
	
	private static final int OPTION_QUIT = 6;
	private static final int OPTION1_QUIT = 2;
	private static final int OPTION2_QUIT = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ArrayList<Item> itemList = new ArrayList<Item>();
	ArrayList<User> userList = new ArrayList<User>();
	ArrayList<Deal> dealList = new ArrayList<Deal>();
//	ArrayList<Category> categoryList = new ArrayList<Category>();

	userList.add(new User("ad", "ad", "ad", "Admin"));
	userList.add(new User("m", "m", "m", "Member"));

	int option = 0;
	int option1 = 0;
	int categoryOption = 0;

	while (option != OPTION2_QUIT) {
		C206_CaseStudy.menu();
		User login = null; // default is null
		option = Helper.readInt("Enter an option > ");

		if (option == 1) {
			login = loginUser(userList);
			if (login != null) {
				if (login.getRole().equals("Admin")) {
					System.out.println("Welcome Admin!");
					while (option1 != OPTION_QUIT) {
						UserDB.showAdminMenu();
						
						option1 = Helper.readInt("Enter an option > ");
						if (option1 == 1) {
							// Add user
							String name = Helper.readString("Enter your name > ");
							String password = Helper.readString("Enter your password > ");
							String email = Helper.readString("Enter your email > ");
							User NewUser = new User(name, password, email, "Member");
							UserDB.addUser(userList, NewUser);
						} else if (option1 == 2) {
							// View all user
							UserDB.viewAllUser(userList);
						} else if (option1 == 3) {
							// Delete user based on EMAIL
							String delete = Helper.readString("Enter your email to delete the user > ");
							UserDB.delUser(delete, userList);
						} else if (option1 == 4) {
							// Search user account based on email
							String sEmail = Helper.readString("Enter user email to search > ");
							UserDB.searchUser(sEmail, userList);
							
						} else if (option1 == 5) {
							//Added by Qiu Rong at 26/08/2020
							categoryMenu();
							
							
							
						
						} else if (option1 == OPTION_QUIT) {
							System.out.println("You have been successfully logged out!");
						}
					}
				} else if (login.getRole().equals("Member")) {
					System.out.println("Welcome Member!");
					while (option1 != OPTION1_QUIT) {
						UserDB.showUserMenu();
						option1 = Helper.readInt("Enter an option > ");
						if (option1 == 1) {
							UserDB.updateUser(userList);

						} else if (option1 == OPTION1_QUIT) {
							System.out.println("You have been successfully logged out!");
						}
					}
				}
			}
		} else if (option == OPTION2_QUIT) {
			System.out.println("Thank you for shopping with us!");
		}
	}
}

// Coded by WM
public static User loginUser(ArrayList<User> userList) { // check login user based on email and password.
	String email = Helper.readString("Enter your email > ");
	String password = Helper.readString("Enter your password >");
	for (int i = 0; i < userList.size(); i++) {
		if (email.equals(userList.get(i).getEmail()) && (password.equals(userList.get(i).getPassword()))) {
			return userList.get(i);
		}
	}
	return null;

}

public static void menu() {
	C206_CaseStudy.setHeader("CAMPUS ONLINE AUCTION SHOP");
	System.out.println("1. Login");
	System.out.println("2. Register");
	System.out.println("3. Quit");
	Helper.line(80, "=");

}

public static void setHeader(String header) {
	Helper.line(80, "=");
	System.out.println(header);
	Helper.line(80, "=");
}

// Coded by Qiu Rong at 25/08/2020
// Edited code by Qiu Rong at 26/08/2020
// Edited code again by Qiu Rong at 27/08/2020
private static void categoryMenu () {

	
	CategoryDB.showCategoryMenu();
	int categoryOption = -1;

	while(categoryOption != 6) {
		categoryOption = Helper.readInt("Enter a category option > ");
		
		if (categoryOption == 1) {
			// View all category
			CategoryDB.display(CategoryDB.categoryList);
		} else if (categoryOption == 2) {
			// Add category
			String catName = Helper.readString("Enter new category name: ");
			Category c1 = new Category(catName);
			CategoryDB.categoryList.add(c1);
			System.out.println(c1+" is add!");
			CategoryDB.viewAllCategory(CategoryDB.categoryList);
			
		} else if (categoryOption == 3) {
			// Delete Category
			String catName = Helper.readString("Enter category name to delete: ");
			CategoryDB.delCategory(catName);
			
		} else if (categoryOption == 4) {
				// Search Category
			
			String catName = Helper.readString("Enter category name to search: ");
			CategoryDB.searchCategory(catName);
				
		} else if (categoryOption == 5) {
				// Update Category
			String catName = Helper.readString("Enter category name to edit: ");
			CategoryDB.updateCategory(catName);
			
		} else if (categoryOption == 6) {
			// Quit
			System.out.println("Exit");
		} else {
			System.out.println("Invalid type");
		}
		
		
	}


}
}

