import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DealTest {
	
	private Deal deal1, deal2, deal3;
	
	@Before
	public void setUp() throws Exception {
		
		deal1 = new Deal("1", "Tablet", "seller1@gmail.com", "buyer1@gmail.com", 136.00, "12/09/2020");
		deal2 = new Deal("2", "Smartphone", "seller2@gmail.com", "buyer2@gmail.com", 640.00, "31/08/2020");
		deal1 = new Deal("3", "PC", "seller3@gmail.com", "buyer3@gmail.com", 5742.00, "27/08/2020");
	}

	@After
	public void tearDown() throws Exception {
		deal1 = null;
		deal2 = null;
		deal3 = null;
		DealDB.dealList.clear();
	}

	@Test
	public void addDealTest() {
		assertNotNull("Test dealList is not null", DealDB.dealList);
		
		//Test that size of dealList is 0 before adding any deals
		assertEquals("Test dealList is 0 before adding any deals", 0, DealDB.dealList.size());
		
		//Test that the size of the dealList is 1 after adding a deal
		DealDB.addDeal(deal1);
		assertEquals("Test size has 1", 1, DealDB.dealList.size());
		
		//Test that the first deal in list is the same as what was added
		assertSame("Test that the first item in list is the same as what was added", deal1, DealDB.dealList.get(0));	
	}

	public void viewDealTest() {
		 //Test that the dealList is not NULL
		assertNotNull("Test that the dealList is NOT null so that the deals can be retrieved from the database", DealDB.dealList);
			
		//test if the list of Deals retrieved is empty

		assertEquals("Test that the size of userList is 0 before viewing any deals", 0, DealDB.dealList.size());				
				
		//Given an empty list, after adding 3 deals, test if the size of the dealList is 3
		DealDB.addDeal(deal1);
		DealDB.addDeal(deal2);
		DealDB.addDeal(deal3);
		assertEquals("Test that the size of dealList is 3 ", 3, DealDB.dealList.size());
		
	}

	public void delDealTest() {
		assertNotNull("Test that itemList is Not null", DealDB.dealList);
		
		//Test if deals is inside the dealList before deleting properly
		DealDB.addDeal(deal1);
		DealDB.addDeal(deal2);
		DealDB.addDeal(deal3);
		assertEquals("Test that the size of dealList is 3 ", 3, DealDB.dealList.size());
		
		//Test if the list has one deal left after removing two deals from the dealList.
		DealDB.delDeal(deal1);
		DealDB.delDeal(deal2);
		assertEquals("Test that the size of the dealList is 1 after deleting the deals", 1, DealDB.dealList.size());
	}
}
