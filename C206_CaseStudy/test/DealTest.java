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
		
		//Test that size of itemList is 0 before adding any items
		assertEquals("Test deallist is 0 before adding any deals", 0, DealDB.dealList.size());
		
		//Test that the size of the itemList is 1 after adding item
		DealDB.addDeal(deal1);
		assertEquals("Test size has 1", 1, DealDB.dealList.size());
		
		//Test that the first item in list is the same as what was added
		assertSame("Test that the first item in list is the same as what was added", deal1, DealDB.dealList.get(0));	
	}
	
	public void viewDealTest() {
		 //Test that dealList is not null
		assertNotNull("Test that dealList is NOT null so deals can be retrieved", DealDB.dealList);
			
		//test if the list of Deals retrieved is empty
		String allDeals= DealDB.viewAllDeal();
		assertEquals("Test that the size of userList is 0 before viewing any Deals", 0, DealDB.dealList.size());
	}
}
