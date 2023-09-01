class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        
        
        for(int i=1; i<suits.length; i++){
            if(suits[i-1] != suits[i]) break;
            if(i==suits.length-1) return "Flush";
        }

        HashMap<Integer, Integer> mp = new HashMap<>();
        int max = 0;
        for(int i : ranks){
            if(mp.containsKey(i)){
                mp.put(i, mp.get(i)+1);
            }
            else mp.put(i,1);
            
            if(max<mp.get(i)) max = mp.get(i);
        }
        if(max>=3) return "Three of a Kind";
        if(max>=2) return "Pair";
        else return "High Card";

    }
}