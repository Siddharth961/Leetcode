class Solution {
    public boolean isNStraightHand(int[] hand, int size) {
        if(hand.length%size != 0) return false;
        HashMap<Integer, Integer> mp = new HashMap<>();
        

        for(int i: hand){
            mp.put( i , mp.getOrDefault(i,0)+1);
        }

        Arrays.sort(hand);

        

        for(int i=0; i<hand.length; i++){  
            if(mp.get(hand[i])==0) continue;         
              
            for(int j=0; j<size; j++){
                int curr = hand[i] + j;                
                if(mp.containsKey(curr)==false || mp.get(curr)==0) return false;
                mp.put(curr, mp.get(curr)-1);
                
            }
            
        }

        return true;
    }

}