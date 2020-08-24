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
		item1 = new Item("Computer");
		itemList = new ArrayList<Item>();
	}

	@After
	public void tearDown() throws Exception {
		item1 = null;
		itemDatabase.itemList.clear();
	}

	@Test
	public void addItemTest() {
		//Test that itemList is NOT null (always check if empty list or not)[boundary]
		assertNotNull("Test itemList is not null", itemDatabase.itemList);
		
		//Test that size of itemList is 0 before adding any items
		assertEquals("Test itemlist is 0 before adding any items", 0, itemDatabase.itemList.size());
		
		//Test that the size of the itemList is 1 after adding item
		itemDatabase.addItem(itemList, item1);
		assertEquals("Test size has 1", 1, itemDatabase.itemList.size());
		
		//Test that the first item in list is the same as what was added
		assertSame("Test that the first item in list is the same as what was added", item1, itemList.get(1));
	}
	
	@Test
	public void viewItemTest() {
		//Test that itemList is NOT null (always check if empty list or not)[boundary]
		assertNotNull("Test itemLIst is not null", itemDatabase.itemList);
		
		String allItems = itemDatabase.retrieveAllItems(itemList);
		String testOutput = "";
		assertEquals("Check if all items are retrieved", testOutput, allItems);
		
		//After adding more items, check whether the itemList increase
		itemDatabase.addItem(itemList, item1);
		assertEquals("Check array list size is 1", 1, itemList.size());
		
		
	}
}
