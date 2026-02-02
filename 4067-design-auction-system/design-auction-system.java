class AuctionSystem {

    HashMap< Integer, HashMap< Integer, Integer> > bid_store;
    HashMap<Integer, PriorityQueue<Pair> > highest_bid ;

    public AuctionSystem() {
        bid_store = new HashMap<>();
        highest_bid = new HashMap<>();
    }
    
    public void addBid(int userId, int itemId, int bidAmount) {
        
        if( !bid_store.containsKey(itemId) ){

            bid_store.put( itemId, new HashMap<>() );
            highest_bid.put( itemId,  new PriorityQueue<>( (a, b) -> {
                if(a.amt != b.amt){
                    return b.amt - a.amt;
                }

                return b.user - a.user;
            } ));
        }

        HashMap<Integer, Integer> mp = bid_store.get(itemId); // gets bid list of itemId

        if( mp.containsKey(userId) ){
            // user only needs to UPDATE his bid
            updateBid(userId, itemId, bidAmount);
        }
        else{

            mp.put( userId, bidAmount);
            
            highest_bid.get(itemId).add( new Pair(bidAmount, userId) ); // adding bid to corresponding pq 
        }
    }
    
    public void updateBid(int userId, int itemId, int newAmount) {
        
        HashMap<Integer, Integer> mp = bid_store.get(itemId);

        mp.put( userId, newAmount);
        highest_bid.get(itemId).add( new Pair(newAmount, userId) );

        // System.out.println(mp);
        // System.out.println(highest_bid);
    }
    
    public void removeBid(int userId, int itemId) {
        HashMap<Integer, Integer> mp = bid_store.get(itemId);

        mp.remove( userId);
    }
    
    public int getHighestBidder(int itemId) {

        if( bid_store.containsKey(itemId) == false) return -1;
        
        HashMap<Integer, Integer> mp = bid_store.get(itemId);

        PriorityQueue<Pair> pq = highest_bid.get(itemId);

        // System.out.println(pq);

        while(pq.size() > 0){

            Pair p = pq.peek();

            if( mp.containsKey(p.user) &&  p.amt == mp.get(p.user) ) break;

            pq.remove();
        }

        if(pq.size() == 0) return -1;

        return pq.peek().user;
    }

    class Pair{
        int amt;
        int user;

        Pair(int a, int u){
            amt = a;
            user = u;
        }
    }
}


// hashmap of hashmap for < item id < userid, amt> > for normal operations

// priority queue to get highest value.. but a seperate pq for each item id
// so hasmap of < item id , pq<bidamt , user id>

// when getting highest bid make sure to match bidamt to actual bid of the user in present

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */