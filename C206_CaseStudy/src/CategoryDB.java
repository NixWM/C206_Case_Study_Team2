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
	
//	public static String doDelCategory(String catName) {
//		
//		boolean isFound = false;
//		String output = "";
////		Category cat = null;
//		int i =0;
//
//		for (; i < categoryList.size(); i++) {
//			
//			String categoryName = categoryList.get(i).getName();
//			
//			if (catName.equalsIgnoreCase(categoryName)) {
//				
//				isFound = true;
//				
////				cat= categoryList.get(i);
//				
//			}
//		}
//		if (isFound==true) {
//			categoryList.remove(categoryList.get(i));
//			output += "You have successfully deleted " + catName;
//		} else {
//			output += "You have entered an invalid category name.";
//		}
//		return output;
//	}
//	
//	public static void delCategory() {
////		CategoryDB.display(categoryList);
//		String catName = Helper.readString("Enter category name to delete: ");
//		System.out.println(doDelCategory(catName));
//		
//		
//	}
	
	public static void delCategory(String categoryName) {
		C206_CaseStudy.setHeader("DELETE Category");
		boolean proceed = false;
		String output = "";
		int i = 0;
		
		for (; i < categoryList.size(); i++) {
			if (categoryList.get(i).getName().equals(categoryName)) {
				proceed = true;
				break;
			}
		}
		
		if (proceed) {
			categoryList.remove(i);
			output += "Category has been removed";
		} else 
			output += "The category name is invalid";
		
		System.out.println(output);
		System.out.println();
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
	
	// Coded by Qiu Rong at 25/08/2020
	// Edited code by Qiu Rong at 26/08/2020
	// Edited code again by Qiu Rong at 27/08/2020
	//Moved it from Case_study to categoryDB by Qiu Rong at 30/08/2020
	public static void categoryMenu() {


		categoryList.add(new Category("Electronic"));
		categoryList.add(new Category("Handphone"));
		int categoryOption = 0;

		while (categoryOption != 7) {
			CategoryDB.showCategoryMenu();
			categoryOption = Helper.readInt("Enter a category option > ");

			if (categoryOption == 1) {
				// View all category
				CategoryDB.display(categoryList);
			} else if (categoryOption == 2) {
				// Add category
//				String catName = Helper.readString("Enter new category name: ");
//				Category c1 = new Category(catName);
//				CategoryDB.categoryList.add(c1);
//				System.out.println(c1 + " is add!");
				Category category = CategoryDB.inputCategory();
				CategoryDB.addCategory(categoryList, category);
				
			} else if (categoryOption == 3) {
				// Delete Category
				display(categoryList);
				System.out.println();
				String categoryName = Helper.readString("Enter category name: ");
				delCategory(categoryName);
				
			

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
	

}