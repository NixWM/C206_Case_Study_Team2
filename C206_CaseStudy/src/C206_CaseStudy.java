
import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 5;
	private static final int OPTION2_QUIT = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<User> userList = new ArrayList<User>();
		

		// In Sequences, (Name,Password,Email,Role)
		userList.add(new User("admin", "admin", "ad@admin", "Admin"));
		userList.add(new User("buyer", "buyer", "buyer@buyer", "Buyer"));
		userList.add(new User("seller", "seller", "seller@seller", "seller"));

		int option = 0;
		int option1 = 0;
		int maxLoginTries = 0;

		// coded by Wei Ming
		while (option != OPTION2_QUIT) {
			C206_CaseStudy.menu();
			User login = null; // default is null
			option = Helper.readInt("Enter an option > ");

			// if option is 1 (Login user)
			if (option == 1) {
				// (takes in the method of loginUser to userList)
				login = loginUser(userList);
				// (Checks if login is not null, then proceed to login)
				if (login != null) {
					// (Checks according to the roles)
					if (login.getRole().equals("Admin")) {
						System.out.println("Welcome Admin!");
						while (option1 != OPTION_QUIT) {
							UserDB.showAdminMenu();

							option1 = Helper.readInt("Enter an option > ");
							if (option1 == 1) {
								//display user menu
								userMenu(userList);

							} else if (option1 == 2) {
								// Added by Qiu Rong at 26/08/2020
								categoryMenu();

							} else if (option1 == 3) {
								// Michell code for (Deal menu here)
								
							} else if (option1 == OPTION_QUIT) {
								System.out.println("You have been successfully logged out!");
							}
						}
						// If role = Buyer, login as Buyer user.
					} else if (login.getRole().equalsIgnoreCase("buyer")) {
						System.out.println("Welcome Member!(Buyer)");
						while (option1 != OPTION2_QUIT) {
							UserDB.showBuyerMenu();
							option1 = Helper.readInt("Enter an option > ");
							if (option1 == 1) {
								UserDB.updateUser(userList);

							} else if (option1 == OPTION2_QUIT) {
								System.out.println("You have been successfully logged out!");
							}
						}
						// if role = Seller, login as Seller user.
					} else if (login.getRole().equalsIgnoreCase("seller")) {
						System.out.println("Welcome Member!(Seller)");
						while (option1 != OPTION2_QUIT) {
							UserDB.showSellerMenu();
							option1 = Helper.readInt("Enter an option > ");
							if (option1 == 1) {
								UserDB.updateUser(userList);

							} else if (option1 == OPTION2_QUIT) {
								System.out.println("You have been successfully logged out!");
							}
						}
					}

					// Coded by Wei Ming
				} else if (login == null && maxLoginTries == 0) {
					maxLoginTries++;
					System.out.println("Incorrect email or password.\nYou have 2 more attempts.");
				} else if (login == null && maxLoginTries == 1) {
					maxLoginTries++;
					System.out.println("Incorrect email or password.\nYou have 1 more attempt.");
				} else if (login == null && maxLoginTries == 2) {
					System.out.println("You've reached the maximum logon attempts\nPlease try again later.");
					System.exit(0);
				}
			} else if (option == 2) {
				// Add user
				String name = Helper.readString("Enter user name > ");
				String password = Helper.readString("Enter user password > ");
				String email = Helper.readString("Enter user email > ");
				String role = Helper.readString("Enter user role (Buyer/Seller) > ");
				if ((role.equalsIgnoreCase("Buyer")) && (!role.equalsIgnoreCase("Admin"))) {
					User NewUser = new User(name, password, email, role);
					UserDB.addUser(userList, NewUser);
				} else if ((role.equalsIgnoreCase("Seller")) && (!role.equalsIgnoreCase("Admin"))) {
					User NewUser = new User(name, password, email, role);
					UserDB.addUser(userList, NewUser);
				} else {
					System.out.println("Sorry, invalid role detected");
				}
			} else if (option == OPTION2_QUIT) {
				System.out.println("Thank you for shopping with us!");
			}
		}
	}

// Coded by Wei Ming
	// check login user based on email and password.
	public static User loginUser(ArrayList<User> userList) { 
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
	private static void categoryMenu() {

		CategoryDB.showCategoryMenu();
		int categoryOption = -1;

		while (categoryOption != 7) {
			categoryOption = Helper.readInt("Enter a category option > ");

			if (categoryOption == 1) {
				// View all category
				CategoryDB.display(CategoryDB.categoryList);
			} else if (categoryOption == 2) {
				// Add category
				String catName = Helper.readString("Enter new category name: ");
				Category c1 = new Category(catName);
				CategoryDB.categoryList.add(c1);
				System.out.println(c1 + " is add!");
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
				//Coded and edited by Qiu Rong on 29/08/2020
				ArrayList<Item> itemList = new ArrayList<Item>();
				
				itemList.add(new Item("Samsung Galaxy S9", "Samsung", 1200, "29/09/2020", "29/09/2020", 5, "Handphone"));
				itemList.add(new Item("Iphone 11 Pro Max", "Apple", 1600, "20/09/2020", "20/09/2020", 10, "Handphone"));
				itemList.add(new Item("Smart Television", "Samsung", 1700, "21/09/2020", "21/09/2020", 10, "Electronic"));
				itemList.add(new Item("Macbook", "Apple", 1900, "18/09/2020", "30/09/2020", 10, "Electronic"));
				// Display num of item in each category
				CategoryDB.findAllItemsInCat(itemList);
				
			} else if (categoryOption == 7) {
				// Coded by Qiu Rong on 29/08/2020
					// Quit
					System.out.println("You have exited Category Menu.");
			
			} else {
				System.out.println("Invalid type");
			}

		}

	}

	// Method userMenu added
	public static void userMenu(ArrayList<User> userList) {
		int userOption = 0;
		while (userOption != OPTION_QUIT) {
			UserDB.showUserMenu();
			userOption = Helper.readInt("Enter a user option > ");

			if (userOption == 1) {
				// Add User
				String name = Helper.readString("Enter user name > ");
				String password = Helper.readString("Enter user password > ");
				String email = Helper.readString("Enter user email > ");
				String role = Helper.readString("Enter user role (Buyer/Seller) > ");
				if ((role.equalsIgnoreCase("Buyer")) && (!role.equalsIgnoreCase("Admin"))) {
					User NewUser = new User(name, password, email, role);
					UserDB.addUser(userList, NewUser);
				} else if ((role.equalsIgnoreCase("Seller")) && (!role.equalsIgnoreCase("Admin"))) {
					User NewUser = new User(name, password, email, role);
					UserDB.addUser(userList, NewUser);
				} else {
					System.out.println("Sorry, invalid role detected");
				}
			} else if (userOption == 2) {
				// View all user
				UserDB.viewAllUser(userList);
			} else if (userOption == 3) {
				// Delete user based on EMAIL
				String delete = Helper.readString("Enter your email to delete the user > ");
				UserDB.delUser(delete, userList);

			} else if (userOption == 4) {
				// Search user account based on email
				String sEmail = Helper.readString("Enter user email to search > ");
				UserDB.searchUser(sEmail, userList);

			} else if (userOption == OPTION_QUIT) {
				// back to main menu
				System.out.println("== Back to main menu ==");
			}
		}

	}
	


}
