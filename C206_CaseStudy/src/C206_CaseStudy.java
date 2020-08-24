import java.util.ArrayList;

public class C206_CaseStudy {
	
	
	
	private static final int OPTION_QUIT = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ArrayList<Item> itemList = new ArrayList<Item>();
	ArrayList<User>userList = new ArrayList<>();
	userList.add(new User("Admin","Admin","Admin@admin","Admin"));
		
		int option = 0;

		while (option != OPTION_QUIT) {

			UserDB.showUserMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Add user
				String name = Helper.readString("Enter your name > ");
				String password = Helper.readString("Enter your password > ");
				String email = Helper.readString("Enter your email > ");
				User NewUser = new User(name,password,email,"Member");
				UserDB.addUser(userList, NewUser);
		}
			else if(option ==2) {
				// View all user
				UserDB.viewAllUser(userList);
			}
			else if(option ==3) {
				// Delete user based on EMAIL
				String delete = Helper.readString("Enter your email to delete your user > ");
				UserDB.delUser(delete, userList);
			}
			else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} 	else {
				System.out.println("Invalid option");
			}

		}
				
		
		
		

	
	

		
	}
	
	public static void menu() {
//		C206_CaseStudy.setHeader("Campus Online Auction 2Shop");
//		System.out.println("1. Login account");
//		System.out.println("2. Register as user");
//		System.out.println("3. Browse items");
//		System.out.println("4. Quit");
//		Helper.line(80, "-");


	}
}