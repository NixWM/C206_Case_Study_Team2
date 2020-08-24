import java.util.ArrayList;

public class UserDB{
	


	//public static ArrayList<User> userList = new ArrayList<User>();
	
	public static void addUser(ArrayList<User>userList,User user) {
		
		userList.add(user);
		
	}
	public static void viewAllUser(ArrayList<User>userList) {

		System.out.println("==================================USER LIST==================================");
		System.out.println(String.format("%-20s %-20s %-20s %-20s", "NAME", "PASSWORD",
				"EMAIL","ROLE"));
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(String.format("%-20s %-20s %-20s %-20s", userList.get(i).getName(),userList.get(i).getPassword(),userList.get(i).getEmail(),userList.get(i).getRole()));
			
		}
		
	
		
	}
	public static void delUser(String delete,ArrayList<User>userList) {
		for(int i=0;i<userList.size();i++) {
			if(delete.equals(userList.get(i).getEmail())) {
				userList.remove(userList.get(i));
				System.out.println("User deleted");
			}
			
			
		}
		
	}
	public static void showUserMenu() {
		System.out.println("");
		System.out.println("Campus Online Auction Shop");
		System.out.println("1. Add user");
		System.out.println("2. View all user");
		System.out.println("3. Delete user");
		System.out.println("4. Quit");
		System.out.println("");
	}
	
	
	
	
	

}
