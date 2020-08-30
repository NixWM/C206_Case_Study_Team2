
import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 5;
	private static final int OPTION2_QUIT = 3;

	public static void main(String[] args) {
		ArrayList<User> userList = new ArrayList<User>();
		
		//michell
		DealDB.addDeal(new Deal("1", "Tablet", "seller1@gmail.com", "buyer1@gmail.com", 136.00, "12/09/2020"));
		DealDB.addDeal(new Deal("2", "Smartphone", "seller2@gmail.com", "buyer2@gmail.com", 640.00, "31/08/2020"));
		DealDB.addDeal(new Deal("3", "PC", "seller3@gmail.com", "buyer3@gmail.com", 5742.00, "27/08/2020"));

		// In Sequences, (Name,Password,Email,Role) (weiming)
		userList.add(new User("admin", "admin", "ad@admin", "Admin"));
		userList.add(new User("buyer", "buyer", "buyer@buyer", "Buyer"));
		userList.add(new User("seller", "seller", "seller@seller", "Seller"));
		
		// hidayah
		itemDatabase.addItem(new Item("Chocolate", "Valentine's Day Chocolate", 1.50, "20 January 2020", "14 February 2020", 0.50));
		itemDatabase.addItem(new Item("Laptop", "Lenovo", 500, "15 February 2020", "19 December 2020", 100));


		int option = 0;
		int option1 = 0;
		int maxLoginTries = 0;

		// coded by Wei Ming
		while (option != OPTION2_QUIT) {
			C206_CaseStudy.loginMenu();
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
								CategoryDB.categoryMenu();

							} else if (option1 == 3) {
								// Michell code for (Deal menu here)
								DealDB.dealMenu("Admin");
							
							} else if (option1 == 4) {
								itemDatabase.showDealMenu();
								
								
								
							} else if (option1 == OPTION_QUIT) {
								System.out.println("You have been successfully logged out!");
							}
						}
						// If role = Buyer, login as Buyer user.
					} else if (login.getRole().equalsIgnoreCase("buyer")) {
						C206_CaseStudy.setHeader("CAMPUS ONLINE AUCTION SHOP");
						System.out.println("Welcome Member!(Buyer)");
						while (option1 != OPTION2_QUIT) {
							showBuyerMenu();
							option1 = Helper.readInt("Enter an option > ");
							if (option1 == 1) {
								UserDB.updateUser(userList);
							} else if (option1 ==2) {
								DealDB.dealMenu("Buyer");
							} else if (option1 == OPTION2_QUIT) {
								System.out.println("You have been successfully logged out!");
							}
						}
						// if role = Seller, login as Seller user.
					} else if (login.getRole().equalsIgnoreCase("seller")) {
						C206_CaseStudy.setHeader("CAMPUS ONLINE AUCTION SHOP");
						System.out.println("Welcome Member!(Seller)");
						while (option1 != OPTION2_QUIT) {
							showSellerMenu();
							option1 = Helper.readInt("Enter an option > ");
							if (option1 == 1) {
								UserDB.updateUser(userList);
							} else if (option1 ==2) {
								DealDB.dealMenu("Seller");
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

	public static void loginMenu() {
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

		public static void showBuyerMenu() {
			System.out.println("1. Update user");
			System.out.println("2. Deal");
			System.out.println("3. Quit");
		}


		public static void showSellerMenu() {
			System.out.println("1. Update user");
			System.out.println("2. Deal");
			System.out.println("3. Quit");
		}
	


}
