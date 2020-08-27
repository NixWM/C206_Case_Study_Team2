
public class Deal {

	private String dealID;
	private String itemName;
	private String sellerEmail;
	private String buyerEmail;
	private double dealPrice;
	private String closeDate;
	
	public Deal(String dealID, String itemName, String sellerEmail, String buyerEmail, double dealPrice,
			String closeDate) {
		this.dealID = dealID;
		this.itemName = itemName;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.dealPrice = dealPrice;
		this.closeDate = closeDate;
	}

	public String getDealID() {
		return dealID;
	}

	public String getItemName() {
		return itemName;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public double getDealPrice() {
		return dealPrice;
	}

	public String getCloseDate() {
		return closeDate;
	}

	@Override
	public String toString() {
		String output = "";
		output += String.format("%-10s, %-15s, %-25s, %-25s, $%-15.2f, %s\n", 
				this.dealID, this.itemName, this.sellerEmail, this.buyerEmail, this.dealPrice, this.closeDate);
		return output;
	}
	
	

	
	
}
