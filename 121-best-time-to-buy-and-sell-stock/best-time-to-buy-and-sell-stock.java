class Solution {
    public int maxProfit(int[] prices) {
        
        int buy = Integer.MAX_VALUE;
        
        int ans = 0;

        for(int i: prices){
            if(buy > i){
                buy = i;
            }
            else{
                ans = Math.max(ans, i-buy);
            }
        }

        return ans;
    }
}