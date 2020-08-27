import java.util.ArrayList;
public class itemDatabase {
	
	public static ArrayList<Item> itemList = new ArrayList<Item>();
	
	Item item1 = new Item("Chocolate", "Valentine's Day Chocolate", 1.50, "20 January 2020", "14 February 2020", 0.50);
	Item item2 = new Item("Laptop", "Lenovo", 500, "15 February 2020", "19 December 2020", 100);
	public static void addItem(Item item) {
		// TODO Auto-generated method stub
		
		itemList.add(item);
	}


	public static String retrieveAllItems(ArrayList<Item> itemList) {
		// TODO Auto-generated method stub
		String output = "Item List \n";
		
		for(int a = 0; a < itemList.size(); a++) {
			output += itemList.get(a);
		}
		return output;
	}
	
	public static void delItem(Item item2) {
		itemList.remove(item2);
	}	
	
	
}
