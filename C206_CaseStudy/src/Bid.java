
public class Bid {

	private String bidid;
	private String bidname;
	
	public Bid(String bidid, String bidname) {
	this.bidid = bidid;
	this.bidname = bidname;
		}
	
	public String getBidid() { 
		return bidid;
		}
	
	public void setBidid(String bidid) {
		this.bidid = bidid;
		}
	
	public String getBidname() {
		return bidname;
		}
	
	public void setBidname(String bidname) {
		this.bidname = bidname;
		}
	}

