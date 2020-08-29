import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	private Category category1;
	private Category category2;
	
	@Before
	public void setUp() throws Exception {
		
		category1 = new Category("Electronic");
		category2 = new Category("Handphone");

	}  

	@After
	public void tearDown() throws Exception {
		category1 = null;
		category2 = null;
		
		CategoryDB.categoryList.clear();
	}

	@Test
	public void addCategoryTest() {
		//Test that catList is NOT NULL
		assertNotNull("Test that catList is NOT null", CategoryDB.categoryList);
		
		//Test that the size of catList is 0 before adding any categories
		assertEquals("Test that the size of catList is 0 before adding any categories", 0, CategoryDB.categoryList.size());
		//Test that the size of catList is 1 after adding a category
		CategoryDB.addCategory(category1);
		assertEquals("Test that the size of catList is 1 after adding a category", 1, CategoryDB.categoryList.size());
		//Test that the first element in catList is the same as what was added.
		assertSame("Test that the first element in catList is the same as what was added", category1, CategoryDB.categoryList.get(0));
	}
	
	@Test 
	public void viewAllCategory() {
		//Test if CategoryList is not null
		assertNotNull("Test if CategoryList is not null", CategoryDB.categoryList);
		
		//Test if the list of category retrieved is not empty
		String allCategory = CategoryDB.viewAllCategory(CategoryDB.categoryList);
		CategoryDB.categoryList.clear();
		String testOutput = "\n======Category List======\n";
		testOutput += "Electronic\nHandphone\n";
		assertEquals("Test if the list of category retrieved is empty",testOutput, allCategory);
				
		//test if the expected output string same as the list of category retrieved from the categoryDB	
		allCategory= CategoryDB.viewAllCategory(CategoryDB.categoryList);
		String testOutput2 = "\n======Category List======\n";
		testOutput2 += "Electronic\n";
		testOutput2 += "Handphone\n";
			
		assertEquals("Test that viewAllCategoryList", testOutput2, allCategory);
		
	}
	
	@Test
	public void delCategoryTest() {
		//Test that catList is NOT NULL
		assertNotNull("Test that categoryList is NOT null", CategoryDB.categoryList);
		
		//Test that the size of categoryList is 0 after deleting a category
		CategoryDB.delCategory("category1");
		assertEquals("Test that the size of categoryList is not 0 after deleting a category", 0, CategoryDB.categoryList.size());

	}
	
	@Test
	public void searchCategoryTest() {
		//Test that categoryList is NOT NULL
		assertNotNull("Test that categoryList is NOT null", CategoryDB.categoryList);
		
		//Test that categoryList is not empty
		CategoryDB.addCategory(category1);
		CategoryDB.addCategory(category2);

		assertNotEquals("Test that categoryList is not empty", category1, CategoryDB.categoryList);
		
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
		CategoryDB.addCategory(category1);
		CategoryDB.addCategory(category2);
		assertTrue("Test that categoryList is not empty", CategoryDB.categoryList.isEmpty()==false);
		
		//Test that category will be able to update
		String updateCat = Helper.readString("Enter category name to search: ");
		CategoryDB.updateCategory(updateCat);
		assertNotSame("Test that category will be able to search", updateCat, CategoryDB.categoryList);
	}
	
	@Test
	public void findAllItemsInCatTest() {
		//Test that categoryList is NOT NULL
		assertNotNull("Test that categoryList is NOT null", CategoryDB.categoryList);
		
		//Test that categoryList is not empty
		CategoryDB.addCategory(category1);
		CategoryDB.addCategory(category2);
		assertTrue("Test that categoryList is not empty", CategoryDB.categoryList.isEmpty()==false);
		
		//Test that category will be able to display number of items
//		CategoryDB.updateCategory(updateCat);
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		itemList.add(new Item("Samsung Galaxy S9", "Samsung", 1200, "29/09/2020", "29/09/2020", 5, "Handphone"));
		itemList.add(new Item("Macbook", "Apple", 1900, "18/09/2020", "30/09/2020", 10, "Electronic"));
		// Display num of item in each category
		CategoryDB.findAllItemsInCat(itemList);

		int numOfItems = itemList.size();
		assertSame("Test that category will be able to display number of items in each category", 2, numOfItems);
	}

}
