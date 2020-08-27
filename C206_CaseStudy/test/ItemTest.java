import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	private Item item1;
	private ArrayList<Item> itemList;
	
	
	@Before
	public void setUp() throws Exception {
		item1 = new Item("");
		itemList = new ArrayList<Item>();
	}

	@After
	public void tearDown() throws Exception {
		item1 = null;
		itemList.clear();
	}

	@Test
	public void addItemTest() {
		//Test that itemList is NOT null (always check if empty list or not)[boundary]
		assertNotNull("Test itemList is not null", itemDatabase.itemList);
		
		//Test that size of itemList is 0 before adding any items
		assertEquals("Test itemlist is 0 before adding any items", 0, itemDatabase.itemList.size());
		
		//Test that the size of the itemList is 1 after adding item
		itemDatabase.addItem(item1);
		assertEquals("Test that the size of the item list is 1 after adding an item", 1, itemDatabase.itemList.size());
		
		//Test that the first item in list is the same as what was added
		assertSame("Test that the first item in list is the same as what was added", item1, itemDatabase.itemList.get(0));
	}
	
	@Test
	public void viewItemTest() {
		//Test that itemList is NOT null (always check if empty list or not)[boundary]
		assertNotNull("Test itemLIst is not null", itemDatabase.itemList);
		
		//Check if the list of items retrieved is empty
		String allItems = itemDatabase.retrieveAllItems(itemList);
		String testOutput = "";
		assertEquals("Check if all items are retrieved", testOutput, allItems);
		
		//After adding more items, check whether the itemList increase
		itemDatabase.addItem(item1);
		assertEquals("Check array list size is 2", 2, itemDatabase.itemList.size());
		
		//test the output string is the same as the list of items retrieved
		allItems = itemDatabase.retrieveAllItems(itemDatabase.itemList);
		testOutput = "";
		
		assertEquals("Test to retrieve and view all category", testOutput, allItems);
	}
	
	@Test
	public void delItemTest() {
		assertNotNull("Test that itemList is Not null", itemDatabase.itemList);
		
		itemDatabase.delItem("item1");
		assertEquals("Test that the size of the itemList is 0 after deleting the item", 0, itemDatabase.itemList.size());
	}
}
