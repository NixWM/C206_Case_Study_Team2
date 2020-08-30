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
		String allItems = itemDatabase.doViewAllItem(itemDatabase.itemList);
		String testOutput = "Item List \n ";
		testOutput += "";
		assertEquals("Test if the list of category retrieved is empty",testOutput, allItems);
		
		//After adding more items, check whether the itemList increase
		//itemDatabase.addItem(item1);
		
		assertEquals("Check array list size is 2", 2, itemDatabase.itemList.size());
		
		//test the output string is the same as the list of items retrieved
		allItems = itemDatabase.doViewAllItem(itemDatabase.itemList);
		testOutput += "";
		
		assertEquals("Test to retrieve and view all category", testOutput, allItems);
	}
	
	@Test
	public void delItemTest() {
		assertNotNull("Test that itemList is Not null", itemDatabase.itemList);
		
		//check if list of items is empty
		String allItems = itemDatabase.doViewAllItem(itemList);
		String testOutput = "Item List \n ";
		assertEquals("Check if all items are retrieved", testOutput, allItems);
		
		//check if item in the list is deleted properly
		String itemName = itemDatabase.itemList.toString();
		String item = itemDatabase.doDelItem(itemList, itemName);
		
		itemDatabase.doDelItem(itemList, item);
		assertEquals("Test that the size of the itemList is 0 after deleting the item", 0, itemDatabase.itemList.size());
	}
}
