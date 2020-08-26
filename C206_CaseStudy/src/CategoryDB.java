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
	
	public static void display(ArrayList<Category> categoryList) {
		if(categoryList != null) {
			
			String output = viewAllCategory(categoryList);
			System.out.println(output);
		}
	}
	
	public static void delCategory(String category) {
		Category cat = null;
		boolean found = false;
		for (int i = 0; i < categoryList.size(); i++){
	          if (categoryList.get(i).getName().equalsIgnoreCase(category)){
	        	  found = true;
	        	  cat= categoryList.get(i);
	          } 
	          
	       }
		if (found == true) {
			categoryList.remove(cat);
			System.out.println("You have successfully deleted " + cat);
		} else {
			System.out.println("You have entered an invalid category name.");
		}
		
		
	}
	
	
	public static void showCategoryMenu() {
		System.out.println("");
		System.out.println("1. View all category");
		System.out.println("2. Add Category");
		System.out.println("3. Delete category");
		System.out.println("4. Search category");
		System.out.println("5. Update category");
		System.out.println("6. Quit");
	}

	public static void searchCategory(String category) {
		
		boolean found = false;
		Category cat = null;
		
		for (int i = 0; i < categoryList.size(); i++){
	          if (categoryList.get(i).getName().contains(category)){
	        	  found = true;
	        	  cat= categoryList.get(i);
	        	  } 
	       }
		if (found == true) {
			System.out.println(cat.toString());
		} else {
			System.out.println("You have entered an invalid category name.");
		}
		
	      
		
		
	}
	
	public static void updateCategory(String category) {
		boolean found = false;
		Category cat = null;
		for (int i = 0; i < categoryList.size(); i++){
	          if (categoryList.get(i).getName().contains(category)){
	        	  found = true;
	        	  cat= categoryList.get(i);
	        	  } 
	       }
		if (found == true) {
			String catNewName = Helper.readString("Enter new category name to change: ");
			cat.setName(catNewName);
		} else {
			System.out.println("You have entered an invalid category name.");
		}
	}
	

}
