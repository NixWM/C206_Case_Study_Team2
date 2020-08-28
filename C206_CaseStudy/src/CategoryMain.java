// Created this file by Qiu Rong on 27/08/2020
public class CategoryMain {

	// Coded by Qiu Rong at 25/08/2020
	// Edited code by Qiu Rong at 26/08/2020
	// Edited code again by Qiu Rong at 27/08/2020
	public static void categoryMenu () {

		
		CategoryDB.showCategoryMenu();
		int categoryOption = -1;


		while(categoryOption != 6) {
			categoryOption = Helper.readInt("Enter a category option > ");
			
			if (categoryOption == 1) {
				// View all category
				CategoryDB.display(CategoryDB.categoryList);
			} else if (categoryOption == 2) {
				// Add category
				String catName = Helper.readString("Enter new category name: ");
				Category c1 = new Category(catName);
				CategoryDB.categoryList.add(c1);
				System.out.println(c1+" is add!");
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
				// Quit
				System.out.println("Exit");
			} else {
				System.out.println("Invalid type");
			}
			
			
		}


	}

}
