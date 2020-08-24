import java.util.ArrayList;

public class CategoryDB {
	
	public static ArrayList<Category> categoryList = new ArrayList<Category>();

	public static void addCategory(Category category) {

		categoryList.add(category);
		
	}
	
	public static String viewAllCategory(ArrayList<Category> categoryList) {
		String output = "";

		for (int i = 0; i < categoryList.size(); i++) {

			output += categoryList.get(i).getName()+"\n";
		}
		return output;
	}
	public static void delCategory(String category) {

		categoryList.remove(category);
		
	}
	

}
