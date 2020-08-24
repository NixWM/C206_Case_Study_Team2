public class Item {
	private String name;
	private String desc;
	private double minPrice;
	private String startDate;
	private String endDate;
	private double bidIncrement;
	
	public Item(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public double getBidIncrement() {
		return bidIncrement;
	}
	public void setBidIncrement(double bidIncrement) {
		this.bidIncrement = bidIncrement;
	}
	@Override
	public String toString() {
		return "Item [name=" + name + ", desc=" + desc + ", minPrice=" + minPrice + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", bidIncrement=" + bidIncrement + "]";
	}
	
	
	
}
