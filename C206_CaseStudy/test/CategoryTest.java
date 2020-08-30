//Coded by Qiu Rong on 24/08/2020
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	private Category category1;
	private Category category2;
	private ArrayList<Category> categoryList;
	
	
	@Before
	public void setUp() throws Exception {
		
		category1 = new Category("Electronic");
		category2 = new Category("Handphone");
		
		categoryList= new ArrayList<Category>();

	}  

	@After
	public void tearDown() throws Exception {
		category1 = null;
		category2 = null;
		
		CategoryDB.categoryList.clear();
	}

	@Test
	public void addCategoryTest() {
//		//New edited code on 30/08/2020 by Qiu Rong

		// Category list is not null, so that can add a new category - boundary
		assertNotNull("Check if there is valid Category arraylist to add to", categoryList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		CategoryDB.addCategory(categoryList, category1);
		assertEquals("Check that Category arraylist size is 1", 1, categoryList.size());
		assertSame("Check that Category is added", category1, categoryList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		CategoryDB.addCategory(categoryList, category2);
		assertEquals("Check that Camcorder arraylist size is 2", 2, categoryList.size());
		assertSame("Check that Camcorder is added", category2, categoryList.get(1));
	}
	
	@Test 
	public void viewAllCategory() {		
		//New code to try solve my error on 30/08/2020
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Category arraylist to retrieve item", categoryList);
		
		//test if the list of category retrieved from the CategoryDB is empty - boundary
		String allCategory= CategoryDB.viewAllCategory(categoryList);
		String testOutput = "\n======Category List======\n";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCategory);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		CategoryDB.addCategory(categoryList, category1);
		CategoryDB.addCategory(categoryList, category2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, categoryList.size());
		
		//test if the expected output string same as the list of category retrieved from the categoryDB	
		allCategory= CategoryDB.viewAllCategory(categoryList);
		testOutput = "\n======Category List======\n";
		testOutput += "Electronic\nHandphone\n";
	
		assertEquals("Test that ViewAllCamcorderlist", testOutput, allCategory);
		
		
	}
	
	@Test
	public void delCategoryTest() {
		//Test that catList is NOT NULL
		assertNotNull("Test that categoryList is NOT null", CategoryDB.categoryList);
		
		//Test that the size of categoryList is 0 after deleting a category
		CategoryDB.delCategory("Electronic");
		assertEquals("Test that the size of categoryList is 0 after deleting a category", 0, CategoryDB.categoryList.size());

	}
	
	@Test
	public void searchCategoryTest() {
		//Test that categoryList is NOT NULL
		assertNotNull("Test that categoryList is NOT null", CategoryDB.categoryList);
		
		//Test that categoryList is not empty
		CategoryDB.addCategory(categoryList, category1);
		CategoryDB.addCategory(categoryList, category2);
		assertEquals("Test that category arraylist not empty", 2, categoryList.size());
		
		//Test that category will be able to search
//		String searchCat = Helper.readString("Enter category name to search: ");
		CategoryDB.searchCategory(category1.toString());
		
		
//		CategoryDB.searchCategory(CategoryDB.categoryList);
		assertNotSame("Test that category will be able to search", category1, CategoryDB.categoryList.contains(category1));

	}
	
	@Test
	public void updateCategoryTest() {
		//Test that categoryList is NOT NULL
		assertNotNull("Test that categoryList is NOT null", CategoryDB.categoryList);
		
		//Test that categoryList is not empty
		CategoryDB.addCategory(categoryList, category1);
		CategoryDB.addCategory(categoryList, category2);
		assertTrue("Test that categoryList is not empty", CategoryDB.categoryList.isEmpty());
		
		//Test that category will be able to update
		String updateCat = Helper.readString("Enter category name to search: ");
		CategoryDB.updateCategory(updateCat);
		assertNotSame("Test that category will be able to search", updateCat, CategoryDB.categoryList);
	}
	
	//Coded by Qiu Rong on 29/08/2020
	@Test
	public void findAllItemsInCatTest() {
		//Test that categoryList is NOT NULL
		assertNotNull("Test that categoryList is NOT null", CategoryDB.categoryList);
		
		//Test that categoryList is not empty
		CategoryDB.addCategory(categoryList, category1);
		CategoryDB.addCategory(categoryList, category2);
		assertTrue("Test that categoryList is not empty", CategoryDB.categoryList.isEmpty());
		
		//Test that category will be able to display number of items
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		itemList.add(new Item("Samsung Galaxy S9", "Samsung", 1200, "29/09/2020", "29/09/2020", 5, "Handphone"));
		itemList.add(new Item("Macbook", "Apple", 1900, "18/09/2020", "30/09/2020", 10, "Electronic"));
		// Display num of item in each category
		CategoryDB.findAllItemsInCat(itemList);

		int numOfItems = itemList.size();
		assertSame("Test that category will be able to display number of items in each category", 2, numOfItems);
	}

}
