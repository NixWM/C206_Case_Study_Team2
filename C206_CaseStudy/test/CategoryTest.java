import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	private Category category1, category2;
	
	@Before
	public void setUp() throws Exception {
		
		category1 = new Category("Electronic");
		category2 = new Category("Accessories");

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
		
		//Test if the list of category retrieved is empty
		String allCategory = CategoryDB.viewAllCategory(CategoryDB.categoryList);
		String testOutput = "";
		assertEquals("Test if the list of category retrieved is empty",testOutput, allCategory);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		CategoryDB.addCategory(category1);
		CategoryDB.addCategory(category2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, CategoryDB.categoryList.size());
				
		//test if the expected output string same as the list of category retrieved from the categoryDB	
		allCategory= CategoryDB.viewAllCategory(CategoryDB.categoryList);
		testOutput = "Electronic\n";
		testOutput += "Accessories\n";
			
		assertEquals("Test that viewAllCategoryList", testOutput, allCategory);
		
	}
	
	@Test
	public void delCategoryTest() {
		//Test that catList is NOT NULL
		assertNotNull("Test that categoryList is NOT null", CategoryDB.categoryList);
		
		//Test that the size of categoryList is 0 after deleting a category
		CategoryDB.delCategory("category1");
		assertEquals("Test that the size of categoryList is not 0 after deleting a category", 0, CategoryDB.categoryList.size());

	}

}
