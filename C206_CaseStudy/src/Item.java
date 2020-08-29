public class Item {
	
	private String name;
	private String desc;
	private double minPrice;
	private String startDate;
	private String endDate;
	private double bidIncrement;
	private String category;
	
	public Item(String name, String desc, double minPrice, String startDate, String endDate, double bidIncrement) {
		this.name = name;
		this.desc = desc;
		this.minPrice = minPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.bidIncrement = bidIncrement;
	}
	
	public Item(String name, String desc, double minPrice, String startDate, String endDate, double bidIncrement, String category) {
		this.name = name;
		this.desc = desc;
		this.minPrice = minPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.bidIncrement = bidIncrement;
		this.category = category;
	}

	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public double getBidIncrement() {
		return bidIncrement;
	}

	public String toString() {
		String output = "";
		output += String.format("%-20s %-30s $%-15.2f %-22s %-22s $%.2f\n", 
				this.name, this.desc, this.minPrice, this.startDate, this.endDate, this.bidIncrement);
		return output;
	}
	
	
	
}
