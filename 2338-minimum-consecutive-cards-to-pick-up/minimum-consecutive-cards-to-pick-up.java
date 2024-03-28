class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = cards.length+1;

        for(int i =0; i<cards.length; i++){
            if(mp.containsKey(cards[i])==false) mp.put(cards[i], i);
            else{
                ans = Math.min(ans, i - mp.get(cards[i]) + 1);
                mp.put(cards[i],i);
            }
        }

        if(ans>cards.length) ans = -1;

        return ans;
    }
}