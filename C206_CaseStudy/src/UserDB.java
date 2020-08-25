import java.util.ArrayList;

public class UserDB {

	public static ArrayList<User> userList = new ArrayList<User>();

	public static void addUser(ArrayList<User> userList, User user) {

		userList.add(user);
		System.out.println("== User Added! ==");

	}

	public static String viewAllUser(ArrayList<User> userList) {
		String output="";
		System.out.println("==================================USER LIST==================================");
		System.out.println(String.format("%-20s %-20s %-20s %-20s", "NAME", "PASSWORD", "EMAIL", "ROLE"));
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(String.format("%-20s %-20s %-20s %-20s", userList.get(i).getName(),
					userList.get(i).getPassword(), userList.get(i).getEmail(), userList.get(i).getRole()));

		}
		return output;

	}

	public static void delUser(String delete, ArrayList<User> userList) {
		for (int i = 0; i < userList.size(); i++) {
			if (delete.equals(userList.get(i).getEmail())) {
				userList.remove(userList.get(i));
				System.out.println("== User deleted ==");
			}
		}

	}

	public static void searchUser(String email, ArrayList<User> userList) {
		System.out.println("==================================USER LIST=====================================");
		System.out.println(String.format("%-20s %-20s %-20s %-20s", "NAME", "PASSWORD", "EMAIL", "ROLE"));
		for (int i = 0; i < userList.size(); i++) {
			if (email.equals(userList.get(i).getEmail())) {
				System.out.println(String.format("%-20s %-20s %-20s %-20s", userList.get(i).getName(),
						userList.get(i).getPassword(), userList.get(i).getEmail(), userList.get(i).getRole()));
			}
		}
	}

	public static void updateUser(ArrayList<User> userList) {
		System.out.println("================================UPDATE ACCOUNT==================================");
		String updName = Helper.readString("Enter your current name > ");
		String upPass = Helper.readString("Enter your current password >");
		for (int i = 0; i < userList.size(); i++) {
			if (updName.equals(userList.get(i).getName()) && (upPass.equals(userList.get(i).getPassword()))) {
				System.out.println("============================ENTER NEW NAME AND PASSWORD=========================");
				String updatedName = Helper.readString("Enter your new name > ");
				String updatedPass = Helper.readString("Enter your new password > ");			
				userList.get(i).setName(updatedName);
				userList.get(i).setPassword(updatedPass);
				System.out.println("== Name and password updated! ==");
			}	
		}
	}
	
	

	public static void showUserMenu() {
		C206_CaseStudy.setHeader("CAMPUS ONLINE AUCTION SHOP");
		System.out.println("1. Update user");
		System.out.println("2. Quit");
		Helper.line(80, "=");
	}
	public static void showAdminMenu() {
		C206_CaseStudy.setHeader("CAMPUS ONLINE AUCTION SHOP");
		System.out.println("1. Add user");
		System.out.println("2. View all user");
		System.out.println("3. Delete user by email");
		System.out.println("4. Search user by email");
		System.out.println("5. Quit");
		Helper.line(80, "=");
	}

}
