import java.util.ArrayList;
public class DealDB {
	public static ArrayList<Deal> dealList = new ArrayList<Deal>();
	
	public static void addDeal(Deal deal1) {
		// TODO Auto-generated method stub
		dealList.add(deal1);
	}
	
	public static String viewAllDeal() {
		String output = "";
		for(int i = 0; i < dealList.size();i++) {
			 output += dealList.get(i).toString();
		}
		return output;
	}
	
	public static void delDeal(Deal deal1) {
		if(dealList.size() != 0) {
			dealList.remove(deal1);
		}
	}
}
	