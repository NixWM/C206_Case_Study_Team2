import java.util.ArrayList;
public class DealDB {
	public static ArrayList<Deal> dealList = new ArrayList<Deal>();
	
	public static void addDeal(Deal deal) {
		boolean proceed = true;
		String output = "";
		
		for (Deal i : dealList) {
			if (i.getDealID().equals(deal.getDealID()))
				proceed = false;
		}
		
		if (proceed) {
			dealList.add(deal);
			output += "Deal has been added";
		} else 
			output += "The current deal ID is already within the list";
		
		System.out.println(output);
		System.out.println();
	}
	
	public static String viewAllDeal() {
		String output = "";
		output += String.format("%-10s, %-15s, %-25s, %-25s, %-15s, %s\n",
				"Deal ID", "Item Name", "Seller Email", "Buyer Email", "Deal Price", "Close Date");
		
		if (dealList.isEmpty()) 
			output += "There is no deal available within the list";
		else {
			for (int i = 0; i < dealList.size(); i++) {
				output += dealList.get(i).toString();
			}
		}
		
		return output;
	}
	
	public static void delDeal(String dealID) {
		boolean proceed = false;
		String output = "";
		int i = 0;
		
		for (; i < dealList.size(); i++) {
			if (dealList.get(i).getDealID().equals(dealID)) {
				proceed = true;
				break;
			}
		}
		
		if (proceed) {
			dealList.remove(i);
			output += "Deal have been removed";
		} else 
			output += "The deal id does not exist in the list";
		
		System.out.println(output);
		System.out.println();
	}
	
	public static void searchDeal(int option, String src) {
		String output = "";
		String OUTPUT = "";
		
		switch (option) {
		// item name
		case 1:
			output += String.format("%-10s, %-15s, %-25s, %-25s, %-15s, %s\n",
					"Deal ID", "Item Name", "Seller Email", "Buyer Email", "Deal Price", "Close Date");
			for (Deal i : dealList) {
				if (i.getItemName().equals(src)) {
					OUTPUT += i.toString();
				}
			}
			if (OUTPUT.isEmpty()) {
				output += "There is no such item available";
			} else 
				output += OUTPUT;
			break;
		// buyer email
		case 2:
			output += String.format("%-10s, %-15s, %-25s, %-25s, %-15s, %s\n",
					"Deal ID", "Item Name", "Seller Email", "Buyer Email", "Deal Price", "Close Date");
			for (Deal i : dealList) {
				if (i.getBuyerEmail().equals(src)) {
					OUTPUT += i.toString();
				}
			}
			if (OUTPUT.isEmpty()) {
				output += "There is no such item available";
			} else 
				output += OUTPUT;
			break;
		// seller email
		case 3:
			output += String.format("%-10s, %-15s, %-25s, %-25s, %-15s, %s\n",
					"Deal ID", "Item Name", "Seller Email", "Buyer Email", "Deal Price", "Close Date");
			for (Deal i : dealList) {
				if (i.getSellerEmail().equals(src)) {
					OUTPUT += i.toString();
				}
			}
			if (OUTPUT.isEmpty()) {
				output += "There is no such item available";
			} else 
				output += OUTPUT;
			break;
		// close date
		case 4:
			output += String.format("%-10s, %-15s, %-25s, %-25s, %-15s, %s\n",
					"Deal ID", "Item Name", "Seller Email", "Buyer Email", "Deal Price", "Close Date");
			for (Deal i : dealList) {
				if (i.getCloseDate().equals(src)) {
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
		System.out.println(output);
	}
	
	public static void updateDeal(String dealID) {
		boolean proceed = false;
		for (Deal i : dealList) {
			if (i.getDealID().equals(dealID)) 
				proceed = true;
		}
		
		if (proceed) {
			String itemName = Helper.readString("Enter Item Name: ");
			String sellerEmail = Helper.readString("Enter seller email: ");
			String buyerEmail = Helper.readString("Enter buyer Email: ");
			double price = Helper.readDouble("Enter deal price: ");
			String closeDate = Helper.readString("Enter closed date: ");
			
			Deal deal = new Deal(dealID, itemName, sellerEmail, buyerEmail, price, closeDate);
			System.out.println(doUpdateDeal(deal));
		} else {
			System.out.println("There no deal id in the list matches the id entered");
		}
	}
	
	public static String doUpdateDeal(Deal deal) {
		String output = "";
		for (int i = 0; i < dealList.size(); i++) {
			if (dealList.get(i).getDealID().equals(deal.getDealID())) {
				dealList.set(i, deal);
				output += "It has been successfully updated";
			}
		}
		return output;
	}
	
	public static void showDealMenu() {
		Helper.line(40, "-");
		System.out.println("DEAL MENU");
		Helper.line(40, "-");
		
		System.out.println("1. Add Deal");
		System.out.println("2. View All Deal");
		System.out.println("3. Delete Deal");
		System.out.println("4. Search Deal");
		System.out.println("5. Update Deal");
	}
}
	