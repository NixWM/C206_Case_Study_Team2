import java.util.ArrayList;

public class CategoryDB {
	
	
	
	public static ArrayList<Category> categoryList = new ArrayList<Category>();
	
	public static Category inputCategory() {
		String catName = Helper.readString("Enter new category name: ");
		Category category = new Category(catName);
		return category;
		
	}
	


	public static void addCategory(ArrayList<Category> categoryList, Category category) {

		categoryList.add(category);
		System.out.println("New Category is added!");
		
	}
	
	public static String viewAllCategory(ArrayList<Category> categoryList) {
		
		//New edit 30/08/2020 to solve my error
		String output = "";
		output += "\n======Category List======\n";
		for (int i = 0; i < categoryList.size(); i++) {
			
			output += categoryList.get(i).getName()+"\n";
		}
		return output;
		
		
		// Coded by Qiu Rong 28/08/2020
//		Category cat1 = new Category("Electronic"); // Creating a new object
//	    categoryList.add(cat1);
//	    categoryList.add(new Category("Handphone"));
//	    String output = "";
//	    
//		output += "\n======Category List======\n";
//		
//
//		for (int i = 0; i < categoryList.size(); i++) {
//			
//			output += categoryList.get(i).getName()+"\n";
//		}
//		
//		return output;
	}
	
	public static void display(ArrayList<Category> categoryList) {
		String output = "";
		output += viewAllCategory(categoryList);
		System.out.println(output);
		
//		if(categoryList != null) {
//			
//			String output = viewAllCategory(categoryList);
//			System.out.println(output);
//		} else {
//			//Coded by Qiu Rong on 29/08/2020
//			System.out.println("Nothing to display");
//		}
	}
	
	public static String inputSearchCategory() {
		String catName = Helper.readString("Enter category name to search: ");

		return catName;
		
	}
	
	public static String doDelCategory(String catName) {
		
		boolean isFound = false;
		String output = "";
//		Category cat = null;
		int i =0;

		for (; i < categoryList.size(); i++) {
			
			String categoryName = categoryList.get(i).getName();
			
			if (catName.equalsIgnoreCase(categoryName)) {
				
				isFound = true;
				
//				cat= categoryList.get(i);
				
			}
		}
		if (isFound==true) {
			categoryList.remove(categoryList.get(i));
			output += "You have successfully deleted " + catName;
		} else {
			output += "You have entered an invalid category name.";
		}
		return output;
	}
	
	public static void delCategory() {
//		CategoryDB.display(categoryList);
		String catName = Helper.readString("Enter category name to delete: ");
		System.out.println(doDelCategory(catName));
		
		
	}
	
	
	public static void showCategoryMenu() {
		System.out.println("");
		//Added by Qiu Rong on 27/08/2020
		C206_CaseStudy.setHeader("Category Menu");
		//Added by Qiu Rong on 25/08/2020
		System.out.println("1. View all category");
		System.out.println("2. Add Category");
		System.out.println("3. Delete category");
		System.out.println("4. Search category");
		System.out.println("5. Update category");
		System.out.println("6. Display amount of items in each category");
		System.out.println("7. Quit");
		//Added by Qiu Rong on 27/08/2020
		System.out.println("");
	}

	public static void searchCategory(String catName) {
		
		boolean found = false;
		Category cat = null;
		
		for (int i = 0; i < categoryList.size(); i++){
	          if (categoryList.get(i).getName().contains(catName)){
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
	          if (categoryList.get(i).getName().equalsIgnoreCase(category)){
	        	  found = true;
	        	  cat= categoryList.get(i);
	        	  } 
	       }
		if (found == true) {
			String catNewName = Helper.readString("Enter new category name to change: ");
			cat.setName(catNewName);
			System.out.println(catNewName+" updated!");
		} else {
			System.out.println("You have entered an invalid category name.");
		}
	}
	
	//Coded by Qiu Rong on 29/08/2020
	public static void findAllItemsInCat(ArrayList<Item> itemList) {
		ArrayList<String> nameOfCat = new ArrayList<String>();
		ArrayList<Integer> itemInCat = new ArrayList<Integer>();
		String catName = null;
		boolean isFound = false;
		int indexFound = -1;
		
		for(int i=0; i<itemList.size(); i++) {
			catName = itemList.get(i).getCategory();
			isFound = false;
			indexFound = -1;
			for(int x=0; x<nameOfCat.size(); x++) {
				if(nameOfCat.get(x).equals(catName)) {
					isFound = true;
					indexFound = x;
				}
			}
			if(isFound==false) {
				nameOfCat.add(catName);
				itemInCat.add(1);
				
			}
			else {
				int get = itemInCat.get(indexFound);
				itemInCat.set(indexFound, get+1);
			}
		}
		for(int i=0; i<nameOfCat.size(); i++) {
			System.out.println(nameOfCat.get(i)+": There are "+itemInCat.get(i)+" items.");
		}
	}
	

}