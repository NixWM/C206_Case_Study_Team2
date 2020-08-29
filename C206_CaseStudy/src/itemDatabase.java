import java.util.ArrayList;
public class itemDatabase {
	
	private static ArrayList<Item> itemList = new ArrayList<Item>();
	
	public static void adddItem(Item item) {
		
		if (item == null) {
			String name = Helper.readString("Enter Name: ");
			String desc = Helper.readString("Enter Description: ");
			double minPrice = Helper.readDouble("Enter Minimum Price: ");
			String startDate = Helper.readString("Enter Auction Start Date: ");
			String endDate = Helper.readString("Enter Auction End Date: ");
			double increment = Helper.readDouble("Enter Price Increment: ");
			
			item = new Item(name, desc, minPrice, startDate, endDate, increment);
		} 		
		System.out.println(doAddItem(item));
		System.out.println();
	}
	
	public static String doAddItem(Item item) {
		boolean proceed = true;
		String output = "";
		
		for (Item i : itemList) {
			if (i.getName().equals(item.getName()))
				proceed = false;
		}
		
		if (proceed) {
			itemList.add(item);
			output += "Item has been added";
		} else 
			output += "The current Item Name is already within the list";
		
		return output;
	}
	
	public static void viewAllItem() {
		
		String output = "";
		output += String.format("%-20s %-30s %-15s %-22s %-22s %s\n",
				"Item Name", "Item Description", "Min Bid Price", "Auction Start Date", "Auction End Date", "Bid Increment");
		output += doViewAllItem(itemList);
		System.out.println(output);
		System.out.println();
	}
	
	public static String doViewAllItem(ArrayList<Item> itemList) {
		String output = "";
		if (itemList.isEmpty()) 
			output += "There is no deal available within the list";
		else {
			for (int i = 0; i < itemList.size(); i++) {
				output += itemList.get(i).toString();
			}
		}
		return output;
	}
	
	public static void delItem() {
		
		String itemName = Helper.readString("Enter Item Name");
		
		System.out.println(doDelItem(itemName));
		System.out.println();
	}
	
	public static String doDelItem(String itemName) {
		boolean proceed = false;
		String output = "";
		int i = 0;
		
		for (; i < itemList.size(); i++) {
			if (itemList.get(i).getName().equals(itemName)) {
				proceed = true;
				break;
			}
		}
		
		if (proceed) {
			itemList.remove(i);
			output += "Item have been removed";
		} else 
			output += "The item name does not exist in the list";
		
		return output;
	}
	
	public static void searchItem() {
		
		String src = "";
		System.out.println("1. Search with item name");
		System.out.println("2. Search with item description");
		int choice = Helper.readInt("Enter option: ");
		if (choice == 1) {
			src = Helper.readString("Enter item name: ");
		} else if (choice == 2) {
			src = Helper.readString("Enter item description (keyword): ");
		}
		
		System.out.println(doSearchItem(choice, src));
		System.out.println();
	}
	
	public static String doSearchItem(int choice, String src) {
		String output = "";
		String OUTPUT = "";
		
		switch (choice) {
		// item name
		case 1:
			output += String.format("%-20s %-30s %-15s %-22s %-22s %s\n",
					"Item Name", "Item Description", "Min Bid Price", "Auction Start Date", "Auction End Date", "Bid Increment");
			for (Item i : itemList) {
				if (i.getName().equals(src)) {
					OUTPUT += i.toString();
				}
			}
			if (OUTPUT.isEmpty()) {
				output += "There is no such item available";
			} else 
				output += OUTPUT;
			break;
		// item description
		case 2:
			output += String.format("%-20s %-30s %-15s %-22s %-22s %s\n",
					"Item Name", "Item Description", "Min Bid Price", "Auction Start Date", "Auction End Date", "Bid Increment");
			for (Item i : itemList) {
				if (i.getDesc().contains(src)) {
					OUTPUT += i.toString();
				}
			}
			if (OUTPUT.isEmpty()) {
				output += "There is no such item available";
			} else 
				output += OUTPUT;
			break;
		default:
			output += "Invalid Choice";
		}
		return output;
	}
	
	public static void updateItem() {
		
		String itemName = Helper.readString("Enter Item Name: ");
		boolean proceed = false;
		
		for (Item i : itemList) {
			if (i.getName().equals(itemName)) 
				proceed = true;
		}
		
		if (proceed) {
			String desc = Helper.readString("Enter Description: ");
			double minPrice = Helper.readDouble("Enter Minimum Price: ");
			String startDate = Helper.readString("Enter Auction Start Date: ");
			String endDate = Helper.readString("Enter Auction End Date: ");
			double increment = Helper.readDouble("Enter Price Increment: ");
			
			Item item = new Item(itemName, desc, minPrice, startDate, endDate, increment);
			System.out.println();
			
		} else {
			System.out.println("There no item name in the list matches the name entered");
		}
	}
	
	public static String doUpdateItem(Item item) {
		String output = "";
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getName().equals(item.getName())) {
				itemList.set(i, item);
				output += "Item have been updated.";
			}
		}
		return output;
	}
	
	public static void showDealMenu() {
		Helper.line(40, "-");
		System.out.println("ITEM MENU");
		Helper.line(40, "-");
		
		System.out.println("1. Add Item");
		System.out.println("2. View All Item");
		System.out.println("3. Delete Item");
		System.out.println("4. Search Item");
		System.out.println("5. Update Item");
	}
}
