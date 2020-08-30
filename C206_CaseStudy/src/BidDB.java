import java.util.ArrayList;
public class BidDB {

    public static ArrayList<Bid> bidList = new ArrayList<Bid>();

    public static void addBid(Bid bid1) {
        // TODO Auto-generated method stub
        bidList.add(bid1);
    }

    public static void deleteBid(Bid userInput) {
        for (int i=0; i < BidDB.bidList.size(); i++ ) {
            if (BidDB.bidList.get(i) == userInput) {
                BidDB.bidList.remove(i);
            }
        }
    }
    public static void viewBid() {
        for (int i=0; i < BidDB.bidList.size(); i++) {
            System.out.println(BidDB.bidList.get(i));

        }
    }   
    public static void updateBid(String userUpdate, String userUpdate2) {
        for (int i=0; i < CategoryDB.categoryList.size(); i++) {
            String searchUpdate = userUpdate;
            String Search = BidDB.bidList.get(i).getBidname();
            if (Search.equalsIgnoreCase(searchUpdate)) {
                BidDB.bidList.get(i).setBidname(userUpdate2);
            }
        }
    }
}

