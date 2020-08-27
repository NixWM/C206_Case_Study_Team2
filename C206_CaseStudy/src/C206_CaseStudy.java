
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

		//In Sequences, (Name,Password,Email,Role)
		userList.add(new User("admin", "admin", "ad@admin", "Admin"));
		userList.add(new User("buyer", "buyer", "buyer@buyer", "Buyer"));
		userList.add(new User("seller", "seller", "seller@seller", "seller"));

		int option = 0;
		int option1 = 0;
		int categoryOption = 0;
		int maxLoginTries = 0;

		// coded by Wei Ming
		while (option != OPTION2_QUIT) {
			C206_CaseStudy.menu();
			User login = null; // default is null
			option = Helper.readInt("Enter an option > ");

			//if option is 1 (Login user)
			if (option == 1) {
				//(takes in the method of loginUser to userList)
				login = loginUser(userList);
				//(Checks if login is not null, then proceed to login)
				if (login != null) {
					//(Checks according to the roles)
					if (login.getRole().equals("Admin")) {
						System.out.println("Welcome Admin!");
						while (option1 != OPTION_QUIT) {
							UserDB.showAdminMenu();

							option1 = Helper.readInt("Enter an option > ");
							if (option1 == 1) {
								// Add user
								String name = Helper.readString("Enter user name > ");
								String password = Helper.readString("Enter user password > ");
								String email = Helper.readString("Enter user email > ");
								String role = Helper.readString("Enter user role > ");
								User NewUser = new User(name, password, email, role);
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
								// Added by Qiu Rong at 26/08/2020
								CategoryMain.categoryMenu();

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

							} else if (option1 == OPTION1_QUIT) {
								System.out.println("You have been successfully logged out!");
							}
						}
						//if role = Seller, login as Seller user.
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
				}else {
					System.out.println("Sorry, invalid role detected");
				}
			} else if (option == OPTION2_QUIT) {
				System.out.println("Thank you for shopping with us!");
			}
		}
	}

// Coded by Wei Ming
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

}
