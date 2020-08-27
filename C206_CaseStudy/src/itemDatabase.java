import java.util.ArrayList;
public class itemDatabase {
	
	public static ArrayList<Item> itemList = new ArrayList<Item>();

	public static void addItem(Item item) {
		// TODO Auto-generated method stub
		itemList.add(item);
	}


	public static String retrieveAllItems(ArrayList<Item> itemList) {
		// TODO Auto-generated method stub
		String output = "";
		
		for(int a = 0; a < itemList.size(); a++) {
			output += itemList.get(a).getName();
		}
		return output;
	}
	
	public static void display(ArrayList<Item> itemList) {
		if(itemList != null) {
			System.out.print(retrieveAllItems(itemList));
		}
	}

	public static void delItem(String item1) {
		Item a = null;
		boolean b = false;
		for(int c = 0; c < itemList.size(); c++) {
			if(itemList.get(c).getName().equalsIgnoreCase(item1)) {
				b = true;
				a = itemList.get(c);
			}
		}
		if(b == true) {
			itemList.remove(a);
			System.out.print("You have successfully deleted " + a);
		}
		else {
			System.out.print("You have entered an invalid name");
		}
	}	
	
	
}
